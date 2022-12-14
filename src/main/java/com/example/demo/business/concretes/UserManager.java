package com.example.demo.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.UserService;
import com.example.demo.core.utilities.DataResult;
import com.example.demo.core.utilities.ErrorResult;
import com.example.demo.core.utilities.Result;
import com.example.demo.core.utilities.SuccessDataResult;
import com.example.demo.core.utilities.SuccessResult;
import com.example.demo.dataAccess.abstracts.UserDao;
import com.example.demo.entities.concretes.User;
@Service
public class UserManager implements UserService{
	
	
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao=userDao;
	}

	@Override
	public Result Add(User user) {
	userDao.save(user);
	return new SuccessResult("User Added");
	}

	@Override
	public Result Delete(User user) {
	userDao.delete(user);
	return new SuccessResult("User Deleted");
	}
	@Override
	public Result Update(User user) {
		Optional<User> findUser= userDao.findById(user.getId());
		
		if(findUser.isPresent()) {
			User FoundCompany=findUser.get();
			FoundCompany.setName(user.getName());
			FoundCompany.setCompanyId(user.getCompanyId());
			FoundCompany.setPassword(user.getPassword());
			userDao.save(user);
			return new SuccessResult("");
		}
		return new ErrorResult("");
		
	}	
	
	@Override
	public DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>(userDao.findAll(),"All user");
	}
	@Override
	public DataResult<User> get(int userId) {
	
	return new SuccessDataResult<User>(userDao.findById(userId).orElse(null));
	}	
}
