///**
// * Copyright (C), 2015-2019, XXX有限公司
// * FileName: JedisPoolUtils
// * Author:   TSYH
// * Date:     2019-12-18 9:03
// * Description:
// * History:
// * <author>     <time>       <version>     <desc>
// * 作者姓名    修改时间     版本号       描述
// */
//package com.xr.springboot.util;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈〉
// *
// * @author TSYH
// * @create 2019-12-18
// * @since 1.0.0
// */
//@Configuration
//public class JedisConfig extends CachingConfigurerSupport {
//    private Logger logger = LoggerFactory.getLogger(JedisConfig.class);
//
//    /**
//     * SpringSession  需要注意的就是redis需要2.8以上版本，然后开启事件通知，在redis配置文件里面加上
//     * notify-keyspace-events Ex
//     * Keyspace notifications功能默认是关闭的（默认地，Keyspace 时间通知功能是禁用的，因为它或多或少会使用一些CPU的资源）。
//     * 或是使用如下命令：
//     * redis-cli config set notify-keyspace-events Egx
//     * 如果你的Redis不是你自己维护的，比如你是使用阿里云的Redis数据库，你不能够更改它的配置，那么可以使用如下方法：在applicationContext.xml中配置
//     * <util:constant static-field="org.springframework.session.data.redis.config.ConfigureRedisAction.NO_OP"/>
//     *
//     * @return
//     */
//
//    @Value("${spring.redis.host}")
//    private String host;
//
//    @Value("${spring.redis.port}")
//    private int port;
//
//    @Value("${spring.redis.password}")
//    private String password;
//
//    @Value("${spring.redis.jedis.pool.max-active}")
//    private int maxActive;
//
//    @Value("${spring.redis.jedis.pool.max-idle}")
//    private int maxIdle;
//
//    @Value("${spring.redis.jedis.pool.min-idle}")
//    private int minIdle;
//
//
//    @Bean
//    public JedisPool redisPoolFactory() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxIdle(maxIdle);
//        jedisPoolConfig.setMaxWaitMillis(100 * 1000);
//        jedisPoolConfig.setMaxTotal(maxActive);
//        jedisPoolConfig.setMinIdle(minIdle);
//        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, 0, password);
//
//        logger.info("JedisPool注入成功！");
//        logger.info("redis地址：" + host + ":" + port + "maxActive:" + maxActive);
//        return jedisPool;
//    }
//
//
//
//    }