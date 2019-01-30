package com.yd.web.base;


import com.yd.dao.SysMenuDao;
import com.yd.dao.SysRoleDao;
import com.yd.util.ParamSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
	@Autowired
	public ParamSettings paramSettings;
	@Autowired
	public SysMenuDao sysMenuDao;
	@Autowired
	public SysRoleDao sysRoleDao;
}
