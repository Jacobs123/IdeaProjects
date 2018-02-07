package pl.portalpracowniczy.app.webapp.temporary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.portalpracowniczy.app.webapp.domain.Employee;
import pl.portalpracowniczy.app.webapp.domain.EmployeeRole;
import pl.portalpracowniczy.app.webapp.domain.Role;
import pl.portalpracowniczy.app.webapp.domain.User;
import pl.portalpracowniczy.app.webapp.repository.EmployeeRoleRepository;
import pl.portalpracowniczy.app.webapp.repository.RoleRepository;
import pl.portalpracowniczy.app.webapp.repository.SystemUserRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

public class UsersCreator {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private SystemUserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    private Set<Role> role = new HashSet<>();;
    private User user;

    public void  create(){
       Role userrole = new Role("ROLE_USER");
       user = new User();
       role.add(userrole);
       user.setName("user");
       user.setActive(1);
       user.setMail("user@user.pl");
       user.setRoles(role);
       roleRepository.save(userrole);
       userRepository.save(user);
    }
}
