package com.yd.web;


import com.yd.dto.SysMenu;
import com.yd.dto.SysUser;
import com.yd.util.MenuUtil;
import com.yd.util.Page;
import com.yd.web.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/menu")
public class SysMenuController extends BaseController {
	//首页跳转
	@RequestMapping(value = "/index")
	public String index(Model model, @ModelAttribute MenuUtil menuUtil, HttpServletRequest request) {
		SysUser emp1 = (SysUser) request.getSession().getAttribute("empSession");

		model.addAttribute("menuUtil", menuUtil);
		List<SysMenu> menuList = sysMenuDao.getAllList();
		model.addAttribute("menuList", menuList);
		return "menu/index";
	}

	//列表
	@ResponseBody
	@RequestMapping(value = "/queryList")
	public Map<String, Object> queryList(String search_name, Integer pagesize, Integer count) {
		Map<String, Object> map = new HashMap<>();
		Page<SysMenu> pageList = sysMenuDao.getList(search_name,pagesize, count);
		map.put("rows", pageList.getResult());
		map.put("total", pageList.getTotalCount());
		return map;
	}

	//添加
	@ResponseBody
	@RequestMapping(value = "/addMenu")
	public String addMenu(SysMenu menu,HttpServletRequest request) {
		SysUser emp1 = (SysUser) request.getSession().getAttribute("empSession");


		int exist = sysMenuDao.addExist(menu);
		if(exist == 0){
			int status = sysMenuDao.addMenu(menu);
			if(status != -1){
				return "ok";
			}
			return "no";
		}
		return "you";
	}

	//修改
	@ResponseBody
	@RequestMapping(value = "/updateMenu")
	public String updateMenu(SysMenu menu,HttpServletRequest request) {
		SysUser emp1 = (SysUser) request.getSession().getAttribute("empSession");

		int exist = sysMenuDao.updateExist(menu);
		if(exist == 0){
			int status = sysMenuDao.updateMenu(menu);
			if(status != -1){
				return "ok";
			}
			return "no";
		}
		return "you";
	}

	//删除(伪)
	@ResponseBody
	@RequestMapping(value = "/deleteMenu")
	public String deleteMenu(int id,HttpServletRequest request) {
		SysUser emp1 = (SysUser) request.getSession().getAttribute("empSession");

		int exist = sysMenuDao.deleteMenu(id);
		if(exist != -1) {
			return "ok";
		}
		return "no";
	}
}
