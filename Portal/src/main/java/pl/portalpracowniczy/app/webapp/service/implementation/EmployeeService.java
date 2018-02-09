package pl.portalpracowniczy.app.webapp.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.portalpracowniczy.app.webapp.domain.Employee;
import pl.portalpracowniczy.app.webapp.domain.EmployeeRole;
import pl.portalpracowniczy.app.webapp.domain.Role;
import pl.portalpracowniczy.app.webapp.repository.EmployeeRepository;
import pl.portalpracowniczy.app.webapp.repository.EmployeeRoleRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements pl.portalpracowniczy.app.webapp.service.EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeRoleRepository employeeRoleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void createEployee(Employee employee) {
        List<EmployeeRole> roles = employeeRoleRepository.findAll();
        employee.setRoles(roles.stream().collect(Collectors.toSet()));
        employeeRepository.save(employee);
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
