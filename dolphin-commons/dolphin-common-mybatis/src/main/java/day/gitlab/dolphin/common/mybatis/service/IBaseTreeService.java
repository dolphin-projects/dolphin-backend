package day.gitlab.dolphin.common.mybatis.service;

import day.gitlab.dolphin.common.mybatis.entity.BaseTreeEntity;
import day.gitlab.dolphin.common.mybatis.mapper.IBaseTreeMapper;

import java.io.Serializable;
import java.util.Collection;

public interface IBaseTreeService<M extends IBaseTreeMapper<E, ID>, E extends BaseTreeEntity<E, ID>, ID extends Serializable>
    extends IBaseService<M, E, ID> {

    Boolean insertWithRelations(E entity);

    Boolean updateWithRelations(E entity, Collection<E> insertEntities, Collection<E> updateEntities, Collection<ID> deleteEntities);

    Boolean deleteWithRelations(Collection<ID> ids);
}
