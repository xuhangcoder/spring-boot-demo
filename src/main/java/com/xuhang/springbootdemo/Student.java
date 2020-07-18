package com.xuhang.springbootdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author xuhang
 * @date 2019/5/14 20:31
 */
public class Student {
    private String name;
    private String studentNo;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Student> getStudentInfo(String studentNo) {
        HashMap<String, Student> map = new HashMap<>();
        Student student1 = new Student();
        student1.setName("张三");
        student1.setStudentNo("123456");
        student1.setAge(18);
        Student student2 = new Student();
        student2.setName("李四");
        student2.setStudentNo("987654");
        student2.setAge(20);

        map.put(student1.getStudentNo(), student1);
        map.put(student2.getStudentNo(), student2);
        List<Student> list = new ArrayList<>();
        if (studentNo != null) {
            Student stu =  map.get(studentNo);
            list.add(stu);
        } else {
            for (Student student : map.values()) {
                list.add(student);
            }
        }
        return list;
    }
    public static void main(String[] args) {

        List<Student> studentInfo = new Student().getStudentInfo(null);
        for (int i = 0; i < studentInfo.size(); i++) {
            System.out.println(studentInfo.get(i).getName()+studentInfo.get(i).getStudentNo()+studentInfo.get(i).getAge());
        }



    }
}
