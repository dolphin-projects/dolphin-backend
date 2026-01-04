package day.gitlab.dolphin.common.mybatis;

import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.core.FlexGlobalConfig;
import com.mybatisflex.core.audit.AuditManager;
import com.mybatisflex.core.keygen.KeyGeneratorFactory;
import com.mybatisflex.spring.boot.MyBatisFlexCustomizer;
import day.gitlab.dolphin.common.mybatis.entity.BaseEntity;
import day.gitlab.dolphin.common.mybatis.listener.BaseEntityListener;
import day.gitlab.dolphin.common.mybatis.util.UUIDv7KeyGenerator;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfiguration implements MyBatisFlexCustomizer {

    static {
        AuditManager.setAuditEnable(true);
        KeyGeneratorFactory.register("uuidv7", new UUIDv7KeyGenerator());
    }

    @Override
    public void customize(FlexGlobalConfig flexGlobalConfig) {
        FlexGlobalConfig.KeyConfig keyConfig = new FlexGlobalConfig.KeyConfig();
        keyConfig.setKeyType(KeyType.Generator);
        keyConfig.setBefore(true);
        keyConfig.setValue("uuidv7");
        flexGlobalConfig.setKeyConfig(keyConfig);

        flexGlobalConfig.registerInsertListener(new BaseEntityListener(), BaseEntity.class);
    }
}
