package pl.portalpracowniczy.app.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.portalpracowniczy.app.webapp.domain.User;

@Repository
public interface SystemUserRepository extends JpaRepository<User, Integer> {

    User findByMail(String email);
    User findByConfirmationId(String uuid);
}
