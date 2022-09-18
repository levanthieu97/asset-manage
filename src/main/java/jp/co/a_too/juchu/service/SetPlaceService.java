package jp.co.a_too.juchu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.a_too.juchu.models.SetPlaceMasterModel;
import jp.co.a_too.juchu.repo.SetPlaceMasterRepo;

@Component
public class SetPlaceService {
	@Autowired
	SetPlaceMasterRepo setPlaceMasterRepo;
	
	public List<SetPlaceMasterModel> testMethod(){
		List<SetPlaceMasterModel> list = setPlaceMasterRepo.OrderById();
		
		return list;
	}
	
}
