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
@RequestMapping(value = "/car")
public class CarController {
    @Autowired
    CarDao carDao;
    @Autowired
    CarImgDao carImgDao;
    @Autowired
    CompanyDao companyDao;

    @RequestMapping(value = "/index")
    public String index(Model model) {
        List<Company> cs = companyDao.selectAllCompany();
        model.addAttribute("cs",cs);
        return "car/index";
        //return "sys/top";
    }



    @RequestMapping(value = "/imgindex")
    public String imgindex(int carid,Model model) {
        List<CarImg> cis = carDao.selectImgByCarid(carid);
        Car car = carDao.getCarByid(carid);
        String title = "";
        if(car!=null){
            title = car.getTitle();
        }
        model.addAttribute("cis",cis);
        model.addAttribute("carid",carid);
        model.addAttribute("title",title);
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

        for (Iterator i = map.keySet().iterator(); i.hasNext();) {
            Object obj = i.next();
            multipartFile=(MultipartFile) map.get(obj);

        }

        /** 获取文件的后缀* */
        String filename = new Date().getTime()+"_"+multipartFile.getOriginalFilename();
        System.out.println();
        InputStream inputStream;
        //System.out.println("             "+request.getRealPath("/"));
        String basePath=request.getRealPath("/")+"upload\\car\\";


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


        return "redirect:imgindex?carid="+carid;

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
    @RequestMapping(value = "/queryImgList")
    public Map<String, Object> queryImgList(String carid, Integer pagesize, Integer count) {
        Map<String, Object> map = new HashMap<>();
        Page<CarImg> pageList = carImgDao.getList(carid,pagesize, count);
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


    @ResponseBody
    @RequestMapping(value = "/delCarImg")
    public String delCarImg(int id){
        CarImg ci = carImgDao.getCarImg(id);
        String filepath = "";
        if(ci!=null){
            filepath = ci.getImgpath();
        }
        int flag = carImgDao.delCarImg(id);
        if(flag==-1){
            return "nook";
        }else {
            //删除数据库记录并删除图片
            if(!filepath.equals("")){
                File f = new File(filepath);
                f.delete();
            }
            return "ok";
        }
    }


}
