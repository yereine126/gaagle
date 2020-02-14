<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="lecturebbs" class="web.LectureBBS" />
<jsp:setProperty name="lecturebbs" property="title" value="${param.LECTURE_TITLE }"/>
<jsp:setProperty name="lecturebbs" property="lecture" value="${param.LECTURE_NAME }"/>
<%

	lecturebbs.readDB();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
            text-align: left;
            font: bold 135% '나눔고딕';
            color: #111c46;
            margin-bottom: 0;
            padding: 1%;
            margin-left: 10%;
        }

        table {
            margin-left: 12%;
            width: 70%;
            margin-top: 0%;
            border-bottom: 1px solid #d8d8d8;
        }

        th {
            text-align: left;
            border-bottom: 1px solid #d8d8d8;
            font: normal 80% '맑은 고딕';
            padding: 1%;
            color: gray;
        }

        h2 {
            font: normal 200% '나눔고딕';
            color: black;
            padding: 0%;
        }

        td {
            padding: 3%;
            font: normal 90% '맑은 고딕';
            color: black;
        }

        .comment {
            padding-top: 5%;
            margin-left: 12%;
        }

        h5 {
            font: bold 120% '나눔 고딕';
            border-bottom: 1px solid #111c46;
            padding: 0.7%;
            border-bottom-width: 2px;
            color: #111c46;
            overflow: hidden;
            width: 10%;
            text-transform: uppercase;
        }

        .button {
            margin-top: 1%;
            background-color: rgba(66, 133, 244, 1.0);
            color: white;
            border: none;
        }

        .table {
            background-color: rgba(66, 133, 244, 1.0);
            color: white;
            text-decoration: none;
            font: normal 90% '맑은 고딕';
            padding: 0.5% 1%;
            float: right;
            margin-left: 1%;
        }

            .table:hover {
                font-weight: bold;
            }

        .write {
            text-decoration: none;
            font: normal 90% '맑은 고딕';
            color: black;
            float: left;
            margin-right: 2%;
        }

            .write:hover {
                font-weight: bold;
                border-bottom: 1px solid black;
            }
    </style>
    <link type="text/css" rel="stylesheet" href="copyright_css.css" />
    <link type="text/css" rel="stylesheet" href="nav_css.css" />
    <meta charset="utf-8" />
    <title>강의 검색</title>
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
        <div>
            <h3></h3>
            <hr style="color:darkblue;width:90%;" />
            <table>
                <tr>
                    <th><h2>${lecturebbs.title}</h2></th>
                </tr>
                <tr>
                    <th>작성자 ${lecturebbs.writer }</th>
                </tr>
                <tr>
                    <td>${lecturebbs.content }<br /></td>
                </tr>
            </table>

        </div>
        <br />
        <a href="ClassBoard.html" class="table" style="margin-right:18%;">목록</a>
        <a href="" class="write" style="margin-left:12%;">수정</a>
        <a href="" class="write">삭제</a>


        <div class="comment">
            <h5>Comments</h5>
            <form>
                <textarea cols="130" rows="6" name="content"></textarea><br />
                <input type="submit" value="확인" class="button" style="padding:1% 2%;margin-left:710px" />
                <input type="reset" value="취소" class="button"style="padding:1% 2%;" />
            </form>
        </div>

        <footer style="text-align:center">
            COPYRIGHT © WANG'SMEN ALL RIGHTS RESERVED
        </footer>
    </div>
</body>
</html>