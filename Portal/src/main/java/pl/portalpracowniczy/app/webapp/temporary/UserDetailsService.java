package pl.portalpracowniczy.app.webapp.temporary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.portalpracowniczy.app.webapp.domain.Role;
import pl.portalpracowniczy.app.webapp.domain.User;
import pl.portalpracowniczy.app.webapp.repository.SystemUserRepository;

import java.util.HashSet;
import java.util.Set;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private SystemUserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findByMail(s);

        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        for(Role role: user.getRoles()){
            grantedAuthoritySet.add(new SimpleGrantedAuthority(role.getName()));


        }
        return null;
    }
}


