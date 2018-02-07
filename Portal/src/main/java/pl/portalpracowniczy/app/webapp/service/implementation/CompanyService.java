package pl.portalpracowniczy.app.webapp.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.portalpracowniczy.app.webapp.domain.Company;
import pl.portalpracowniczy.app.webapp.repository.CompanyRepository;

@Service
public class CompanyService implements pl.portalpracowniczy.app.webapp.service.CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company createEployee(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void readEmployee() {

    }

    @Override
    public void updateEmployee() {

    }

    @Override
    public void delateEmployee() {

    }
}
