package day.gitlab.dolphin.module.core.entity;

import com.mybatisflex.annotation.Table;
import day.gitlab.dolphin.common.mybatis.entity.BaseStringTreeEntity;
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
public class DictionaryItem extends BaseStringTreeEntity<DictionaryItem> {

    /**
     * 字典ID
     */
    private String masterId;

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
}
