package day.gitlab.dolphin.module.core.api.dto;

import day.gitlab.dolphin.common.business.api.dto.TreeInsertDTO;
import day.gitlab.dolphin.module.core.entity.DictionaryItem;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 * 字典项表 新增操作DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = DictionaryItem.class)
public class DictionaryItemInsertDTO extends TreeInsertDTO<DictionaryItemInsertDTO> {

    private String masterId;

    @NotBlank
    @Size(min = 1, max = 500)
    private String name;

    @NotBlank
    @Size(min = 1, max = 500)
    private String code;

    private Integer sort;

    private String description;
}
