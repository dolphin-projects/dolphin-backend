package day.gitlab.dolphin.module.core.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 * 字典项 表定义层。
 *
 * @author jiangyc
 * @since 2026-01-01
 */
public class DictionaryItemTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 字典项
     */
    public static final DictionaryItemTableDef DICTIONARY_ITEM = new DictionaryItemTableDef();

    /**
     * 字典 ID
     */
    public final QueryColumn MASTER_ID = new QueryColumn(this, "master_id");

    /**
     * 父级ID，如果为空则为根节点
     */
    public final QueryColumn PARENT_ID = new QueryColumn(this, "parent_id");

    /**
     * 主键
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 字典项名称
     */
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 字典项代码
     */
    public final QueryColumn CODE = new QueryColumn(this, "code");

    /**
     * 字典项排序，升序排列
     */
    public final QueryColumn SORT = new QueryColumn(this, "sort");

    /**
     * 创建时间
     */
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 修改时间
     */
    public final QueryColumn UPDATE_TIME = new QueryColumn(this, "update_time");

    /**
     * 字典项描述
     */
    public final QueryColumn DESCRIPTION = new QueryColumn(this, "description");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, MASTER_ID, PARENT_ID, NAME, CODE, SORT, DESCRIPTION, CREATE_TIME, UPDATE_TIME};

    public DictionaryItemTableDef() {
        super("", "sys_core_dictionary_item");
    }

    private DictionaryItemTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public DictionaryItemTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new DictionaryItemTableDef("", "sys_core_dictionary_item", alias));
    }
}
