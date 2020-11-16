package cn.shopex.exercise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther shengjia
 * @Create 2020/11/13
 * @description:
 **/
@RestController
@RequestMapping("/provider")
public class ProviderController {
    @GetMapping("/demo")
    public String provider() {
        return "hello this demo!";
    }
}
