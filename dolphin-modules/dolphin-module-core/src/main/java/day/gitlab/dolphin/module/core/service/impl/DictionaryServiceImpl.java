package day.gitlab.dolphin.module.core.service.impl;

import day.gitlab.dolphin.common.mybatis.service.impl.BaseStringServiceImpl;
import day.gitlab.dolphin.module.core.api.dto.DictionaryInsertDTO;
import day.gitlab.dolphin.module.core.entity.Dictionary;
import day.gitlab.dolphin.module.core.entity.DictionaryItem;
import day.gitlab.dolphin.module.core.mapper.DictionaryItemMapper;
import day.gitlab.dolphin.module.core.mapper.DictionaryMapper;
import day.gitlab.dolphin.module.core.service.DictionaryService;
import io.github.linpeilie.Converter;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Slf4j
@Service
@EqualsAndHashCode(callSuper = true)
public class DictionaryServiceImpl extends BaseStringServiceImpl<DictionaryMapper, Dictionary> implements DictionaryService {

    @Resource
    private Converter converter;

    @Resource
    private DictionaryMapper mapper;

    @Resource
    private DictionaryItemMapper dictionaryItemMapper;

    @Override
    public Boolean insert(DictionaryInsertDTO dto) {
        Dictionary dictionary = getConverter().convert(dto, Dictionary.class);
        boolean rs = this.insert(dictionary);

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
