package learn.dao;

import common.SpringTest;
import learn.dao.mysql.CaseDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MybatisTest extends SpringTest {

    @Autowired
    CaseDao caseDao;

    @Test
    public void test(){
    }
}
