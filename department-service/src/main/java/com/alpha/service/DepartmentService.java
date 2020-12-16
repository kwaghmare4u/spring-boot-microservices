package com.alpha.service;

import com.alpha.entity.Department;
import com.alpha.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment of Department service");
        return departmentRepository.save(department);
    }

    public Optional<Department> getDepartment(Long deptId) {
        return departmentRepository.findById(deptId);
    }
}
