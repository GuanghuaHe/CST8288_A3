package dao;

import java.util.List;

public interface BaseDAO<T> {

	int add(T t);
	
	List<T> getAll();
	
	T getById(int id);
	
	int update(T object);
	
	int delete(int id);
}
