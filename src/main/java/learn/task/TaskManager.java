package learn.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.MethodInvokingRunnable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.concurrent.ScheduledFuture;

@Service
@Slf4j
public class TaskManager {

    @Autowired
    TaskScheduler taskScheduler;

    @Autowired
    SaticScheduleTask saticScheduleTask;

    Runnable runnable;

    ScheduledFuture<?> schedule;

    public void init(){
        MethodInvokingRunnable runnable = new MethodInvokingRunnable();
        runnable.setTargetClass(SaticScheduleTask.class);
        Method method = null;
        try {
            method = SaticScheduleTask.class.getMethod("task1");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        runnable.setTargetClass(saticScheduleTask.getClass());
        runnable.setTargetMethod(method.getName());
        runnable.setArguments(new Object[0]);
        runnable.setTargetObject(saticScheduleTask);
        try {
            runnable.prepare();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        this.runnable = runnable;
        schedule = taskScheduler.scheduleWithFixedDelay(this.runnable,3000);
    }

    public void updateCron(long delay){
        log.info("变更执行计划delay="+delay);
        schedule.cancel(false);
        schedule = taskScheduler.scheduleWithFixedDelay(this.runnable,delay);
    }
}
