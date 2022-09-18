package jp.co.a_too.juchu.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.a_too.juchu.data.User;

@Scope("request")
@Controller
public class AssetManageController {
	
	@GetMapping("/asset_manage_search")
	public String assetManageSearch(){
		
		return "asset_manage_search";
	}
	
	@PostMapping("/asset_manage_entry")
	public String assetManageEntry() {
		
		return "asset_manage_entry";
	}
	
	@PostMapping("/asset_manage_search")
	public String assetManageSearch(@ModelAttribute("user") User user) {
		
		return "/asset_manage_search";
	}
}
