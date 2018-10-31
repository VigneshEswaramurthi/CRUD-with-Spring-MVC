package com.crud.dao;
import javax.sql.DataSource;

import com.crud.bean.UserBean;
public interface ICombatDAO 
{
	public void setDataSource(DataSource dataSource);
	public boolean authenticateUser(UserBean userBean);
}
