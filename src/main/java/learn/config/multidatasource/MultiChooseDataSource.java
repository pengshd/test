package learn.config.multidatasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultiChooseDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }
}
