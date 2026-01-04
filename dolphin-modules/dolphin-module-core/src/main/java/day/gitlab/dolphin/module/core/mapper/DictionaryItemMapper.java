package day.gitlab.dolphin.module.core.mapper;

import day.gitlab.dolphin.common.mybatis.mapper.IBaseStringTreeMapper;
import day.gitlab.dolphin.module.core.entity.DictionaryItem;
import day.gitlab.dolphin.module.core.entity.table.DictionaryItemTableDef;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

/**
 * 字典项表 映射层。
 *
 * @author jiangyc
 * @since 2026-01-01
 */
@Mapper
public interface DictionaryItemMapper extends IBaseStringTreeMapper<DictionaryItem> {

    default int deleteByMasterId(String masterId) {
        return this.deleteByCondition(DictionaryItemTableDef.DICTIONARY_ITEM.MASTER_ID.eq(masterId));
    }

    default int deleteBatchByMasterId(Collection<String> masterIds) {
        return this.deleteByCondition(DictionaryItemTableDef.DICTIONARY_ITEM.MASTER_ID.in(masterIds));
    }
}
