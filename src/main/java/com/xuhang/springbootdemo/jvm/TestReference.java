package com.xuhang.springbootdemo.jvm;

import java.util.ArrayList;

/**
 * @author xuhang
 * @date 2020/3/10 17:34
 */
public class TestReference {
   static class dog{
        private String name;
        private Integer age;

        public dog(String name, Integer age) {
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

       @Override
       public String toString() {
           return "dog{" +
                   "name='" + name + '\'' +
                   ", age=" + age +
                   '}';
       }
   }

    public static void main(String[] args) {
        ArrayList<dog> list = new ArrayList<>();
        list.add(new dog("haha", 2));
        list.add(new dog("heihei", 2));
        list.add(new dog("haha", 2));
        list.add(new dog("haha", 2));
        for (int i = 0; i < list.size(); i++) {
            dog dog = list.get(i);
            if (dog.getName().equals("haha")){
                list.remove(i);
            }

        }

        for (dog dog : list) {
            System.out.println(dog.toString());
        }

    }
}
