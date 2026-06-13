package com.codingshuttle.assignments.controllers;

import com.codingshuttle.assignments.dto.EmployeeDTO;
import com.codingshuttle.assignments.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
//
//    @GetMapping(path = "/")
//    public EmployeeDTO getEmployee() {
//        employeeService.getEmployee();
//        return;
//
//    }


    @PostMapping(path = "/add")
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        EmployeeDTO newEmployee = employeeService.addUser(employeeDTO);
        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);

    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId) {
        EmployeeDTO employeeById = employeeService.getEmployeeById(employeeId);
        if( employeeById!= null) return ResponseEntity.ok(employeeById);
        return ResponseEntity.notFound().build();


    }

    @PutMapping(path = "/updateprofile")
    public ResponseEntity<EmployeeDTO> UpdateEmployeeProfile(@RequestBody EmployeeDTO employeeDTO, @RequestParam Long employeeId) {
        EmployeeDTO updatedEmployeeProfile = employeeService.UpdateEmployeeProfile(employeeDTO, employeeId);
        if(updatedEmployeeProfile != null)return ResponseEntity.ok(updatedEmployeeProfile);
        return ResponseEntity.noContent().build();


    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> allEmployee = employeeService.findAllEmployee();
        if(allEmployee.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(allEmployee);

    }

    @PatchMapping(path = "/update/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody Map<String, Object> employee, @PathVariable Long employeeId) {
        EmployeeDTO employeeDTO = employeeService.UpdateEmployeeDetails(employee, employeeId);
        return ResponseEntity.ok(employeeDTO);
    }

    @DeleteMapping(path = "/DeleteById/{employeeId}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long employeeId) {
        if(employeeService.deleteEmployeeById(employeeId)) return ResponseEntity.accepted().build();
        return ResponseEntity.badRequest().build();
    }
}



