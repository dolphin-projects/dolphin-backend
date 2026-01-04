package day.gitlab.dolphin.common.mybatis.util;

import com.mybatisflex.core.keygen.IKeyGenerator;
import day.gitlab.dolphin.common.core.util.UUIDv7;

public class UUIDv7KeyGenerator implements IKeyGenerator {

    @Override
    public Object generate(Object entity, String keyColumn) {
        return UUIDv7.randomUUID().toString();
    }
}
