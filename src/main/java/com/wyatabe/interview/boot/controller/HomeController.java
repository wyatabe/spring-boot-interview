package com.wyatabe.interview.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(hidden = true)
@Controller
public class HomeController {
	
	@ApiOperation(value = "Redireciona para o swagger.", hidden = true)
    @RequestMapping(value = "/")
    public String index() {
        return "redirect:swagger-ui.html";
    }
    
}
