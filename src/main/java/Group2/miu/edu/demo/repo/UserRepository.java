package Group2.miu.edu.demo.repo;

import Group2.miu.edu.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUserName(String userName);

}
