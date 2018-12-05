package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datasource.DataSourceFactory;
import dto.FileDetail;
import factory.DTOFactoryCreator;
import factory.Factory;


public class FileDetailDAOImpl implements FileDetailDAO {
	private static final String FILEDETAIL_INSERT = "Insert into mapmaker.filedetail (file_id,name,type,date,size) values (?,?,?,?,?);";
	private static final String QUERRY_ALL = "Select * from mapmaker.filedetail;";
	private static final String GET_BY_ID = "Select * from mapmaker.filedetail where id = ?;";

	@Override
	public int add(FileDetail fd) {
		try (Connection connection = DataSourceFactory.createConnection();
				PreparedStatement statement = connection.prepareStatement(FILEDETAIL_INSERT);) {
			statement.setInt(1, fd.getFile_id());
			statement.setString(2, fd.getName());
			statement.setString(3, fd.getType());
			statement.setDate(4, java.sql.Date.valueOf(fd.getDate()));
			statement.setString(5, fd.getSize());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<FileDetail> getAll() {
		try (Connection connection = DataSourceFactory.createConnection();
				PreparedStatement statement = connection.prepareStatement(QUERRY_ALL);) {
			ResultSet rs = statement.executeQuery();
			Factory<FileDetail> factory = DTOFactoryCreator.createFactory(FileDetail.class);
			return factory.createListFromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new ArrayList<>();
	}

	@Override
	public FileDetail getById(int id) {
		try(
				Connection connection = DataSourceFactory.createConnection();
				PreparedStatement statement=connection.prepareStatement(GET_BY_ID);
			){
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			Factory<FileDetail> factory = DTOFactoryCreator.createFactory(FileDetail.class);
			return factory.createFromResultSet(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(FileDetail object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
