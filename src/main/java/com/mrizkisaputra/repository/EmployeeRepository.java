package com.mrizkisaputra.repository;

import com.mrizkisaputra.models.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Boolean existsByUserAccount(String userAccount);
}
