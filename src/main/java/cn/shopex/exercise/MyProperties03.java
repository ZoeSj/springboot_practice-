package cn.shopex.exercise;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Auther shengjia
 * @Create 2020/11/16
 * @description:
 **/
@Component
@PropertySource("classpath:test.properties")
@ConfigurationProperties(prefix = "mytest")
public class MyProperties03 {
    private int age;
    private String name;
    private String email;

    @Override
    public String toString() {
        return "MyProperties test{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
