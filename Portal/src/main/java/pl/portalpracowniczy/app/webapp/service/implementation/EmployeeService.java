package pl.portalpracowniczy.app.webapp.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.portalpracowniczy.app.webapp.domain.Employee;
import pl.portalpracowniczy.app.webapp.repository.EmployeeRepository;
import pl.portalpracowniczy.app.webapp.repository.EmployeeRoleRepository;

@Service
public class EmployeeService implements pl.portalpracowniczy.app.webapp.service.EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeRoleRepository employeeRoleRepository;


    @Override
    public void createEployee(Employee employee) {

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
