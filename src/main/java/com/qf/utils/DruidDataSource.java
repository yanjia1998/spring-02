package com.qf.utils;

import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

public class DruidDataSource extends PooledDataSourceFactory {

    public  DruidDataSource(){
        this.dataSource=new com.alibaba.druid.pool.DruidDataSource();
    }
}
