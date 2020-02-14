<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="web.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <style>
        body {
            background-color: #F7F7F7;
            font-family: '맑은 고딕';
        }

        p {
            text-align: center;
            margin-top: 7%;
        }

        div {
            margin-left: 24%;
            padding: 4%;
            width: 45%;
            border: 1px solid lightgray;
            box-shadow: 2px 2px 5px #808080;
            background-color: white;
        }

        h2 {
            font-weight: bold;
        }

        h5 {
            font-weight: normal;
            color: gray;
        }

        .login_button {
            padding: 20px 45px;
            font: 110% '맑은 고딕';
            background-color: #3F84F5;
            color: white;
            border: 1px solid #3F84F5;
        }

            .login_button:hover {
                background-color: #3E82F0;
                border: 1px solid #2F5BB7;
                text-shadow: 0px 2px 1px #2B5BA8;
            }

        a {
            font: 100% '맑은 고딕';
            color: dodgerblue;
            text-decoration: none;
        }

            a:hover {
                color: darkblue;
            }
        #title {
            text-decoration: none;
            color: #3F84F5;
            font: 80% '맑은 고딕';
            margin-top: 2%;
        }
            #title:hover {
                color: darkblue;
            }
    </style>
    <link type="text/css" rel="stylesheet" href="copyright_css.css" />
    <title>로그인</title>
</head>
<body>
    <p>
        <a href="Main.jsp"><img src="gaagle_sublogo.png" style="max-width:40%"/></a>       
    </p>
    <div>
    <c:choose>
    <c:when test="${MEMBERITEM_LIST.isDel == true }">이용해주셔서 감사합니다.</br>
		<a href="Main.jsp" >메인화면으로 이동하기</a></c:when>
 <c:otherwise>
  <h4>구매 목록</h4>
 <table border=1>
			<tr>
				<td width=140>음식점 명</td>
				<td width=200>구매내용</td>
				<td width=100></td>
				</tr>
				
				<c:if test="${MEMBERITEM_LIST.count-1>=0}">
				<c:forEach var="cnt" begin="0" end="${MEMBERITEM_LIST.count-1}">
				<tr>
					<td>${MEMBERITEM_LIST.store[cnt] }</td>
					<td>${MEMBERITEM_LIST.content[cnt] }</td>
					<td><a href='/Gaagle/basket?seqNo=${MEMBERITEM_LIST.seqNo[cnt]}&LOGIN_ID=${MEMBERITEM_LIST.id}'>사용하기</a></td>
					</tr>
					</c:forEach>	
					</c:if>								
		</table></br>
		<a href="Main.jsp" >메인화면으로 이동하기</a>
		</c:otherwise>
		</c:choose>
    </div>
    <footer style="text-align:center">
        COPYRIGHT © WANG'SMEN ALL RIGHTS RESERVED
    </footer>
</body>
</html>