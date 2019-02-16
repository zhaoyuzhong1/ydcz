package com.yd.dao;



import com.yd.dao.base.BaseDao;
import com.yd.dto.Banner;
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
public class BannerDao {
    Log log = LogFactory.getLog(BannerDao.class);
    @Autowired
    private BaseDao baseDao;


    public Page<Banner> getList(String search_name, Integer pagesize, Integer count){
        if(search_name!=null && !search_name.equals("")) {
            String sql = "SELECT * FROM t_banner where name like ? order by cdate asc";
            return baseDao.queryByPage(sql, Banner.class, new Object[]{"%" + search_name + "%"}, pagesize, count);
        }else{
            String sql = "SELECT * FROM t_banner order by cdate asc";
            return baseDao.queryByPage(sql, Banner.class, new Object[]{}, pagesize, count);
        }
    }


    //添加
    public int addBanner(Banner banner) {
        StringBuffer sql =new StringBuffer();
        sql.append(" insert into t_banner (name,imgpath,type,cdate) values(:name,:imgpath,:type,now()) ");
        return baseDao.insert(sql.toString(),banner);
    }



    //注销和启用
    public int updateBanner(int id,String flag) {
        String sql = "update t_banner set flag=? where id=?";
        return baseDao.update2(sql,new Object[]{flag,id});
    }


    public Banner getBannerByid(int id){
        String sql = "select * from t_banner where id=?";
        List<Banner> bs = baseDao.query(sql,Banner.class,new Object[]{id});
        if(bs.size()>0){
            return bs.get(0);
        }else{
            return null;
        }
    }



    public Banner getBannerByType(String type){
        String sql = "select * from t_banner where type=? and flag='0'";
        List<Banner> bs = baseDao.query(sql,Banner.class,new Object[]{type});
        if(bs.size()>0){
            return bs.get(0);
        }else{
            return null;
        }
    }



    public int zxBanner(String type) {
        String sql = "update t_banner set flag='1' where type=?";
        return baseDao.update2(sql,new Object[]{type});
    }




}
