package com.cpp288.demo.mapstruct;

import java.util.Date;

/**
 * person do
 *
 * @author chenjian
 * @date 2021/1/29 下午2:25
 */
//@Getter
//@Setter
public class PersonDO {

    private Integer id;
    private String name;
    private int age;
    private Date birthday;
    private String gender;

    @Override
    public String toString() {
        return "PersonDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
