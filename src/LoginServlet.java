

import java.io.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("ID");
		String password = request.getParameter("PASSWORD");
		String result;
		if(checkLoginInfo(id, password)){
			HttpSession session = request.getSession();
			session.setAttribute("LOGIN_ID", id);
			result = "SUCCESS";
		}else
			result = "FAIL";
		response.sendRedirect("LoginResult.jsp?LOGIN_RESULT=" + result);//����������
	}
	
	private boolean checkLoginInfo(String id, String password) throws ServletException{
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "student");
			if (conn == null)
				throw new Exception("������ ���̽� ���� ��");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select passwd from clientinfo where id = '" + id + "';");
			if (!rs.next())
				return false;
			String correctPassword = rs.getString("passwd");
			if(password.equals(correctPassword))
				return true;
			else
				return false;
		}catch(Exception e){
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