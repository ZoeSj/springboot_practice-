package cn.shopex.exercise.repository;

import cn.shopex.exercise.controller.SpringJdbcControllerTest;
import cn.shopex.exercise.entity.User;
import cn.shopex.exercise.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    private static final Logger log = LoggerFactory.getLogger(UserRepositoryTest.class);
    @Autowired
    private UserRepository userRepository;

//    @Bean
//    public TestRestTemplate restTemplate() {
//        return new TestRestTemplate();
//    }

    @Test
    public void test1() throws Exception {
        final User user = userRepository.save(new User("u1", "p1"));
        log.info("[添加成功] - [{}]", user);
        final List<User> u1 = userRepository.findAllByUsername("u1");
        log.info("[条件查询] - [{}]", u1);
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("username")));
        final Page<User> users = userRepository.findAll(pageable);
        log.info("[分页+排序+查询所有] - [{}]", users.getContent());
        userRepository.findById(users.getContent().get(0).getId()).ifPresent(user1 -> log.info("[主键查询] - [{}]", user1));
        final User edit = userRepository.save(new User(user.getId(), "修改后的ui", "修改后的p1"));
        log.info("[修改成功] - [{}]", edit);
        userRepository.deleteById(user.getId());
        log.info("[删除主键为 {} 成功] - [{}]", user.getId());
    }
}