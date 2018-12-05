package factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import builder.FileBuilder;
import dto.File;
import dto.Student;

public class FileFactory extends AbstractFactory<File>{

	@Override
	public File createFromResultSet(ResultSet rs) throws SQLException {
		FileBuilder fileBuilder = new FileBuilder();
		fileBuilder.build(rs);
		return fileBuilder.get();
	}

	@Override
	public File createFromMap(Map<String, String[]> map) {
		FileBuilder fileBuilder = new FileBuilder();
		fileBuilder.build(map);
		return fileBuilder.get();
	}

}
