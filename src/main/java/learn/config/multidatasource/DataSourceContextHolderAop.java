package learn.config.multidatasource;

import learn.config.multidatasource.DataSource;
import learn.config.multidatasource.DataSourceContextHolder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
@Order(9999)
public class DataSourceContextHolderAop {
    //@within在类上设置
    //@annotation在方法上进行设置
    @Pointcut("@within(learn.config.multidatasource.DataSource)||@annotation(learn.config.multidatasource.DataSource)")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        DataSource annotationClass = AnnotationUtils.getAnnotation(method, DataSource.class);
        if (annotationClass == null) {
            annotationClass = AnnotationUtils.getAnnotation(joinPoint.getTarget().getClass(), DataSource.class);
            if (annotationClass == null) return;
        }
        //获取注解上的数据源的值的信息
        String dataSourceKey = annotationClass.dataSource();
        if (dataSourceKey != null) {
            //给当前的执行SQL的操作设置特殊的数据源的信息
            DataSourceContextHolder.setDataSource(dataSourceKey);
        }
        log.info("AOP动态切换数据源，className" + joinPoint.getTarget().getClass().getName() + "methodName" + method.getName() + ";dataSourceKey:" + dataSourceKey == "" ? "默认数据源" : dataSourceKey);
    }

    @After("pointcut()")
    public void after(JoinPoint point) {
        //清理掉当前设置的数据源，让默认的数据源不受影响
        DataSourceContextHolder.clear();
    }

}