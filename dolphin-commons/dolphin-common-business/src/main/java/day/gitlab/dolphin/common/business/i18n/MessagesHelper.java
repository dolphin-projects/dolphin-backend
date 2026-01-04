package day.gitlab.dolphin.common.business.i18n;

import day.gitlab.dolphin.common.business.exception.BusinessException;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

@Data
@NoArgsConstructor
public class MessagesHelper {

    @Resource
    private MessageSource messageSource;

    public Locale getCurrentLocale() {
        return LocaleContextHolder.getLocale();
    }

    public String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, getCurrentLocale());
    }

    public BusinessException newBusinessException(String code, Object... args) {
        return new BusinessException(code, getMessage(code, args));
    }
}
