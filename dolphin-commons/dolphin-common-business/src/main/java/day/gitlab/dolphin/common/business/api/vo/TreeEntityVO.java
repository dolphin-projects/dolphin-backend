package day.gitlab.dolphin.common.business.api.vo;

import java.util.List;

public interface TreeEntityVO<T extends TreeEntityVO<T>> {

    String getParentId();

    void setParentId(String parentId);

    List<T> getChildren();

    void setChildren(List<T> children);
}
