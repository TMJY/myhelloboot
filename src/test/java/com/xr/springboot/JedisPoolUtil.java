/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: JedisPoolUtil
 * Author:   TSYH
 * Date:     2019-12-17 17:17
 * Description:
 * History:
 * <author>     <time>       <version>     <desc>
 * 作者姓名    修改时间     版本号       描述
 */
package com.xr.springboot;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author TSYH
 * @create 2019-12-17
 * @since 1.0.0
 */
public class JedisPoolUtil {
    private static volatile JedisPool jedisPool =null;

    private JedisPoolUtil(){}

    public static JedisPool getJedisPoolInstance(){
        if(null==jedisPool){
            synchronized (JedisPoolUtil.class){
                JedisPoolConfig poolConfig = new JedisPoolConfig();
                poolConfig.setMaxTotal(1000); //控制一个pool可分匹配多少个jedis实例
                poolConfig.setMaxIdle(32);//控制一个pool最多有多状态为空闲(idle)的jedis实例
                poolConfig.setMaxWaitMillis(100*1000);//最大的等待的时间
                poolConfig.setTestOnBorrow(true);//检查连接可用性(ping)，返回为true，就可用
                jedisPool = new JedisPool(poolConfig,"47.96.144.120",6379,0,"Family@1314");

            }
        }
        return jedisPool;
    }

    public static void release(JedisPool jedisPool, Jedis jedis){

        try {
            jedis = jedisPool.getResource();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }



}