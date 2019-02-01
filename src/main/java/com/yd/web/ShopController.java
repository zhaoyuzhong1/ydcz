package com.yd.web;

import com.yd.dao.CityDao;
import com.yd.dao.ShopDao;
import com.yd.dto.City;
import com.yd.dto.Shop;
import com.yd.dto.SysUser;
import com.yd.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by james on 2019/2/1.
 */
@Controller
@RequestMapping(value = "/shop")
public class ShopController {
    @Autowired
    CityDao cityDao;
    @Autowired
    ShopDao shopDao;

    @RequestMapping(value = "/index")
    public String index(Model model) {
        List<City> cs = cityDao.getList();
        model.addAttribute("cs",cs);
        return "shop/index";
        //return "sys/top";
    }




    @ResponseBody
    @RequestMapping(value = "/queryList")
    public Map<String, Object> queryList(String search_name, Integer pagesize, Integer count) {
        Map<String, Object> map = new HashMap<>();
        Page<Shop> pageList = shopDao.getList(search_name,pagesize, count);
        map.put("rows", pageList.getResult());
        map.put("total", pageList.getTotalCount());
        return map;
    }



    @ResponseBody
    @RequestMapping(value = "/addShop")
    public String index(Shop shop) {
        int flag = shopDao.addShop(shop);
        if(flag>0){
            return "ok";
        }else {
            return "nook";
        }
        //return "sys/top";
    }



    @ResponseBody
    @RequestMapping(value = "/updateShop")
    public String updateShop(Shop shop) {
        int flag = shopDao.updateShop(shop);
        if(flag==0){
            return "ok";
        }else {
            return "nook";
        }
        //return "sys/top";
    }


}
