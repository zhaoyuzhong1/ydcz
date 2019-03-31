package com.yd.web;

import com.yd.dao.*;
import com.yd.dto.*;
import com.yd.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by james on 2019/2/1.
 */
@Controller
@RequestMapping(value = "/web")
public class WebController {
    @Autowired
    CarDao carDao;
    @Autowired
    CarImgDao carImgDao;
    @Autowired
    ShopDao shopDao;
    @Autowired
    MainDao mainDao;
    @Autowired
    CompanyDao companyDao;
    @Autowired
    BannerDao bannerDao;

    @RequestMapping(value = "/index")
    public String index(Model model) {
        Shop shop = shopDao.selectShopByCity("长春");
        List<Car> cars = carDao.getSyCar(10);
        Main main = mainDao.getMain();
        List<Company> coms = companyDao.selectYxCompany();
        model.addAttribute("new",carDao.getSyCar2("0",3));//新车
        model.addAttribute("old",carDao.getSyCar2("1",3));//二手车
        model.addAttribute("tuan",carDao.getSyCar2("2",3));//团购

        Banner top = bannerDao.getBannerByType("0");
        //Banner center = bannerDao.getBannerByType("1");
        model.addAttribute("top",top);
        //model.addAttribute("center",center);
        return "web/index2";
        //return "sys/top";
    }



    @RequestMapping(value = "/list")
    public String list(Model model,String companyid) {
        Shop shop = shopDao.selectShopByCity("长春");
        List<Car> cars = new ArrayList<>();
        if(companyid!=null && !companyid.equals("")){
            cars = carDao.getAllCar(companyid,20);
        }else{
            cars = carDao.getAllCar("",20);
        }

        Main main = mainDao.getMain();
        model.addAttribute("shop",shop);
        model.addAttribute("cars",cars);
        model.addAttribute("main",main);
        return "web/list";
        //return "sys/top";
    }



    @RequestMapping(value = "/detail")
    public String detail(Model model,int carid) {
        Shop shop = shopDao.selectShopByCity("长春");
        Car car = carDao.getCarByid(carid);
        List<CarImg> cis = carDao.selectImgByCarid(carid);

        Main main = mainDao.getMain();
        Banner top = bannerDao.getBannerByType("0");
        Banner center = bannerDao.getBannerByType("1");
        model.addAttribute("top",top);
        model.addAttribute("center",center);

        model.addAttribute("shop",shop);
        model.addAttribute("car",car);
        model.addAttribute("cis",cis);
        model.addAttribute("main",main);
        return "web/detail";
        //return "sys/top";
    }







}
