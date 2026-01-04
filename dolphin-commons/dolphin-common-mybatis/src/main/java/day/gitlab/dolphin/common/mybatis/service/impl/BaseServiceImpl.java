package day.gitlab.dolphin.common.mybatis.service.impl;

import day.gitlab.dolphin.common.mybatis.entity.BaseEntity;
import day.gitlab.dolphin.common.mybatis.mapper.IBaseMapper;
import day.gitlab.dolphin.common.mybatis.service.IBaseService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Collection;

@Data
@Slf4j
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class BaseServiceImpl<M extends IBaseMapper<E, ID>, E extends BaseEntity<ID>, ID extends Serializable>
        extends ServiceImpl<M, E> implements IBaseService<M, E, ID> {

    @Override
    public Boolean deleteById(ID id) {
        int rs = getMapper().deleteById(id);
        log.debug("delete entity by id: [{}], rs: [{}]", id, rs);
        return rs > 0;
    }

    @Override
    public Boolean deleteBatchById(Collection<ID> ids) {
        int rs = getMapper().deleteBatchByIds(ids);
        log.debug("delete entity by ids: [{}], rs: [{}]", ids, rs);
        return rs > 0;
    }
}
