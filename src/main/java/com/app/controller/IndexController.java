package com.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
public class IndexController {

    @GetMapping(path = "/")
    public ModelAndView modelAndView() {
        return new ModelAndView("index");
    }
}
