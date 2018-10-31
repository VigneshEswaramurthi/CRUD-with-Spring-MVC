package com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crud.bean.UserBean;
@Repository
@Primary
public class RetrieveDAO implements IRetrieveDAO
{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource) 
	{
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<UserBean> findAllUsers(UserBean userBean) 
	{
		return this.jdbcTemplate.query("select username, phone, email from customer", new RowMapper<UserBean>()
		{

			@Override
			public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserBean ub = new UserBean();
				ub.setUsername(rs.getString(1));
				ub.setphone(rs.getInt(2));
				ub.setemail(rs.getString(3));
				return ub;
			}
		});
	}

	@Override
	public String delete(String username) 
	{
		String sql="delete from customer where username=?";
		jdbcTemplate.update(sql, username);
		return null;
	}

	@Override
	public UserBean getelement(String username) 
	{
		String sql="select username, phone, email from customer where username=?";  
		return jdbcTemplate.queryForObject(sql, new Object[]{username}, new BeanPropertyRowMapper<UserBean>(UserBean.class));
	}
	
	@Override
	public String updates(UserBean userBean) 
	{
		
		String sql="UPDATE customer SET phone=?, email=? WHERE username=?";
		jdbcTemplate.update(sql, new Object[] { userBean.getphone(), userBean.getemail(), userBean.getUsername() });
		return null;
		
		
	}
	
}
