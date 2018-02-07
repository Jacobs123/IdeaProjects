package pl.portalpracowniczy.app.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.portalpracowniczy.app.webapp.domain.EmployeeRole;


@Repository
public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole, Integer> {
}
