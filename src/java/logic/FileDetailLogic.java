package logic;

import java.util.List;

import dao.FileDetailDAO;
import dao.FileDetailDAOImpl;
import dto.FileDetail;

public class FileDetailLogic {
	
	
	private FileDetailDAO fileDetailDAO = new FileDetailDAOImpl();
	
	/**
	 * create a student and add it into data base
	 * @param student
	 * @return
	 */
	public boolean addFileDetail(FileDetail student) {
		return fileDetailDAO.add(student)>0;
	}
	/**
	 * get all fileDetail
	 * @return
	 */
	public List<FileDetail> getAllFileDetail(){
		return fileDetailDAO.getAll();
	}
	
	/**
	 * get a fileDetail by id
	 */
	public FileDetail getFileDetailById(int id) {
		return fileDetailDAO.getById(id);
	}
	
	/**
	 * update a fileDetail
	 */
	public boolean updateFileDetail(FileDetail fileDetail) {
		return fileDetailDAO.update(fileDetail) > 0;
	}
	
	/**
	 * delete a fileDetail
	 */
	public boolean deleteFileDetail(int id) {
		return fileDetailDAO.delete(id) > 0;
	}
}
