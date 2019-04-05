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
    @Autowired
    private BaseDao baseDao;


    public Page<CarImg> getList(String carid, Integer pagesize, Integer count){

        String sql = "SELECT * FROM t_car_img where carid= ? order by cdate asc";
        return baseDao.queryByPage(sql, CarImg.class, new Object[]{carid}, pagesize, count);

    }


    //添加
    public int addCarImg(CarImg carImg) {
        StringBuffer sql =new StringBuffer();
        sql.append(" insert into t_car_img (carid,imgname,cdate,flag) values(:carid,:imgname,now(),:flag) ");
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


    public List<CarImg> getImgList(String carid){

        String sql = "SELECT * FROM t_car_img where carid= ? order by cdate asc";
        return baseDao.query(sql, CarImg.class, new Object[]{carid});

    }


    public int updateZx() {
        String sql="update t_car_img set flag='1' where flag='0'";
        return baseDao.update2(sql,new Object[]{});
    }


    public int updateZx2(int id) {
        String sql="update t_car_img set flag='1' where id=?";
        return baseDao.update2(sql,new Object[]{id});
    }


    public int updateQy(int id) {
        String sql="update t_car_img set flag='0' where id=?";
        return baseDao.update2(sql,new Object[]{id});
    }


}
