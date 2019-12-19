/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestMS
 * Author:   TSYH
 * Date:     2019-12-17 16:00
 * Description: TestMs
 * History:
 * <author>     <time>       <version>     <desc>
 * 作者姓名    修改时间     版本号       描述
 */
package com.xr.springboot;

import redis.clients.jedis.Jedis;

/**
 * 〈一句话功能简述〉<br> 
 * 〈TestMs〉
 *
 * @author TSYH
 * @create 2019-12-17
 * @since 1.0.0
 */
public class TestMS {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("47.96.144.120",6379);
        jedis.auth("Family@1314");

    }
}