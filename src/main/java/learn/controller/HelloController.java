package learn.controller;

import learn.config.properties.ExteriorProperties;
import learn.service.CaseService;
import learn.task.TaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
public class HelloController {

    @Autowired
    ExteriorProperties  exteriorProperties;

    @Autowired
    CaseService caseService;

    @Autowired
    TaskManager taskManager;

    @GetMapping("/hello")
    public String hello() throws Exception {
        if(caseService!=null){
            throw new Exception("aaa");
        }
        return "hello";
    }

    @GetMapping("/updateCron")
    public void updateCron(@RequestParam("cron") long delay){
        taskManager.updateCron(delay);
    }
    @GetMapping("/init")
    public void updateCron(){
        taskManager.init();
    }

    @ExceptionHandler
    public String handleException(Exception e, WebRequest request){
        return "exception";
    }

}
