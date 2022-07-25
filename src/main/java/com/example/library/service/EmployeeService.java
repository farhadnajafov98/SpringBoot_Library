package com.example.library.service;

import com.example.library.entity.Employee;
import com.example.library.request.RequestEmployee;
import com.example.library.response.Response;
import com.example.library.response.ResponseEmployee;
import com.example.library.response.ResponseStatusList;

import java.util.List;

public interface EmployeeService {
    Response<List<ResponseEmployee>>getEmployeeList();
    Response<ResponseEmployee>getEmployeeById(Long bookId);
    ResponseStatusList addEmployee(RequestEmployee requestEmployee);
    ResponseStatusList updateEmployee(RequestEmployee requestEmployee);
    ResponseStatusList deleteEmployee(Long employeeId);
}
