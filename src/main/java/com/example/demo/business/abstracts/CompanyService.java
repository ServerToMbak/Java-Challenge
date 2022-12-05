package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.DataResult;
import com.example.demo.core.utilities.Result;
import com.example.demo.entities.concretes.Company;


public interface CompanyService {
	Result Add(Company company);
	Result Update(Company company);
	Result Delete(Company company);
	DataResult<Company> get(int companyId);
	DataResult<List<Company>> getAll();

}
