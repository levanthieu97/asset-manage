package jp.co.a_too.juchu.service;

import java.util.List;
import java.util.Optional;

import jp.co.a_too.juchu.models.DepartmentMasterModel;

public interface DepartmentService {
	
	List<DepartmentMasterModel> getAllDepartments();
	Integer getNextId();
	
	void saveDepartment(DepartmentMasterModel department);
	
	
	DepartmentMasterModel getDepartmentById(Integer id);
	DepartmentMasterModel updateDepartment(DepartmentMasterModel department);
	
	void deleteDepartmentById(Integer id);
	
}
