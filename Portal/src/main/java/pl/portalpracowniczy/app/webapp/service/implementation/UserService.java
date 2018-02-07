package pl.portalpracowniczy.app.webapp.service.implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.portalpracowniczy.app.webapp.domain.Role;
import pl.portalpracowniczy.app.webapp.domain.User;
import pl.portalpracowniczy.app.webapp.repository.RoleRepository;
import pl.portalpracowniczy.app.webapp.repository.SystemUserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements pl.portalpracowniczy.app.webapp.service.UserService {

    @Autowired
   private SystemUserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByMail(email);
    }

    @Override
    public User getUserByConfirmationId(String uuid) {
        return userRepository.findByConfirmationId(uuid);
    }

    @Override
    public void saveUser(User user) {
//        mylist.stream().collect(Collectors.toSet()));
        List<Role> roles = roleRepository.findAll();
        user.setRoles(roles.stream().collect(Collectors.toSet()));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public void updateUser(String rola, User user) {

    }

    public void update(User user){
        userRepository.save(user);
    }
}
