package day.gitlab.dolphin.common.mybatis.service.impl;

import com.mybatisflex.core.relation.RelationManager;
import day.gitlab.dolphin.common.mybatis.entity.BaseTreeEntity;
import day.gitlab.dolphin.common.mybatis.mapper.IBaseTreeMapper;
import day.gitlab.dolphin.common.mybatis.service.IBaseTreeService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.*;

@Data
@Slf4j
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class BaseTreeServiceImpl<M extends IBaseTreeMapper<E, ID>, E extends BaseTreeEntity<E, ID>, ID extends Serializable>
        extends BaseServiceImpl<M, E, ID> implements IBaseTreeService<M, E, ID> {

    public Boolean insertWithRelations(E entity) {
        boolean success = this.insert(entity);
        if (success) {
            List<E> children = entity.getChildren();
            if (!CollectionUtils.isEmpty(children)) {
                for (E child : children) {
                    child.setParentId(entity.getId());
                    if (!this.insertWithRelations(child)) {
                        throw new RuntimeException(String.format("insert fail: [%s]", child));
                    }
                }
            }
        }
        return success;
    }

    public Boolean updateWithRelations(E entity, Collection<E> insertEntities, Collection<E> updateEntities, Collection<ID> deleteEntities) {
        boolean success = this.update(entity);
        if (success) {
            // insert
            if (!CollectionUtils.isEmpty(insertEntities)) {
                for (E child : insertEntities) {
                    child.setParentId(entity.getId());
                    if (!this.insertWithRelations(child)) {
                        throw new RuntimeException(String.format("insert fail: [%s]", child));
                    }
                }
            }
            // update
            if (!CollectionUtils.isEmpty(updateEntities)) {
                for (E child : updateEntities) {
                    getMapper().update(child);
                }
            }
            if (!CollectionUtils.isEmpty(deleteEntities)) {
                this.deleteBatchById(deleteEntities);
            }
        }
        return success;
    }

    public Boolean deleteWithRelations(Collection<ID> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return true;
        }

        Set<ID> deleteIds = new HashSet<>(ids);
        RelationManager.setMaxDepth(Integer.MAX_VALUE);
        for (ID id : ids) {
            E e = getMapper().selectOneWithRelationsById(id);
            treeId2Set(e, deleteIds);
        }
        boolean success = this.deleteBatchById(deleteIds);
        log.debug("deleteWithRelations ids: [{}], success: [{}]", deleteIds, success);
        return success;
    }

    protected void treeId2Set(E e, Set<ID> deleteIds) {
        if (deleteIds == null) {
            deleteIds = new HashSet<>();
        }
        if (e == null) {
            return;
        }

        List<E> children = e.getChildren();
        if (CollectionUtils.isEmpty(children)) {
            return;
        }
        for (E child : children) {
            if (child != null) {
                deleteIds.add(child.getId());
            }
            treeId2Set(child, deleteIds);
        }
    }
}
