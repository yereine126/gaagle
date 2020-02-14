<%@ page contentType="text/html; charset=utf-8" %>
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
        <a href="Main.html"><img src="gaagle_sublogo.png" style="max-width:40%"/></a>
        
    </p>
    <div>
  <h4>구매 목록</h4>
  <c:choose>
  
  <c:when test="${SHOPPING_LIST.isMileage==false}">
			보유마일리지가 부족합니다.(보유마일리지: ${SHOPPING_LIST.mileage }) </br>
			<a href="shoppingMain.html" >구매화면으로 이동하기</a>
		</c:when>
		<c:when test="${SHOPPING_LIST.isCount==false}">
			재고가 부족합니다.(잔여수량: ${SHOPPING_LIST.extraCount }) </br>
			<a href="shoppingMain.html" >구매화면으로 이동하기</a>
		</c:when>
		<c:otherwise>
		<table border=1>
			<tr>
				<td width=200>음식점 명</td>
				<td width=200>구매내용</td>
				</tr>
				
				<c:forEach var="cnt" begin="1" end="${SHOPPING_LIST.count}">
				<tr>
					<td>${SHOPPING_LIST.name }</td>
					<td>${SHOPPING_LIST.content }</td>
					</tr>
					</c:forEach>									
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