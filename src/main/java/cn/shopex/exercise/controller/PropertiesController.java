package cn.shopex.exercise.controller;

import cn.shopex.exercise.MyProperties02;
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
public class PropertiesController {
    private static final Logger log = LoggerFactory.getLogger(PropertiesController.class);
    private final MyProperties02 myProperties02;

    @Autowired
    public PropertiesController(MyProperties02 myProperties02) {
        this.myProperties02 = myProperties02;
    }

    @GetMapping("/02")
    public MyProperties02 myProperties02() {
        log.info("=============================================================");
        log.info(myProperties02.toString());
        log.info("=============================================================");
        return myProperties02;
    }
}
