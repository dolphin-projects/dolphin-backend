package day.gitlab.dolphin.common.business.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class DeleteDTO<ID extends Serializable> extends BaseDTO {

    @NotNull
    private ID id;
}
