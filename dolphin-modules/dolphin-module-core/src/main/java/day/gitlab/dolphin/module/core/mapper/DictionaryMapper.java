package day.gitlab.dolphin.module.core.mapper;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import day.gitlab.dolphin.common.mybatis.mapper.IBaseStringMapper;
import day.gitlab.dolphin.module.core.entity.Dictionary;
import day.gitlab.dolphin.module.core.entity.table.DictionaryTableDef;
import org.apache.ibatis.annotations.Mapper;

/**
 * 字典表 映射层。
 *
 * @author jiangyc
 * @since 2026-01-01
 */
@Mapper
public interface DictionaryMapper extends IBaseStringMapper<Dictionary> {

    default Page<Dictionary> page(Number pageNum, Number pageSize, Dict query) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (query != null) {
            String name = query.getStr(DictionaryTableDef.DICTIONARY.NAME.getName().toLowerCase());
            if (StrUtil.isNotBlank(name)) {
                queryWrapper.like(DictionaryTableDef.DICTIONARY.NAME.getName(), name);
            }
            String code = query.getStr(DictionaryTableDef.DICTIONARY.CODE.getName().toLowerCase());
            if (StrUtil.isNotBlank(code)) {
                queryWrapper.like(DictionaryTableDef.DICTIONARY.CODE.getName(), code);
            }
            String type = query.getStr(DictionaryTableDef.DICTIONARY.TYPE.getName().toLowerCase());
            if (StrUtil.isNotBlank(type)) {
                queryWrapper.eq(DictionaryTableDef.DICTIONARY.TYPE.getName(), type);
            }
        }
        return this.paginateWithRelations(pageNum, pageSize, queryWrapper);
    }
}
