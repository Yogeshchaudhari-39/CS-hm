package com.codingshuttle.assignments.services;

import com.codingshuttle.assignments.dto.EmployeeDTO;
import com.codingshuttle.assignments.entites.EmployeeEntity;
import com.codingshuttle.assignments.exceptions.ResourceNotFoundException;
import com.codingshuttle.assignments.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;
    private final ModelMapper modelMapper;


    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mapper, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
        this.modelMapper = modelMapper;
    }


    public boolean employeeExist(Long employeeId) {
        return employeeRepository.existsById(employeeId);
    }

    public EmployeeDTO addUser(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeToBeSaved = mapper.map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity savedEmployee = employeeRepository.save(employeeToBeSaved);
        return mapper.map(savedEmployee, EmployeeDTO.class);


    }

    public EmployeeDTO getEmployeeById(Long employeeId) {
        EmployeeEntity employeeById =
                employeeRepository.findById(employeeId)
                        .orElseThrow(()->new ResourceNotFoundException("User Not Found"));
        return mapper.map(employeeById, EmployeeDTO.class);

    }


    public EmployeeDTO UpdateEmployeeProfile(EmployeeDTO employeeDTO, Long employeeId) {
        if(!employeeExist(employeeId)) throw new ResourceNotFoundException("User Not found with id "+employeeId);
        EmployeeEntity employee = mapper.map(employeeDTO, EmployeeEntity.class);
        employee.setId(employeeId);
        EmployeeEntity savedEmployee = employeeRepository.save(employee);
        return mapper.map(savedEmployee, EmployeeDTO.class);

    }

    public List<EmployeeDTO> findAllEmployee() {


        List<EmployeeEntity> allEmployees = employeeRepository.findAll();
        return allEmployees.stream().map(employee -> mapper.map(employee, EmployeeDTO.class)).collect(Collectors.toList());


    }

    public EmployeeDTO UpdateEmployeeDetails(Map<String, Object> employee, Long employeeId) {

        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("User Not found with id "+employeeId));
        employee.forEach((emp, value) -> {
            Field field = ReflectionUtils.findField(EmployeeEntity.class, emp);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, employeeEntity, value);
            }
        });
        return mapper.map(employeeEntity, EmployeeDTO.class);
    }

    public boolean deleteEmployeeById(Long employeeId) {
        EmployeeEntity employeeById = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("User Not found with id "+employeeId));
        return true;
        }

}

