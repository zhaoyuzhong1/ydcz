package com.yd.web;


import com.yd.dto.SysMenu;
import com.yd.dto.SysRole;
import com.yd.dto.SysRoleMenu;
import com.yd.dto.SysUser;
import com.yd.util.HelperClazz;
import com.yd.util.MenuUtil;
import com.yd.util.Page;
import com.yd.web.base.BaseController;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/role")
public class SysRoleController extends BaseController {
	//首页跳转
	@RequestMapping(value = "/index")
	public String index(Model model, @ModelAttribute MenuUtil menuUtil, HttpServletRequest request) {
		SysUser emp1 = (SysUser) request.getSession().getAttribute("empSession");


		model.addAttribute("menuUtil", menuUtil);
		return "role/index";
	}

	//列表
	@ResponseBody
	@RequestMapping(value = "/queryList")
	public Map<String, Object> queryList(String search_name, Integer pagesize, Integer count) {
		Map<String, Object> map = new HashMap<>();
		Page<SysRole> pageList = sysRoleDao.getList(search_name,pagesize, count);
		map.put("rows", pageList.getResult());
		map.put("total", pageList.getTotalCount());
		return map;
	}

	//添加
	@ResponseBody
	@RequestMapping(value = "/addRole")
	public String addRole(SysRole role,HttpServletRequest request) {
		SysUser emp1 = (SysUser) request.getSession().getAttribute("empSession");


		int exist = sysRoleDao.addExist(role);
		if(exist == 0){
			int status = sysRoleDao.addRole(role);
			if(status != -1){
				return "ok";
			}
			return "no";
		}
		return "you";
	}

	//修改
	@ResponseBody
	@RequestMapping(value = "/updateRole")
	public String updateRole(SysRole role,HttpServletRequest request) {
		SysUser emp1 = (SysUser) request.getSession().getAttribute("empSession");

		int exist = sysRoleDao.updateExist(role);
		if(exist == 0){
			int status = sysRoleDao.updateRole(role);
			if(status != -1){
				return "ok";
			}
			return "no";
		}
		return "you";
	}

	//删除(伪)
	@ResponseBody
	@RequestMapping(value = "/deleteRole")
	public String deleteRole(int id,HttpServletRequest request) {
		SysUser emp1 = (SysUser) request.getSession().getAttribute("empSession");

		int exist = sysRoleDao.deleteRole(id);
		if(exist != -1) {
			return "ok";
		}
		return "no";
	}

	//菜单显示
	@RequestMapping( value = "/queryMenu")
	public void queryMenu(HttpServletResponse response, Integer roleid){
		response.setCharacterEncoding("utf-8");
		//所有权限
		List<SysMenu> functionAllList = sysRoleDao.queryRoleAllFunction();
		//当前登录人的的权限
		List<SysMenu> functionLoginList = sysRoleDao.functionLoginList(roleid);
		JSONArray jsonArray = new JSONArray();
		if (functionAllList != null && functionAllList.size() > 0) {
			for (int i = 0; i < functionAllList.size(); i++) {
				JSONObject jsonObject = new JSONObject();
				SysMenu function = functionAllList.get(i);
				jsonObject.put("id",function.getId());
				jsonObject.put("pid",function.getPid());
				jsonObject.put("name",function.getName());
				for (int j = 0; j < functionLoginList.size(); j++) {
					SysMenu functionChecked = functionLoginList.get(j);
					//判断已有权限选中
					if (function.getId()==functionChecked.getId()) {
						jsonObject.put("checked", true);
					}
				}
				jsonObject.put("open", "true");
				jsonArray.put(jsonObject);
			}
		}
		String jsonCommunity = jsonArray.toString();
		HelperClazz.renderText(response,jsonCommunity);
	}

	//授权菜单(将原有的菜单在关联表中删除, 在添加新的)
	@RequestMapping(value="/settingMenu")
	public void settingMenu(int id, String str, HttpServletResponse response, HttpServletRequest request){
		SysUser emp1 = (SysUser) request.getSession().getAttribute("empSession");


		//删除该ID下所有菜单
		sysRoleDao.deleteMenuByRoleId(id);
		//添加菜单
		if(str!=null&&!"".equals(str)){
			String[] menuArray = str.split(",");
			SysRoleMenu userRole=new SysRoleMenu();
			userRole.setRoleid(id);
			for(String menuId:menuArray){
				if(!"0".equals(menuId)){
					userRole.setFunctionid(Integer.parseInt(menuId));
					sysRoleDao.insertUserRoleMenu(userRole);
					HelperClazz.renderText(response,"ok");
				}
			}
		} else {
			HelperClazz.renderText(response,"no");
		}
	}
}
