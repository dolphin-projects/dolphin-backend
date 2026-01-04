package day.gitlab.dolphin.module.core.api.dto;

import day.gitlab.dolphin.common.business.api.dto.InsertDTO;
import day.gitlab.dolphin.module.core.entity.Dictionary;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 字典表 新建操作DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = Dictionary.class)
public class DictionaryUpdateDTO extends InsertDTO {

    @NotBlank
    @Size(min = 1, max = 500)
    private String name;

    @NotBlank
    @Size(min = 1, max = 200)
    private String code;

    @NotBlank
    @Size(min = 1, max = 50)
    private String type;

    private String description;

    private List<DictionaryItemInsertDTO> itemsInsert;
    private List<DictionaryItemUpdateDTO> itemsUpdate;
    private List<String> itemsDelete;
}
