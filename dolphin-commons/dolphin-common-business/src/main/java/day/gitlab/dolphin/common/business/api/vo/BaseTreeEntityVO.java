package day.gitlab.dolphin.common.business.api.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaseTreeEntityVO<T extends BaseTreeEntityVO<T, ID>, ID extends Serializable> extends BaseEntityVO<ID> {

    protected ID parentId;

    protected List<T> children;
}
