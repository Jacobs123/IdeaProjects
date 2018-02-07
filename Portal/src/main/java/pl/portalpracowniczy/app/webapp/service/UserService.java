package pl.portalpracowniczy.app.webapp.service;
import pl.portalpracowniczy.app.webapp.domain.User;

import java.util.List;

public interface UserService {

    public User findUserByEmail(String email);

    public User getUserByConfirmationId(String uuid);

    public void saveUser(User user);

    public List<User> findAll();

    public User findUserById(int id);

    public void updateUser(String rola, User user);

    public void update(User user);
}
