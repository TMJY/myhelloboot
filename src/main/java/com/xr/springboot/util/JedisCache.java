///**
// * Copyright (C), 2015-2019, XXX有限公司
// * FileName: JedisCache
// * Author:   TSYH
// * Date:     2019-12-18 11:39
// * Description:
// * History:
// * <author>     <time>       <version>     <desc>
// * 作者姓名    修改时间     版本号       描述
// */
//package com.xr.springboot.util;
//
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.JSONPObject;
//import com.hazelcast.internal.json.JsonArray;
//import com.xr.springboot.pojo.Student;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jmx.export.naming.KeyNamingStrategy;
//import org.springframework.stereotype.Component;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//
//import java.io.InputStream;
//import java.util.*;
//import java.util.concurrent.TimeUnit;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈〉
// *
// * @author TSYH
// * @create 2019-12-18
// * @since 1.0.0
// */
//@Component
//public class JedisCache {
//    private Logger log = LoggerFactory.getLogger(JedisCache.class);
//
//    @Autowired
//    private JedisPool jedisPool;
//
//    /**
//     * <p>	 * 判断key是否存在	 * </p>	 *
//     * * @param key	 * @return true OR false
//     */
//    public Boolean exists(String key) {
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            return jedis.exists(key);
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            return false;
//        } finally {
//            jedis.close();
//        }
//    }
//
//    /**
//     * <p>	 * 为给定 key 设置生存时间，当 key 过期时(生存时间为 0 )，它会被自动删除。	 * </p>	 *	 * @param key	 * @param value	 *            过期时间，单位：秒	 * @return 成功返回1 如果存在 和 发生异常 返回 0
//     */
//    public Long expire(String key, int time, int indexdb) {
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            jedis.select(indexdb);
//            return jedis.expire(key, time);
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            return 0L;
//        } finally {
//            jedis.close();
//        }
//    }
//
//
//    /**
//     *
//     * 此方法将ArrayList集合直接存储为一个字符串
//     *
//     * @param key
//     *            存储的名字
//     * @param list
//     *            要存储的集合对象
//     * @param activeTime
//     *            该对象的有效时间，单位为秒
//     */
//    public Boolean setArrayList(String key, List list,
//                                       Integer activeTime) {
//        if (list != null && key != null && key != "") {
//            Jedis jedis = jedisPool.getResource();
//            jedis.set(key, JSONArray.toJSONString(list).toString());
//            if (activeTime != null && activeTime > 0) {
//                jedis.expire(key, activeTime);
//            }
//            jedis.close();
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 此方法将会把存在redis中的数据取出来，并封装成相应的Arraylist集合
//     *
//     * @param key
//     *            存储的名字
//     *            要封装成为的javaBean
//     * @return List
//     */
//    public List getArraylist(String key, Class beanClass) {
//        if (key != null && key != "" && beanClass != null) {
//            Jedis jedis = jedisPool.getResource();
//            JSONArray jsonArray = JSONArray.parseArray(jedis.get(key));
//            List list = new ArrayList();
//
//            for (int i = 0; i < jsonArray.size(); i++) {
//                Object object = JSONObject.parseObject(jsonArray.get(i).toString(), beanClass);
//                list.add(object);
//            }
//
//            return list;
//        }
//        return null;
//    }
//
//    /**
//     * 此方法将Map集合直接存储为一个字符串
//     * @param key         存储的名字
//     * @param map         要存储的Map集合对象
//     * @param activeTime  该对象的有效时间，单位为秒
//     * @return            成功返回true,失败返回false
//     */
//    public boolean setMap(String key, Map map,
//                                 Integer activeTime) {
//        if (map != null && key != null && key != "") {
//            Jedis jedis = jedisPool.getResource();
//            jedis.set(key, JSONObject.toJSONString(map).toString());
//            if (activeTime != null && activeTime > 0) {
//                jedis.expire(key, activeTime);
//            }
//            jedis.close();
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 此方法将会把存在redis中的数据取出来，并封装成相应的Map集合
//     * @param key          存储的名字
//     * @param beanClass    要封装成的对象
//     * @return             返回封装后的map集合
//     */
//    public  Map getMap(String key, Class beanClass) {
//        if (key != null && key != "" && beanClass != null) {
//            Jedis jedis = jedisPool.getResource();
//            Map map1 = (Map) JSONObject.parseObject(jedis.get(key));
//            Set set = map1.keySet();
//            Iterator ite = set.iterator();
//            Map maps = new HashMap();
//            while (ite.hasNext()) {
//                String key1 = (String) ite.next();
//                JSONObject jsonObject = JSONObject.parseObject(map1.get(key1).toString());
//                Object object = JSONObject.parseObject(jsonObject.toString(), beanClass);
//                maps.put(key1, object);
//            }
//            return maps;
//        }
//        return null;
//    }
//
//
//}