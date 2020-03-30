package learn.dao.mongo;

import common.SpringTest;
import learn.dao.mongo.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Slf4j
public class UserDaoTest extends SpringTest {

    @Autowired
    UserDao userDao;

    @Test
    public void testFindAllBySex() {
        log.info(userDao.findAll().toString());
        log.info(userDao.findAllBySex("M").toString());
    }

}