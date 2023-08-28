package com.example.RegistrationLogin.Service.impl;

import com.example.RegistrationLogin.Dto.EmployeeDTO;
import com.example.RegistrationLogin.Dto.LoginDTO;
import com.example.RegistrationLogin.Entity.Employee;
import com.example.RegistrationLogin.Payload.Response.LoginMessage;
import com.example.RegistrationLogin.Repo.EmployeeRepo;
import com.example.RegistrationLogin.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class EmployeeIMPL implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getEmployeeId(),
                employeeDTO.getEmployeeName(),
                employeeDTO.getEmail(),
                this.passwordEncoder.encode(employeeDTO.getPassword())
        );
        employeeRepo.save(employee);
        return employee.getEmployeeName();
    }

    @Override
    public LoginMessage loginEmployee(LoginDTO loginDTO) {
        String msg = "";
        Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Employee> employee = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("password Not Match", false);
            }
        }else {
            return new LoginMessage("Email not exits", false);
        }
    }
}
