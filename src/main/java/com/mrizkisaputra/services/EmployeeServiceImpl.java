package com.mrizkisaputra.services;

import com.mrizkisaputra.auth.models.entity.ApplicationUser;
import com.mrizkisaputra.auth.models.entity.Role;
import com.mrizkisaputra.auth.repository.ApplicationRoleRepository;
import com.mrizkisaputra.auth.repository.ApplicationUserRepository;
import com.mrizkisaputra.auth.services.ApplicationUserService;
import com.mrizkisaputra.models.dto.CreateEmployeeDTO;
import com.mrizkisaputra.models.entity.Employee;
import com.mrizkisaputra.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.NumberFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ApplicationUserService userService;

    @Autowired
    private ApplicationRoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Transactional
    @Override
    public void registration(CreateEmployeeDTO employeeDTO) {


        // mengambil waktu saat ini lalu di format berdasarkan kebutuhan
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        String dateTime = ZonedDateTime.now(ZoneId.systemDefault()).format(formatter);

        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
        String formatted = currencyInstance.format(employeeDTO.getSalary());

        // menambahkan data di dalam table employees
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setRegistrated(dateTime);
        employee.setSalary(formatted);
        employee.setWorkLocation(employeeDTO.getWorkLocation());
        employee.setUserAccount(employeeDTO.getUserAccount());
        employee.setPasswordAccount(employeeDTO.getPasswordAccount());
        Employee result = employeeRepository.save(employee);

        // menambahkan data di dalam table s_users
        ApplicationUser appUser = new ApplicationUser();
        appUser.setUsername(result.getUserAccount());
        appUser.setPassword(passwordEncoder.encode(result.getPasswordAccount()));
        appUser.setRole(roleRepository.findByName(Role.EMPLOYE));
        appUser.setEmployee(employee);
        userService.saveEmployeeAccount(appUser);
    }

    @Override
    public void removeEmployee(String id) {
        userService.deleteUserAccount(id);
        employeeRepository.deleteById(id);
    }

    @Override
    public Boolean existUserAccount(String userAccount) {
        return employeeRepository.existsByUserAccount(userAccount);
    }

}
