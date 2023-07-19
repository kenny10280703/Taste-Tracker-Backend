package com.kenny.tastetracker.Service;

import com.kenny.tastetracker.Entity.User;
import com.kenny.tastetracker.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(username).password(user.getPassword()).roles("USER").build();
        if (userDetails == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return userDetails;
    }
}
