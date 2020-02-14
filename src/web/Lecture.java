package web;





import java.io.*;
import java.sql.*;
import javax.servlet.*;
import java.util.ArrayList;

public class Lecture {
	private ArrayList<String> lectureName = new ArrayList<String>();
	private ArrayList<String> lectureType = new ArrayList<String>();
	private ArrayList<String> major = new ArrayList<String>();
	private ArrayList<String> grade = new ArrayList<String>();
	private ArrayList<String> teacherName = new ArrayList<String>();
	private boolean lastPage = false;
	private boolean firstPage = true;
	private ArrayList<Integer> seqNo = new ArrayList<Integer>();
	private ArrayList<String> lectureTime = new ArrayList<String>();	
	private String q1;
	private String q2;
	private String q3;
	private String q4;
	private String q5;
	
	
	public Lecture(){}
	
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
	
	public void setSeqNo(int index, Integer seqNo){
		this.seqNo.add(index,seqNo);
	}
	public void setLectureName(int index, String lectureName){
		this.lectureName.add(index, lectureName);
	}
	
	public void setLectureType(int index, String lectureType){
		this.lectureType.add(index, lectureType);
	}
	
	public void setMajor(int index, String major){
		this.major.add(index, major);
	}
	
	public void setGrade(int index, String grade){
		this.grade.add(index, grade);
	}
	
	public void setTeacherName(int index, String teacherName){
		this.teacherName.add(index, teacherName);
	}
	
	public void setLastPage(boolean lastPage){
		this.lastPage = lastPage;
	}
	
	public void setFirstPage(boolean firstPage){
		this.firstPage = firstPage;
	}
	
	public void setLectureTime(int index, String lectureTime){
		this.lectureTime.add(index, lectureTime);
	}
	
	public String[] getLectureType(){
		return lectureType.toArray(new String[lectureType.size()]);
	}
	
	public String[] getLectureName(){
		return lectureName.toArray(new String[lectureName.size()]);
	}
	
	public String[] getMajor(){
		return major.toArray(new String[major.size()]);
	}
	
	public String[] getTeacherName(){
		return teacherName.toArray(new String[teacherName.size()]);
	}
	
	public String[] getGrade(){
		return grade.toArray(new String[grade.size()]);
	}
	
	public boolean isLastPage(){
		return lastPage;
	}
	
	public Integer[] getSeqNo(){
		return seqNo.toArray(new Integer[seqNo.size()]);
	}
	
	public int getListSize(){
		return seqNo.size();
	}
	
	public String[] getLectureTime(){
		return lectureTime.toArray(new String[lectureTime.size()]);
	}
	
	public boolean isFirstPage(){
		return firstPage;
	}
}

