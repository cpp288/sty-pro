package com.cpp288.demo.mapstruct;

import java.util.Date;

/**
 * person dto
 *
 * @author chenjian
 * @date 2021/1/29 下午2:25
 */
//@Getter
//@Setter
public class PersonDTO {

    private String userName;
    private Integer age;
    private Date birthday;
    private String gender;

    @Override
    public String toString() {
        return "PersonDTO{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
