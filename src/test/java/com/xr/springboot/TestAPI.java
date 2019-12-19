/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestAPI
 * Author:   TSYH
 * Date:     2019-12-16 21:14
 * Description:
 * History:
 * <author>     <time>       <version>     <desc>
 * 作者姓名    修改时间     版本号       描述
 */
package com.xr.springboot;

import com.xr.springboot.pojo.User;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author TSYH
 * @create 2019-12-16
 * @since 1.0.0
 */
public class TestAPI {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("47.96.144.120", 6379);
        jedis.auth("Family@1314");
        jedis.set("balance","100");
        jedis.set("debt","0");
        jedis.set("k1", "v1");
        jedis.set("k2", "v2");
        jedis.set("k3", "v3");



        //key
       /* Set<String> keys = jedis.keys("*");
        for (Iterator iterator = keys.iterator(); iterator.hasNext(); ) {
            String key = (String) iterator.next();
            System.out.println(key);
        }
        System.out.println("jdeis.exists====>" + jedis.exists("k1"));
        System.out.println(jedis.ttl("k2"));
        System.out.println(jedis.get("k1"));
        jedis.set("k4", "k4_redis");
        System.out.println("========================");
        jedis.mset("str1", "v1", "str2", "v2", "str3", "v3");
        System.out.println(jedis.mget("str1", "str2", "str3"));
*/

        //list
       /* jedis.lpush("mylist", "v1", "v2", "v3", "v4", "v5");

        List<String> mylist = jedis.lrange("mylist", 0, -1);
        for (String s : mylist) {
            System.out.println(s);
        }*/
        //set
        /*jedis.sadd("orders","jd001");
        jedis.sadd("orders","jd002");
        jedis.sadd("orders","jd003");

        Set<String> orders = jedis.smembers("orders");
        for(Iterator iterator=orders.iterator();iterator.hasNext();){
            String string = (String)iterator.next();
            System.out.println(string);
        }
        jedis.srem("orders","jd003");//删除
        System.out.println("size0"+orders.size()); //3

        System.out.println("size1="+jedis.smembers("orders").size());//2
*/
        //hash
        /*jedis.hset("hash1","userName","lisi");
        jedis.hset("hash1","password","1234");
        System.out.println(jedis.hget("hash1","userName"));
        System.out.println(jedis.hget("hash1","password"));
        Map<String,String> map = new HashMap<>();
        map.put("telPhone","13345272282");
        map.put("address","atguigu");
        map.put("email","abc@163.com");
        jedis.hmset("User0",map);
        List<String> hmget = jedis.hmget("User0", "telPhone", "address", "email");
        for (String s : hmget) {
            System.out.println(s);
        }*/


        //zset
       /* jedis.zadd("zset01",60d,"v1");
        jedis.zadd("zset01",80d,"v2");
        jedis.zadd("zset01",90d,"v3");
        jedis.zadd("zset01",100d,"v4");
        jedis.zadd("zset01",110d,"v5");

        Set<String> zset01 = jedis.zrange("zset01", 0, -1);
        for (Iterator iterator = zset01.iterator();iterator.hasNext();){
            String string = (String)iterator.next();
            System.out.println(string);

        }*/



    }
}