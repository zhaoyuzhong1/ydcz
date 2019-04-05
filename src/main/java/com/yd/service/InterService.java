package com.yd.service;

import com.yd.dao.CarDao;
import com.yd.dao.CarImgDao;
import com.yd.dto.CarImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by james on 2018/12/20.
 * Update by wcw on 2018/12/29.
 */
@Service
public class InterService {
    @Autowired
    CarImgDao carImgDao;

    @Autowired
    CarDao carDao;


    //启用imgFile的某个图片放在首页
    @Transactional
    public void qyImg(int id){
        carImgDao.updateZx();
        carImgDao.updateQy(id);
    }

    //启用某个图片做封面,要更新t_car表的imgpath
    @Transactional
    public void qyCarImg(int id,int carid,String imgname){
        carImgDao.updateZx();
        carImgDao.updateQy(id);
        carDao.updateImgname(carid,imgname);//更新goods表的imgfile的内容
    }

    //如果之前的图片有设置默认图片，调用改方法
    @Transactional
    public void addCarImg(CarImg gf){
        carImgDao.updateZx();//之前所有的图片都要把fmflag设置为1
        carImgDao.addCarImg(gf);
        carDao.updateImgname(gf.getCarid(),gf.getImgname());//更新t_car表的imgpath的内容
    }


}
