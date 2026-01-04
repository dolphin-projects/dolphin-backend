package day.gitlab.dolphin.module.core.api.vo;

import day.gitlab.dolphin.common.business.api.vo.BaseStringEntityVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DictionaryVO extends BaseStringEntityVO {

    protected String name;

    protected String code;

    protected String type;

    protected List<DictionaryItemVO> items;
}
