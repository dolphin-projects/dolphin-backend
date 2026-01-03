package day.gitlab.dolphin.module.core.service;

import day.gitlab.dolphin.common.business.service.IService;
import day.gitlab.dolphin.module.core.api.dto.DictionaryInsertDTO;
import day.gitlab.dolphin.module.core.entity.Dictionary;

public interface DictionaryService extends IService<Dictionary, String> {

    Boolean insert(DictionaryInsertDTO dto);
}
