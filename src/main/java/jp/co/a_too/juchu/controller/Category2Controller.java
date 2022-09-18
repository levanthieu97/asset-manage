package jp.co.a_too.juchu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.a_too.juchu.models.Category1MasterModel;
import jp.co.a_too.juchu.models.Category2MasterModel;
import jp.co.a_too.juchu.models.DepartmentMasterModel;
import jp.co.a_too.juchu.service.Category1Service;
import jp.co.a_too.juchu.service.Category2Service;

@Controller
public class Category2Controller {
	
	@Autowired
	Category2Service category2Service;
	@Autowired
	Category1Service category1Service;


	@GetMapping("/category2_master")
	public String category2Master(Model model) {
		List<Category2MasterModel> modelList = category2Service.testMethod();
		List<Category1MasterModel> model1List = category1Service.testMethod();
		
		model.addAttribute("modelList", modelList);
		model.addAttribute("model1List", model1List);
	
		return "category2_master";
	} 
	
	
	
}
