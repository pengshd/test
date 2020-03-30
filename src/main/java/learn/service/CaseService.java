package learn.service;

import learn.config.multidatasource.DataSource;
import learn.dao.mysql.CaseDao;
import learn.dao.mysql.entity.Case;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Slf4j
@Service
public class CaseService  {

    @Autowired
    CaseDao caseDao;

    @DataSource("db1")
    @Transactional
    public void testSelectOne(){
        log.info(String.valueOf(caseDao.selectNullCommentCount()));
        caseDao.fillNullComment();
        log.info(String.valueOf(caseDao.selectNullCommentCount()));
//        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }
}