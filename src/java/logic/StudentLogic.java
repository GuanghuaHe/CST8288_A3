package logic;

import java.util.List;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import dto.Student;

public class StudentLogic {

	private StudentDAO studentDAO = new StudentDAOImpl();
	/**
	 * create a student and add it into data base
	 * @param student
	 * @return
	 */
	public boolean addStudent(Student student) {
		return studentDAO.add(student)>0;
	}
	/**
	 * get all students
	 * @return
	 */
	public List<Student> getAllStudent(){
		return studentDAO.getAll();
	}
	
	/**
	 * get a student by id
     * @param id
     * @return 
	 */
	public Student getStudentById(int id) {
		return studentDAO.getById(id);
	}
	/**
	 * get a student by id
     * @param id
     * @return 
	 */
	public List<Student> getAllStudentByGroupId(int id) {
		return studentDAO.getAllStudentByGroupId(id);
	}
	/**
	 * update a student
     * @param student
     * @return 
	 */
	public boolean updateStudent(Student student) {
		return studentDAO.update(student) > 0;
	}
	
	/**
	 * delete a student
     * @param id
     * @return 
	 */
	public int deleteStudent(int id) {
		return studentDAO.delete(id);
	}
}
