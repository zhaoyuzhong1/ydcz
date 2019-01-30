package com.yd.web;


import com.yd.dao.SysUserDao;
import com.yd.dao.YwLoginDao;
import com.yd.dto.Function;
import com.yd.dto.SysUser;
import com.yd.util.MenuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


/**
 * Created by What！
 * on 2017/12/25.
 */
@Controller
@RequestMapping(value = "/sys")
public class SysController  {
    @Autowired
    YwLoginDao ywLoginDao;
    @Autowired
    SysUserDao sysUserDao;


    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request) {
        return "ywsys/ywlogin";
        //return "sys/top";
    }
    @RequestMapping(value = "/login")
    public String login(Model model, HttpServletRequest request , HttpServletResponse response ){
        String userName = request.getParameter("loginName");
        String password = request.getParameter("loginPwd");
        SysUser emp = ywLoginDao.selectLoginEmp(userName,password);
        if(emp!=null) {
            request.getSession().setAttribute("login",emp.getId()+"@"+emp.getRoleid());
            List<Map<String,Object>> alllist = new ArrayList<Map<String,Object>>();
            List<Function> plist=ywLoginDao.getAllParent(emp.getRoleid()+"");

            Set<Function> setData = new HashSet<Function>();
            setData.addAll(plist);


            for (Function function : setData){
                Map<String,Object> map = new HashMap<>();
                //遍历后将父级菜单存入map集合
                map.put("pfunction",function);
                //根据父级菜单查询所有子级菜单
               // List<Function> slist=ywLoginDao.getAllByPid(function.getId(),emp.getIdentification()==0?"8":"");
                List<Function> slist=ywLoginDao.getAllByPid1(function.getId(),emp.getId());
                //遍历后将子级菜单存入map集合
                map.put("slist",slist);
                //将装有父级菜单与子级菜单的map集合存入list
                alllist.add(map);
            }


            request.getSession().setAttribute("empSession",emp);
            request.getSession().setAttribute("smenus",alllist);
            request.getSession().setMaxInactiveInterval(99999999);

            return "ywsys/ywindex";


        }else {
            model.addAttribute("returnInfo", "loginNoOK");
            return index(request);
        }
    }
    //退出登录
    @RequestMapping(value = "/nologin")
    public String nologin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session!=null) {
            SysUser emp1 = (SysUser) session.getAttribute("empSession");

            session.invalidate();
        }
//        Enumeration em = request.getSession().getAttributeNames();
//        while(em.hasMoreElements()){
//            request.getSession().removeAttribute(em.nextElement().toString());
//        }
        return "redirect:/sys/index";
    }


    /*@RequestMapping(value = "/toCheckPublicBusi")
    public  void  toCheckPublicBusi (HttpServletResponse response, HttpServletRequest request){
        SysUser emp1 = (SysUser) request.getSession().getAttribute("empSession");
        if (emp1!=null){
            Integer emp_id = emp1.getId();
            int t = ywLoginDao.select(emp_id);
            if (t ==0){
                HelperClazz.renderText(response,"notok");
            }else{
                HelperClazz.renderText(response,"ok");
            }
        }

    }*/



}
