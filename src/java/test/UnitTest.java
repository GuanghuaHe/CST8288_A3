package mapmarker.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dto.Student;
import logic.StudentLogic;

public class UnitTest {
	
	private StudentLogic studentLogic;
	
	@Before
	public void setUpClass() {
		studentLogic = new StudentLogic();
	}
	
	@Test
	public void test() {
//		Student student = new Student();
//		student.setId(1);
//		student.setFirstName("san");
//		student.setLastName("zhang");
//		assertTrue(studentLogic.addStudent(student));
		
		List<Student> studentList = studentLogic.getAllStudent();
		for(Student stu:studentList) {
			System.out.println(stu);
		}
	}
}
