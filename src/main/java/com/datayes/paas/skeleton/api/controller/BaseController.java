package com.datayes.paas.skeleton.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public abstract class BaseController {
    @Autowired
    protected HttpServletRequest request;
    protected final String SUCCESS = "";
}
