package service;

import java.util.List;

import dao.UserDao;
import domain.User;

public class UserService {
	
	private UserDao userDao = new UserDao();
	
	public boolean addUser(User user){
		try{
			userDao.addUser(user);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	public List<User> queryAllUser(){
		try{
			List<User> users = userDao.queryAllUser();
			return users;
		}catch (Exception e) {
			return null;
		}
	}
	public boolean deleteUser(Integer id){
		try{
			userDao.deleteUser(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	public User queryUser(Integer id){
		try{
			User u = userDao.queryUser(id);
			return u;
		}catch (Exception e) {
			return null;
		}
	}
	public boolean updateUser(User user){
		try{
			return userDao.updateUser(user);
		}catch (Exception e) {
			return false;
		}
	}
}