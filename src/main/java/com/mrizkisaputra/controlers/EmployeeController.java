package com.mrizkisaputra.controlers;

import com.mrizkisaputra.auth.services.ApplicationUserService;
import com.mrizkisaputra.models.dto.CreateEmployeeDTO;
import com.mrizkisaputra.models.entity.Employee;
import com.mrizkisaputra.models.entity.WorkLocation;
import com.mrizkisaputra.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    ApplicationUserService userService;

    @GetMapping(path = "/employees")
    public String employeeView(Authentication user, Model model) {
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);

        // untuk menampilkan text login sebagai admin/karyawan
        String role = userService.findRoleNameByUsername(user.getName());
        model.addAttribute("loggedInAs", role);

        return "employee";
    }

    @GetMapping(path = "/employee/registration")
    public String employeeRegistration(Authentication user, Model model) {
        model.addAttribute("employee", new CreateEmployeeDTO());
        model.addAttribute("workLocations", WorkLocation.values());

        // untuk menampilkan text login sebagai admin/karyawan
        String role = userService.findRoleNameByUsername(user.getName());
        model.addAttribute("loggedInAs", role);

        return "employee-registration";
    }

    @PostMapping(path = "/employee/registration", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String employeeRegistration(@Valid @ModelAttribute("employee") CreateEmployeeDTO employee, BindingResult bindingResult, Model model) {
        if (employeeService.existUserAccount(employee.getUserAccount())) {
            model.addAttribute("existUserAccount", "User Account is already registered");
            model.addAttribute("workLocations", WorkLocation.values());
            return "employee-registration";
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("workLocations", WorkLocation.values());
            return "employee-registration";
        }
        employeeService.registration(employee);
        return "redirect:/employees";
    }

    @GetMapping(path = "/employees/{id}")
    public String removeEmployee(@PathVariable(name = "id") String id) {
        employeeService.removeEmployee(id);
        return "redirect:/employees";
    }

}
