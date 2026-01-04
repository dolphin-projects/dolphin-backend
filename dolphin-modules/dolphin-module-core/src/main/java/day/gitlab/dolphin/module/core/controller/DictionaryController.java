package day.gitlab.dolphin.module.core.controller;

import day.gitlab.dolphin.common.business.api.R;
import day.gitlab.dolphin.common.business.api.dto.DeleteBatchDTO;
import day.gitlab.dolphin.common.business.api.dto.DeleteDTO;
import day.gitlab.dolphin.common.business.api.dto.PageDTO;
import day.gitlab.dolphin.common.business.api.vo.PageVO;
import day.gitlab.dolphin.common.business.controller.BaseController;
import day.gitlab.dolphin.module.core.api.dto.DictionaryInsertDTO;
import day.gitlab.dolphin.module.core.api.dto.DictionaryUpdateDTO;
import day.gitlab.dolphin.module.core.api.vo.DictionaryVO;
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
        return R.success(dictionaryService.doInsert(dto));
    }

    @PostMapping("/delete")
    public R<Boolean> delete(@RequestBody DeleteDTO<String> dto) {
        return R.success(dictionaryService.doDelete(dto.getId()));
    }

    @PostMapping("/deleteBatch")
    public R<Boolean> deleteBatch(@RequestBody DeleteBatchDTO<String> dto) {
        return R.success(dictionaryService.doDeleteBatch(dto.getIds()));
    }

    @PostMapping("/update")
    public R<Boolean> update(@RequestBody DictionaryUpdateDTO dto) {
        return R.success(dictionaryService.doUpdate(dto));
    }

    @PostMapping("/select")
    public R<PageVO<DictionaryVO>> select(@RequestBody PageDTO dto) {
        return R.success(dictionaryService.doSelect(dto.getPageIndex(), dto.getPageSize(), dto.getQuery()));
    }
}
