package day.gitlab.dolphin.common.business.service.impl;

import day.gitlab.dolphin.common.business.entity.Entity;
import day.gitlab.dolphin.common.business.exception.BusinessException;
import day.gitlab.dolphin.common.business.mapper.IMapper;
import day.gitlab.dolphin.common.business.service.IService;
import io.github.linpeilie.Converter;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Locale;

@Data
@Slf4j
@EqualsAndHashCode(callSuper = true)
public abstract class ServiceImpl<M extends IMapper<T, ID>, T extends Entity<ID>, ID extends Serializable>
        extends com.mybatisflex.spring.service.impl.ServiceImpl<M, T> implements IService<T, ID> {

    @Resource
    protected Converter converter;

    @Resource
    protected MessageSource messageSource;

    // ========== 增删改查 ==========

    public Boolean insertEntity(T entity) {
        int rs = getMapper().insertEntity(entity);
        log.info("insert entity: [{}], rs: [{}]", entity, rs);
        return rs > 0;
    }

    // ========== 国际化消息 ==========

    @Override
    public Locale getCurrentLocale() {
        return LocaleContextHolder.getLocale();
    }

    @Override
    public String getMessage(String code, String defaultMessage, Object... args) {
        return messageSource.getMessage(code, args, defaultMessage, getCurrentLocale());
    }

    // ========== 业务异常快捷方法 ==========

    @Override
    public BusinessException newBusinessException(String code, String defaultMessage, Object... args) {
        return new BusinessException(code, getMessage(code, defaultMessage, args));
    }
}
