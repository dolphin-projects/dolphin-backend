package day.gitlab.dolphin.module.core.entity;

import com.mybatisflex.annotation.RelationOneToMany;
import com.mybatisflex.annotation.Table;
import day.gitlab.dolphin.common.business.entity.Entity;
import day.gitlab.dolphin.common.business.entity.TreeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 字典项 实体类。
 *
 * @author jiangyc
 * @since 2026-01-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table("sys_core_dictionary_item")
public class DictionaryItem extends Entity<String> implements TreeEntity<DictionaryItem, String> {

    /**
     * 字典ID
     */
    private String masterId;

    /**
     * 父级主键
     */
    private String parentId;

    /**
     * 字典项名称
     */
    private String name;

    /**
     * 字典项代码
     */
    private String code;

    /**
     * 字典项排序，升序排列
     */
    private Integer sort;

    /**
     * 字典项描述
     */
    private String description;

    @RelationOneToMany(targetField = "parentId")
    private List<DictionaryItem> children;
}
