package com.yd.dao;


import com.yd.dao.base.BaseDao;
import com.yd.dto.SysMenu;
import com.yd.dto.SysRole;
import com.yd.dto.SysRoleMenu;
import com.yd.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SysRoleDao {
	@Autowired
	private BaseDao baseDao;

	//列表
	public Page<SysRole> getList(String search_name, Integer pagesize, Integer count) {
		String sql = "select * from sys_role where name like ? or type like ? order by id";
		return baseDao.queryByPage(sql,SysRole.class,new Object[]{"%"+search_name+"%","%"+search_name+"%"},pagesize,count);
	}

	//添加前判断是否存在
	public Integer addExist(SysRole role){
		String sql ="select * from sys_role where name = ? ";
		if(baseDao.query(sql,SysMenu.class,new Object[]{role.getName()}).size()>0){
			return 1;
		}
		return 0;
	}

	//添加
	public Integer addRole(SysRole role){
		String sql ="insert into sys_role(name,type) values(:name,:type)";
		return baseDao.insert(sql,role);
	}

	//修改前判断是否存在
	public Integer updateExist(SysRole role){
		String sql ="select * from sys_role where name = ? and id != ? ";
		if(baseDao.query(sql,SysMenu.class,new Object[]{role.getName(),role.getId()}).size()>0){
			return 1;
		}
		return 0;
	}

	//修改
	public Integer updateRole(SysRole role){
		String sql ="update sys_role set name=:name,type=:type where id=:id ";
		return baseDao.update(sql,role);
	}

	//删除(真)
	public Integer deleteRole(int id){
		return baseDao.deleteById("sys_role",id);
	}

	//所有菜单
	public List<SysMenu> queryRoleAllFunction(){
		String sql = "select * from sys_function where flag = 0";
		return baseDao.query(sql,SysMenu.class);
	}

	//当前登录人的菜单(Menu)
	public List<SysMenu> functionLoginList(Integer roleid){
		String sql = "select * from sys_function where flag = 0 and id in ( select functionid from sys_role_function where roleid = ? )";
		return baseDao.query(sql,SysMenu.class,new Object[]{roleid});
	}

	//删除角色_URL的关联
	public void deleteMenuByRoleId(int roleid) {
		String sql = "delete from sys_role_function where roleid =?";
		baseDao.delete(sql,roleid);
	}

	//添加角色_URL的关联
	public Integer insertUserRoleMenu(SysRoleMenu roleMenu) {
		String sql = "insert into sys_role_function (roleid,functionid) values(:roleid,:functionid)";
		return baseDao.insert(sql,roleMenu);
	}
}
