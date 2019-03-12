package com.ryan.xunwu.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName UserController
 * @Description
 * @Author linzhenhong
 * @Date 2019/3/12 17:44
 * @Version 1.0
 **/
@Controller
public class UserController {
    @GetMapping("/user/login")
    public String loginPage(){
        return "user/login";
    }

    @GetMapping("/user/center")
    public String centerPage(){
        return "user/center";
    }
}
