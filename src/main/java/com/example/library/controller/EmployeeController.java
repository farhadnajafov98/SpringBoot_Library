package com.example.library.controller;

import com.example.library.request.RequestEmployee;
import com.example.library.request.RequestReader;
import com.example.library.response.Response;
import com.example.library.response.ResponseEmployee;
import com.example.library.response.ResponseStatusList;
import com.example.library.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/getEmployeeList")
    public Response<List<ResponseEmployee>>getEmployeeList(){
        return employeeService.getEmployeeList();
    }
    @PostMapping(value = "/getEmployeeById")
    public Response <ResponseEmployee>getEmployeeById(@RequestParam Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }
    @PostMapping(value= "/addEmployee")
    public ResponseStatusList addEmployee(@RequestBody RequestEmployee requestEmployee){
        return employeeService.addEmployee(requestEmployee);
    }

    @PutMapping(value = "/updateEmployee")
    public ResponseStatusList updateEmployee(@RequestBody RequestEmployee requestEmployee) {
        return employeeService.updateEmployee(requestEmployee);
    }

    @PutMapping(value = "/deleteEmployee/{employeeId}")
    public ResponseStatusList deleteEmployee(@PathParam("employeeId") Long employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }

}
