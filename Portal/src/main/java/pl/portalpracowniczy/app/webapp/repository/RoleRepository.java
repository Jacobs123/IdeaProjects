package pl.portalpracowniczy.app.webapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.portalpracowniczy.app.webapp.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

    Role findByName(String name);
}
