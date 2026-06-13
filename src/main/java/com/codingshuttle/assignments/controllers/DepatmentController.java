package com.codingshuttle.assignments.controllers;

import com.codingshuttle.assignments.DTOs.DepartmentDTO;
import com.codingshuttle.assignments.services.DepartmentService;
import com.codingshuttle.assignments.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/department")
public class DepatmentController {


    private final DepartmentService departmentService;


    public DepatmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;

    }

    @PostMapping(path = "/departments")
    public DepartmentDTO addDepatment(@RequestBody @Valid DepartmentDTO depatmentDTO) {
        return departmentService.addDepatment(depatmentDTO);
    }

    @GetMapping(path = "/departments")
    public ResponseEntity<ApiResponse<List<DepartmentDTO>>> getAllDepartments() {
        List<DepartmentDTO> departmentDTOS = departmentService.getAllDepartments();
        return ResponseEntity.ok(new ApiResponse<>(departmentDTOS));
    }

    @DeleteMapping(path = "/departments/{id}")
    public ResponseEntity<ApiResponse<?>> deleteDepartmentById(@PathVariable Integer id) {
        DepartmentDTO departmentDTO = departmentService.deleteById(id);
        return ResponseEntity.ok(new ApiResponse<>(departmentDTO));
    }

    @PutMapping(path = "/departments")
    public ResponseEntity<ApiResponse<?>> updateDepartment(@RequestBody Map<String,Object> departmentMap){
        DepartmentDTO departmentDTO = departmentService.updateDepartment(departmentMap);
        return ResponseEntity.ok(new ApiResponse<>(departmentDTO));
    }

    @GetMapping(path = "/departments/{id}")
    public ResponseEntity<ApiResponse<?>> getDepatmentById(@PathVariable Integer id){
        DepartmentDTO departmentDTO = departmentService.findById(id);

        return new ResponseEntity<>(new ApiResponse<>(departmentDTO), HttpStatus.FOUND);

    }

}
