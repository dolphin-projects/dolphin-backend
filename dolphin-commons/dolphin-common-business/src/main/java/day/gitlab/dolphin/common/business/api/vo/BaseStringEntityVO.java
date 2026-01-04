package day.gitlab.dolphin.common.business.api.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 基本实体类对应的 VO
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BaseStringEntityVO extends BaseEntityVO<String> {
}
