package learn.config.test;

import org.springframework.context.annotation.Bean;

public class BaseConfiguration {

    @Bean
    public BeanVO bean(){
        return new BeanVO();

    }
}
