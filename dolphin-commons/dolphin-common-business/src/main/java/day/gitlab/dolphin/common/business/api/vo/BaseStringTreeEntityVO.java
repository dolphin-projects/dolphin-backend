package day.gitlab.dolphin.common.business.api.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaseStringTreeEntityVO<T extends BaseStringTreeEntityVO<T>> extends BaseTreeEntityVO<T, String> {

    protected String masterId;

    protected String name;

    protected String code;

    protected Integer sort;
}
