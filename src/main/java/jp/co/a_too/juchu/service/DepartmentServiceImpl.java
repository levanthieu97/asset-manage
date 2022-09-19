package jp.co.a_too.juchu.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import jp.co.a_too.juchu.models.DepartmentMasterModel;
import jp.co.a_too.juchu.repo.DepartmentMasterRepo;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	
    private static final Logger LOGGER = LogManager.getLogger(DepartmentServiceImpl.class);

	
	@Autowired 
	DepartmentMasterRepo departmentMasterRepo;
	
	@Override
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
	public Optional<DepartmentMasterModel> updateDepartment(int departmentId, DepartmentMasterModel department) {	
		Optional<DepartmentMasterModel> findDepartment = departmentMasterRepo.findById(departmentId);
		if(findDepartment.isPresent()) {
			findDepartment.get().setDepartmentName(department.getDepartmentName());
			Optional<DepartmentMasterModel> newDepartment = Optional.of(departmentMasterRepo.save(findDepartment.get()));
			return newDepartment;
		}
		return Optional.empty();
	}

	@Override
	public void deleteDepartmentById(int departmentId) {
		Optional<DepartmentMasterModel> findDepartment = departmentMasterRepo.findById(departmentId);
		try {
			departmentMasterRepo.delete(findDepartment.get());
		} catch(Exception e) {
			LOGGER.error("Not found: ", departmentId);
		}
		
	}

	@Override
	public DepartmentMasterModel createNewDepartment(DepartmentMasterModel department) {
		return departmentMasterRepo.save(new DepartmentMasterModel(department.getDepartmentName()));
	}
}

