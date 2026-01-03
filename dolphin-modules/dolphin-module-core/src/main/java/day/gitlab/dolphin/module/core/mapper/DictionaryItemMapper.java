package day.gitlab.dolphin.module.core.mapper;

import day.gitlab.dolphin.common.business.mapper.ITreeMapper;
import day.gitlab.dolphin.module.core.entity.DictionaryItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * 字典项表 映射层。
 *
 * @author jiangyc
 * @since 2026-01-01
 */
@Mapper
public interface DictionaryItemMapper extends ITreeMapper<DictionaryItem, String> {
}
