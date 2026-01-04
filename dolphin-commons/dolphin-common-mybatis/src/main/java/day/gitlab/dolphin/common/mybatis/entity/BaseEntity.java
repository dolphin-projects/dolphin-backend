package day.gitlab.dolphin.common.mybatis.entity;

import com.mybatisflex.annotation.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaseEntity<ID extends Serializable> extends Entity {

    @Id
    protected ID id;

    private String description;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
