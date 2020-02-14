import web.Lecture;
import web.LectureBBSList;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class lectureBBSListServlet
 */
@WebServlet("/lectureBBSListServlet")
public class lectureBBSListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lectureBBSListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String lecture = request.getParameter("LEC_NAME");
		String time=request.getParameter("LEC_TIME");
		
		String strLowerSeqNo = request.getParameter("FIRST_SEQ_NO");
	      int upperSeqNo;
	      int lowerSeqNo;
	         upperSeqNo = Integer.MAX_VALUE;

	      // int upperSeqNo=1134;

	      if (strLowerSeqNo == null)
	         lowerSeqNo = 0;
	      else
	         lowerSeqNo = Integer.parseInt(strLowerSeqNo);
		
		LectureBBSList list=readDB(upperSeqNo, lowerSeqNo, lecture,time,request,response);
		request.setAttribute("LECTUREBBS_LIST", list);
		request.setAttribute("LECTURE_NAME", lecture);
		

		RequestDispatcher dispatcher=request.getRequestDispatcher("ClassBoard.jsp");
		dispatcher.forward(request,response);
	}
	private LectureBBSList readDB(int upperSeqNo, int lowerSeqNo, String lecture,String time,HttpServletRequest request, HttpServletResponse response) throws ServletException{
		LectureBBSList list = new LectureBBSList();
		
	      list.setQ1(request.getParameter("LEC_NAME"));
	      list.setQ2(request.getParameter("LEC_TIME"));
	     
		Connection conn=null;
		Statement stmt=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "student");
	         if(conn==null)
	        	 throw new Exception("데이터베이스에 연결할 수 없습니다.");
	         stmt = conn.createStatement();
	         ResultSet rs=stmt.executeQuery("select * from class where seqNo < " + upperSeqNo + " and seqNo >= " + lowerSeqNo + " and lecture = '"+lecture+"'and time = '"+time+"';");
	         for(int cnt=0;cnt<10;cnt++){
	        	 if(!rs.next())
	        		 break;
	        	 list.setSeqNo(cnt, rs.getInt("seqNo"));
	        	 list.setTitle(cnt, rs.getString("title"));
	        	 list.setWriter(cnt, rs.getString("writer"));
	         }
	         if(!rs.next())
	        	 list.setLastPage(true);
	         
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
		return list;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
