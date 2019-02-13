package com.yd.web;

import com.yd.dao.BannerDao;
import com.yd.dao.CarDao;
import com.yd.dao.CarImgDao;
import com.yd.dto.Banner;
import com.yd.dto.Car;
import com.yd.dto.CarImg;
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
import java.util.*;

/**
 * Created by james on 2019/2/1.
 */
@Controller
@RequestMapping(value = "/banner")
public class BannerController {
    @Autowired
    BannerDao bannerDao;


    @RequestMapping(value = "/index")
    public String index() {
        return "banner/index";
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
        String type = multipartRequest.getParameter("type");
        for (Iterator i = map.keySet().iterator(); i.hasNext();) {
            Object obj = i.next();
            multipartFile=(MultipartFile) map.get(obj);

        }

        /** 获取文件的后缀* */
        String filename = new Date().getTime()+"_"+ multipartFile.getOriginalFilename();

        InputStream inputStream;
        //System.out.println("             "+request.getRealPath("/"));
        String basePath=request.getRealPath("/")+"upload\\banner\\";


        byte[] data = new byte[1024];
        int len = 0;
        FileOutputStream fileOutputStream = null;

        try {
            inputStream = multipartFile.getInputStream();
            fileOutputStream = new FileOutputStream(basePath+filename);
            while ((len = inputStream.read(data)) != -1) {
                fileOutputStream.write(data, 0, len);
            }
            Banner img = new Banner();
            img.setName(name);
            img.setImgpath(basePath+filename);
            img.setType(type);

            bannerDao.addBanner(img);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "redirect:index";

    }




    @ResponseBody
    @RequestMapping(value = "/queryList")
    public Map<String, Object> queryList(String search_name, Integer pagesize, Integer count) {
        Map<String, Object> map = new HashMap<>();
        Page<Banner> pageList = bannerDao.getList(search_name,pagesize, count);
        map.put("rows", pageList.getResult());
        map.put("total", pageList.getTotalCount());
        return map;
    }




    @ResponseBody
    @RequestMapping(value = "/qy")
    public String qy(int id ) {
        Banner b = bannerDao.getBannerByid(id);
        //先注销这个位置的所有图片
        bannerDao.zxBanner(b.getType());
        //然后在启用
        int flag = bannerDao.updateBanner(id,"0");
        if(flag==0){
            return "ok";
        }else {
            return "nook";
        }
        //return "sys/top";
    }



    @ResponseBody
    @RequestMapping(value = "/zx")
    public String zx(int id ) {
        int flag = bannerDao.updateBanner(id,"1");
        if(flag==0){
            return "ok";
        }else {
            return "nook";
        }
        //return "sys/top";
    }


}
