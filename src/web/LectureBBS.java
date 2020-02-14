package web;
import java.io.*;
import java.sql.*;
import javax.servlet.*;

public class LectureBBS {
	private String faculty;
	private String grade;
	private String type;
	private String professor;
	private String title;
	private String content;
	private String writer;
	private String lecture;
	private String time;
	public LectureBBS(){}
	public void setTime(String time){
		this.time=time;
	}
	public void setLecture(String lecture) {
		this.lecture=lecture;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String getFaculty(){
		return faculty;
	}
	public String getLecture(){
		return lecture;
	}
	public String getGrade(){
		return grade;
	}
	public String getType(){
		return type;
	}
	public String getProfessor(){
		return professor;
	}
	
	public String getTitle(){
		return title;
	}
	public String getContent(){
		return content;
	}
	public String getWriter(){
		return writer;
	}
	public String getTime(){
		return time;
	}
	public void readDB() throws ServletException{
		Connection conn=null;
		Statement stmt=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "student");
	         if(conn==null)
	        	 throw new Exception("데이터베이스에 연결할 수 없습니다.");
	         stmt=conn.createStatement();
	         ResultSet rs=stmt.executeQuery("select * from class where title = '"+title+"' and lecture= '"+lecture+"';");
	         if(rs.next()){
	        	 
	        	 content=rs.getString("content");
	        	 writer=rs.getString("writer");
	        	 time=rs.getString("time");
	         }
		}
		catch(Exception e){
			throw new ServletException(e);
		}
		finally{
			try{
				stmt.close();
			}
			catch(Exception ignored){}
			try{
				conn.close();
			}
			catch(Exception ignored){}
		}
		
	}
}
