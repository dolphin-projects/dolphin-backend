package day.gitlab.dolphin.common.business.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 树型表的实体类
 */
public interface TreeEntity<T extends TreeEntity<T, ID>, ID extends Serializable> {

    /**
     * 获取树型表记录的父级节点的主键，如果为空则表明当前节点为根节点
     *
     * @return 树型表记录的父级节点的主键
     */
    ID getParentId();

    /**
     * 设置树型表记录的父级节点的主键，如果为空则表明当前节点为根节点
     *
     * @param parentId 树型表记录的父级节点的主键
     */
    void setParentId(ID parentId);

    /**
     * 获取树型表记录的子级节点，如果为空则表明当前节点为叶子节点
     *
     * @return 树型表记录的子级节点
     */
    List<T> getChildren();

    /**
     * 设置树型表记录的子级节点，如果为空则表明当前节点为叶子节点
     *
     * @param children 树型表记录的子级节点
     */
    void setChildren(List<T> children);
}
