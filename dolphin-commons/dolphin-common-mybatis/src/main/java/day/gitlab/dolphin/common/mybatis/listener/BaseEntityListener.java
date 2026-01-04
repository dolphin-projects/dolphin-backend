package day.gitlab.dolphin.common.mybatis.listener;

import cn.hutool.core.util.StrUtil;
import com.mybatisflex.annotation.InsertListener;
import com.mybatisflex.annotation.UpdateListener;
import day.gitlab.dolphin.common.mybatis.entity.BaseEntity;
import day.gitlab.dolphin.common.mybatis.entity.BaseStringTreeEntity;

import java.time.LocalDateTime;

public class BaseEntityListener implements InsertListener, UpdateListener {

    @Override
    public void onInsert(Object entity) {
        if (entity instanceof BaseEntity<?> baseEntity) {
            baseEntity.setCreateTime(LocalDateTime.now());
            baseEntity.setUpdateTime(LocalDateTime.now());
        }
        if (entity instanceof BaseStringTreeEntity<?> baseStringTreeEntity) {
            if (StrUtil.isBlank(baseStringTreeEntity.getParentId())) {
                baseStringTreeEntity.setParentId(baseStringTreeEntity.getId());
            }
        }
    }

    @Override
    public void onUpdate(Object entity) {
        if (entity instanceof BaseEntity<?> baseEntity) {
            baseEntity.setUpdateTime(LocalDateTime.now());
        }
    }
}
