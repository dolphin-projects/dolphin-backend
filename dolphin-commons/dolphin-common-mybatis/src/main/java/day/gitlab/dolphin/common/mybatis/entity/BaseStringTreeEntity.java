package day.gitlab.dolphin.common.mybatis.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaseStringTreeEntity<T extends BaseStringTreeEntity<T>> extends BaseTreeEntity<T, String> {
}
