package com.ryan.xunwu.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName AdminController
 * @Description
 * @Author linzhenhong
 * @Date 2019/3/12 16:19
 * @Version 1.0
 **/
@Controller
public class AdminController {
    @GetMapping("/admin/center")
    public String adminCenterPage(){
        return "admin/center";
    }

    @GetMapping("/admin/welcome")
    public String welcomePage(){
        return "admin/welcome";
    }

    @GetMapping("/admin/login")
    public String adminLogin(){
        return "admin/login";
    }
}
