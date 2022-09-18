package jp.co.a_too.juchu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.a_too.juchu.models.StoreMasterModel;
import jp.co.a_too.juchu.repo.StoreMasterRepo;

@Component
public class StoreService {

	@Autowired
	StoreMasterRepo storeMasterRepo;
	
	public List<StoreMasterModel> testMethod(){
		List<StoreMasterModel> list = storeMasterRepo.OrderById();
		
		return list;
	}
}
