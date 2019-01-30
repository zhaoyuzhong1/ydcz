package com.yd.dao;


import com.yd.dao.base.BaseDao;
import com.yd.dto.SysRole;
import com.yd.dto.SysUser;
import com.yd.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by james on 2018/6/28.
 */
@Component
public class SysUserDao {
    @Autowired
    private BaseDao baseDao;

    public SysUser login(String loginName, String pwd){
        final String sql ="select * from sys_user where loginname = ? and loginpwd = ? and flag='0'";
        List<SysUser> emps = baseDao.query(sql,SysUser.class,new Object[]{loginName,pwd});
        return emps.isEmpty() ? null : emps.get(0);
    }


    public int queryByName(String login_name) {
        StringBuffer sql =new StringBuffer();
        sql.append( " select * from sys_user where loginname = ? ");
        if (baseDao.query(sql.toString(),SysUser.class,new Object[]{login_name}).size()>0){
            return 1;
        }else{
            return 0;
        }
    }

    public SysUser getEmpById(String emp_id) {
        StringBuffer sql =new StringBuffer();
        sql.append(" select * from sys_user where id = ?");
        return baseDao.queryById(sql.toString(),SysUser.class,emp_id);
    }

    public int updateUser(SysUser emp) {
        String sql = " update sys_user set name = :name,loginname=:loginname,loginpwd=:loginpwd,roleid=:roleid,mobile=:mobile  where id = :id ";
        return baseDao.update(sql,emp);
    }

    public int deleteUser(String id) {
        String sql = "update sys_user set flag='1' where id=?";
        return baseDao.update2(sql,new Object[]{id});
    }


    //创建用户查询角色
    public List<SysRole> SelectRole() {
        StringBuffer sql =new StringBuffer();
        sql.append(" SELECT * FROM sys_role where type != 'admin' ");
        return baseDao.query(sql.toString(),SysRole.class);
    }


    //查询账号
    public int quertyByName(String login_name) {
        StringBuffer sql =new StringBuffer();
        sql.append(" SELECT count(*) FROM sys_user where loginname = ? and flag ='0' ");
        return baseDao.queryForObject(sql.toString(),Integer.class,new Object[]{login_name});
    }

    //添加
    public int insUser(SysUser emp) {
        StringBuffer sql =new StringBuffer();
        sql.append(" insert into sys_user (name,loginname,loginpwd,roleid,mobile,cdate,cuser,flag) values(:name,:loginname,:loginpwd,:roleid,:mobile,now(),:cuser,'0') ");
        return baseDao.insert(sql.toString(),emp);
    }


    //修改密码
    public SysUser getEmpByid(Integer emp_id) {
        StringBuffer sql =new StringBuffer();
        sql.append(" select * from sys_user where id = ?");
        return baseDao.queryById(sql.toString(),SysUser.class,emp_id);
    }
    //修改
    public int update(SysUser emp) {

        StringBuffer sql = new StringBuffer();
        sql.append(" update sys_user set name=:name,loginname=:loginname,loginpwd=:loginpwd,mobile=:mobile  where id = :id ");
        return baseDao.update(sql.toString(),emp);

    }


    public Page<SysUser> getList(String name, Integer pagesize, Integer count) {
        String sql="SELECT a.*,b.name as rolename FROM sys_user a left join sys_role b on a.roleid=b.id WHERE a.name like ? and a.flag='0'";
        return baseDao.queryByPage(sql,SysUser.class,new Object[]{"%"+name+"%"},pagesize,count);
    }
}
