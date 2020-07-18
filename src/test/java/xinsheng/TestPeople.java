package xinsheng;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

/**
 * @author xuhang
 * @date 2018/12/27 17:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPeople {
    @Value("${syn.supplier.limit}")
    private String synSupplierLimit;

    @Test
    public void contextLoads() {
    }/*
    @Test
    public void deletePermruleUserTest() {

        String userName = "admin";
        String rid = "ece5891e14f246a7bb7a336e85710fee";
        String isban = "no";//白名单
        String accounts = "201807090001,201809010001,201805030001";        //只需将要删除的人员工号放在这里即可，可以用数组批量删除，类似 “840126,259631”
        // 发送 POST 请求
        String sr = HttpRequestUtil.sendPost("http://59.111.105.140/fsserver/app/permruleUser",
                "appsecret=63560b42e510&appkey=d0f0e645a710e919901fda410b7df7ea&serviceName=DELETE_PERMRULE_USER&rid=" + rid + "&userName=" + userName +
                        "&isban=" + isban + "&accounts=" + accounts);
        System.out.println("[ConnPostTest]>>>>>>>>>>>>>>>>>>>>>>result:" + sr);
    }


    @Test
    public void addPermruleUserTest() {
        String userName = "admin";
        String rid = "ece5891e14f246a7bb7a336e85710fee";
        String isban = "no";//白名单
        String accounts = "201807090001";        //只需将要添加的人员工号放在这里即可，可以用数组批量插入，类似 “840126,259631”
        // 发送 POST 请求
        String sr = HttpRequestUtil.sendPost("http://59.111.105.201/fsserver/app/permruleUser",
                "appsecret=63560b42e510&appkey=d0f0e645a710e919901fda410b7df7ea&serviceName=ADD_PERMRULE_USER&rid=" + rid + "&userName=" + userName +
                        "&isban=" + isban + "&accounts=" + accounts);
        System.out.println("[ConnPostTest]>>>>>>>>>>>>>>>>>>>>>>result:" + sr);
    }*/

    @Test
    public void test() {
        String[] strings = {"adv,def,dfg,hjk"};

        String join = StringUtils.join(strings, ",");
        System.out.println('"' + join + '"');
    }
    @Test
    public void testJson() {

        JSONObject jsonObject = JSON.parseObject(synSupplierLimit);
        System.out.println(jsonObject);

    }


}
