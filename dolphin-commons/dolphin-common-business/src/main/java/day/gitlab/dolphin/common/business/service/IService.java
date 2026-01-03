package day.gitlab.dolphin.common.business.service;

import day.gitlab.dolphin.common.business.entity.Entity;
import day.gitlab.dolphin.common.business.exception.BusinessException;
import io.github.linpeilie.Converter;
import org.springframework.context.MessageSource;

import java.io.Serializable;
import java.util.Locale;

public interface IService<T extends Entity<ID>, ID extends Serializable> extends com.mybatisflex.core.service.IService<T> {

    // ========== 增删改查 ==========

    Boolean insertEntity(T entity);

    // ========== MapStruct转换 ==========

    Converter getConverter();

    // ========== 国际化消息 ==========

    Locale getCurrentLocale();

    MessageSource getMessageSource();

    String getMessage(String code, String defaultMessage, Object... args);

    // ========== 业务异常快捷方法 ==========

    BusinessException newBusinessException(String code, String defaultMessage, Object... args);
}
