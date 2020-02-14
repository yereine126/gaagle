
import web.Shopping;
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
import javax.swing.JOptionPane;

/**
 * Servlet implementation class ShoppingPostServlet
 */
@WebServlet("/ShoppingPostServlet")
public class ShoppingPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShoppingPostServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub
	 * response.getWriter().append("Served at: ").append(request.getContextPath(
	 * )); }
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("LOGIN_ID");
		
		String q1 = request.getParameter("content");
		String q2 = request.getParameter("count");

		Shopping list = readDB(id, q1, q2, request, response);
		request.setAttribute("SHOPPING_LIST", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ShoppingPostResult.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

	}

	private Shopping readDB(String id, String q1, String q2, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		Shopping list = new Shopping();
		list.setIsCount(true);
		list.setIsMileage(true);
		Connection conn = null;
		Statement stmt = null;
		Connection conn2 = null;
		Statement stmt2 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "student");
			conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "student");
			
			if (conn == null)
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			if (conn2 == null)
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			stmt = conn.createStatement();
			stmt2 = conn2.createStatement();
			ResultSet rs = stmt.executeQuery("select * from goodsinfo where content = '" + q1 + "';");
			ResultSet rs2 = stmt2.executeQuery("select * from clientinfo where id = '" + id + "';");
			rs.first();
			rs2.first();
		
			if (rs2.getInt("mileage") < rs.getInt("price")*Integer.parseInt(q2)) {
				list.setIsMileage(false);
				list.setMileage(rs2.getInt("mileage"));
			}else if (Integer.parseInt(q2) > rs.getInt("extraCount")) {
				list.setIsCount(false);
				list.setExtraCount(rs.getInt("extraCount"));
			}
			else {
					list.setMileage(rs2.getInt("mileage")-rs.getInt("price")*Integer.parseInt(q2));
					list.setContent(rs.getString("content"));
					list.setName(rs.getString("name"));
					list.setPrice(rs.getInt("price") * Integer.parseInt(q2));
					list.setExtraCount(rs.getInt("extraCount") - Integer.parseInt(q2));
					list.setCount(Integer.parseInt(q2));
				}
			if(list.getIsMileage() && list.getIsCount()){
				stmt.executeUpdate("update goodsinfo set extraCount = " + list.getExtraCount() + " where name = '"
						+ list.getName() + "' and content = '" + list.getContent() + "';");
				stmt.executeUpdate("update clientinfo set mileage = " + list.getMileage() + " where id = '"
						+ id+"';");
				
				for(int i=0;i<Integer.parseInt(q2);i++) stmt.executeUpdate("insert into basket (id, store, content) values ('"+id+"', '"+list.getName()+"', '"+list.getContent()+"');");
			}
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		} finally {
			try {
				stmt.close();
				stmt2.close();
			} catch (Exception ignored) {
			}
			try {
				conn.close();
				conn2.close();
			} catch (Exception ignored) {
			}
		}
		return list;
	}

}
