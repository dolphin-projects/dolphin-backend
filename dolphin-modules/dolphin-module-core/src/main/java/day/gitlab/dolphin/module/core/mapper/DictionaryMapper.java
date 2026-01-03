package day.gitlab.dolphin.module.core.mapper;

import day.gitlab.dolphin.common.business.mapper.IMapper;
import day.gitlab.dolphin.module.core.entity.Dictionary;
import org.apache.ibatis.annotations.Mapper;

/**
 * 字典表 映射层。
 *
 * @author jiangyc
 * @since 2026-01-01
 */
@Mapper
public interface DictionaryMapper extends IMapper<Dictionary, String> {
}
