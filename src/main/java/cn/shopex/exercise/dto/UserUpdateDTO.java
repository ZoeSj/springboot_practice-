package cn.shopex.exercise.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther shengjia
 * @Create 2020/11/10
 * @description:
 **/
@ApiModel("用户更新 DTO")
public class UserUpdateDTO {

    @ApiModelProperty(value = "用户编号", required = true, example = "1024")
    private Integer id;
    @ApiModelProperty(value = "账号", required = true, example = "yudaoyuanma")
    private String username;
    @ApiModelProperty(value = "密码", required = true, example = "nicai")
    private String password;

    public Integer getId() {
        return id;
    }

    public UserUpdateDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserUpdateDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserUpdateDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
