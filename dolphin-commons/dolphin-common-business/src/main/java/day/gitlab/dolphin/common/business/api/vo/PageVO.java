package day.gitlab.dolphin.common.business.api.vo;

import com.mybatisflex.core.paginate.Page;
import day.gitlab.dolphin.common.business.api.dto.PageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PageVO<T extends BaseVO> extends BaseVO {

    private Long pageIndex;

    private Long pageSize;

    private Long total;

    private Collection<T> records;

    public static <T extends BaseVO> PageVO<T> of(Page<?> page, Collection<T> records) {
        return new PageVO<>(page.getPageNumber(), page.getPageSize(), page.getTotalRow(), records);
    }
}
