package day.gitlab.dolphin.common.business.api.vo;

import day.gitlab.dolphin.common.business.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class R<T> extends BaseVO {

    public static final String SUCCESS_CODE    = "00000000";
    public static final String SUCCESS_MESSAGE = "success";
    public static final String FAILURE_CODE    = "99999999";
    public static final String FAILURE_MESSAGE = "failure";

    private String code;

    private String message;

    private T data;

    public static<T> R<T> success() {
        return new R<>(SUCCESS_CODE, SUCCESS_MESSAGE, null);
    }

    public static <T> R<T> success(T data) {
        return new R<>(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static <T> R<T> failure(String code, String message) {
        return new R<>(code, message, null);
    }

    public static <T> R<T> failure(Throwable t) {
        if (t instanceof BusinessException biz) {
            return new R<>(biz.getCode(), biz.getMessage(), null);
        }
        return new R<>(FAILURE_CODE, t.getMessage(), null);
    }
}
