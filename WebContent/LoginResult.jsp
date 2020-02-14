<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <style>
        body {
            background-color: #F7F7F7;
            font-family: '맑은 고딕';
            line-height:30px;
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
<div>
    <p>
        <a href="Gaagle.jsp"><img src="gaagle_sublogo.png" style="max-width:40%"/></a>
        
    </p>
    <div>
    <c:choose>
        	<c:when test="${param.LOGIN_RESULT == 'SUCCESS'}">
        		로그인이 되었습니다.<br>
        		안녕하세요${sessionScope.LOGIN_ID}님.<br>
        		<a href="Main.jsp" >확인</a>
        	</c:when>
        	<c:otherwise>
        		로그인에 실패했습니다. <br>
        		아이디와 패스워드를 체크하세요.<br>
        		<a href="Login.html" >로그인</a>
        	</c:otherwise>
        </c:choose>
    </div>
    <footer style="text-align:center">
        COPYRIGHT © WANG'SMEN ALL RIGHTS RESERVED
    </footer>
    </div>
</body>
</html>