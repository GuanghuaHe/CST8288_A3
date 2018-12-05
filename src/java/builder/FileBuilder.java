package builder;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import dto.File;


public class FileBuilder {
	private static final String COL_ID="id";
	private static final String COL_FILE="file";
	
	private File file = new File();
	
	public File get() {
		return file;
	}
	
	public void build(ResultSet rs) throws SQLException{
		file.setId(rs.getInt(COL_ID));
		file.setFile(rs.getBlob(COL_FILE));
		
	}
	
	/**
	 * this image file does exist in this object ,it will go database directly from request. 
	 * @param map
	 */
	public void build(Map<String,String[]> map){
		throw new UnsupportedOperationException("pass input stream directly to dao impl");
//		String[] id=map.get("id");
//		if(id!=null && id.length>0) {
//			file.setId(Integer.parseInt(id[0]));
//		}
//		String[] files = map.get("file");
//		if(files!=null && files.length>0) {
//			String path = files[0];
//			try {
//				file.setFile((Blob) new ByteArrayInputStream(Files.readAllBytes(Paths.get(path))));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
	}
}
