package com.briup.estore.util;

import java.io.InputStream;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.alibaba.druid.pool.DruidDataSource;

public class SqlSessionUtil extends UnpooledDataSourceFactory {
	private static SqlSessionFactory sqlSessionFactory;
	private static DataSource DATA_SOURCE= new DruidDataSource();
	
	static {
		try {
			InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	{
		this.dataSource = DATA_SOURCE;
	}
	
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
	public static SqlSession getSqlSession(boolean flag) {
		return sqlSessionFactory.openSession(flag);
	}
	
}
