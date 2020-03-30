package learn.task;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service      //1.主要用于标记配置类，兼备Component的效果。
public class SaticScheduleTask {

    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    public void task1() throws InterruptedException {
        System.err.println("task1 begin: " + LocalDateTime.now());
        Thread.sleep(5000);
        System.err.println("task1 end: " + LocalDateTime.now());
    }
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    public void task2() throws InterruptedException {
        System.err.println("configureTasks2: " + LocalDateTime.now());
        Thread.sleep(10000);
    }
}