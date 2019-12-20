package com.xdja.bdp.attence.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author yxb
 * @since 2019/12/17
 */
@Slf4j
@Controller
public class IndexController {


    @GetMapping(value = "/")
    public String index() {
        return "index";
    }
}
