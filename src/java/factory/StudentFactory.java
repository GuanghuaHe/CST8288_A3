package factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import builder.StudentBuilder;
import dto.Student;

public class StudentFactory extends AbstractFactory<Student>{

	@Override
	public Student createFromResultSet(ResultSet rs) throws SQLException {
		StudentBuilder studentBuilder = new StudentBuilder();
		studentBuilder.build(rs);
		return studentBuilder.get();
	}

	@Override
	public Student createFromMap(Map<String, String[]> map) {
		StudentBuilder studentBuilder = new StudentBuilder();
		studentBuilder.build(map);
		return studentBuilder.get();
	}

}
