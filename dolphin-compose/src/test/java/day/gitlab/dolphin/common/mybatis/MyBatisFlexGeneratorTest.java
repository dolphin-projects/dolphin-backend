package day.gitlab.dolphin.common.mybatis;

import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.GlobalConfig;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.Set;

@SpringBootTest
public class MyBatisFlexGeneratorTest {

    private static final String BASE_PACKAGE = "day.gitlab.dolphin";
    private static final String GEN_TABLE_PREFIX = "sys_core_";
    private static final Set<String> GEN_TABLES = Set.of("sys_core_dictionary", "sys_core_dictionary_item");

    @Resource
    private DataSource dataSource;

    @Test
    public void testGenerate() {
        GlobalConfig globalConfig = initGlobalConfig();
        Generator generator = new Generator(dataSource, globalConfig);
        generator.generate();
    }

    private GlobalConfig initGlobalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();

        globalConfig.getPackageConfig()
                .setBasePackage(BASE_PACKAGE)
                .setEntityPackage(BASE_PACKAGE.concat(".entity"))
                .setMapperPackage(BASE_PACKAGE.concat(".mapper"))
                .setTableDefPackage(BASE_PACKAGE.concat(".entity.table"))
                .setServicePackage(BASE_PACKAGE.concat(".service"))
                .setServiceImplPackage(BASE_PACKAGE.concat(".service.impl"))
                .setControllerPackage(BASE_PACKAGE.concat(".controller"));

        globalConfig.getStrategyConfig()
                .setTablePrefix(GEN_TABLE_PREFIX)
                .setGenerateTables(GEN_TABLES);

        globalConfig.enableEntity()
                .setWithLombok(true)
                .setOverwriteEnable(false)
//                .setSuperClass(BaseEntity.class)
                .setJdkVersion(25);

        globalConfig.enableTableDef()
                .setOverwriteEnable(false);

        globalConfig.enableMapper()
                .setOverwriteEnable(false);

        return globalConfig;
    }
}
