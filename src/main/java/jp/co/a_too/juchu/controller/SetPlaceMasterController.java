package jp.co.a_too.juchu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.a_too.juchu.models.SetPlaceMasterModel;
import jp.co.a_too.juchu.service.SetPlaceService;

@Controller
public class SetPlaceMasterController {
	
	@Autowired
	SetPlaceService setPlaceService;

	@GetMapping( "/set_place_master")
	public String setPlaceMaster(Model model){
		List<SetPlaceMasterModel> modelList = setPlaceService.testMethod();
		model.addAttribute("modelList", modelList);
		
		return "set_place_master";
	}
}
