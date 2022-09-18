package jp.co.a_too.juchu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jp.co.a_too.juchu.models.Category1MasterModel;
import jp.co.a_too.juchu.repo.Category1MasterRepo;

@Scope
@Component
public class Category1Service {
	@Autowired
	Category1MasterRepo category1MasterRepo;
	
	public List<Category1MasterModel> testMethod() {
		List<Category1MasterModel> list = category1MasterRepo.OrderById();
		
		return list;
	}
}
