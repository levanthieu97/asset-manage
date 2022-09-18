package jp.co.a_too.juchu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jp.co.a_too.juchu.models.DepartmentMasterModel;
import jp.co.a_too.juchu.service.DepartmentService;


@Controller
public class DepartmentMasterController {

	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/department_master")
	public ModelAndView departmentMaster(Model model){
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@GetMapping("/department/info")
    @ResponseBody
	public List<DepartmentMasterModel> getDepartMent() {
		return departmentService.getAllDepartments();
	}
}
