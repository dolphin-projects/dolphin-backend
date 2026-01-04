package day.gitlab.dolphin.common.mybatis.mapper;

import day.gitlab.dolphin.common.mybatis.entity.BaseEntity;

import java.io.Serializable;

public interface IBaseMapper<T extends BaseEntity<ID>, ID extends Serializable> extends IMapper<T> {
}
