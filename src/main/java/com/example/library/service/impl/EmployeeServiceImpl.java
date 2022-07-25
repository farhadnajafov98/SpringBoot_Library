package com.example.library.service.impl;

import com.example.library.entity.Employee;
import com.example.library.enums.EnumAvaliableStatus;
import com.example.library.exceptions.ExceptionsConstant;
import com.example.library.exceptions.LibraryException;
import com.example.library.repository.EmployeeRepository;
import com.example.library.request.RequestEmployee;
import com.example.library.response.Response;
import com.example.library.response.ResponseEmployee;
import com.example.library.response.ResponseStatus;
import com.example.library.response.ResponseStatusList;
import com.example.library.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Response<List<ResponseEmployee>> getEmployeeList() {
        Response<List<ResponseEmployee>> response = new Response<>();
        try {
            List<Employee> employeeList = employeeRepository.findAllByActive(EnumAvaliableStatus.ACTIVE.getValue());
            if (employeeList == null) {
                throw new LibraryException(ExceptionsConstant.EMPLOYEE_NOT_FOUND, "EMPLOYEE NOT FOUND");
            }
            List<ResponseEmployee> responseEmployeeList = new ArrayList<>();
            for (Employee employee : employeeList) {
                ResponseEmployee responseEmployee = new ResponseEmployee();
                responseEmployee.setId(employee.getId());
                responseEmployee.setName(employee.getName());
                responseEmployee.setSurname(employee.getSurName());
                responseEmployee.setDateOfBirth(employee.getDateOfBirth());
                responseEmployee.setAddress(employee.getAddress());
                responseEmployee.setContact(employee.getContact());
                responseEmployee.setPosition(employee.getPosition());
                responseEmployee.setSalary(employee.getSalary());
                responseEmployeeList.add(responseEmployee);
                response.setT(responseEmployeeList);
                response.setStatus(ResponseStatus.getSuccessMessage());
            }

        } catch (LibraryException ex) {
            response.setStatus(new ResponseStatus(ex.getCode(), ex.getMessage()));
        } catch (Exception exx) {
            exx.printStackTrace();
            response.setStatus(new ResponseStatus(ExceptionsConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }
        return response;
    }

    @Override
    public Response<ResponseEmployee> getEmployeeById(Long employeeId) {
        Response<ResponseEmployee> response = new Response<>();
        try{
            if(employeeId==null){
                throw  new LibraryException(ExceptionsConstant.INVALID_REQUEST_DATA,"INVALID REQUEST DATA");
            }
            Employee employee = employeeRepository.findEmployeeByIdAndActive(employeeId, EnumAvaliableStatus.ACTIVE.getValue());
            if(employee==null){
                throw new LibraryException(ExceptionsConstant.EMPLOYEE_NOT_FOUND,"EMPLOYEE NOT FOUND");
            }
            ResponseEmployee responseEmployee = new ResponseEmployee();
            responseEmployee.setId(employee.getId());
            responseEmployee.setName(employee.getName());
            responseEmployee.setSurname(employee.getSurName());
            responseEmployee.setDateOfBirth(employee.getDateOfBirth());
            responseEmployee.setAddress(employee.getAddress());
            responseEmployee.setContact(employee.getContact());
            responseEmployee.setPosition(employee.getPosition());
            responseEmployee.setSalary(employee.getSalary());
            response.setT(responseEmployee);
            response.setStatus(ResponseStatus.getSuccessMessage());

        }catch (LibraryException ex){
            response.setStatus(ResponseStatus.getSuccessMessage());

        }catch (Exception exx){
            exx.printStackTrace();
            response.setStatus(new ResponseStatus(ExceptionsConstant.INTERNAL_EXCEPTION,"INTERNAL EXCEPTION"));
        }
        return response;
    }

    @Override
    public ResponseStatusList addEmployee(RequestEmployee requestEmployee) {
        return null;
    }

    @Override
    public ResponseStatusList updateEmployee(RequestEmployee requestEmployee) {
        return null;
    }

    @Override
    public ResponseStatusList deleteEmployee(Long employeeId) {
        return null;
    }
}
