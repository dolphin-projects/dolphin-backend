package day.gitlab.dolphin.module.core.service;

import cn.hutool.core.lang.Dict;
import day.gitlab.dolphin.common.business.api.vo.PageVO;
import day.gitlab.dolphin.common.mybatis.service.IBaseStringService;
import day.gitlab.dolphin.module.core.api.dto.DictionaryInsertDTO;
import day.gitlab.dolphin.module.core.api.dto.DictionaryUpdateDTO;
import day.gitlab.dolphin.module.core.api.vo.DictionaryVO;
import day.gitlab.dolphin.module.core.entity.Dictionary;
import day.gitlab.dolphin.module.core.mapper.DictionaryMapper;

import java.util.Collection;

public interface DictionaryService extends IBaseStringService<DictionaryMapper, Dictionary> {

    Boolean doInsert(DictionaryInsertDTO dto);

    Boolean doDelete(String id);

    Boolean doDeleteBatch(Collection<String> ids);

    Boolean doUpdate(DictionaryUpdateDTO dto);

    PageVO<DictionaryVO> doSelect(Number pageIndex, Number pageSize, Dict query);
}
