package day.gitlab.dolphin.module.core.service.impl;

import cn.hutool.core.lang.Dict;
import com.mybatisflex.core.paginate.Page;
import day.gitlab.dolphin.common.business.api.dto.PageDTO;
import day.gitlab.dolphin.common.business.api.vo.PageVO;
import day.gitlab.dolphin.common.mybatis.service.impl.BaseStringServiceImpl;
import day.gitlab.dolphin.module.core.api.dto.DictionaryInsertDTO;
import day.gitlab.dolphin.module.core.api.dto.DictionaryItemInsertDTO;
import day.gitlab.dolphin.module.core.api.dto.DictionaryUpdateDTO;
import day.gitlab.dolphin.module.core.api.vo.DictionaryVO;
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

import java.util.Collection;
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
    public Boolean doInsert(DictionaryInsertDTO dto) {
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

    @Override
    public Boolean doDelete(String id) {
        dictionaryItemMapper.deleteByMasterId(id);
        return this.deleteById(id);
    }

    @Override
    public Boolean doDeleteBatch(Collection<String> ids) {
        dictionaryItemMapper.deleteBatchByMasterId(ids);
        return this.deleteBatchById(ids);
    }

    @Override
    public Boolean doUpdate(DictionaryUpdateDTO dto) {
        Dictionary dictionary = getConverter().convert(dto, Dictionary.class);
        boolean rs = this.update(dictionary);
        if (rs) {
            // insert items
            List<DictionaryItem> itemsInsert = getConverter().convert(dto.getItemsInsert(), DictionaryItem.class);
            if (itemsInsert != null && !itemsInsert.isEmpty()) {
                int itemRs = dictionaryItemMapper.insertBatchTreeEntity(itemsInsert);
                log.info("insert items entity: [{}], rs: [{}]", itemsInsert, itemRs);
            }
            List<DictionaryItem> itemsUpdate = getConverter().convert(dto.getItemsUpdate(), DictionaryItem.class);
            if (itemsUpdate != null && !itemsUpdate.isEmpty()) {
                int itemRs = 0;
                for (DictionaryItem dictionaryItem : itemsUpdate) {
                    itemRs += dictionaryItemMapper.update(dictionaryItem);
                }
                log.info("update items entity: [{}], rs: [{}]", itemsUpdate, itemRs);
            }
            List<String> itemsDelete = dto.getItemsDelete();
            dictionaryItemMapper.deleteBatchByIds(itemsDelete);
        }
        return rs;
    }

    @Override
    public PageVO<DictionaryVO> doSelect(Number pageIndex, Number pageSize, Dict query) {
        Page<Dictionary> page = mapper.page(pageIndex, pageSize, query);
        return PageVO.of(page, getConverter().convert(page.getRecords(), DictionaryVO.class));
    }
}
