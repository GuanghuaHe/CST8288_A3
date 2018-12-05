package builder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import dto.Student;

public class StudentBuilder {

	private static final String COL_ID="id";
	private static final String COL_FIRST_NAME="first_name";
	private static final String COL_LAST_NAME="last_name";
	
	private Student student = new Student();
	
	public Student get() {
		return student;
	}
	
	public void build(ResultSet rs) throws SQLException{
		student.setId(rs.getInt(COL_ID));
		student.setFirstName(rs.getString(COL_FIRST_NAME));
		student.setLastName(rs.getString(COL_LAST_NAME));
	}
	
	public void build(Map<String,String[]> map){
		String[] id=map.get("id");
		if(id!=null && id.length>0) {
			student.setId(Integer.parseInt(id[0]));
		}
		String[] firstName = map.get("first_name");
		if(firstName!=null && firstName.length>0) {
			student.setFirstName(firstName[0]);
		}
		String[] lastName = map.get("last_name");
		if(lastName!=null && lastName.length>0) {
			student.setLastName(lastName[0]);
		}
	}
}
