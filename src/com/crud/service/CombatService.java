package com.crud.service;
 
import org.springframework.beans.factory.annotation.Autowired;
 
import com.crud.bean.UserBean;
import com.crud.dao.ICombatDAO;
 
public class CombatService implements ICombatService 
{
 
	@Autowired
	public ICombatDAO combatDAO;
 
	public boolean authenticateUser(UserBean userBean)
	{
		return combatDAO.authenticateUser(userBean);
	}
	
}