package org.example.config.security;

import lombok.RequiredArgsConstructor;
import org.example.entity.MyUser;
import org.example.entity.Role;
import org.example.repo.RoleRepo;
import org.example.repo.UserRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
    @RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
        private final UserRepo userRepo;
        private final RoleRepo roleRepo;
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            MyUser user = userRepo.findByEmail(username);
            List<Role> roles=roleRepo.findAllRoles(user);
            user.setRoles(roles);
            return user;
        }
    }

