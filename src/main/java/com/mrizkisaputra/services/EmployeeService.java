package com.mrizkisaputra.services;

import com.mrizkisaputra.models.dto.CreateEmployeeDTO;
import com.mrizkisaputra.models.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    void registration(CreateEmployeeDTO employeeDTO);

    void removeEmployee(String id);

    default public Boolean existUserAccount(String userAccount) {
        return Boolean.TRUE;
    }
}
