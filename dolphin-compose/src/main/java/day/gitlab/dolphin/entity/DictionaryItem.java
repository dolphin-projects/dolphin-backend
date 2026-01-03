package day.gitlab.dolphin.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import java.sql.Timestamp;

import java.io.Serial;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 字典项 实体类。
 *
 * @author jiangyc
 * @since 2026-01-01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("sys_core_dictionary_item")
public class DictionaryItem implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 字典ID
     */
    private String dictionaryId;

    /**
     * 父级ID，如果为空则为根节点
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

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

}
