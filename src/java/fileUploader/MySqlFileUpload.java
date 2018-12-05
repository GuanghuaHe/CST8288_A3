package fileUploader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.IntStream;

@SuppressWarnings( "unused")
public class MySqlFileUpload{

	//private static final String STUDENT_INSERT = "insert into MapMaker.Student (id, first_name, last_name) values ( 1, 'Shawn', 'Emami');";
	private static final String STUDENT_INSERT = "insert into MapMaker.Student (id, first_name, last_name) values ( 2, 'Joey', 'Yin');";
	private static final String FILE_INSERT = "insert into MapMaker.File (file) values (?)";
	private static final String FILE_GET = "select id, file from MapMaker.File where id = ?";
	private static final String FILE_DELETE = "delete from MapMaker.File where id = ?";
	private static final String FILE_UPDATE = "update MapMaker.File set file = ? where id = ?";
	//private static final String GROUP_INSERT = "insert into MapMaker.Group (name) values ( 'Shawn Team');";
	private static final String GROUP_INSERT = "insert into MapMaker.Group (name) values ( 'Joey Team');";
	//private static final String DETAIL_INSERT = "insert into MapMaker.FileDetail (file_id, name, type, date, size) values ( 1, 'test3', 'map', '2019-11-11', '9kb');";
	private static final String DETAIL_INSERT = "insert into MapMaker.FileDetail (file_id, name, type, date, size) values ( ?, ?, ?, ?, ?);";
	private static final String UPINSERT_INSERT = "insert into MapMaker.FileStudentGroupMatch ( student_id, group_id, file_id) "
			+ "values ( ?, ?, ?);";
	private static final String REGISTER_INSERT = "insert into MapMaker.StudentGroupMatch (group_id, student_id, date) values ( ?, ?, ?);";
	private static final String GET_ALL_TABLES = "SELECT TABLE_NAME as table FROM information_schema.tables WHERE table_schema = ?;";
	private static final String FOREIGN_CHECK = "SET FOREIGN_KEY_CHECKS = ?;";
	private static final String CLEAR_TABLE = "TRUNCATE TABLE MapMaker.%s;";
	private static final String TABLSE[] = { "StudentGroupMatch", "FileStudentGroupMatch", "FileDetail", "Group", "File", "Student" };

	private static final String address = "jdbc:mysql://localhost:3306/MapMaker?useSSL=false";
	private static final String user = "cst8288";
	private static final String pass = "8288";

