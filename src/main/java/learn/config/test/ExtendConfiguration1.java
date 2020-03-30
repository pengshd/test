package learn.config.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(1)
public class ExtendConfiguration1 extends BaseConfiguration{

}
