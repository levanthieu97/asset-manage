package jp.co.a_too.juchu.repo;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.a_too.juchu.models.Category1MasterModel;

@Scope("request")
@Repository
public interface Category1MasterRepo extends JpaRepository<Category1MasterModel, Integer>{
	List<Category1MasterModel> OrderById();
}
