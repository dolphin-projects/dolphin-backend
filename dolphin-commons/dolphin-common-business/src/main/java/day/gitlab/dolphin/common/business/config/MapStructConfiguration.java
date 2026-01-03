package day.gitlab.dolphin.common.business.config;

import io.github.linpeilie.Converter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapStructConfiguration {

    @Bean
    public Converter getConverter() {
        return new Converter();
    }
}
