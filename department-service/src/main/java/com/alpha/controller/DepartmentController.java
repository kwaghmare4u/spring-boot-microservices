package com.alpha.controller;

import com.alpha.entity.Department;
import com.alpha.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.Optional;

@RestController
@RequestMapping(value = "/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping(value = "/",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside saveDepartment of department controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping(value = "{deptId}")
    public Optional<Department> getDepartment(@PathVariable(value = "deptId") Long deptId){
        log.info("Fetching department by id {}",deptId);
        return departmentService.getDepartment(deptId);
    }

}
