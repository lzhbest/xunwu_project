package com.ryan.xunwu.web.controller;

import com.ryan.xunwu.base.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName HomeController
 * @Description
 * @Author linzhenhong
 * @Date 2019/3/12 14:18
 * @Version 1.0
 **/
@Controller
public class HomeController {
    @GetMapping(value = {"/", "/index"})
    public String index(Model model){
//        model.addAttribute("name","课程");
        return "index";
    }

    @GetMapping("/404")
    public String notFoundPage(){
        return "404";
    }

    @GetMapping("/403")
    public String accessError(){
        return "403";
    }

    @GetMapping("/500")
    public String internalError(){
        return "500";
    }

    @GetMapping("/logout/page")
    public String logoutPage(){
        return "logout";
    }


    @GetMapping("/get")
    @ResponseBody
    public ApiResponse get(){
        return ApiResponse.ofMessage(200, "成功了");
    }
}
