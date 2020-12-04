package cn.shopex.exercise.controller;

import cn.shopex.exercise.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringJdbcControllerTest.class)
public class SpringJdbcControllerTest {
    private static final Logger log = LoggerFactory.getLogger(SpringJdbcControllerTest.class);
    @Autowired
    private TestRestTemplate template;
//    @LocalServerPort
//    private String port;

    @Bean
    public TestRestTemplate restTemplate() {
        return new TestRestTemplate();
    }

    @Test
    public void test1() throws Exception {
        template.postForEntity("http://localhost:8080" + "/users", new User("user1", "pass1"), Integer.class);
        log.info("[添加用户成功]\n");
        ResponseEntity<List<User>> response2 = template.exchange("http://localhost:8080" + "/users", HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        });
        final List<User> body = response2.getBody();
        log.info("[查询所有] - [{}]\n", body);
        Long userId = body.get(0).getId();
        ResponseEntity<User> response3 = template.getForEntity("http://localhost:8080" + "/users/{id}", User.class, userId);
        log.info("[主键查询] - [{}]\n", response3.getBody());
        template.put("http://localhost:8080" + "/users/{id}", new User("user11", "pass11"), userId);
        log.info("[修改用户成功]\n");
        template.delete("http://localhost:8080" + "/users/{id}", userId);
        log.info("[删除用户成功]");
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void queryUsers() {
    }

    @Test
    public void getUser() {

    }

    @Test
    public void delUser() {
    }

    @Test
    public void addUser() {

    }

    @Test
    public void editUser() {
    }
}