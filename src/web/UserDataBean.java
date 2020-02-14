package web;



import java.util.ArrayList;

public class UserDataBean {
	private String name;
	private ArrayList<String> id = new ArrayList<String>();
	private String password;
	private String sNum;
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public String[] getId(){
		return id.toArray(new String[id.size()]);
	}
	public void setId(int index, String id){
		this.id.add(index, id);
	}
	
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getSNum(){
		return sNum;
	}
	public void setSNum(String sNum){
		this.sNum = sNum;
	}
}