	public static void main( String[] arg){
		Consumer< Integer> print = lines -> System.out.printf( "Lines Modified: %d%n", lines);
		try( Connection con = DriverManager.getConnection( address, user, pass)){
			//must set FOREIGN_KEY to 0/false first to clear the tables
			//print.accept( setOption( con, FOREIGN_CHECK, 0));
			//clear the tables
			//print.accept( clearDB( con, CLEAR_TABLE, TABLSE));
			//set FOREIGN_KEY to 1/true after clearing tables
		//	print.accept( setOption( con, FOREIGN_CHECK, 1));
			
			
			/**
			 * 添加文件路径表
			 */
//			print.accept( insertFile( con, FILE_INSERT, "resources\\test1.map"));
//			print.accept( insertFile( con, FILE_INSERT, "resources\\test2.map"));
//			print.accept( insertFile( con, FILE_INSERT, "resources\\test3.map"));
//			print.accept( insertFile( con, FILE_INSERT, "resources\\test4.map"));
//			print.accept( insertFile( con, FILE_INSERT, "resources\\test5.map"));
//			print.accept( insertFile( con, FILE_INSERT, "resources\\test6.map"));
//			print.accept( insertFile( con, FILE_INSERT, "resources\\test7.map"));
//			print.accept( insertFile( con, FILE_INSERT, "resources\\test8.map"));
//			print.accept( insertFile( con, FILE_INSERT, "resources\\test9.map"));
//			print.accept( insertFile( con, FILE_INSERT, "resources\\test10.map"));
//			print.accept( insertFile( con, FILE_INSERT, "resources\\test11.map"));
//			print.accept( insertFile( con, FILE_INSERT, "resources\\test12.map"));
//			print.accept( insertFile( con, FILE_INSERT, "resources\\test13.map"));
//			print.accept( insertFile( con, FILE_INSERT, "resources\\test14.map"));
//			print.accept( insertFile( con, FILE_INSERT, "resources\\test15.map"));
//			print.accept( insertFile( con, FILE_INSERT, "resources\\test16.map"));
			
			
		//	print.accept( insert( con, STUDENT_INSERT));
		//	print.accept( insert( con, GROUP_INSERT));
			
			/**
			 * 添加 文件详单表
			 */
//			IntStream.range(1, 17).forEach(i->{
//				try {
//					print.accept( insert( con, DETAIL_INSERT, new String[] {String.valueOf(i),"test"+i, "map","2018-11-25", (int)(Math.random()*16)+1 + "kb"}));
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
			//});
			/**
			 * 添加 文件，学生，分组 关系表
			 */
//			Random random = new Random();
//			for(int i = 0 , j =2, k=1; i < 16; k++, j++) {
//			print.accept( insert( con, UPINSERT_INSERT, new int[]{ j,i++/4+201,16-k}));
//			}
			
			/*print.accept( insert( con, REGISTER_INSERT, new Object[] {201,1,"2018-11-25"}));*/
			print.accept( insert( con, REGISTER_INSERT, new Object[] {201,2,"2018-11-25"}));
			print.accept( insert( con, REGISTER_INSERT, new Object[] {201,3,"2018-11-25"}));
			print.accept( insert( con, REGISTER_INSERT, new Object[] {201,4,"2018-11-25"}));
			print.accept( insert( con, REGISTER_INSERT, new Object[] {202,5,"2018-11-25"}));
			print.accept( insert( con, REGISTER_INSERT, new Object[] {202,6,"2018-11-25"}));
			print.accept( insert( con, REGISTER_INSERT, new Object[] {202,7,"2018-11-25"}));
			print.accept( insert( con, REGISTER_INSERT, new Object[] {202,8,"2018-11-25"}));
			print.accept( insert( con, REGISTER_INSERT, new Object[] {203,9,"2018-11-25"}));
			print.accept( insert( con, REGISTER_INSERT, new Object[] {203,10,"2018-11-25"}));
			print.accept( insert( con, REGISTER_INSERT, new Object[] {203,11,"2018-11-25"}));
			print.accept( insert( con, REGISTER_INSERT, new Object[] {203,12,"2018-11-25"}));
			print.accept( insert( con, REGISTER_INSERT, new Object[] {204,13,"2018-11-25"}));
			print.accept( insert( con, REGISTER_INSERT, new Object[] {204,14,"2018-11-25"}));
			print.accept( insert( con, REGISTER_INSERT, new Object[] {204,15,"2018-11-25"}));
			print.accept( insert( con, REGISTER_INSERT, new Object[] {204,16,"2018-11-25"}));

//			print.accept( deleteFile( con, FILE_DELETE, 1));
//			print.accept( insertFile( con, FILE_INSERT, "resources\\test3.map"));
			
		//	print.accept( updateFile( con, FILE_UPDATE, 1, "resources\\test.map"));
			
	//		System.out.printf( "Bytes Read: %d%n", getFile( con, FILE_GET, 1, "resources\\test5.map"));
		}catch( SQLException /*| IOException */e){
			e.printStackTrace();
		}
	}

	/**
	 * set a variable on the DB
	 * @param con - connection to the DB
	 * @param query - set given the option value
	 * @param option - value of option to be set
	 * @return number of lines modified on DB
	 * @throws SQLException - problem setting an option on the DB
	 */
	public static int setOption( Connection con, String query, int option) throws SQLException{
		try( PreparedStatement statement = con.prepareStatement( query)){
			statement.setInt( 1, option);
			return statement.executeUpdate();
		}
	}

	/**
	 * clear all the given tables
	 * @param con - connection to the DB
	 * @param query - truncate table given the list of tables
	 * @param tables - list of tables to be cleared
	 * @return number of lines modified on DB
	 * @throws SQLException - problem truncating the table
	 */
	public static int clearDB( Connection con, String query, String...tables) throws SQLException{
		int linesModified = 0;
		for( String table : tables){
			try( PreparedStatement clearTabel = con.prepareStatement( String.format( query, table))){
				linesModified += clearTabel.executeUpdate();
			}
		}
		return linesModified;
	}

	/**
	 * insert a full query to the DB, this method is only good for inserting fully built query.
	 * must create custom one for each table.
	 * @param con - connection to the DB
	 * @param query - insert full query to the DB
	 * @return number of lines modified on DB
	 * @throws SQLException - problem inserting to table
	 */
	public static int insert( Connection con, String query) throws SQLException{
		try( PreparedStatement statement = con.prepareStatement( query)){
			return statement.executeUpdate();
		}
	}
	
