package com.fqz.skeleton.api.controller.rest;

import com.fqz.skeleton.api.controller.BaseController;
import com.fqz.skeleton.exception.CommonException;
import com.fqz.skeleton.model.ResultType;
import com.fqz.skeleton.model.entity.User;
import com.fqz.skeleton.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DemoRestController extends BaseController {
    @Autowired
    TestService testService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object getUser(@PathVariable(value="id") long id) throws CommonException {
        return "22";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public Object createUser(@RequestBody User user){
        return testService.createUser(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Object updateUser(@PathVariable(value="id") long id,
                               @RequestBody User user) throws CommonException {
        if (user==null || id!=user.getId())
            throw new CommonException(ResultType.INVALID_INPUT);

        testService.updateUser(user);
        return SUCCESS;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteUser(@PathVariable(value="id") long id) throws CommonException {
        testService.deleteUser(id);
        return SUCCESS;
    }

}
