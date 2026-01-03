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
 * 字典 实体类。
 *
 * @author jiangyc
 * @since 2026-01-01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("sys_core_dictionary")
public class Dictionary implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    private String id;

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

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

}
