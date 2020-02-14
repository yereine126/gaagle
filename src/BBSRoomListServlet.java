

import java.io.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.http.*;

public class BBSRoomListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strUpperSeqNo = request.getParameter("LAST_SEQ_NO");
		int upperSeqNo;
		if(strUpperSeqNo == null)
			upperSeqNo = Integer.MAX_VALUE;
		else
			upperSeqNo = Integer.parseInt(strUpperSeqNo);
		web.BBSList list = readDB(upperSeqNo);
		request.setAttribute("BBS_LIST", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AllFree.jsp?");
		dispatcher.forward(request, response);
	}
	
	private web.BBSList readDB(int upperSeqNo) throws ServletException {
		web.BBSList list = new web.BBSList();
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "student");
			if(conn == null)
				throw new Exception("데이터 베이스 연결 ㄴㄴ");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from bbs where type='자취방' and seqNo < " + upperSeqNo + " order by seqno desc; ");
			for(int cnt = 0; cnt < 10; cnt++){
				if(!rs.next())
					break;
				list.setSeqNo(cnt, rs.getInt("seqNo"));
				list.setTitle(cnt, rs.getString("title"));
				list.setWriter(cnt, rs.getString("writer"));
				list.setType(cnt, rs.getString("type"));
			}
			if (!rs.next())
				list.setLastPage(true);
		}catch(Exception e){
			throw new ServletException(e);
		}finally{
			try{
				stmt.close();
			}catch(Exception ignored){}
			try{
				conn.close();
			}catch (Exception ignored) {}
		}
		return list;
	}
}
