package day.gitlab.dolphin.common.business.api.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基本实体类对应的 VO
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BaseEntityVO<ID extends Serializable> extends BaseVO {

    /**
     * 主键
     */
    protected ID id;

    protected String description;

    /**
     * 创建时间
     */
    protected LocalDateTime createTime;

    /**
     * 修改时间
     */
    protected LocalDateTime updateTime;
}
