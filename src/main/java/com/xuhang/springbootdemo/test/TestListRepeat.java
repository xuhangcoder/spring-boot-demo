package com.xuhang.springbootdemo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xuhang
 * @date 2020/3/9 17:19
 */

class Dog{

    private String name;

    private Integer age;

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
public class TestListRepeat {
    public static List<Dog> dogs = null;
    static {
        dogs = new ArrayList<Dog>(){
            {
                add(new Dog("黄一",11));
                add(new Dog("黄一",22));
                add(new Dog("黄三",33));
                add(new Dog("黄三",33));
                add(new Dog("黄三",33));
                add(new Dog("黄三",33));
            }
        };

    }
    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    public static void main(String[] args) {

        List<String> list =dogs.stream().
                collect(Collectors.groupingBy(dog->dog.getName(),Collectors.counting()))
                .entrySet().stream()
                .filter(entry->entry.getValue()>1)
                .map(entry->entry.getKey())
                .collect(Collectors.toList());
        System.out.println(list.toString());

}
}
