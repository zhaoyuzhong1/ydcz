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
    @Autowired
    AdvertDao advertDao;

    @RequestMapping(value = "/index")
    public String index(Model model) {
        Shop shop = shopDao.selectShopByCity("长春");
        List<Car> cars = carDao.getSyCar(10);
        Main main = mainDao.getMain();
        List<Company> coms = companyDao.selectYxCompany();
        List<Car> news = carDao.getSyCar2("0",3);
        List<Car> old = carDao.getSyCar2("0",3);
        List<Car> tuan = carDao.getSyCar2("0",3);

        model.addAttribute("news",news);//新车
        model.addAttribute("old",old);//二手车
        model.addAttribute("tuan",tuan);//团购
        Advert advert = advertDao.getAdvert();
        String content = "";
        if(advert!=null){
            content = advert.getContent();
        }

        Banner top = bannerDao.getBannerByType("0");
        //Banner center = bannerDao.getBannerByType("1");
        model.addAttribute("top",top);
        model.addAttribute("content",content);
        //model.addAttribute("center",center);
        return "web/index2";
        //return "sys/top";
    }



    @RequestMapping(value = "/list")
    public String list(Model model,String type) {
//        Shop shop = shopDao.selectShopByCity("长春");
//        List<Car> cars = new ArrayList<>();
//        if(companyid!=null && !companyid.equals("")){
//            cars = carDao.getAllCar(companyid,20);
//        }else{
//            cars = carDao.getAllCar("",20);
//        }

        //Main main = mainDao.getMain();
        List<Car> cars = carDao.getAllCarsByType(type,30);

        model.addAttribute("type",type);
        model.addAttribute("cars",cars);

        return "web/list2";
        //return "sys/top";
    }



    @RequestMapping(value = "/detail")
    public String detail(Model model,int carid) {
//        Shop shop = shopDao.selectShopByCity("长春");
//        Car car = carDao.getCarByid(carid);
//        List<CarImg> cis = carDao.selectImgByCarid(carid);
//
//        Main main = mainDao.getMain();
//        Banner top = bannerDao.getBannerByType("0");
//        Banner center = bannerDao.getBannerByType("1");

        Car car = carDao.getCarByid(carid);
        List<CarImg> cis = carImgDao.getImgList(carid+"");

//        model.addAttribute("top",top);
//        model.addAttribute("center",center);
//
//        model.addAttribute("shop",shop);
        model.addAttribute("car",car);
        model.addAttribute("cis",cis);
        //model.addAttribute("main",main);
        return "web/detail2";
        //return "sys/top";
    }







}
