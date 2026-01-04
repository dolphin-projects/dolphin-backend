package day.gitlab.dolphin.common.mybatis.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaseStringEntity extends BaseEntity<String> {
}
