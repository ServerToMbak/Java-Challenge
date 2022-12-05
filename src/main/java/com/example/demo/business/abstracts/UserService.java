package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.DataResult;
import com.example.demo.core.utilities.Result;
import com.example.demo.entities.concretes.User;

public interface UserService {
	Result Add(User user);
	Result Update(User user);
	Result Delete(User user);
	DataResult<User> get(int userId);
	DataResult<List<User>> getAll();

}
