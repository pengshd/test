package learn.service;

import common.SpringTest;
import learn.dao.mysql.CaseDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.concurrent.Future;

@Slf4j
public class MultiThreadServiceTest  extends SpringTest {

    @Autowired
    MultiThreadService multiThreadService;

    @Autowired
    CaseDao caseDao;

    @Test
    public void outputCaseInfo() throws Exception {

        Future<String> future = multiThreadService.outputCaseInfo(caseDao.listAll());

        for (int i = 0; i < 10; i++) {
            log.info("aaaaa");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        /*while (true){
            if(future.isDone()){
                log.info("获取到异步线程执行结果："+future.get());
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }


    @Test
    public void test(){
        LinkedList<Future<String>> futures = new LinkedList<>();
        for (int i = 0; i < 30; i++) {
            log.info("启动线程"+i);
            Future<String> f = multiThreadService.test();
            futures.add(f);
        }
        int count = 0;
        while(true){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean isDone = true;
            for (Future<String> f:
                 futures) {
                if(!f.isDone()){
                    count++;
                    isDone=false;
                }
            }
            if(isDone){
                break;
            }
        }
        log.info(String.valueOf(count));
    }
}