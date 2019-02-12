package com.yd.web;

import com.yd.dao.CarDao;
import com.yd.dao.CarImgDao;
import com.yd.dao.ShopDao;
import com.yd.dto.Car;
import com.yd.dto.CarImg;
import com.yd.dto.Shop;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/index")
    public String index(Model model) {
        Shop shop = shopDao.selectShopByCity("长春");
        List<Car> cars = carDao.getSyCar(10);

        model.addAttribute("shop",shop);
        model.addAttribute("cars",cars);
        return "web/index";
        //return "sys/top";
    }







}
