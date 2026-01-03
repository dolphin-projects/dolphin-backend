package day.gitlab.dolphin.common.business.mapper;

import com.mybatisflex.core.BaseMapper;
import day.gitlab.dolphin.common.business.entity.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface IMapper<T extends Entity<ID>, ID extends Serializable> extends BaseMapper<T> {

    default int insertEntity(T entity) {
        entity.setId(null);
        entity.setCreateTime(LocalDateTime.now());
        entity.setUpdateTime(LocalDateTime.now());
        return this.insert(entity);
    }

    default int updateEntity(T entity) {
        entity.setUpdateTime(LocalDateTime.now());
        return this.update(entity);
    }
}
