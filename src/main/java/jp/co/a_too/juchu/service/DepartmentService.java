package jp.co.a_too.juchu.service;

import java.util.List;
import java.util.Optional;

import jp.co.a_too.juchu.models.DepartmentMasterModel;

public interface DepartmentService {
	
	List<DepartmentMasterModel> getAllDepartments();
	
	DepartmentMasterModel createNewDepartment(DepartmentMasterModel department);
	Integer getNextId();
	
	void saveDepartment(DepartmentMasterModel department);
	
	
	DepartmentMasterModel getDepartmentById(Integer id);
	Optional<DepartmentMasterModel> updateDepartment(int departmentId, DepartmentMasterModel department);
	
	void deleteDepartmentById(int departmentId);
	
}
