package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.CompanyService;
import com.example.demo.core.utilities.DataResult;
import com.example.demo.core.utilities.Result;
import com.example.demo.core.utilities.SuccessDataResult;
import com.example.demo.core.utilities.SuccessResult;
import com.example.demo.dataAccess.abstracts.CompanyDao;
import com.example.demo.entities.concretes.Company;
@Service
public class CompanyManager implements CompanyService{
	private CompanyDao companyDao;
	@Autowired
	public CompanyManager(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}
	@Override
	public Result Add(Company company) {
		companyDao.save(company);
	return new SuccessResult("Company Added");
	}

	@Override
	public Result Delete(Company company) {
		companyDao.delete(company);
	return new SuccessResult("Company Deleted");
	}
	@Override
	public Result Update(Company company) {
		companyDao.save(company);
		return new SuccessResult("Company Updated");
	}
	@Override
	public DataResult<List<Company>> getAll() {
		
		return new SuccessDataResult<List<Company>>(companyDao.findAll());
	}
	@Override
	public DataResult<Company> get(int companyId) {
	
	return new SuccessDataResult<Company>(companyDao.findById(companyId).orElse(null));
	}	
	
}
