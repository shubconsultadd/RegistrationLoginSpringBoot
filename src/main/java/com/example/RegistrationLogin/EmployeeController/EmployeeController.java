package com.example.RegistrationLogin.EmployeeController;

import com.example.RegistrationLogin.Dto.EmployeeDTO;
import com.example.RegistrationLogin.Dto.LoginDTO;
import com.example.RegistrationLogin.Payload.Response.LoginMessage;
import com.example.RegistrationLogin.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        String id = employeeService.addEmployee(employeeDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
    {
        LoginMessage loginResponse = employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
