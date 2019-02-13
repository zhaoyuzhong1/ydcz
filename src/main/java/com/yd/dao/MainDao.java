package com.yd.dao;



import com.yd.dao.base.BaseDao;
import com.yd.dto.Car;
import com.yd.dto.CarImg;
import com.yd.dto.Main;
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
public class MainDao {
    @Autowired
    private BaseDao baseDao;



    //根据city获取该城市下的门店
    public Main getMain(){
        String sql = "SELECT * FROM t_main ";
        List<Main> cs = baseDao.query(sql,Main.class,new Object[]{});
        if(cs.size()>0){
            return cs.get(0);
        }else{
            return null;
        }
    }


}
