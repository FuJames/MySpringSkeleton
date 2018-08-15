package com.fqz.skeleton.api.controller.view;

import com.fqz.skeleton.api.controller.BaseController;
import com.fqz.skeleton.exception.CommonException;
import com.fqz.skeleton.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoViewController extends BaseController {
    @Autowired
    TestService testService;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public Object getUser() throws CommonException {
        return "index";
    }

}
