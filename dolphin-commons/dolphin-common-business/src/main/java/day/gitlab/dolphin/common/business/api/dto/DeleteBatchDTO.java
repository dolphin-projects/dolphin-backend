package day.gitlab.dolphin.common.business.api.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class DeleteBatchDTO<ID extends Serializable> extends BaseDTO {

    @NotEmpty
    private List<ID> ids;
}
