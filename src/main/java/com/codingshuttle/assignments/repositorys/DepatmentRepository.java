package com.codingshuttle.assignments.repositorys;


import com.codingshuttle.assignments.entitys.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepatmentRepository extends JpaRepository<DepartmentEntity,Integer> {


}
