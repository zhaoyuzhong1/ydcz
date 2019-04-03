package com.yd.dao;



import com.yd.dao.base.BaseDao;
import com.yd.dto.Advert;
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
public class AdvertDao {
    Log log = LogFactory.getLog(AdvertDao.class);
    @Autowired
    private BaseDao baseDao;


    public Page<Advert> getList(Integer pagesize, Integer count){
        String sql = "SELECT * FROM t_advert ";
        return baseDao.queryByPage(sql, Advert.class, new Object[]{}, pagesize, count);

    }




    //添加
    public int updateAdvert(Advert advert) {
        StringBuffer sql =new StringBuffer();
        sql.append(" update t_advert set content=:content where id=:id ");
        return baseDao.update(sql.toString(),advert);
    }





    public Advert getAdvert(){

        String sql = "SELECT * from t_advert ";
        List<Advert> as = baseDao.query(sql, Advert.class, new Object[]{});
        if(as.size()>0){
            return as.get(0);
        }else{
            return null;
        }

    }


}
