package day.gitlab.dolphin.common.mybatis.service;

import day.gitlab.dolphin.common.mybatis.entity.BaseStringEntity;
import day.gitlab.dolphin.common.mybatis.mapper.IBaseStringMapper;

public interface IBaseStringService<M extends IBaseStringMapper<E>, E extends BaseStringEntity>
        extends IBaseService<M, E, String> {
}
