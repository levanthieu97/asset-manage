package jp.co.a_too.juchu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.a_too.juchu.data.User;

@Controller
public class LoginController {
	
	@GetMapping( "/login")
	public String loginForm(Model model){
		User user = new User();
		model.addAttribute("user", user);
		return "login_form";
	}
	
	@PostMapping("/index")
	public String loginUser(@ModelAttribute("user") User user){
		return "index";
	}
	
	//@GetMapping("/login?logout")
	//public String logout() {
	//	return "login_form";
	//}
	
	


}
