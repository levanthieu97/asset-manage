package jp.co.a_too.juchu.repo;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.a_too.juchu.models.Category2MasterModel;

@Scope("request")
@Repository
public interface Category2MasterRepo extends JpaRepository<Category2MasterModel, Integer>{
	List<Category2MasterModel> OrderById();
	
	@EntityGraph(value = "category2_category1", type = EntityGraph.EntityGraphType.FETCH)
	public List<Category2MasterModel> findAll();
}
