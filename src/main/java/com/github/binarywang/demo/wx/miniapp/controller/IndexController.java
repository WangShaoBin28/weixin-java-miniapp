package com.github.binarywang.demo.wx.miniapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package com.github.binarywang.demo.wx.miniapp.controller
 * @ClassName IndexController
 * @Author shaobin.wang
 * @Date 2019/10/28 15:17
 * @Version 1.0
 * @Description:
 **/
@RestController
public class IndexController {

    @GetMapping("/a")
    public String name() {
        return "hello";
    }
}
