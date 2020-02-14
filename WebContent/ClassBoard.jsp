<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="web.LectureBBSList" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String lec= (String)request.getAttribute("LECTURE_NAME");

%>
<html>
<head>
    <style>
        p {
            text-align: center;
        }

        .top {
            background-color: rgba(66, 133, 244, 1.0);
            padding: 1.2%;
            max-width: 100%;
            margin: -8px;
        }

        .mypage_logout {
            color: white;
            font: normal 90% 'Century Gothic';
            text-decoration: none;
            padding: 1%;
        }

            .mypage_logout:hover {
                font-weight: bold;
            }

        h3 {
            text-align: center;
            font: normal 250% '나눔손글씨 펜';
            color: #111c46;
            margin-bottom: 0;
            text-shadow: 1px 1px 5px lightgray;
        }

        table {
            margin-left: 12%;
            margin-top: 5%;
            border-bottom: 1px solid #dcd9d9;
            border-top: 2px solid black;
        }

        th {
            font: bold 85% '맑은 고딕';
            color: #333232;
            padding: 1%;
            border-bottom: 1px solid darkgray;
        }

        td {
            font: normal 80% '맑은 고딕';
            color: black;
            text-align: center;
            padding: 0.8%;
            border-bottom: 1px solid #dcd9d9;
        }

        .next {
            font: bold 70% '맑은 고딕';
            color: #111c46;
            text-align: right;
            padding: 1%;
            text-decoration: none;
            padding: 3%;
            margin-top: 100px;
        }

            .next:hover {
                text-decoration: underline;
            }

        .write {
            text-decoration: none;
            font: normal 80% '맑은 고딕';
            color: black;
            float: right;
            margin-right: 14%;
        }

            .write:hover {
                font-weight: bold;
                border-bottom: 1px solid black;
            }

        a {
            color: black;
            text-decoration: none;
        }

            a:hover {
                color: gray;
            }
    </style>
    <link type="text/css" rel="stylesheet" href="copyright_css.css" />
    <link type="text/css" rel="stylesheet" href="nav_css.css" />
    <meta charset="utf-8" />
    <title><%=lec %>강의 검색</title>
</head>
<body>

    <div style="min-width:1200px">
        <div class="top">
            <a class="mypage_logout" href="http://catholic.ac.kr" style="text-align:left" target="_blank">학교 홈페이지</a>
            <a class="mypage_logout" href="http://e-cyber.catholic.ac.kr" style="text-align:left" target="_blank">사이버캠퍼스</a>
            <a class="mypage_logout" href="/Gaagle/logout" style="float:right; margin-right:2%; padding:0.2%;">LOGOUT</a>
        </div>
        <p>
            <a href="Main.jsp"><img src="gaagle_sublogo.png" style="max-width:25%" /></a>
        </p>
        <nav>
            <ul>
                <li><a href="ClassSearch.html">/ 강의검색 /</a></li>
                <li><a href="bbs-list">/ 자유게시판 /</a></li>
                <li><a href="shoppingMain.html">/ 마일리지쇼핑 /</a></li>
            </ul>
        </nav>
        <h3><%=lec %> 게시판</h3>
        <table>
        
            <tr>
                <th width="80">번호</th>
                <th width="650">제목</th>
                <th width="200">작성자</th>
            </tr>
        	<c:forEach var="cnt" begin="1" end="${LECTUREBBS_LIST.getListSize() }">
        		<tr>
                <td style="font-size:75%">${cnt}</td>
                <td style="text-align:left"><a href="Q&A.jsp?LECTURE_TITLE=${LECTUREBBS_LIST.title[cnt-1] }&LECTURE_NAME=<%=lec %>">${LECTUREBBS_LIST.title[cnt-1] }</a></td>
                <td style="font-weight:bold">${LECTUREBBS_LIST.writer[cnt-1]}</td>
            </tr>
        	
        	</c:forEach>     
            
        
        </table><br />
        <a href="ClassWrite.html" class="write">글쓰기</a><br />
        <p>
             <c:if test="${LECTUREBBS_LIST.listSize-1>=0}">
		<c:if test="${!LECTUREBBS_LIST.lastPage}">
			<A class="next" href='/Gaagle/lecture-bbs?FIRST_SEQ_NO=${LECTUREBBS_LIST.seqNo[LECTUREBBS_LIST.listSize-1]}&LEC_TIME=${LECTUREBBS_LIST.q2}&LEC_NAME=${LECTUREBBS_LIST.q1}'>NEXT</A>
		</c:if>
		</c:if>
        </p>

        <footer style="text-align:center">
            COPYRIGHT © WANG'SMEN ALL RIGHTS RESERVED
        </footer>
    </div>
</body>
</html>