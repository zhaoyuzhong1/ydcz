package com.yd.dto;

import org.springframework.stereotype.Component;

@Component
public class SysRoleMenu extends BaseDTO {
	private int roleid;
	private int functionid;

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getFunctionid() {
		return functionid;
	}

	public void setFunctionid(int functionid) {
		this.functionid = functionid;
	}
}
