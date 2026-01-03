package day.gitlab.dolphin.common.business.exception;

import day.gitlab.dolphin.common.business.api.vo.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    public <T> R<T> handleBusinessException(BusinessException e) {
        return R.failure(e);
    }

    @ExceptionHandler(value = Exception.class)
    public <T> R<T> handleException(Exception e) {
        return R.failure(e);
    }
}
