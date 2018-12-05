package builder;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

import dto.FileDetail;

public class FileDetailBuilder {
	private static final String COL_ID="file_id";
	private static final String COL_NAME="name";
	private static final String COL_TYPE="type";
	private static final String COL_DATE="date";
	private static final String COL_SIZE="size";
	
	
private FileDetail fileDetail = new FileDetail();
	
	public FileDetail get() {
		return fileDetail;
	}
	
	public void build(ResultSet rs) throws SQLException{
		fileDetail.setFile_id(rs.getInt(COL_ID));
		fileDetail.setName(rs.getString(COL_NAME));
		fileDetail.setType(rs.getString(COL_TYPE));
		fileDetail.setDate(rs.getDate(COL_DATE).toLocalDate());
		fileDetail.setSize(rs.getString(COL_SIZE));
		
		
	}
	
	public void build(Map<String,String[]> map) {
		String[] ids=map.get("file_id");
		if(ids!=null && ids.length>0) {
			fileDetail.setFile_id(Integer.parseInt(ids[0]));
		}
		String[] names = map.get("name");
		if(names!=null && names.length>0) {
			fileDetail.setName(names[0]);
		}
		
		String[] types = map.get("type");
		if(types!=null && types.length>0) {
			fileDetail.setType(types[0]);
		}
		
		String[] dates = map.get("type");
		if(dates!=null && dates.length>0) {
			fileDetail.setDate(LocalDate.parse(dates[0]));
		}
		String[] sizes = map.get("size");
		if(sizes!=null && sizes.length>0) {
			fileDetail.setSize(sizes[0]);
		}
	}
}
