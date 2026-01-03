package day.gitlab.dolphin.common.business.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TreeInsertDTO <T extends TreeInsertDTO<T>> extends InsertDTO {

    protected List<T> children;
}
