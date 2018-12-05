package factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import builder.GroupBuilder;
import dto.Group;

public class GroupFactory extends AbstractFactory<Group>{

	@Override
	public Group createFromResultSet(ResultSet rs) throws SQLException {
		GroupBuilder groupBuilder = new GroupBuilder();
		groupBuilder.build(rs);
		return groupBuilder.get();
	}

	@Override
	public Group createFromMap(Map<String, String[]> map) {
		GroupBuilder groupBuilder = new GroupBuilder();
		groupBuilder.build(map);
		return groupBuilder.get();
	}

}
