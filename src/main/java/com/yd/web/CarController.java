package com.yd.web;

import com.yd.dao.CarDao;
import com.yd.dao.CityDao;
import com.yd.dao.ShopDao;
import com.yd.dto.Car;
import com.yd.dto.CarImg;
import com.yd.dto.City;
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
@RequestMapping(value = "/car")
public class CarController {
    @Autowired
    CarDao carDao;

    @RequestMapping(value = "/index")
    public String index() {
        return "car/index";
        //return "sys/top";
    }



    @RequestMapping(value = "/imgindex")
    public String imgindex(int carid,Model model) {
        List<CarImg> cis = carDao.selectImgByCarid(carid);
        model.addAttribute("cis",cis);
        return "car/imgindex";
        //return "sys/top";
    }




    @ResponseBody
    @RequestMapping(value = "/queryList")
    public Map<String, Object> queryList(String search_name, Integer pagesize, Integer count) {
        Map<String, Object> map = new HashMap<>();
        Page<Car> pageList = carDao.getList(search_name,pagesize, count);
        map.put("rows", pageList.getResult());
        map.put("total", pageList.getTotalCount());
        return map;
    }



    @ResponseBody
    @RequestMapping(value = "/addCar")
    public String addCar(Car car) {
        int flag = carDao.addCar(car);
        if(flag>0){
            return "ok";
        }else {
            return "nook";
        }
        //return "sys/top";
    }



    @ResponseBody
    @RequestMapping(value = "/updateCar")
    public String updateCar(Car car) {
        int flag = carDao.updateCar(car);
        if(flag==0){
            return "ok";
        }else {
            return "nook";
        }
        //return "sys/top";
    }


}
