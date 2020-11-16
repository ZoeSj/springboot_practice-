package cn.shopex.exercise;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther shengjia
 * @Create 2020/11/16
 * @description:
 **/
@Component
@ConfigurationProperties(prefix = "mytest02")
public class MyProperties02 {
    private int age;
    private String name;

    @Override
    public String toString() {
        return "MyProperties02{" + "age=" + age + ",name=" + name + '\'' + '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
