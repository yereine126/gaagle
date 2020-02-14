<%@ page contentType="text/html; charset=utf-8" %>

<%@ page import ="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>아이디 찾기</title>
</head>
<body>
<% request.setCharacterEncoding("utf-8"); %>
<%
	String name = request.getParameter("name");
	web.UserBean manager = web.UserBean.getInstance();
	web.UserDataBean d = manager.searchId(name);
	boolean result = false;
	int cnt;
	if(d != null) result = true;
	try {
		for(cnt = 0;cnt<d.getId().length; cnt++){
			if(!result)
				break;
			else{
%>			<%= name %>님의 아이디는
				<%
					String sId = d.getId()[cnt].substring(0, 3);
					for (int i = 3; i < d.getId()[cnt].length(); i++)
						sId += "*";
				%><%= sId %>입니다.<br>
<%			}	
		}
		if(cnt == 0)
			out.println("가입되지 않은 이름입니다.");
	}catch (Exception e){}
%>
</body>
</html>