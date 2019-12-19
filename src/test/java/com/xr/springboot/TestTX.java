/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestTX
 * Author:   TSYH
 * Date:     2019-12-16 22:17
 * Description:
 * History:
 * <author>     <time>       <version>     <desc>
 * 作者姓名    修改时间     版本号       描述
 */
package com.xr.springboot;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author TSYH
 * @create 2019-12-16
 * @since 1.0.0
 */
public class TestTX {

    public boolean transMethod(){
        Jedis jedis = new Jedis("47.96.144.120",6379);
        jedis.auth("Family@1314");
        int balance; //可用余额
        int debt;//欠额
        int amtToSubtract =10;//实刷额度

        jedis.watch("balance");
        balance = Integer.parseInt(jedis.get("balance"));
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(balance < amtToSubtract){
            jedis.unwatch();
            System.out.println("modify");
            return false;
        }else{
            System.out.println("********************transaction");
            Transaction transaction = jedis.multi();
            transaction.decrBy("balance",amtToSubtract);
            transaction.incrBy("debt",amtToSubtract);

            transaction.exec();
            balance = Integer.parseInt(jedis.get("balance"));
            debt = Integer.parseInt(jedis.get("debt"));
            System.out.println("*******"+balance);
            System.out.println("*******"+debt);
            return true;
        }

    }

    public static void main(String[] args) {
        TestTX test = new TestTX();

        boolean b = test.transMethod();
        System.out.println("main。。。。"+b);

    }

}