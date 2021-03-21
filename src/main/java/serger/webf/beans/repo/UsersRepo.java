package serger.webf.beans.repo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import serger.webf.beans.domain.User;

public interface UsersRepo extends CrudRepository<User, Long> {

    List<User> findAll();

    User findFirstByName(String name);

}
