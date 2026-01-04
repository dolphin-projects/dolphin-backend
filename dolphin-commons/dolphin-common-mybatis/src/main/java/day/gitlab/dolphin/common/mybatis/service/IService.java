package day.gitlab.dolphin.common.mybatis.service;

import day.gitlab.dolphin.common.mybatis.entity.Entity;
import day.gitlab.dolphin.common.mybatis.mapper.IMapper;

public interface IService<M extends IMapper<E>, E extends Entity> {

    Boolean insert(E entity);

    Boolean delete(E entity);

    Boolean update(E entity);
}
