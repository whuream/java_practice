package com.ream.www.maventest;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.ScriptAssert;
import org.hibernate.validator.internal.metadata.core.ConstraintHelper;

import java.util.List;
import java.util.Set;

import javax.validation.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * 用户实体类
 * 验证规则如下：
 * userId最小为1
 * userName不为空
 * userPwd非空，长度在6-20之间
 * userAge的值在18-60之间
 * @author tanlan
 *
 */
@ScriptAssert(lang = "jython", script = "_this.ck > 10 and _this.sc < -100")
public class User {
    @Min(value = 1, message = "用户id 》=1")
    private Integer userId;
    @NotNull(message = "用户名不能为空！")
    @Size(min=1000, message = "The license plate '${validatedValue}' must be between {min}")
    private String userName = "nnn";
    @NotNull
    @Size(min = 6, max = 20)
    private String userPwd;
    @Min(value = 18, message = "年龄最小值必须是18")
    @Max(value = 60, message = "年龄最大值必须是60")
    private int userAge;

    @NotBlank
    private String blank;

    @PrintMe
    private Long ck;

    @CheckF(time = 1000)
    private String fuc = "";

    @Valid
    List<User> users;

    private Long sc = 100l;


    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getCk() {
        return ck;
    }

    public void setCk(Long ck) {
        this.ck = ck;
    }

    public String getFuc() {
        return fuc;
    }

    public void setFuc(String fuc) {
        this.fuc = fuc;
    }

    public User() {
    }

    public User(Integer userId, String userName, String userPwd, int userAge) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userAge = userAge;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        User user = new User(0, "xxx", "123", 10);
        user.users = Lists.newArrayList(new User(null, null, null, -1));
        user.blank = "  ";
        System.out.println("-------------ssssssssssssssssssss");
        System.out.println(user.sc);
        System.out.println("-------------ssssssssssssssssssss");

        Set<ConstraintViolation<User>> constraintViolations = validator
                .validate(user);

        for (ConstraintViolation<User> constraintViolation : constraintViolations) {
            System.out.println(constraintViolation.getMessage() + constraintViolation.getPropertyPath());
        }

        System.out.println(JSON.toJSONString(null));
    }
}