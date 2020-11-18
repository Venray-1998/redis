package com.fwr.redis.controller;

import com.fwr.redis.entity.Student;
import com.fwr.redis.service.TestService;
import com.fwr.redis.utils.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fwr
 * @date 2020-11-17
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/select")
    public ResultResponse<List<Student>> select() {
        return testService.select();
    }
}
