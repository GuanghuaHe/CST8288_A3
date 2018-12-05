package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datasource.DataSourceFactory;
import dto.Group;
import factory.DTOFactoryCreator;
import factory.Factory;

public class GroupDAOImpl implements GroupDAO{
	
	private static final String GROUP_INSERT="insert into MapMaker.Group (id, name) values ( ?, ?);";
	private static final String QUERY_ALL="select id,name from MapMaker.Group";
	private static final String GET_BY_ID="select id,name from MapMaker.Group where id = ?";
	private static final String GROUP_UPDATE="udpate MapMaker.Group set name = ? where id = ?";
	private static final String GROUP_DELETE="delete from MapMaker.Group where id = ?";

	@Override
	public int add(Group t) {
		try (
				Connection connection = DataSourceFactory.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GROUP_INSERT);
				){
			preparedStatement.setInt(1, t.getId());
			preparedStatement.setString(2, t.getName());
			return preparedStatement.executeUpdate();
					}catch (SQLException e) {
						
		}
		return 0;
	}

	@Override
	public List<Group> getAll() {
		try (
				Connection connection = DataSourceFactory.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL);
				){
			ResultSet result = preparedStatement.executeQuery();
			Factory<Group> factory = DTOFactoryCreator.createFactory(Group.class);
			return factory.createListFromResultSet(result);
					}catch (SQLException  e) {
		}
		return new ArrayList<>();
	}

	@Override
	public Group getById(int id) {
		try (
				Connection connection = DataSourceFactory.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID);
				){
			ResultSet result = preparedStatement.executeQuery();
			Factory<Group> factory = DTOFactoryCreator.createFactory(Group.class);
			return factory.createFromResultSet(result);
					}catch (SQLException  e) {
		}
		
		return null;
	}

	@Override
	public int update(Group group) {
		try(
				Connection connection = DataSourceFactory.createConnection();
				PreparedStatement statement=connection.prepareStatement(GROUP_UPDATE);
			){
			statement.setInt(1, group.getId());
			statement.setString(2, group.getName());
			
			return statement.executeUpdate();
		} catch (SQLException  e) {
			
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		try(
				Connection connection = DataSourceFactory.createConnection();
				PreparedStatement statement=connection.prepareStatement(GROUP_DELETE);
			){
			statement.setInt(1, id);
			return statement.executeUpdate();
		} catch (SQLException  e) {
			
		}
		return 0;
	}

}
