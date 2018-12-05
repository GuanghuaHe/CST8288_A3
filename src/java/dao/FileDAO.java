package dao;

import java.io.InputStream;
import java.util.List;

import dto.File;

public interface FileDAO {
int add(InputStream inputStream);
	
	List<File> getAll();
	
	File getById(int id);
	
	
	void delete(int id);
	
	void deleteAll(int[] ids);
	
	void update(InputStream stream);
}
