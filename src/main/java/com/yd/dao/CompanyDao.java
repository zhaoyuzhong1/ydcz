package com.yd.dao;



import com.yd.dao.base.BaseDao;
import com.yd.dto.Car;
import com.yd.dto.CarImg;
import com.yd.dto.Company;
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
public class CompanyDao {
    @Autowired
    private BaseDao baseDao;




    //添加
    public int addCompany(Company c) {
        StringBuffer sql =new StringBuffer();
        sql.append(" insert into t_company (name,isyx,cdate) values(:name,:isyx,now()) ");
        return baseDao.insert(sql.toString(),c);
    }



    //添加
    public int updateCompany(Company c) {
        StringBuffer sql =new StringBuffer();
        sql.append(" update t_company set name=:name,isyx=:isyx where id=:id ");
        return baseDao.update(sql.toString(),c);
    }


    //查询所有优选的品牌
    public List<Company> selectYxCompany(){
        String sql = "SELECT * FROM t_company where isyx='0' order by cdate asc ";
        return baseDao.query(sql,Company.class,new Object[]{});

    }



    //查询所有的品牌
    public List<Company> selectAllCompany(){
        String sql = "SELECT * FROM t_company order by cdate asc ";
        return baseDao.query(sql,Company.class,new Object[]{});

    }





}
