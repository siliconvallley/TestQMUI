package com.isoftstone.huidingc.testqmui.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.isoftstone.huidingc.testqmui.greendao.DaoMaster;
import com.isoftstone.huidingc.testqmui.greendao.DaoSession;

/**
 * @auther huidingc
 * @date 2018/1/25 16:57
 * @description DBManager
 */

public class DBManager {
    private static final String DB_NAME = "test_qmui";
    private Context context;
    private DaoMaster.DevOpenHelper helper;
    private static DBManager dbManager;

    private DBManager(Context context){
        this.context = context;
        helper = new DaoMaster.DevOpenHelper(context,DB_NAME,null);
    }

    /**
     * 创建DBManager
     * @param context
     * @return
     */
    public static DBManager getInstance(Context context) {
        if (null == dbManager) {
            synchronized (DBManager.class) {
                return new DBManager(context);
            }
        }
        return dbManager;
    }

    /**
     * 获取数据库的操作类
     * @return
     */
    public DaoSession getWriteDaoSession(){
        if(null == helper){
            //创建数据库
            helper = new DaoMaster.DevOpenHelper(context,DB_NAME,null);
        }
        //获取可读可写数据库
        SQLiteDatabase database = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(database);
        return daoMaster.newSession();
    }

    /**
     * 获取数据库的操作类
     * @return
     */
    public DaoSession getReadDaoSession(){
        if(null == helper){
            helper = new DaoMaster.DevOpenHelper(context,DB_NAME,null);
        }
        //获取可读数据库
        SQLiteDatabase database = helper.getReadableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(database);
        //获取Dao对象管理者
        return daoMaster.newSession();
    }
}
