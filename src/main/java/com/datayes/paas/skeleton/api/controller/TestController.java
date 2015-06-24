package com.datayes.paas.skeleton.api.controller;

import com.datayes.paas.skeleton.common.exception.CommonException;
import com.datayes.paas.skeleton.common.model.ResultType;
import com.datayes.paas.skeleton.process.entity.User;
import com.datayes.paas.skeleton.business.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController extends BaseController {
    @Autowired
    TestService testService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Object getUser(@PathVariable(value="id") long id) throws CommonException {
        return testService.getUser(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Object createUser(@RequestBody User user){
        return testService.createUser(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public Object updateUser(@PathVariable(value="id") long id,
                               @RequestBody User user) throws CommonException {
        if (user==null || id!=user.getId())
            throw new CommonException(ResultType.INVALID_INPUT);

        testService.updateUser(user);
        return SUCCESS;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public Object deleteUser(@PathVariable(value="id") long id) throws CommonException {
        testService.deleteUser(id);
        return SUCCESS;
    }

}
