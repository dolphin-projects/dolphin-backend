package day.gitlab.dolphin.common.mybatis.service.impl;

import day.gitlab.dolphin.common.mybatis.entity.Entity;
import day.gitlab.dolphin.common.mybatis.mapper.IMapper;
import day.gitlab.dolphin.common.mybatis.service.IService;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public abstract class ServiceImpl<M extends IMapper<E>, E extends Entity> implements IService<M, E> {

    protected abstract M getMapper();

    @Override
    public Boolean insert(E entity) {
        int rs = getMapper().insert(entity);
        log.debug("insert entity : [{}], rs: [{}]", entity, rs);
        return rs > 0;
    }

    @Override
    public Boolean delete(E entity) {
        int rs = getMapper().delete(entity);
        log.debug("delete entity : [{}], rs: [{}]", entity, rs);
        return rs > 0;
    }

    @Override
    public Boolean update(E entity) {
        int rs = getMapper().update(entity);
        log.debug("update entity : [{}], rs: [{}]", entity, rs);
        return rs > 0;
    }
}
