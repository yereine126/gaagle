<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="web.Lecture" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<HTML>
	<HEAD>
	   <style>
        p {
            text-align: center;
        }

        .top {
            background-color: rgba(66, 133, 244, 1.0);
            padding: 1.2%;
            max-width: 100%;
            margin: -8px;
            margin-top: -8px;
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
            color: #676666;
            margin-bottom: 0;
        }

        table {
            margin-left: 4%;
            margin-top: 5%;
        }

        th {
            font: normal 85% '맑은 고딕';
            background-color: rgba(66, 133, 244, 1.0);
            padding: 1%;
            color: white;
        }

        td {
            font: normal 85% '맑은 고딕';
            color: black;
            padding: 0.8%;
            text-align: center;
        }

        h5 {
            font: normal 80% '맑은 고딕';
            color: gray;
            text-align: center;
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

        a {
            color: black;
            text-decoration: none;
        }

            a:hover {
                font-weight: bold;
            }
    </style>
     <meta charset="utf-8" />
    <link type="text/css" rel="stylesheet" href="copyright_css.css" />
    <link type="text/css" rel="stylesheet" href="nav_css.css" />
	<TITLE>게시판</TITLE>
	</HEAD>
	<BODY>
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
    <h3>강의 게시판 목록</h3>
    <h5>강의명을 누르면 해당 게시판으로 이동합니다</h5>
    <p>
        <table border="0">

            <tr>
                <th width="200">학부</th>
                <th width="100">학년</th>
                <th width="100">유형</th>
                <th width="100">교수님</th>
                <th width="300">시간</th>
                <th width="350">강의명</th>
                
            </tr>
- 
			<c:if test="${LECTURE_LIST.listSize-1>=0}">
				<c:forEach var="cnt" begin="0" end="${LECTURE_LIST.listSize-1}">
					<TR>
						<TD>${LECTURE_LIST.major[cnt] }</TD>
						<TD>${LECTURE_LIST.grade[cnt] }</TD>
						<TD>${LECTURE_LIST.lectureType[cnt] }</TD>
						<TD>${LECTURE_LIST.teacherName[cnt] }</TD>
						<TD>${LECTURE_LIST.lectureTime[cnt] }</TD>
						<TD><a href="/Gaagle/lecture-bbs?LEC_NAME=${LECTURE_LIST.lectureName[cnt] }&LEC_TIME=${LECTURE_LIST.lectureTime[cnt]}">${LECTURE_LIST.lectureName[cnt] }</a></TD>
					</TR>
				</c:forEach>
			</c:if>				
		</TABLE>
		<br /><br />
    <p>
       <c:if test="${LECTURE_LIST.listSize-1>=0}">
		<c:if test="${!LECTURE_LIST.lastPage}">
			<A class="next" href='/Gaagle/lecture?FIRST_SEQ_NO=${LECTURE_LIST.seqNo[LECTURE_LIST.listSize-1]}&major=${LECTURE_LIST.q1}&lectureName=${LECTURE_LIST.q2}&lectureType=${LECTURE_LIST.q3}&grade=${LECTURE_LIST.q4}&teacherName=${LECTURE_LIST.q5}'>NEXT</A>
		</c:if>
		</c:if>

    </p>
    
    <footer style="text-align:center">
        COPYRIGHT © WANG'S MEN ALL RIGHTS RESERVED
    </footer>
		
		</div>
	</BODY>
</HTML>