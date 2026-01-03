package day.gitlab.dolphin.common.business.mapper;

import day.gitlab.dolphin.common.business.entity.Entity;
import day.gitlab.dolphin.common.business.entity.TreeEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface ITreeMapper<T extends Entity<ID> & TreeEntity<T, ID>, ID extends Serializable> extends IMapper<T, ID> {

    default int insertTreeEntity(T entity) {
        int rs = this.insertEntity(entity);
        if (rs > 0) {
            List<T> children = entity.getChildren();
            if (children != null && !children.isEmpty()) {
                ID parentId = entity.getId();
                for (T child : children) {
                    child.setParentId(parentId);
                    this.insertEntity(child);
                }
            }
        }
        return rs;
    }

    default int insertBatchTreeEntity(Collection<T> entities) {
        int rs = 0;
        for (T entity : entities) {
            rs += this.insertEntity(entity);
        }
        return rs;
    }
}
