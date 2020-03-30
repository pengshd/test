package learn.dao.mysql;

import learn.dao.mysql.entity.Case;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CaseDao {

    @Select("select count(1) from case_tbl where comment = ''")
    int selectNullCommentCount();

    @Update("update case_tbl set comment = 'test' where comment = '' limit 1")
    void fillNullComment();

    String findNameByDateCreated(Case tcase);

    @Select("select * from case_tbl")
    List<Case> listAll();
}
