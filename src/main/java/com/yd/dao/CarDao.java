package com.yd.dao;



import com.yd.dao.base.BaseDao;
import com.yd.dto.Car;
import com.yd.dto.CarImg;
import com.yd.dto.Shop;
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
public class CarDao {
    Log log = LogFactory.getLog(CarDao.class);
    @Autowired
    private BaseDao baseDao;


    public Page<Car> getList(String search_name, Integer pagesize, Integer count){
        if(search_name!=null && !search_name.equals("")) {
            String sql = "SELECT * FROM t_car where (title like ? or color like ?) and flag='0' order by cdate asc";
            return baseDao.queryByPage(sql, Car.class, new Object[]{"%" + search_name + "%", "%" + search_name + "%"}, pagesize, count);
        }else{
            String sql = "SELECT * FROM t_car where flag='0' order by cdate asc";
            return baseDao.queryByPage(sql, Car.class, new Object[]{}, pagesize, count);
        }
    }


    //添加
    public int addCar(Car car) {
        StringBuffer sql =new StringBuffer();
        sql.append(" insert into t_car (title,color,guiprice,price,downpay,monpay,issy,cdate,flag) values(:title,:color,:guiprice,:price,:downpay,:monpay,:issy,now(),'0') ");
        return baseDao.insert(sql.toString(),car);
    }



    //添加
    public int updateCar(Car car) {
        StringBuffer sql =new StringBuffer();
        sql.append(" update t_car set title=:title,color=:color,guiprice=:guiprice,price=:price,downpay=:downpay,monpay=:monpay,issy=:issy where id=:id ");
        return baseDao.update(sql.toString(),car);
    }


    //根据city获取该城市下的门店
    public List<CarImg> selectImgByCarid(int carid){
        String sql = "SELECT * FROM t_car_img where carid=? ";
        return baseDao.query(sql,CarImg.class,new Object[]{carid});

    }





}
