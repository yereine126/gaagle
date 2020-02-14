
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.MemberItem;

/**
 * Servlet implementation class BasketPostServlet
 */
@WebServlet("/BasketPostServlet")
public class BasketPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("LOGIN_ID");
		String temp=request.getParameter("seqNo");
		int count=0;
		MemberItem list = readDB(temp, count,id, request, response);
		request.setAttribute("MEMBERITEM_LIST", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("basket.jsp");
		dispatcher.forward(request, response);
	}

	private MemberItem readDB(String temp, int count,String id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		MemberItem list = new MemberItem();
		list.setId(getString(id));
		list.setIsDel(false);
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "student");
			if(conn == null)
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from basket where id = '" +id+"';");

			if(temp!=null){
				stmt.executeUpdate("delete from basket where seqNo = "+Integer.parseInt(temp)+";");
				list.setIsDel(true);
				}
			
			for (int cnt = 0; cnt < 10000; cnt++) {
				
				if (!rs.next())
					break;
				count++;	
			list.setSeqNo(cnt, rs.getInt("seqNo"));
			list.setContent(cnt, rs.getString("content"));
			list.setStore(cnt, rs.getString("store"));
			}
			
			list.setCount(count);
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		} finally {
			try {
				stmt.close();
			} catch (Exception ignored) {
			}
			try {
				conn.close();
			} catch (Exception ignored) {
			}
		}
		return list;
	}

	private String getString(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
