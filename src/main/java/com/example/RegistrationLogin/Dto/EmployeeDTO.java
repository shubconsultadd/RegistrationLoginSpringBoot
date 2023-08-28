package com.example.RegistrationLogin.Dto;

public class EmployeeDTO {
    private int employeeId;
    private String employeeName;
    private String email;
    private String password;

    public EmployeeDTO(int employeeId,String employeeName,String email,String password){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.password = password;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }
}
