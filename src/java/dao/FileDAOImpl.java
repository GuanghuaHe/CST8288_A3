package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import datasource.DataSourceFactory;
import dto.File;
import factory.DTOFactoryCreator;
import factory.Factory;








/**
 *
 * @author Shawn
 */
public class FileDAOImpl implements FileDAO {
	private static final String INSERT_FILE = "insert into MapMaker.File (file) values (?)";
    private static final String GET_ALL_FILES = "select * from MapMaker.File";
    //private static final String GET_FILE = "select id, file from MapMaker.File where id = ?";
    private static final String DELETE_FILE = "delete from MapMaker.File where id = ?";

    private final Factory<File> factory = DTOFactoryCreator.createFactory(File.class);

    @Override
    public List<File> getAll() {
        List<File> files = Collections.emptyList();
        try (Connection con = DataSourceFactory.createConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_ALL_FILES);
                ResultSet rs = pstmt.executeQuery();) {
            files = factory.createListFromResultSet(rs);
        } catch ( SQLException  ex) {
            Logger.getLogger(FileDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return files;
    }

    @Override
    public int add(InputStream stream) {
        try (Connection con = DataSourceFactory.createConnection();
                PreparedStatement statement = con.prepareStatement(INSERT_FILE)) {
            //replace the ? in the query with the given loaded path
            statement.setBlob(1, stream);
            //insert the stream to DB
            statement.executeUpdate();
            //grab the latest auto incremented key from DB
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                return keys.getInt(1);
            }
        } catch ( SQLException ex) {
            Logger.getLogger(FileDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public File getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(InputStream stream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        try (Connection con = DataSourceFactory.createConnection();
                PreparedStatement statement = con.prepareStatement(DELETE_FILE)) {
            //replace the ? in the query with the given id
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FileDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteAll(int[] ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

