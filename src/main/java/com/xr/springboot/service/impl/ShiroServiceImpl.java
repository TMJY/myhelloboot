/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ShiroServiceImpl
 * Author:   TSYH
 * Date:     2019-12-09 12:36
 * Description:
 * History:
 * <author>     <time>       <version>     <desc>
 * 作者姓名    修改时间     版本号       描述
 */
package com.xr.springboot.service.impl;

import com.xr.springboot.dao.ShiroDao;
import com.xr.springboot.pojo.Permission;
import com.xr.springboot.pojo.Role;
import com.xr.springboot.pojo.Student;
import com.xr.springboot.pojo.User;
import com.xr.springboot.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private ShiroDao shiroDao;

    @Override
    public User getUserByUsername(String username) {
        return shiroDao.getUserByUsername(username);
    }

    @Override
    public Set<String> listRoles(String username) {
        return shiroDao.listRoles(username);
    }

    @Override
    public Set<String> listPermissions(String username) {
        return shiroDao.listPermissions(username);
    }

    @Override
    public List<Student> queryAllStudent() {
        return shiroDao.queryAllStudent();
    }
}