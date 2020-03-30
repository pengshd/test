package learn.config;

import com.alibaba.druid.pool.DruidDataSource;
import learn.config.multidatasource.MultiChooseDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Configuration
//@EnableAspectJAutoProxy
//@ComponentScan("learn.*")
public class DataSourceConfiguration {

    @Value("${druid.filters}")
    String filters;

    @Bean("dataSource1")
    @ConfigurationProperties("spring.datasource.db1")
    public DataSource getDataSource1() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setFilters(filters);
        return druidDataSource;
    }

    @Bean("dataSource2")
    @ConfigurationProperties("spring.datasource.db2")
    public DataSource getDataSource2() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setFilters(filters);
        return druidDataSource;
    }

    @Bean("dataSourceChoose")
    @Primary
    //下面一句解决循环依赖的问题
    @DependsOn({"dataSource1", "dataSource2"})
    public DataSource getChoosedDataSource(@Qualifier("dataSource1") DataSource dataSource1, @Qualifier("dataSource2") DataSource dataSource2) throws SQLException {
        MultiChooseDataSource dataSource = new MultiChooseDataSource();
        dataSource.setDefaultTargetDataSource(dataSource1);
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put("db1", dataSource1);
        dataSourceMap.put("db2", dataSource2);
        dataSource.setTargetDataSources(dataSourceMap);
        return dataSource;
    }
}
