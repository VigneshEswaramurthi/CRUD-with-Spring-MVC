package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.crud.bean.UserBean;
import com.crud.dao.IRetrieveDAO;

@Repository
@Primary
public class RetrieveService implements IRetrieveService
{
	@Autowired
	IRetrieveDAO retrievedao;

	@Override
	public List<UserBean> findAllUsers(UserBean userBean) 
	{
		
				return retrievedao.findAllUsers(userBean);
	}

	@Override
	public String delete(String username)
	{
		
		return retrievedao.delete(username);
	}

	@Override
	public UserBean getelement(String username)
	{
		
		return retrievedao.getelement(username);
	}

	@Override
	public String updates(UserBean userBean) 
	{
		
		return retrievedao.updates(userBean);
	}


}
