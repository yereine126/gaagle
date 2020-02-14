

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String sNumber = request.getParameter("stNumber");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("rePassword");
		//String result = request.getParameter("result");
		Connection conn = null;
		Statement stmt = null;
		try{
			if(name == null || id == null || password == null || rePassword == null)
				throw new Exception("데이터를 입력하세요.");
			if(!(password.equals(rePassword)))
				throw new Exception("비밀번호가 일치하지 않습니다.");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "student");
			if(conn == null)
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			stmt = conn.createStatement();
			String command = String.format("insert into clientinfo" + 
				"(name,sNum, id, passwd) values ('%s','%s', '%s', '%s');", name, sNumber,id, password);
			int rowNum = stmt.executeUpdate(command);
			if(rowNum < 1)
				throw new Exception("데이터를 DB에 입력할 수 없습니다.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try{
				stmt.close();
			}
			catch (Exception ignored){}
			try{
				conn.close();
			}
			catch (Exception ignored){}
		}
		response.sendRedirect("Join-Success.html");
	}
}
