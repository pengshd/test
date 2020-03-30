package learn;

import learn.config.properties.ExteriorProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableConfigurationProperties({ExteriorProperties.class})
@ServletComponentScan(basePackages = {"learn.druid"})
@EnableSwagger2
@EnableScheduling   // 2.开启定时任务
@EnableAsync
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
