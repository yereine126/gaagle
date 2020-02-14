package web;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
public class LectureBBSList {
	private ArrayList<Integer> seqNoList=new ArrayList<Integer>();
	private ArrayList<String> titleList = new ArrayList<String>();
	private ArrayList<String> writerList = new ArrayList<String>();
	private boolean lastPage = false;
	public LectureBBSList(){}
	private String q1;
	private String q2;
	private String q3;
	private String q4;
	private String q5;
	
	public void setQ1(String q1){
		this.q1 = q1;
	}
	
	public void setQ2(String q2){
		this.q2 = q2;
	}
	
	public void setQ3(String q3){
		this.q3 = q3;
	}
	
	public void setQ4(String q4){
		this.q4 = q4;
	}
	
	public void setQ5(String q5){
		this.q5 = q5;
	}
	
	public String getQ1(){
		return q1;
	}
	
	public String getQ2(){
		return q2;
	}
	
	public String getQ3(){
		return q3;
	}
	
	public String getQ4(){
		return q4;
	}
	
	public String getQ5(){
		return q5;
	}
	public void setSeqNo(int index,Integer seqNo){
		this.seqNoList.add(index,seqNo);
	}
	public void setTitle(int index,String title){
		this.titleList.add(index,title);
	}
	public void setWriter(int index,String writer){
		this.writerList.add(index,writer);
	}
	public void setLastPage(boolean lastPage){
		this.lastPage = lastPage;
	}

	public Integer[] getSeqNo(){
		return seqNoList.toArray(new Integer[seqNoList.size()]);
	}
	public String[] getTitle(){
		return titleList.toArray(new String[titleList.size()]);
	}
	public String[] getWriter(){
		return writerList.toArray(new String[writerList.size()]);
	}
	public boolean isLastPage(){
		return lastPage;
	}
	public int getListSize(){
		return seqNoList.size();
	}

}
