package learn.dao.mongo;

import learn.dao.mongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends MongoRepository<User,String> {

    List<User> findAllBySex(String sex);
}
