package day.gitlab.dolphin.common.mybatis.service;

import day.gitlab.dolphin.common.mybatis.entity.BaseEntity;
import day.gitlab.dolphin.common.mybatis.mapper.IBaseMapper;

import java.io.Serializable;
import java.util.Collection;

public interface IBaseService<M extends IBaseMapper<E, ID>, E extends BaseEntity<ID>, ID extends Serializable>
        extends IService<M, E> {

    Boolean deleteById(ID id);

    Boolean deleteBatchById(Collection<ID> ids);
}
