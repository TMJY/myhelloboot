/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ShiroDao
 * Author:   TSYH
 * Date:     2019-12-09 12:00
 * Description:
 * History:
 * <author>     <time>       <version>     <desc>
 * 作者姓名    修改时间     版本号       描述
 */
package com.xr.springboot.dao;

import com.xr.springboot.pojo.Role;
import com.xr.springboot.pojo.Student;
import com.xr.springboot.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author TSYH
 * @create 2019-12-09
 * @since 1.0.0
 */
@Repository
public interface     ShiroDao {
    /**
     * 根据用户名查找用户
     */
     User getUserByUsername(@Param("username") String username);

    /*
     *根据用户查询角色
     */
    Set<String> listRoles(@Param("username")String username);

    /**
     * 查询用户所有权限,返回值是权限名集合
     */
    Set<String> listPermissions(@Param("username")String username);

    /**
     * 查找所有角色名
     */
    List<Student> queryAllStudent();







}