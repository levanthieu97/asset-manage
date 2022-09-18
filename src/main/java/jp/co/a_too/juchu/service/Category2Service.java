package jp.co.a_too.juchu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jp.co.a_too.juchu.models.Category2MasterModel;
import jp.co.a_too.juchu.repo.Category2MasterRepo;

@Scope
@Component
public class Category2Service {
	@Autowired 
	Category2MasterRepo category2MasterRepo;
	
	public List<Category2MasterModel> testMethod(){
		List<Category2MasterModel> list = category2MasterRepo.OrderById();
		
		return list;		
	}
}
