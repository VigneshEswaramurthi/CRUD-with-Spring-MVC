package com.crud.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.crud.bean.UserBean;
import com.crud.dao.IRegisterDAO;

public class RegisterService implements IRegisterService
{
	@Autowired
	public IRegisterDAO registerDAO;
	
	public String insert(UserBean userBean)
	{
		return registerDAO.insert(userBean);
		
	}
}
