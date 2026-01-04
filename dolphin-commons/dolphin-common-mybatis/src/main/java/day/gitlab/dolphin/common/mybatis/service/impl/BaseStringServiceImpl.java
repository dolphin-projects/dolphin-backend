package day.gitlab.dolphin.common.mybatis.service.impl;

import day.gitlab.dolphin.common.mybatis.entity.BaseStringEntity;
import day.gitlab.dolphin.common.mybatis.mapper.IBaseStringMapper;
import day.gitlab.dolphin.common.mybatis.service.IBaseStringService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class BaseStringServiceImpl<M extends IBaseStringMapper<E>, E extends BaseStringEntity>
        extends BaseServiceImpl<M, E, String> implements IBaseStringService<M, E> {
}
