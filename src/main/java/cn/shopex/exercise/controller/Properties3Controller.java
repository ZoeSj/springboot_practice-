package cn.shopex.exercise.controller;

import cn.shopex.exercise.MyProperties02;
import cn.shopex.exercise.MyProperties03;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther shengjia
 * @Create 2020/11/16
 * @description:
 **/
@RequestMapping("/properties")
@RestController
public class Properties3Controller {
    private static final Logger log = LoggerFactory.getLogger(Properties3Controller.class);
    private final MyProperties03 myProperties03;

    @Autowired
    public Properties3Controller(MyProperties03 myProperties03) {
        this.myProperties03 = myProperties03;
    }

    @GetMapping("/03")
    public MyProperties03 myProperties03() {
        log.info("=============================================================");
        log.info(myProperties03.toString());
        log.info("=============================================================");
        return myProperties03;
    }
}
