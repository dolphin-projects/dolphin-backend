package day.gitlab.dolphin.common.business.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PageVO<T extends BaseVO> extends BaseVO {

    private Long pageIndex;

    private Long pageSize;

    private Long total;

    private List<T> records;
}
