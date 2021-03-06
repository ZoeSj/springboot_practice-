package cn.shopex.exercise.mapper;

import cn.shopex.exercise.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * t_user 操作：演示两种方式
 * <p>第一种是基于mybatis3.x版本后提供的注解方式<p/>
 * <p>第二种是早期写法，将SQL写在 XML 中<p/>
 *
 * @Auther shengjia
 * @Create 2020/11/26
 * @description:
 **/
public interface UserMapper {
    /**
     * 根据用户名查询用户结果集
     *
     * @param username
     * @return 查询结果
     */
    @Select("SELECT * FROM t_user WHERE username = #{username}")
    List<User> findByUsername(@Param("username") String username);

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 成功1 失败0
     */
    int insert(User user);
}
