package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datasource.DataSourceFactory;
import dto.Student;
import factory.DTOFactoryCreator;
import factory.Factory;

public class StudentDAOImpl implements StudentDAO{
	
	private static final String STUDENT_INSERT="insert into MapMaker.Student (id, first_name, last_name) values ( ?, ?, ?);";
	private static final String QUERY_ALL="select id,first_name,last_name from MapMaker.Student";
	private static final String GET_BY_ID="select id,first_name,last_name from MapMaker.Student where id = ?";
        private static final String GET_BY_GROUP_ID="select id,first_name,last_name from MapMaker.Student join MapMaker.StudentGroupMatch on Student.id=StudentGroupMatch.Student_id where StudentGroupMatch.group_id = ?";
	private static final String STUDENT_UPDATE="udpate MapMaker.Student set first_name = ?,last_name = ? where id = ?";
	private static final String STUDENT_DELETE="delete from MapMaker.Student where id = ?";
	
	@Override
	public int add(Student t) {
		try(
				Connection connection = DataSourceFactory.createConnection();
				PreparedStatement statement=connection.prepareStatement(STUDENT_INSERT);
			){
			statement.setInt(1, t.getId());
			statement.setString(2, t.getFirstName());
			statement.setString(3, t.getLastName());
			return statement.executeUpdate();
		} catch (SQLException e) {
			
		}
		return 0;
	}

	@Override
	public List<Student> getAll() {
		try(
				Connection connection = DataSourceFactory.createConnection();
				PreparedStatement statement=connection.prepareStatement(QUERY_ALL);
			){
			ResultSet result = statement.executeQuery();
			Factory<Student> factory = DTOFactoryCreator.createFactory(Student.class);
			return factory.createListFromResultSet(result);
		} catch (SQLException e) {
			
		}
		return new ArrayList<>();
	}

	@Override
	public Student getById(int id) {
		try(
				Connection connection = DataSourceFactory.createConnection();
				PreparedStatement statement=connection.prepareStatement(GET_BY_ID);
			){
                    statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			Factory<Student> factory = DTOFactoryCreator.createFactory(Student.class);
			return factory.createFromResultSet(result);
		} catch (SQLException e) {
			
		}
		return null;
	}

        @Override
	public List<Student> getAllStudentByGroupId(int id) {
		try(
				Connection connection = DataSourceFactory.createConnection();
				PreparedStatement statement=connection.prepareStatement(GET_BY_GROUP_ID);
                        
			){
                    statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			Factory<Student> factory = DTOFactoryCreator.createFactory(Student.class);
			return factory.createListFromResultSet(result);
		} catch (SQLException e) {
			
		}
		return null;
	}
        
        
	@Override
	public int update(Student student) {
		try(
				Connection connection = DataSourceFactory.createConnection();
				PreparedStatement statement=connection.prepareStatement(STUDENT_UPDATE);
			){
			statement.setString(1, student.getFirstName());
			statement.setString(2, student.getLastName());
			statement.setInt(3, student.getId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		try(
				Connection connection = DataSourceFactory.createConnection();
				PreparedStatement statement=connection.prepareStatement(STUDENT_DELETE);
			){
			statement.setInt(1, id);
			return statement.executeUpdate();
		} catch (SQLException e) {
			
		}
		return 0;
	}

}
