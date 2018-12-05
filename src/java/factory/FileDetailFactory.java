package factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import builder.FileDetailBuilder;
import dto.FileDetail;

public class FileDetailFactory extends AbstractFactory<FileDetail>{

	@Override
	public FileDetail createFromResultSet(ResultSet rs) throws SQLException {
		FileDetailBuilder fileDetailBuilder = new FileDetailBuilder();
		fileDetailBuilder.build(rs);
		return fileDetailBuilder.get();
	}

	@Override
	public FileDetail createFromMap(Map<String, String[]> map) {
		FileDetailBuilder fileDetailBuilder = new FileDetailBuilder();
		fileDetailBuilder.build(map);
		return fileDetailBuilder.get();
	}

}
