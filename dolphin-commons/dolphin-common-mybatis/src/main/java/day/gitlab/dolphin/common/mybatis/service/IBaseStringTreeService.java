package day.gitlab.dolphin.common.mybatis.service;

import day.gitlab.dolphin.common.mybatis.entity.BaseStringTreeEntity;
import day.gitlab.dolphin.common.mybatis.mapper.IBaseStringTreeMapper;

public interface IBaseStringTreeService<M extends IBaseStringTreeMapper<E>, E extends BaseStringTreeEntity<E>>
        extends IBaseTreeService<M, E, String> {
}
