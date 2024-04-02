package com.cskaoyan.bean;

import java.util.Date;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-04-02 00:11
 **/

public class User {
    Integer id;
    String name;
    Date birthday;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
