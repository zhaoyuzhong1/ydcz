package com.yd.dao;



import com.yd.dao.base.BaseDao;
import com.yd.dto.Car;
import com.yd.dto.CarImg;
import com.yd.util.Page;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by What！ on 2017/7/21.
 */
@Component
public class CarImgDao {
    Log log = LogFactory.getLog(CarImgDao.class);
    @Autowired
    private BaseDao baseDao;


    public Page<CarImg> getList(String search_name, Integer pagesize, Integer count){
        if(search_name!=null && !search_name.equals("")) {
            String sql = "SELECT * FROM t_car_img where imgname like ? order by cdate asc";
            return baseDao.queryByPage(sql, CarImg.class, new Object[]{"%" + search_name + "%"}, pagesize, count);
        }else{
            String sql = "SELECT * FROM t_car_img order by cdate asc";
            return baseDao.queryByPage(sql, CarImg.class, new Object[]{}, pagesize, count);
        }
    }


    //添加
    public int addCarImg(CarImg carImg) {
        StringBuffer sql =new StringBuffer();
        sql.append(" insert into t_car_img (carid,imgname,imgpath,cdate) values(:carid,:imgname,:imgpath,now()) ");
        return baseDao.insert(sql.toString(),carImg);
    }



    //添加
    public int delCarImg(int id) {
        return baseDao.deleteById("t_car_img",id);
    }


    public CarImg getCarImg(int id){
        String sql = "select * from t_car_img where id=?";
        return baseDao.queryById(sql,CarImg.class,id);
    }


}
