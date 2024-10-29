package service;

import java.util.List;

import dao.User2Dao;
import domain.User2;

public class User2Service {
	
	private User2Dao userDao = new User2Dao();
	
	public boolean addUser(User2 user){
		try{
			userDao.addUser(user);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	public User2 queryUser(User2 user){
		try{
			User2 u = userDao.queryUser(user);
			return u;
		}catch (Exception e) {
			return null;
		}
	}
}