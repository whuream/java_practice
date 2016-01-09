package com.ream.www.maventest;

import org.hibernate.validator.internal.metadata.core.ConstraintHelper;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
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
public class User {
    @Min(value = 1, message = "用户id 》=1")
    private Integer userId;
    @NotNull(message = "用户名不能为空！")
    @Size(min=1,message = "The license plate '${validatedValue}' must be between {min}")
    private String userName = "";
    @NotNull
    @Size(min = 6, max = 20)
    private String userPwd;
    @Min(value = 18, message = "年龄最小值必须是18")
    @Max(value = 60, message = "年龄最大值必须是60")
    private int userAge;

    @PrintMe
    private Long ck;

    @CheckF(time = 1000)
    private String fuc = "";

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
        User user = new User(0, "", "123", 10);
        Set<ConstraintViolation<User>> constraintViolations = validator
                .validate(user);

        for (ConstraintViolation<User> constraintViolation : constraintViolations) {
            System.out.println(constraintViolation.getMessage());
        }
    }
}