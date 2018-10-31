package com.crud.dao;
import javax.sql.DataSource;
/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.crud.bean.UserBean;
import com.crud.dao.*;
 
public class CombatDAO implements ICombatDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
 
	@SuppressWarnings("deprecation")
	public boolean authenticateUser(UserBean userBean){
		boolean userExists = false;
		int rowcount = jdbcTemplate.queryForInt("select count(*) from customer " +
				" where username = ? and password = ?",
				userBean.getUsername(),userBean.getPasswords());
		if(rowcount==1)
		{
			userExists = true;
		}
		return userExists;
	}
}