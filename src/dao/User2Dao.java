package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.User2;
import util.ConnectionUtil;

public class User2Dao {
	public boolean addUser(User2 user){
		String sql = "insert into user4(username,password) values(?,?)";
		Object[] params = {
				user.getUsername(),
				user.getPassword(),
				
		};
		return ConnectionUtil.executeUpdate(sql, params);
	}
	public User2 queryUser(User2 user){
		String sql = "select * from user4 where username = ?";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, user.getUsername());
			ResultSet rs = ps.executeQuery();
			User2 u = null;
			if(rs.next()){
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				u = new User2(username, password);
			}
			if(u.getPassword().equals(user.getPassword())){
				return u;
			}else{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
