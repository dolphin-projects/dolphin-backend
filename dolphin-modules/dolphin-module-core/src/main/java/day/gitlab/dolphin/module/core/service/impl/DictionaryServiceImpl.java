package day.gitlab.dolphin.module.core.service.impl;

import day.gitlab.dolphin.common.business.service.impl.ServiceImpl;
import day.gitlab.dolphin.module.core.api.dto.DictionaryInsertDTO;
import day.gitlab.dolphin.module.core.entity.Dictionary;
import day.gitlab.dolphin.module.core.entity.DictionaryItem;
import day.gitlab.dolphin.module.core.mapper.DictionaryItemMapper;
import day.gitlab.dolphin.module.core.mapper.DictionaryMapper;
import day.gitlab.dolphin.module.core.service.DictionaryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary, String> implements DictionaryService {

    private DictionaryItemMapper dictionaryItemMapper;

    @Override
    public Boolean insert(DictionaryInsertDTO dto) {
        Dictionary dictionary = getConverter().convert(dto, Dictionary.class);
        boolean rs = this.insertEntity(dictionary);

        if (rs) {
            // insert items
            List<DictionaryItem> items = dictionary.getItems();
            if (items != null && !items.isEmpty()) {
                int itemRs = dictionaryItemMapper.insertBatchTreeEntity(items);
                log.info("insert item entity: [{}], rs: [{}]", items, itemRs);
                return itemRs > 0;
            }
        }
        return rs;
    }
}
