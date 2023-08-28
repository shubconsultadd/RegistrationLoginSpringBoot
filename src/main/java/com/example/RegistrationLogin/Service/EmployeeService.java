package com.example.RegistrationLogin.Service;

import com.example.RegistrationLogin.Dto.EmployeeDTO;
import com.example.RegistrationLogin.Dto.LoginDTO;
import com.example.RegistrationLogin.Payload.Response.LoginMessage;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);
    LoginMessage loginEmployee(LoginDTO loginDTO);
}
