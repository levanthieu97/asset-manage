package jp.co.a_too.juchu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.a_too.juchu.models.StoreMasterModel;
import jp.co.a_too.juchu.service.StoreService;

@Controller
public class StoreMasterController {
	
	@Autowired
	StoreService storeService;
	
	@GetMapping( "/store_master")
	public String storeMaster(Model model){
		List<StoreMasterModel> modelList = storeService.testMethod();
		model.addAttribute("modelList", modelList);
		return "store_master";
	}
}
