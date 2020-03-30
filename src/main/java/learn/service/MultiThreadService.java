package learn.service;

import learn.dao.mysql.entity.Case;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

@Service
@Slf4j
public class MultiThreadService {

    @Async
    public Future<String> outputCaseInfo(List<Case> caseList) throws Exception {

        for (Case c:
             caseList) {

            log.info(c.getName());


            throw new Exception();
        }
        return new AsyncResult<String>("hello world !!!!");

    }

    @Async("taskExecutor")
    public Future<String> test(){
        log.info("开始");
        for (int i = 0; i < 10 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("结束");
        return new AsyncResult<>("") ;
    }
}
