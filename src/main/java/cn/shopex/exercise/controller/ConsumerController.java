package cn.shopex.exercise.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Auther shengjia
 * @Create 2020/11/13
 * @description:
 **/
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @NacosInjected
    private NamingService namingService;
    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/demo")
    public String consumer() throws IllegalStateException, NacosException {
        //get instance
        Instance instance = null;
        if (false) {
            List<Instance> instances = namingService.getAllInstances("exercise");
            //get first instance for use
            instance = instances.stream().findFirst().orElseThrow(() -> new IllegalStateException("not find the instance!"));
        } else {
            instance = namingService.selectOneHealthyInstance("exercise");
        }
        //run the request
        return restTemplate.getForObject("http://" + instance.toInetAddr() + "/provider/demo", String.class);
    }
}
