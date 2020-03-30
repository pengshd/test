package learn.dao.mysql;

import common.SpringTest;
import learn.config.DataSourceConfiguration;
import learn.config.multidatasource.DataSource;
import learn.dao.mysql.entity.Case;
import learn.service.CaseService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

@Slf4j
@ContextConfiguration(classes={DataSourceConfiguration.class})
@Component
public class CaseDaoTest extends SpringTest {

    @Autowired
    CaseService caseService;

    @Autowired
    CaseDao caseDao;

    @Test
    @DataSource("db2")
    public void testSelectOne(){
//        DataSourceContextHolder.setDataSource("db2");
        Case aCase = new Case();
        aCase.setCreatedDate(null);
        caseDao.findNameByDateCreated(aCase);
    }

}