	/**
	 * this is 添加 学生，分组，文件 关系表  连表ID，一共4个字段
	 * @param con
	 * @param query
	 * @param ids
	 * @return
	 * @throws SQLException
	 */
	public static int insert( Connection con, String query, int[] ids) throws SQLException{
		try( PreparedStatement statement = con.prepareStatement( query)){
			statement.setInt(1, ids[0]);
			statement.setInt(2, ids[1]);
			statement.setInt(3, ids[2]);
			
			return statement.executeUpdate();
		}
	}
	/**
	 * overload method to insert multiple file detail.
	 */
	public static int insert( Connection con, String query, String[] values) throws SQLException{
		try( PreparedStatement statement = con.prepareStatement( query)){
			statement.setInt(1, Integer.parseInt(values[0]));
			statement.setString(2, values[1]);
			statement.setString(3, values[2]);
			statement.setDate(4, java.sql.Date.valueOf(values[3]));
			statement.setString(5, values[4]);
			return statement.executeUpdate();
		}
	}
	/**
	 * 
	 * @param con
	 * @param query
	 * @param values
	 * @return
	 * @throws SQLException
	 */
	public static int insert( Connection con, String query, Object[] values) throws SQLException{
		try( PreparedStatement statement = con.prepareStatement( query)){
			statement.setInt(1, (Integer)values[0]);
			statement.setInt(2, (Integer)values[1]);
			statement.setString(3, (String)values[2]);
			return statement.executeUpdate();
		}
	}
	/**
	 * add a file to the DB
	 * @param con - connection to the DB
	 * @param query - insert given path to DB
	 * @param path - address to load the file
	 * @return number of lines modified on DB
	 * @throws IOException - problem reading the file
	 * @throws SQLException - problem inserting the file to the DB
	 */
	public static int insertFile( Connection con, String query, String path) throws IOException, SQLException{
		try( PreparedStatement statement = con.prepareStatement( query)){
			//replace the ? in the query with the given loaded path
			statement.setBlob( 1, Files.newInputStream( Paths.get( path)));
			return statement.executeUpdate();
		}
	}
	
	
	
	/**
	 * delete a file from the DB
	 * @param con - connection to the DB
	 * @param query - delete the given row id
	 * @param id - id of the row containing the file
	 * @return number of lines modified on DB
	 * @throws IOException - problem deleting the row
	 * @throws SQLException - problem inserting the file to the DB
	 */
	public static int deleteFile( Connection con, String query, int id) throws SQLException{
		try( PreparedStatement statement = con.prepareStatement( query)){
			//replace the ? in the query with the given loaded path
			statement.setInt( 1, id);
			return statement.executeUpdate();
		}
	}

	/**
	 * update the file in the row with given the id
	 * @param con - connection to the DB
	 * @param query - update the row with given the id
	 * @param id - id of the row containing the file
	 * @param path - address to load the file
	 * @return number of lines modified on DB
	 * @throws IOException - problem loading the row
	 * @throws SQLException - problem updating the file on the DB
	 */
	public static int updateFile( Connection con, String query, int id, String path) throws SQLException, IOException{
		try( PreparedStatement statement = con.prepareStatement( query)){
			//replace the ? in the query with the given loaded path
			statement.setBlob( 1, Files.newInputStream( Paths.get( path)));
			statement.setInt( 2, id);
			return statement.executeUpdate();
		}
	}

	/**
	 * get a file from connection using the given query and id and store it in path
	 * @param con - connection to the database
	 * @param query - select a file from DB given the id
	 * @param id - id of the given file
	 * @param path - address to save the file
	 * @return number of bytes that are read
	 * @throws IOException - problem creating the file
	 * @throws SQLException - problem getting the file from DB
	 */
	public static long getFile( Connection con, String query, int id, String path) throws IOException, SQLException{
		try( PreparedStatement statement = con.prepareStatement( query)){
			//replace the ? in the query with the given id
			statement.setInt( 1, id);
			ResultSet result = statement.executeQuery();
			if( result.next()){
				//get the Binary Large Object.
				Blob blob = result.getBlob( "file");
				//get input stream from Blob and copy it to the given path, if file exists replace it.
				return Files.copy( blob.getBinaryStream(), Paths.get( path), StandardCopyOption.REPLACE_EXISTING);
			}
		}
		return 0;
	}
}
