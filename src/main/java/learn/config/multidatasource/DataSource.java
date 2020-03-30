package learn.config.multidatasource;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    @AliasFor("dataSource")
    String value() default "";

    @AliasFor("value")
    String dataSource() default "";
}
