package jp.co.a_too.juchu.repo;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.a_too.juchu.models.StoreMasterModel;

@Scope("request")
@Repository
public interface StoreMasterRepo extends JpaRepository<StoreMasterModel, Integer>{
	
	List<StoreMasterModel> OrderById();

}
