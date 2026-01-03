package day.gitlab.dolphin.common.business.api.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 基本实体类对应的 VO
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EntityVO extends BaseVO {

    /**
     * 主键
     */
    private String id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
