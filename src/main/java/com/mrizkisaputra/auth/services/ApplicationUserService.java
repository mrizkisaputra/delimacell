package com.mrizkisaputra.auth.services;

import com.mrizkisaputra.auth.models.entity.ApplicationUser;
import com.mrizkisaputra.auth.repository.ApplicationUserRepository;
import com.mrizkisaputra.models.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplicationUserService {
    @Autowired
    ApplicationUserRepository userRepository;

    public String findRoleNameByUsername(String username) {
        String result = userRepository.findRoleNameByUsername(username);
        return result.split(",")[0];
    }

    public void saveEmployeeAccount(ApplicationUser user) {
        userRepository.save(user);
    }

    @Transactional
    public void deleteUserAccount(String id) {
        userRepository.deleteByEmployee_Id(id);
    }

}
