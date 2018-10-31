package com.crud.dao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import javax.sql.DataSource;
/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
*/
import org.springframework.beans.factory.annotation.Autowired;

import com.crud.bean.UserBean;

//import com.jcombat.dao.*;

public class RegisterDAO implements IRegisterDAO 
{
	
	private DataSource dataSource;
		
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	
	public String insert(UserBean userBean)
	{
		String sql = "insert into customer " +
				"(username, phone, email, address, password) VALUES (?, ?, ?, ?, ?)";
	Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userBean.getUsername());
			ps.setInt(2, userBean.getphone());
			ps.setString(3, userBean.getemail());
			ps.setString(4, userBean.getaddress());
			ps.setString(5, userBean.getPasswords());
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
	}
		return sql;
	}
	
}
