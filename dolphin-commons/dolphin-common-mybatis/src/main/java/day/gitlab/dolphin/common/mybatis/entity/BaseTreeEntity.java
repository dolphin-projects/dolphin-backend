package day.gitlab.dolphin.common.mybatis.entity;

import com.mybatisflex.annotation.RelationOneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaseTreeEntity<T extends BaseTreeEntity<T, ID>, ID extends Serializable> extends BaseEntity<ID> {

    protected ID parentId;

    @RelationOneToMany(targetField = "parentId")
    protected List<T> children;
}
