package day.gitlab.dolphin.module.core.service;

import day.gitlab.dolphin.common.mybatis.service.IBaseStringService;
import day.gitlab.dolphin.module.core.api.dto.DictionaryInsertDTO;
import day.gitlab.dolphin.module.core.entity.Dictionary;
import day.gitlab.dolphin.module.core.mapper.DictionaryMapper;

public interface DictionaryService extends IBaseStringService<DictionaryMapper, Dictionary> {

    Boolean insert(DictionaryInsertDTO dto);
}
