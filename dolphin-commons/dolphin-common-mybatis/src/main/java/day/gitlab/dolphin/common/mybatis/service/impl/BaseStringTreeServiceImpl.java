package day.gitlab.dolphin.common.mybatis.service.impl;

import day.gitlab.dolphin.common.mybatis.entity.BaseStringTreeEntity;
import day.gitlab.dolphin.common.mybatis.mapper.IBaseStringTreeMapper;
import day.gitlab.dolphin.common.mybatis.service.IBaseStringTreeService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class BaseStringTreeServiceImpl<M extends IBaseStringTreeMapper<E>, E extends BaseStringTreeEntity<E>>
        extends BaseTreeServiceImpl<M, E, String> implements IBaseStringTreeService<M, E> {
}
