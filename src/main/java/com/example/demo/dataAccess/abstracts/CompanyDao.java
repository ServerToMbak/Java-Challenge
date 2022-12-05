package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.Company;

public interface  CompanyDao extends JpaRepository<Company,Integer>{

}
