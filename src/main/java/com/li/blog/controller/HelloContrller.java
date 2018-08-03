package com.li.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author licheng
 * @description
 * @create 2018/8/2 20:56
 */
@RestController
public class HelloContrller {

    @RequestMapping("/hello")
    public String Hello(){
        return "hello clasticsearch";
    }
}
