package com.fwr.redis.controller;

import com.fwr.redis.entity.Student;
import com.fwr.redis.entity.TestDTO;
import com.fwr.redis.service.TestService;
import com.fwr.redis.utils.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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

    @GetMapping("/selectOne")
    public ResultResponse<TestDTO> selectList(Integer id) {
        return testService.selectOne(id);
    }

    @PostMapping("/insert")
    public ResultResponse<Integer> insert(@RequestBody Student student) {
        return testService.insert(student);
    }

    @PostMapping("/update")
    public ResultResponse<Integer> update(@RequestBody Student student) {
        return testService.update(student);
    }

    @GetMapping("/delete")
    public ResultResponse<Integer> delete(Integer id) {
        return testService.delete(id);
    }

    @GetMapping("/session")
    public ResultResponse<String> getSession(HttpServletRequest request, HttpServletResponse response) {
        List<String> list = (List<String>) request.getSession().getAttribute("list");
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add("xxxxxx");
        request.getSession().setAttribute("list", list);
        return ResultResponse.toSuccessResult("sessionId" + request.getSession().getId() + "count:" + list.size());
    }
}
