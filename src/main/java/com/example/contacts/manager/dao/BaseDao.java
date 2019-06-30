package pers.contacts.core.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseDao<T, ID extends Serializable> extends JpaSpecificationExecutor<T>,
		PagingAndSortingRepository<T, ID> {

	List<T> findAll();
}
