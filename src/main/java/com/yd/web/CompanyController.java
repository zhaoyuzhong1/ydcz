package com.yd.web;

import com.yd.dao.CityDao;
import com.yd.dao.CompanyDao;
import com.yd.dao.ShopDao;
import com.yd.dto.City;
import com.yd.dto.Company;
import com.yd.dto.Shop;
import com.yd.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by james on 2019/2/1.
 */
@Controller
@RequestMapping(value = "/company")
public class CompanyController {
    @Autowired
    CompanyDao companyDao;

    @RequestMapping(value = "/index")
    public String index(Model model) {

        return "company/index";
        //return "sys/top";
    }




    @ResponseBody
    @RequestMapping(value = "/queryList")
    public Map<String, Object> queryList(String search_name, Integer pagesize, Integer count) {
        Map<String, Object> map = new HashMap<>();
        Page<Company> pageList = companyDao.getList(search_name,pagesize, count);
        map.put("rows", pageList.getResult());
        map.put("total", pageList.getTotalCount());
        return map;
    }



    @ResponseBody
    @RequestMapping(value = "/add")
    public String add(Company company) {
        company.setIsyx("0");
        int flag = companyDao.addCompany(company);
        if(flag>0){
            return "ok";
        }else {
            return "nook";
        }
        //return "sys/top";
    }



    @ResponseBody
    @RequestMapping(value = "/update")
    public String update(Company company) {
        company.setIsyx("0");
        int flag = companyDao.updateCompany(company);
        if(flag==0){
            return "ok";
        }else {
            return "nook";
        }
        //return "sys/top";
    }


}
