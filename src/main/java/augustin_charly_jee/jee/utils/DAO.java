package augustin_charly_jee.jee.utils;

import java.util.List;

public interface DAO<T, ID> {

	List<T> findAll();

	T getById(ID id);

	ID create(T t);

	Integer update(T t);

	void delete(T t);

	void deleteById(ID id);

}
