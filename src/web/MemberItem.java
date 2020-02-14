package web;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
public class MemberItem {
	private int mileage;
	private String id;
	private String passwd;
	private String name;
	private String sNum;
	private ArrayList<String> content = new ArrayList<String>();
	private ArrayList<String> store = new ArrayList<String>();
	private int count;
	private ArrayList<Integer> seqNo = new ArrayList<Integer>();
	private int temp;
	private boolean isDel;
	public MemberItem(){
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public void setIsDel(boolean isDel){
		this.isDel = isDel;
	}
	public boolean getIsDel(){
		return isDel;
	}
	public void setCount(int count){
		this.count = count;
	}
	
	public void setTemp(int temp){
		this.temp = temp;
	}
	
	public void setSeqNo(int index, Integer seqNo){
		this.seqNo.add(index,seqNo);
	}
	
	public void setStore(int index, String store){
		this.store.add(index, store);
	}
	
	public void setContent(int index, String content){
		this.content.add(index, content);
	}
	
	public String getId(){
		return id;
	}
	
	public String getSNum(){
		return sNum;
	}
	
	public String getPasswd(){
		return passwd;
	}
	
	public String getName(){
		return name;
	}
	
	public int getMileage(){
		return mileage;
	}
	public Integer[] getSeqNo(){
		return seqNo.toArray(new Integer[seqNo.size()]);
	}
	
	public String[] getContent(){
		return content.toArray(new String[content.size()]);
	}
	
	public String[] getStore(){
		return store.toArray(new String[store.size()]);
	}
	
	public int getCount(){
		return count;
	}
	
	public int getTemp(){
		return temp;
	}
	public void readDB() throws ServletException {
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "student");
			if(conn==null)
				throw new Exception("데이터베이스에 연결 ㄴㄴ");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from clientinfo where id = '" + id + "';");
			if(rs.next()){
				id = rs.getString("id");
				name = rs.getString("name");
				passwd = rs.getString("passwd");
				sNum = rs.getString("sNum");
				mileage = rs.getInt("mileage");
			}
		}catch(Exception e) {
			throw new ServletException(e);
		}finally{
			try{
				stmt.close();
			}catch(Exception ignored){}
			try{
				conn.close();
			}catch(Exception ignored){}
		}
	}
}
