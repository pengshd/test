package learn.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Configuration //声明配置类
public class TaskExecutorConfig {

    @Bean
    public TaskScheduler taskScheduler() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        return new ConcurrentTaskScheduler(executorService);
    }
}