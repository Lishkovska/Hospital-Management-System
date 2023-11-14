package com.example.hospitalmanagementsystem.service;

import com.example.hospitalmanagementsystem.models.entity.NurseEntity;
import com.example.hospitalmanagementsystem.models.entity.UserRole;
import com.example.hospitalmanagementsystem.repository.NurseRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class NurseUserDetailService implements UserDetailsService {
   private final NurseRepository nurseRepository;

    public NurseUserDetailService(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return nurseRepository.findByUsername(username)
                .map(NurseUserDetailService::map)
                .orElseThrow(() -> new UsernameNotFoundException("Nurse " + username + " not found!"));

    }
    private static UserDetails map(NurseEntity nurse){
       return User.withUsername(nurse.getUsername())
                .password(nurse.getPassword())
                .authorities(nurse.getRoles().stream().map(NurseUserDetailService::map).toList())
                .build();

    }
    private static GrantedAuthority map(UserRole userRole){
        return new SimpleGrantedAuthority(
                "ROLE_" + userRole.getRole().name()
        );
    }

}
