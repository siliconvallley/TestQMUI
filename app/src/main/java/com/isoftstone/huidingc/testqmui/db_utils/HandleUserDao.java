package com.isoftstone.huidingc.testqmui.db_utils;

import android.content.Context;

import com.isoftstone.huidingc.testqmui.db.DBManager;
import com.isoftstone.huidingc.testqmui.entity.User;
import com.isoftstone.huidingc.testqmui.greendao.UserDao;

import java.util.List;

/**
 * @auther huidingc
 * @date 2018/1/25 17:29
 * @description HandleUserDao
 */

public class HandleUserDao {
    private Context context;

    public HandleUserDao(Context context){
        this.context = context;
    }

    /**
     * 插入数据
     * @param user
     */
    public void insert(User user){
        UserDao userDao = DBManager.getInstance(context).getWriteDaoSession().getUserDao();
        userDao.insert(user);
    }

    /**
     * 查询所有数据
     * @return
     */
    public List<User> queryList(){
        UserDao userDao = DBManager.getInstance(context).getWriteDaoSession().getUserDao();
        return userDao.loadAll();
    }

    /**
     * 根据条件查询
     * @param userName
     * @return
     */
    public List<User> queryList(String userName){
        UserDao userDao = DBManager.getInstance(context).getWriteDaoSession().getUserDao();
        return userDao.queryBuilder().where(UserDao.Properties.UserName.gt(userName))
                .orderAsc(UserDao.Properties.UserName).build().list();
    }

    /**
     * 删除所有数据
     */
    public void deleteAll(){
        UserDao userDao = DBManager.getInstance(context).getWriteDaoSession().getUserDao();
        userDao.deleteAll();
    }

    /**
     * 删除指定数据
     * @param userName
     */
    public void delete(String userName){
        UserDao userDao = DBManager.getInstance(context).getWriteDaoSession().getUserDao();
        User user = userDao.queryBuilder().where(UserDao.Properties.UserName.eq(userName)).build().unique();
        if(null != user){
            userDao.deleteByKey(user.getId());
        }
    }

    /**
     * 更新所有数据
     * @param user
     */
    public void update(User user){
        UserDao userDao = DBManager.getInstance(context).getWriteDaoSession().getUserDao();
        userDao.update(user);
    }
}
