package com.codingshuttle.assignments.services;


import com.codingshuttle.assignments.DTOs.DepartmentDTO;
import com.codingshuttle.assignments.entitys.DepartmentEntity;
import com.codingshuttle.assignments.exceptions.ResourceNotFoundException;
import com.codingshuttle.assignments.repositorys.DepatmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {

    private final ModelMapper modelMapper;

    private final DepatmentRepository depatmentRepository;


    public DepartmentService(DepatmentRepository depatmentRepository, ModelMapper modelMapper) {
        this.depatmentRepository = depatmentRepository;
        this.modelMapper = modelMapper;
    }


    public DepartmentDTO addDepatment(DepartmentDTO depatmentDTO) {

        DepartmentEntity department = modelMapper.map(depatmentDTO, DepartmentEntity.class);
        department.setLocalDateTime(LocalDateTime.now());
        return modelMapper.map(depatmentRepository.save(department), DepartmentDTO.class);


    }

    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> all = depatmentRepository.findAll();
        if(all.isEmpty()) throw new ResourceNotFoundException("Department or Departments Not Found");
        return all.stream().map(depatment->modelMapper.map(depatment,DepartmentDTO.class)).toList();


    }

    public DepartmentDTO deleteById(int id) {
        DepartmentEntity departmentEntity = depatmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department With id :"+id+" Not found"));
        depatmentRepository.deleteById(id);
        return modelMapper.map(departmentEntity,DepartmentDTO.class);

    }

    public DepartmentDTO updateDepartment(Map<String, Object> departmentMap) {
        Integer id = (Integer)departmentMap.get("id");
        DepartmentEntity departmentEntity = depatmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department With details is not found "+departmentMap));
        departmentMap.forEach((value,obj)->{

            Field field = ReflectionUtils.findField(DepartmentEntity.class,value);
            if (field!=null){
                field.setAccessible(true);
                ReflectionUtils.setField(field,departmentEntity,obj);
            }
        });
        departmentEntity.setId(id);
        depatmentRepository.save(departmentEntity);
        return modelMapper.map(departmentEntity,DepartmentDTO.class);

    }

    public DepartmentDTO findById(Integer id) {
     DepartmentEntity department =   depatmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department With :" +id+ " is not found"));
        return modelMapper.map(department,DepartmentDTO.class);
    }
}
