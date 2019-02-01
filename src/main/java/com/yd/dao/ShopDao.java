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
        if(search_name!=null && !search_name.equals("")) {
            String sql = "SELECT * FROM t_shop where (name like ? or city like ?) and flag='0' order by cdate asc";
            return baseDao.queryByPage(sql, Shop.class, new Object[]{"%" + search_name + "%", "%" + search_name + "%"}, pagesize, count);
        }else{
            String sql = "SELECT * FROM t_shop where flag='0' order by cdate asc";
            return baseDao.queryByPage(sql, Shop.class, new Object[]{}, pagesize, count);
        }
    }


    //添加
    public int addShop(Shop shop) {
        StringBuffer sql =new StringBuffer();
        sql.append(" insert into t_shop (name,address,linkman,mobile,city,cdate,flag) values(:name,:address,:linkman,:mobile,:city,now(),'0') ");
        return baseDao.insert(sql.toString(),shop);
    }



    //添加
    public int updateShop(Shop shop) {
        StringBuffer sql =new StringBuffer();
        sql.append(" update t_shop set name=:name,linkman=:linkman,city=:city,mobile=:mobile,address=:address where id=:id ");
        return baseDao.update(sql.toString(),shop);
    }


    //根据city获取该城市下的门店
    public Shop selectShopByCity(String city){
        String sql = "SELECT * FROM t_shop where city=? and flag='0' ";
        List<Shop> s = baseDao.query(sql,Shop.class,new Object[]{city});
        if(s.size()>0){
            return s.get(0);
        }else{
            return null;
        }
    }





}
