package com.xuhang.springbootdemo.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author xuhang
 * @date 2019/6/25 9:16
 */
public class TestListDelete {


    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setAge("2"+i);
            user.setSex("男");
            users.add(user);
        }

        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            User u = new User();
            u.setAge("2"+i);
            u.setSex("男");
            u.setName("abc"+i);
            userList.add(u);
        }


        Iterator<User> iterator = userList.iterator();
        User uTemp = null;
        while (iterator.hasNext()){
            uTemp = iterator.next();
            Boolean flag = false;
            for (User us :users){
                if (uTemp.getAge().equalsIgnoreCase(us.getAge())){
                    flag = true;
                    break;

                }
            }

            if (flag){
                iterator.remove();
            }
        }

        System.out.println(userList);


    }
}
