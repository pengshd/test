package learn.dao;

import common.SpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.junit.Assert.*;

@Slf4j
public class DataSourceConfigurationTest extends SpringTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void testDB() throws SQLException {
        log.info(dataSource.getConnection().getSchema());
    }

}