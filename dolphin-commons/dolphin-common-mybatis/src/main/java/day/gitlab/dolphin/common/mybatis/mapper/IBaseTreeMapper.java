package day.gitlab.dolphin.common.mybatis.mapper;

import day.gitlab.dolphin.common.mybatis.entity.BaseTreeEntity;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface IBaseTreeMapper<T extends BaseTreeEntity<T, ID>, ID extends Serializable> extends IBaseMapper<T, ID> {

    default int insertTreeEntity(T entity) {
        int rs = this.insert(entity);
        if (rs > 0) {
            List<T> children = entity.getChildren();
            if (!CollectionUtils.isEmpty(children)) {
                for (T child : children) {
                    child.setParentId(entity.getId());
                    if (insertTreeEntity(child) <= 0) {
                        throw new RuntimeException(String.format("insert tree entity error, entity: [%s]", child));
                    }
                }
            }
        }
        return rs;
    }

    default int insertBatchTreeEntity(Collection<T> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return 0;
        }
        int rs = 0;
        for (T entity : entities) {
            rs += insertTreeEntity(entity);
        }
        return rs;
    }
}
