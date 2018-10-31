package com.crud.dao;

import javax.sql.DataSource;

import com.crud.bean.UserBean;
public interface IRegisterDAO
{
	public void setDataSource(DataSource dataSource);
	public String insert(UserBean userBean);
}
