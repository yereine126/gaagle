package web;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class BBSList {
	private ArrayList<Integer> seqNoList = new ArrayList<Integer>();
	private ArrayList<String> titleList = new ArrayList<String>();
	private ArrayList<String> writerList = new ArrayList<String>();
	private ArrayList<String> typeList = new ArrayList<String>();
	private boolean lastPage = false;
	
	public BBSList() {
	}
	
	public void setSeqNo(int index, Integer seqNo){
		this.seqNoList.add(index, seqNo);
	}
	
	public void setTitle(int index, String title){
		this.titleList.add(index, title);
	}
	
	public void setType(int index, String type){
		this.typeList.add(index, type);
	}

	public void setWriter(int index, String writer){
		this.writerList.add(index, writer);
	}
	
	public void setLastPage(boolean lastPage){
		this.lastPage = lastPage;
	}
	
	public Integer[] getSeqNo() {
		return seqNoList.toArray(new Integer[seqNoList.size()]);
	}
	
	public String[] getTitle() {
		return titleList.toArray(new String[titleList.size()]);
	}
	
	public String[] getType() {
		return typeList.toArray(new String[typeList.size()]);
	}
	
	public String[] getWriter() {
		return writerList.toArray(new String[writerList.size()]);
	}
	
	public boolean isLastPage() {
		return lastPage;
	}
	
	public int getListSize() {
		return seqNoList.size();
	}
}
