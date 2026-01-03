package day.gitlab.dolphin.common.business.config;

import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.core.FlexGlobalConfig;
import com.mybatisflex.core.audit.AuditManager;
import com.mybatisflex.core.keygen.IKeyGenerator;
import com.mybatisflex.core.keygen.KeyGeneratorFactory;
import com.mybatisflex.spring.boot.MyBatisFlexCustomizer;
import day.gitlab.dolphin.common.core.util.UUIDv7;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisFlexConfiguration implements MyBatisFlexCustomizer {

    static {
        AuditManager.setAuditEnable(true);
        KeyGeneratorFactory.register("uuidv7", new UUIDv7KeyGenerator());
    }

    @Override
    public void customize(FlexGlobalConfig flexGlobalConfig) {
        FlexGlobalConfig.KeyConfig keyConfig = new FlexGlobalConfig.KeyConfig();
        keyConfig.setBefore(true);
        keyConfig.setKeyType(KeyType.Generator);
        keyConfig.setValue("uuidv7");
        flexGlobalConfig.setKeyConfig(keyConfig);
    }

    public static class UUIDv7KeyGenerator implements IKeyGenerator {

        @Override
        public Object generate(Object o, String s) {
            return UUIDv7.randomUUID().toString();
        }
    }
}
