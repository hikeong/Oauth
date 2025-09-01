package Oauth.Oauth.repository;

import Oauth.Oauth.vo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByID (String username);
}
