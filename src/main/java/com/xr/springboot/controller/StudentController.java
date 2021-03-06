///**
// * Copyright (C), 2015-2019, XXX有限公司
// * FileName: RoleController
// * Author:   TSYH
// * Date:     2019-12-17 22:08
// * Description:
// * History:
// * <author>     <time>       <version>     <desc>
// * 作者姓名    修改时间     版本号       描述
// */
//package com.xr.springboot.controller;
//
//import com.xr.springboot.pojo.Role;
//import com.xr.springboot.pojo.Student;
//import com.xr.springboot.service.ShiroService;
//import com.xr.springboot.util.JedisCache;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpSession;
//import java.util.List;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈〉
// *
// * @author TSYH
// * @create 2019-12-17
// * @since 1.0.0
// */
//@Controller
//public class StudentController {
//
//    @Autowired
//    private ShiroService shiroService;
//
//    @Autowired
//    private JedisCache jedisCache;
//
//    @RequestMapping("/query")
//    public String role(HttpSession session){
//        List<Student> students =null;
//        Boolean ifExists = jedisCache.exists("com.xr.springboot.controller.StudentController.role");
//        if(ifExists){
//            students = jedisCache.getArraylist("com.xr.springboot.controller.StudentController.role",Student.class);
//            /*students = jedisCache.getArraylist("students", Student.class);*/
//        }else{
//            students = shiroService.queryAllStudent();
//            //存入内存
//            jedisCache.setArrayList("com.xr.springboot.controller.StudentController.role",students,60*5);
//        }
//
//        session.setAttribute("students",students);
//
//        return "query";
//    }
//
//}