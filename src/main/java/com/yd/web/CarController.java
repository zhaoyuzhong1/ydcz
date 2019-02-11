package com.yd.web;

import com.yd.dao.CarDao;
import com.yd.dao.CarImgDao;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@RequestMapping(value = "/car")
public class CarController {
    @Autowired
    CarDao carDao;
    @Autowired
    CarImgDao carImgDao;

    @RequestMapping(value = "/index")
    public String index() {
        return "car/index";
        //return "sys/top";
    }



    @RequestMapping(value = "/imgindex")
    public String imgindex(int carid,Model model) {
        List<CarImg> cis = carDao.selectImgByCarid(carid);
        model.addAttribute("cis",cis);
        model.addAttribute("carid",carid);
        return "car/imgindex";
        //return "sys/top";
    }



    @RequestMapping(value = "/uploadFile")
    public String upload(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setCharacterEncoding("UTF-8");
        Map<String, Object> json = new HashMap<String, Object>();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        /** 页面控件的文件流* */
        MultipartFile multipartFile = null;
        Map map =multipartRequest.getFileMap();
        String name = multipartRequest.getParameter("name");
        String carid = multipartRequest.getParameter("carid");
        System.out.println("name:"+name);
        for (Iterator i = map.keySet().iterator(); i.hasNext();) {
            Object obj = i.next();
            multipartFile=(MultipartFile) map.get(obj);

        }

        /** 获取文件的后缀* */
        String filename = multipartFile.getOriginalFilename();

        InputStream inputStream;
        //System.out.println("             "+request.getRealPath("/"));
        String basePath=request.getRealPath("/")+"upload\\index\\";


        byte[] data = new byte[1024];
        int len = 0;
        FileOutputStream fileOutputStream = null;

        try {
            inputStream = multipartFile.getInputStream();
            fileOutputStream = new FileOutputStream(basePath+filename);
            while ((len = inputStream.read(data)) != -1) {
                fileOutputStream.write(data, 0, len);
            }
            CarImg img = new CarImg();
            img.setImgname(name);
            img.setImgpath(basePath+filename);
            if(carid!=null) {
                img.setCarid(Integer.parseInt(carid));
            }else{
                img.setCarid(0);
            }
            carImgDao.addCarImg(img);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "redirect:imgindex";

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
