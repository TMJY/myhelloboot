/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RedisController
 * Author:   TSYH
 * Date:     2019-12-25 13:58
 * Description:
 * History:
 * <author>     <time>       <version>     <desc>
 * 作者姓名    修改时间     版本号       描述
 */
package com.xr.springboot.controller;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author TSYH
 * @create 2019-12-25
 * @since 1.0.0
 */

import com.xr.springboot.pojo.Student;
import com.xr.springboot.pojo.User;
import com.xr.springboot.service.ShiroService;
import com.xr.springboot.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @program: springbootdemo
 * @Date: 2019/1/25 15:03
 * @Author: Mr.Zheng
 * @Description:
 */

@Controller
public class RedisController {
    @Autowired
    private ShiroService shiroService;

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("/query")
    public void role(HttpSession session){
        List<Student> students = null;
        Boolean ifExists = redisUtil.hasKey("com.xr.springboot.controller.StudentController.role");
        if(ifExists){
            students = redisUtil.lGet("com.xr.springboot.controller.StudentController.role",0,-1,Student.class);
            System.out.println(students);
            /*students = jedisCache.getArraylist("students", Student.class);*/
        }else{
            students = shiroService.queryAllStudent();
            //存入内存
            redisUtil.lSet("com.xr.springboot.controller.StudentController.role",students,60*2);
        }

        session.setAttribute("students",students);


    }


}


















































