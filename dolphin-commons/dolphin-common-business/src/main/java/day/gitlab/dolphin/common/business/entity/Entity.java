package day.gitlab.dolphin.common.business.entity;

import com.mybatisflex.annotation.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 通用数据库表 实体类
 */
@Data
@NoArgsConstructor
public class Entity<ID extends Serializable> implements Serializable {

    /**
     * 主键
     */
    @Id
    private ID id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
