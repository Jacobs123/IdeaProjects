package pl.portalpracowniczy.app.webapp.service;


import pl.portalpracowniczy.app.webapp.domain.Employee;
import pl.portalpracowniczy.app.webapp.service.implementation.EmployeeRoleService;

public interface EmployeeService {
    /**
     * CRUD function definition's
     */
    public void createEployee(Employee employee);
    public void readEmployee();
    public void updateEmployee();
    public void delateEmployee();


}
