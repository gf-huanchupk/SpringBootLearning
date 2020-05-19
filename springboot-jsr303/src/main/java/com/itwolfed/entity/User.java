package com.itwolfed.entity;

import com.itwolfed.valid.Groups;
import com.itwolfed.valid.ListValue;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;


@Data
public class User {

    @Null(message = "新增不需要指定id" , groups = Groups.Add.class)
    @NotNull(message = "修改需要指定id" , groups = Groups.Update.class)
    private Integer id;
    @NotBlank(message = "用户名不能为空")
    @NotNull
    private String username;
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$", message = "密码必须为8~16个字母和数字组合")
    private String password;
    @Email
    private String email;
    @ListValue( message = "性别应指定相应的值" , vals = {1,2} , groups = {Groups.Add.class , Groups.Update.class})
    private Integer gender;

}
