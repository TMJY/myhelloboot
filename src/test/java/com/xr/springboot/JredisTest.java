/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: JredisTest
 * Author:   TSYH
 * Date:     2019-12-16 20:13
 * Description:
 * History:
 * <author>     <time>       <version>     <desc>
 * 作者姓名    修改时间     版本号       描述
 */
package com.xr.springboot;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author TSYH
 * @create 2019-12-16
 * @since 1.0.0
 */
public class JredisTest {
    public static void main(String[] args) {
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();

        Jedis jedis = null;
        try{
            jedis =jedisPool.getResource();
        }catch (Exception e){

        }finally {
            JedisPoolUtil.release(jedisPool,jedis);
        }
    }
}