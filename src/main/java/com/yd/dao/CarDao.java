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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by What！ on 2017/7/21.
 */
@Component
public class CarDao {
    Log log = LogFactory.getLog(CarDao.class);
    @Autowired
    private BaseDao baseDao;


    public Page<Car> getList(String search_name,String type, Integer pagesize, Integer count){
        List<String> arr = new ArrayList();
        String sql = "SELECT a.*,b.name as companyname FROM t_car a left join t_company b on a.companyid=b.id where (a.title like ? or a.color like ?) and a.flag='0' ";
        if(search_name==null ) {
           search_name = "";
        }
        arr.add("%"+search_name+"%");
        arr.add("%"+search_name+"%");

        if(type!=null && !type.equals("")){
            sql = sql + " and a.type=? ";
            arr.add(type);
        }
        sql = sql + " order by a.cdate asc";
        return baseDao.queryByPage(sql,Car.class,arr.toArray(),pagesize,count);
    }


    //添加
    public int addCar(Car car) {
        StringBuffer sql =new StringBuffer();
        sql.append(" insert into t_car (title,companyid,color,guiprice,price,downpay,monpay,issy,cdate,flag) values(:title,:companyid,:color,:guiprice,:price,:downpay,:monpay,:issy,now(),'0') ");
        return baseDao.insert(sql.toString(),car);
    }


    //添加
    public int addCar2(Car car) {
        StringBuffer sql =new StringBuffer();
        sql.append(" insert into t_car (title,companyid,color,guiprice,price,downpay,monpay,issy,cdate,flag,type,tcase,depict,km) values(:title,:companyid,:color,:guiprice,:price,:downpay,:monpay,:issy,now(),'0',:type,:tcase,:depict,:km) ");
        return baseDao.insert(sql.toString(),car);
    }



    //添加
    public int updateCar(Car car) {
        StringBuffer sql =new StringBuffer();
        sql.append(" update t_car set title=:title,companyid=:companyid,color=:color,guiprice=:guiprice,price=:price,downpay=:downpay,monpay=:monpay,issy=:issy where id=:id ");
        return baseDao.update(sql.toString(),car);
    }


    //修改汽车
    public int updateCar2(Car car) {
        StringBuffer sql =new StringBuffer();
        sql.append(" update t_car set title=:title,companyid=:companyid,color=:color,guiprice=:guiprice,price=:price,downpay=:downpay,monpay=:monpay,issy=:issy,type=:type,tcase=:tcase,depict=:depict,km=:km where id=:id ");
        return baseDao.update(sql.toString(),car);
    }



    public List<CarImg> selectImgByCarid(int carid){
        String sql = "SELECT * FROM t_car_img where carid=? ";
        return baseDao.query(sql,CarImg.class,new Object[]{carid});

    }



    public Car getCarByid(int carid){
        String sql = "SELECT * FROM t_car where id=? ";
        List<Car> cs = baseDao.query(sql,Car.class,new Object[]{carid});
        if(cs.size()>0){
            return cs.get(0);
        }else{
            return null;
        }
    }


    //获取首页展示的car列表
    public List<Car> getSyCar(int limit){
        String sql = "SELECT a.* FROM t_car a WHERE a.flag='0' AND a.issy='0' GROUP BY a.id ORDER BY a.id ASC LIMIT "+limit;
        return baseDao.query(sql,Car.class,new Object[]{});
    }


    //获取首页展示的car列表
    public List<Car> getSyCar2(String type,int limit){
        String sql = "SELECT a.* FROM t_car a WHERE a.flag='0' and a.type=? AND a.issy='0' GROUP BY a.id ORDER BY a.id ASC LIMIT "+limit;
        return baseDao.query(sql,Car.class,new Object[]{type});
    }


    //获取所有car列表
    public List<Car> getAllCar(String companyid,int limit){
        if(companyid!=null && !companyid.equals("")) {
            String sql = "SELECT a.* FROM t_car a WHERE a.flag='0' and a.companyid=? GROUP BY a.id ORDER BY a.issy,a.id ASC LIMIT " + limit;
            return baseDao.query(sql, Car.class, new Object[]{companyid});
        }else{
            String sql = "SELECT a.* FROM t_car a WHERE a.flag='0' GROUP BY a.id ORDER BY a.issy,a.id ASC LIMIT " + limit;
            return baseDao.query(sql, Car.class, new Object[]{});
        }
    }


    //获取所有car列表
    public List<Car> getAllCarsByType(String type,int limit){
        String sql = "SELECT a.* FROM t_car a WHERE a.flag='0' and a.type=? GROUP BY a.id ORDER BY a.issy,a.id ASC LIMIT " + limit;
        return baseDao.query(sql, Car.class, new Object[]{type});

    }


    public Integer updateImgname(int id,String imgname){
        String sql ="update t_car set imgpath=? where id=? ";
        return baseDao.update2(sql,new Object[]{imgname,id});
    }





}
