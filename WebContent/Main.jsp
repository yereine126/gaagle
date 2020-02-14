<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="memberItem" class="web.MemberItem"/>
<jsp:setProperty property="id" name="memberItem" value="${sessionScope.LOGIN_ID}"/>
<% memberItem.readDB(); %>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
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

        .menu {
            background-repeat: no-repeat;
            margin-bottom: 20px;
            height: 300px;
            width: 450px;
            margin-left: 25px;
            float: left;
            box-shadow: 0 0 20px grey;
        }

        .contents {
            background-color: white;
            text-align: center;
            margin-top: 17%;
            max-width: 70%;
            padding: 10%;
            margin-left: 5%;
            opacity: 0.87;
            box-shadow : 0 0 20px grey;
        }

        .a_contents {
            color: #6f6c6c;
            font: normal 200% '나눔손글씨 펜';
            text-shadow: 1px 1px 5px #d8d5d5;
            text-decoration: none;
        }

            .a_contents:hover {
                color: #ff6a00;
                text-shadow: 1px 1px 5px #d8d5d5;
            }

        .personalInfo {
            background-color: white;
            box-shadow: 0px 0px 10px gray;
            width: 218px;
            float: left;
            height: 270px;
            margin-top: 30px;
            margin-left: 25px;
            text-align: center;
            font: normal 90% gray;
        }
        .banner {
            float: left;
            margin-left: 25px;
            margin-bottom : 20px;
            background-color: white;
            text-align: center;
            padding: 1%;
            cursor: pointer;
            box-shadow: 0 0 20px grey;
        }
            .banner:hover {
                background-color: #B0B0B0;
                transition-property: background-color;
                transition-duration: 1s;
            }
    </style>

    <meta charset="utf-8" />
    <link type="text/css" rel="stylesheet" href="copyright_css.css" />
    <title>가글-가대인들의 구글</title>
</head>
<body>
    <div style="min-width:1200px;">
        <div class="top">
            <a class="mypage_logout" href="http://catholic.ac.kr" style="text-align:left" target="_blank">학교 홈페이지</a>
            <a class="mypage_logout" href="http://e-cyber.catholic.ac.kr" style="text-align:left" target="_blank">사이버캠퍼스</a>
            <a class="mypage_logout" href="/Gaagle/logout" style="float:right; margin-right:2%; padding:0.2%;">LOGOUT</a>
        </div>
        <p>
            <a href="Main.jsp"><img src="gaagle_sublogo.png" style="max-width:25%" /></a>
        </p>
        <hr style="color:#4285f4;" />
        <div class="menu" style="background-image:url('lecture.jpg');margin-top : 30px;">
            <div class="contents">
                <a class="a_contents" href="ClassSearch.html">
                    강의검색<br />lecture search
                </a>
            </div>
        </div>
        <div class="menu" style="background-image:url('free.jpg');margin-top : 30px;">
            <div class="contents">
                <a class="a_contents" href="bbs-list">
                    자유게시판<br />free bulletin board
                </a>
            </div>
        </div>
        <div class="personalInfo" style="float:left;">
    <table border=1>      
           <tr>
           <td width=80>이름</td>
           <td width=140>${memberItem.name}</td>
           </tr>
           <tr>
           <td>아이디</td>
           <td>${sessionScope.LOGIN_ID}님</td>
           </tr>
           <tr>
            <td>마일리지</td>
            <td>${memberItem.mileage}점</td>
           </tr>
</table>
<a href=/Gaagle/basket>마일리지 쇼핑내역 조회하기</a>
        </div>
        <br>

        <div class="menu" style="background-image:url('shopping.jpg')">
            <div class="contents">
                <a class="a_contents" href="shoppingMain.html">
                    마일리지 쇼핑<br />Mileage shopping
                </a>
            </div>
        </div><div class="menu" style="background-image:url('questions.jpg')">
            <div class="contents">
                <a class="a_contents" href="http://www.catholic.ac.kr/openspace/02_01.html" target="_blank">
                    학교 공지사항<br />Notice
                </a>
            </div>
        </div>
        <br>
        <div class="banner" onclick="location.href='산바쿠shopping.html'">
            <img src="산바쿠 배너.png" width="190" />
        </div>
           <div><br /></div>
        <div class="banner" onclick="location.href='디델리shopping.html'">
            <img src="디델리 배너.png" width="190" />
        </div>
        <div class="banner" onclick="location.href='울엄마shopping.html'">
            <img src="울엄마 배너.png" width="190" />
        </div>
       
        <br />
    <footer style="text-align:center">
        COPYRIGHT © WANG'SMEN ALL RIGHTS RESERVED
    </footer>
    </div>
</body>
</html>