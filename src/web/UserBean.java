package web;


import java.sql.*;
public class UserBean {
	private static UserBean instance = new UserBean();
	
	public static UserBean getInstance(){
		return instance;
	}
	
	private UserBean() {}
	
	private Connection getConnection() throws Exception{
		String jdbcDriver = "jdbc:mysql://localhost:3306/webdb";
		return DriverManager.getConnection(jdbcDriver, "root", "student");
	}
	
	public UserDataBean searchId(String name) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDataBean sId = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select id from clientinfo where name = ?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			sId = new UserDataBean();
			for(int cnt = 0; ;cnt++){
				if(!rs.next())
					break;
				sId.setId(cnt, rs.getString("id"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(rs != null){
				try { rs.close(); } catch(SQLException e){}
			}
			if(pstmt != null){
				try { pstmt.close(); } catch(SQLException e){}
			}
			if(conn != null){
				try { conn.close(); } catch(SQLException e){}
			}
		}
		return sId;
	}
	
	public  UserDataBean searchPassword(String name, String id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDataBean sPassword = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select passwd from clientinfo where name = ? and id = ?");
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				sPassword = new UserDataBean();
				sPassword.setPassword(rs.getString("passwd"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(rs != null){
				try { rs.close(); } catch(SQLException e){}
			}
			if(pstmt != null){
				try { pstmt.close(); } catch(SQLException e){}
			}
			if(conn != null){
				try { conn.close(); } catch(SQLException e){}
			}
		}
		return sPassword;
	}
}
