package day.gitlab.dolphin.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 * 字典 表定义层。
 *
 * @author jiangyc
 * @since 2026-01-01
 */
public class DictionaryTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 字典
     */
    public static final DictionaryTableDef DICTIONARY = new DictionaryTableDef();

    /**
     * 主键
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 字典代码
     */
    public final QueryColumn CODE = new QueryColumn(this, "code");

    /**
     * 字典名称
     */
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 字典类型: enum-枚举、tree-树型
     */
    public final QueryColumn TYPE = new QueryColumn(this, "type");

    /**
     * 创建时间
     */
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 修改时间
     */
    public final QueryColumn UPDATE_TIME = new QueryColumn(this, "update_time");

    /**
     * 字典描述
     */
    public final QueryColumn DESCRIPTION = new QueryColumn(this, "description");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, NAME, CODE, TYPE, DESCRIPTION, CREATE_TIME, UPDATE_TIME};

    public DictionaryTableDef() {
        super("", "sys_core_dictionary");
    }

    private DictionaryTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public DictionaryTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new DictionaryTableDef("", "sys_core_dictionary", alias));
    }

}
