<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%--<html lang="ko">--%>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>
    <meta name="keywords" content="알바하자,아르바이트,알바,구인,구직">
    <meta name="description" content="알바하자 메인페이지">
    <meta name="robot" content="all">
    <link rel="shortcut icon" href="#">
    <title>알바하자</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <!--CSS File-->
    <link rel="stylesheet" href="css/alba.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


    <!--swiper slider-->
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
    <script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <script src="js/main.js"></script>
    <script src="js/main_event.js"></script>
    <script src="js/memberupdate.js"></script>
 
</head>
<%
    String mainPage="layout/main.jsp";
	if(request.getParameter("main")!=null){
		mainPage=request.getParameter("main");
	}
%>
<body>
    <div class="wrapper">
        <!--header start-->
        <div class="header">
            <%//세션에서 로그인 상태를 알 수 있는 loginok 얻기
                String loginok=(String)session.getAttribute("loginok");
                if(loginok==null){%>
            <jsp:include page="layout/header.jsp"/>
            <%}else{%>
            <jsp:include page="layout/header2.jsp"/>
            <%}%>
	    </div>
        <!--//header end-->

        <div class="content">
            <jsp:include page="<%=mainPage%>"/>
	    </div>

        <!--footer start-->
        <div class="footer">
		    <jsp:include page="layout/footer.jsp"/>
	    </div>

        <!--footer end-->
     
    </div>


</body>
</html>

