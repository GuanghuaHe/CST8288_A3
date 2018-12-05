package factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFactory<T> implements Factory<T>{

	@Override
	public List<T> createListFromResultSet(ResultSet rs) throws SQLException {
		List<T> list = new ArrayList<>();
		while(rs.next()) {
			list.add(createFromResultSet(rs));
		}
		return list;
	}

	
	
}
