package com.crud.dao;

import java.util.List;

import com.crud.bean.UserBean;

public interface IRetrieveDAO 
{
	public List<UserBean> findAllUsers(UserBean userBean);
	
	public String delete(String username);
	
	public UserBean getelement(String username);
	
	public String updates(UserBean userBean);
}
