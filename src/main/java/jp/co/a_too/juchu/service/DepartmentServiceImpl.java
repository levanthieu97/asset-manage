package jp.co.a_too.juchu.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.a_too.juchu.models.DepartmentMasterModel;
import jp.co.a_too.juchu.repo.DepartmentMasterRepo;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired 
	DepartmentMasterRepo departmentMasterRepo;
	
	public List<DepartmentMasterModel> getAllDepartments(){
		List<DepartmentMasterModel> departments = departmentMasterRepo.findAll();
		return departments;		
	}
	
	@Override
	public Integer getNextId() {
		Integer maxId = departmentMasterRepo.getMaxId();
		Integer nextValue = maxId + 1;
		return nextValue;
	}

	@Override
	public void saveDepartment(DepartmentMasterModel department) {  //insert and update method
		departmentMasterRepo.save(department);
	}

	@Override
	public DepartmentMasterModel getDepartmentById(Integer id) {	
		return departmentMasterRepo.findById(id).get();
	}

	@Override
	public DepartmentMasterModel updateDepartment(DepartmentMasterModel department) {	
		return departmentMasterRepo.save(department);
	}

	@Override
	public void deleteDepartmentById(Integer id) {
		departmentMasterRepo.deleteById(id);
		
	}
	

	




	

	
	
	
	


	
	

}
