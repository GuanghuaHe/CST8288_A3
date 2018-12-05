package builder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import dto.Group;


public class GroupBuilder {
	private static final String COL_ID="id";
	private static final String COL_GROUP_NAME="name";
	
	private Group group = new Group();
	
	public Group get() {
		return group;
	}
	// from MySQL DataBase
	public void build(ResultSet rs) throws SQLException{
		group.setId(rs.getInt(COL_ID));
		group.setName(rs.getString(COL_GROUP_NAME));
	}
	
	
	// from https servelet
	public void build(Map<String,String[]> map) {
		String[] id=map.get("id");
		if(id!=null && id.length>0) {
			group.setId(Integer.parseInt(id[0]));
		}
		String[] names = map.get("name");
		if(names!=null && names.length>0) {
			group.setName(names[0]);
		}
		
	}
}
