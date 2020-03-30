package learn.config.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(0)
public class ExtendConfiguration2 extends BaseConfiguration{
}
