package day.gitlab.dolphin.module.core.controller;

import day.gitlab.dolphin.common.business.api.vo.R;
import day.gitlab.dolphin.common.business.controller.BaseController;
import day.gitlab.dolphin.module.core.api.dto.DictionaryInsertDTO;
import day.gitlab.dolphin.module.core.service.DictionaryService;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@EqualsAndHashCode(callSuper = true)
@RequestMapping("/sys/core/dictionary")
public class DictionaryController extends BaseController {

    @Resource
    private DictionaryService dictionaryService;

    @PostMapping("/insert")
    public R<Boolean> insert(@RequestBody DictionaryInsertDTO dto) {
        return R.success(dictionaryService.insert(dto));
    }
}
