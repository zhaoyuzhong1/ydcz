package com.yd.dao;



import com.yd.dao.base.BaseDao;
import com.yd.dto.City;
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
public class ShopDao {
    Log log = LogFactory.getLog(ShopDao.class);
    @Autowired
    private BaseDao baseDao;


    public Page<Shop> getList(String search_name, Integer pagesize, Integer count){
        String sql = "SELECT * FROM t_shop where name like ? and flag='0' order cdate asc";
        return baseDao.queryByPage(sql,Shop.class,new Object[]{"%"+search_name+"%"},pagesize,count);
    }


    //添加
    public int addShop(Shop shop) {
        StringBuffer sql =new StringBuffer();
        sql.append(" insert into t_shop (name,linkman,mobile,city,cdate,flag) values(:name,:linkman,:mobile,:city,now(),'0') ");
        return baseDao.insert(sql.toString(),shop);
    }



    //添加
    public int updateShop(Shop shop) {
        StringBuffer sql =new StringBuffer();
        sql.append(" update t_shop set name=:name,linkman=:linkman,city=:city,mobile=:mobile where id=:id ");
        return baseDao.update(sql.toString(),shop);
    }







}
