package cn.shopex.exercise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther shengjia
 * @Create 2020/11/18
 * @description: Spring4.3以后为简化@RequestMapping(method = RequestMethod.XXX)的写法，
 * 故而将其做了一层包装，也就是现在的GetMapping、PostMapping、PutMapping、DeleteMapping、PatchMapping
 **/
@Controller
@RequestMapping
public class ThymeleafController {
    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        //设置跳转的视图，默认映射到src/main/resources/templates/{viewName}.html
        view.setViewName("index");
        //set attribute
        view.addObject("title", "my second web page!");
        view.addObject("desc", "welcome to the best zoe's system!");
        Author author = new Author();
        author.setAge(25);
        author.setName("zoe");
        author.setEmail("shengjiamo@163.com");
        view.addObject("author", author);
        return view;
    }

    @GetMapping("/index1")
    public String index1(HttpServletRequest request) {
        //另外一种写法，和上面结果是一样的
        //set attribute
        request.setAttribute("title", "my first web page");
        request.setAttribute("desc", "welcome to my system!");
        Author author = new Author();
        author.setAge(25);
        author.setName("zoe");
        author.setEmail("shengjiamo@163.com");
        request.setAttribute("author", author);
        return "index";
    }

    class Author {
        private int age;
        private String name;
        private String email;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

}
