<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	String id = request.getParameter("id");
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	boolean result = false;
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "student");
		if(conn == null)
			throw new Exception("데이터베이스에 연결할 수 없습니다.");
		stmt = conn.createStatement();
		String command = String.format("select * from clientinfo where id='"+ id+ "'");
		rs = stmt.executeQuery(command);
	}
	catch (SQLException se){
		System.out.println(se.getMessage());
	}
	%>
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>아이디 중복 확인</title>
		<script>
			function checkIdClose(id){
				opener.input.id.value = id;
				window.close();
				opener.input.password.focus();
			}
		</script>
	</head>
	<body>
		<form method=post action="checkId.jsp">
			<%
				try{
					if(rs.next()){
						result = true;
						%>
						<%=id %>는 이미 사용중인 아이디입니다.<br>
						아이디: <input type="text" name="id">
						<input type="submit" value="중복체크">
				<%	}
					else if(id == null){
						%>
						다른 아이디 입력: <input type="text" name="id">
						<input type="submit" value="중복체크">
				<%	}
					else{
						 %>
						 <%=id %>는 사용가능한 아이디입니다.<br>
						 <a href="checkId.jsp">다른 아이디 입력</a><br>
						 <input type="button" value="현재 아이디 선택" onclick="checkIdClose('<%=id %>');">
				<%	}
				}
				catch(SQLException e){
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
			%>
		</form>
	</body>
	</html>