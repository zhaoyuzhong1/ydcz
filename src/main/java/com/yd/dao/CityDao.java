package com.yd.dao;



import com.yd.dao.base.BaseDao;
import com.yd.dto.City;
import com.yd.dto.Function;
import com.yd.dto.SysUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by What！ on 2017/7/21.
 */
@Component
public class CityDao {
    Log log = LogFactory.getLog(CityDao.class);
    @Autowired
    private BaseDao baseDao;

    public List<City> getList() {
        StringBuffer sql =new StringBuffer();
        sql.append("select * from t_city");
        List<City> emps = baseDao.query(sql.toString(),City.class,new Object[]{});
        return emps.isEmpty()?null:emps;
    }



}
