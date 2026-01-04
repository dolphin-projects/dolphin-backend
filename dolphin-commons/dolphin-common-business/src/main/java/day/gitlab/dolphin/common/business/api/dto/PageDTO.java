package day.gitlab.dolphin.common.business.api.dto;

import cn.hutool.core.lang.Dict;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PageDTO extends BaseDTO {

    protected Long pageIndex = 1L;

    protected Long pageSize = 10L;

    protected Dict query;
}
