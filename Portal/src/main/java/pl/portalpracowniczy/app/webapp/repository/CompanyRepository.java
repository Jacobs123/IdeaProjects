package pl.portalpracowniczy.app.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.portalpracowniczy.app.webapp.domain.Company;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
