package jp.co.a_too.juchu.repo;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jp.co.a_too.juchu.models.DepartmentMasterModel;


@Scope("request")
@Repository
public interface DepartmentMasterRepo  extends JpaRepository<DepartmentMasterModel, Integer> {

	List<DepartmentMasterModel> OrderById();
	
	@Query(value = "SELECT last_value FROM tool.department_master_id_seq", nativeQuery = true)
	Integer getMaxId();
	
	

}
