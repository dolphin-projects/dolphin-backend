package day.gitlab.dolphin.module.core.entity;

import com.mybatisflex.annotation.RelationOneToMany;
import com.mybatisflex.annotation.Table;
import day.gitlab.dolphin.common.business.entity.Entity;
import lombok.*;

import java.util.List;

/**
 * 字典表 实体类。
 *
 * @author jiangyc
 * @since 2026-01-01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(value = "sys_core_dictionary", comment = "字典表")
public class Dictionary extends Entity<String> {

    /**
     * 字典名称
     */
    private String name;

    /**
     * 字典代码
     */
    private String code;

    /**
     * 字典类型: enum-枚举、tree-树型
     */
    private String type;

    /**
     * 字典描述
     */
    private String description;

    @RelationOneToMany(targetField = "mainId")
    private List<DictionaryItem> items;
}
