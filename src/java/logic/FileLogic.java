package logic;

import java.io.InputStream;
import java.util.List;

import dao.FileDAO;
import dao.FileDAOImpl;
import dto.File;

public class FileLogic {
	private FileDAO fileDAO = new FileDAOImpl();
	/**
	 * create a student and add it into data base
     * @param stream
	 * @return
	 */
	public int addFile(InputStream stream) {
		return fileDAO.add(stream);
	}
	/**
	 * get all files
	 * @return
	 */
	public List<File> getAllFile(){
		return fileDAO.getAll();
	}
	
	/**
	 * get a file by id
     * @param id
     * @return 
	 */
	public File getFileById(int id) {
		return fileDAO.getById(id);
	}
	
	/**
	 * update a file
     * @param file
	 */
	public void updateStudent( InputStream file) {
		 fileDAO.update(file);
	}
	
	/**
	 * delete a file
     * @param id
	 */
	public void deleteStudent(int id) {
		fileDAO.delete(id);
	}
}
