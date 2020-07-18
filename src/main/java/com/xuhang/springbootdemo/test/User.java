package com.xuhang.springbootdemo.test;

import java.util.Objects;

/**
 * @author xuhang
 * @date 2019/4/9 17:26
 */
public class User {
    private String age;
    private String name;
    private String sex;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "age='" + age + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public User(String age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getAge(), user.getAge()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getSex(), user.getSex());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName(), getSex());
    }
}
