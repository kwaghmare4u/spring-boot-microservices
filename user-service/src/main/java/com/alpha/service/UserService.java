package com.alpha.service;

import com.alpha.entity.User;
import com.alpha.repository.UserRepository;
import com.alpha.valueObjects.Department;
import com.alpha.valueObjects.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Saving user ...");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartmentDetails(Long userId) {
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User user = userRepository.findById(userId).get();

        Department department = restTemplate.getForObject("http://localhost:9000/departments/" + user.getDeptId(), Department.class);
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);
        return responseTemplateVO;
    }
}
