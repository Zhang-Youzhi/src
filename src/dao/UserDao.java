package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.User;
import util.ConnectionUtil;

public class UserDao {
	public boolean addUser(User user){
		String sql = "insert into user5(id,name,sex,job,info,hobby) values(?,?,?,?,?,?)";
		Object[] params = {
				user.getId(),
				user.getName(),
				user.getSex(),
				user.getJob(),
				user.getInfo(),
				user.getHobbys()
				
		};
		return ConnectionUtil.executeUpdate(sql, params);
	}

	public List<User> queryAllUser(){
		String sql = "select * from user5";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			User u = null;
			List<User> users = new ArrayList<User>();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String info = rs.getString("info");
				String hobbys = rs.getString("hobby");
				String job = rs.getString("job");
				u = new User(id, name, sex, hobbys, info, job);
				users.add(u);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean deleteUser(Integer id){
		String sql = "delete from user5 where id = ?";
		Object[] params = {
				id
		};
		return ConnectionUtil.executeUpdate(sql, params);
	}
	public User queryUser(Integer id){
		String sql = "select * from user5 where id = ?";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			User u = null;
			if(rs.next()){
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String info = rs.getString("info");
				String hobbys = rs.getString("hobby");
				String job = rs.getString("job");
				u = new User(id, name, sex, hobbys, info, job);
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean updateUser(User user){
		String sql = "update user5 set name = ?,sex = ?,job = ?,hobby = ?,info = ? where id = ?";
		Object[] params = {
				user.getName(),
				user.getSex(),
				user.getJob(),
				user.getHobbys(),
				user.getInfo(),
				user.getId()
				
		};
		return ConnectionUtil.executeUpdate(sql, params);
	}
	
}
