package com.xuanphi.securityjpa.service;

import com.xuanphi.securityjpa.dao.RoleRepository;
import com.xuanphi.securityjpa.dao.UserRepository;
import com.xuanphi.securityjpa.entity.Role;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import com.xuanphi.securityjpa.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void insertUser() {
        User user1 = new User();
        user1.setUsername("xuanphi");
        user1.setPassword("$2a$12$GYoMADwErXnxEgEmx0NmHucMYedLsHW0NiWflGlcW4xmcWqyY8nyS");
        user1.setEnabled(true);

        Role role1 = new Role();
        role1.setName("ROLE_ADMIN");

        Role role2 = new Role();
        role2.setName("ROLE_USER");

        Collection<Role> roles = new ArrayList<>();
        roles.add(role1);
        roles.add(role2);

        user1.setRoles(roles);

        userRepository.save(user1);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), rolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
