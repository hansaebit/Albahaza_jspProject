<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>
    <meta name="keywords" content="알바하자,아르바이트,알바,구인,구직">
    <meta name="description" content="알바하자 메인페이지">
    <meta name="robot" content="all">
    <title>알바하자</title>

</head>
<%
    String url = request.getContextPath();
%>
<body>
<header>
    <div class="m_logo">
        <h1><a href="index.jsp">알바하자</a></h1>
    </div>

    <nav class="navbar">
        <ul class="a_li">
            <li><a class="goto_jobofferlist">채용정보</a></li>
            <li><a class="goto_resumelist">인재정보</a></li>
            <li><a href="index.jsp?main=form/resume.jsp">이력서등록</a></li>
            <li><a href="index.jsp?main=form/jobofferform.jsp">공고등록</a></li>
        </ul>
    </nav>
    <nav class="navbar">
        <ul class="b_li">

            <li class="intro"><%=request.getSession().getAttribute("loginid")%>님 환영합니다.</li>
            <li>
                <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-search"></span>   검색</button>
            </li>
            <li>
                <button type="button" class="btn btn-primary mypagebtn"
                <%--onclick="location.href='index.jsp?main=mypage/mypage.jsp'"--%>
                >마이페이지
                </button>
            </li>
            <li>
                <button type="button" class="btn btn-primary logoutbtn"

                >로그아웃
                </button>
            </li>
        </ul>
    </nav>
    <input type="checkbox" class="open_menu" id="open_menu"/>
    <label for="open_menu" class="burger"><span class="glyphicon glyphicon-menu-hamburger"></span></label>
    <nav class="slide_bar">
        <div class="slide_info">
            <div><a class="goto_jobofferlist">채용정보</a></div>
            <div><a class="goto_resumelist">인재정보</a></div>
            <div><a href="index.jsp?main=form/resume.jsp">이력서등록</a></div>
            <div><a href="index.jsp?main=form/jobofferform.jsp">공고등록</a></div>
        </div>
        <div class="slide_sign">
            <div>
                <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">검색</button>
            </div>
            <div>
                <button type="button" class="btn btn-primary mypagebtn"
                <%--onclick="location.href='index.jsp?main=mypage/mypage.jsp'"--%>
                >마이페이지
                </button>
            </div>
            <div class="intro_side">
                <button type="button" class="btn btn-primary logoutbtn"
                >로그아웃
                </button>
            </div>
        </div>
    </nav>
</header> <!--//header-->

<div class="modal fade" id="myModal" role="dialog">
    <form action="#" id="btn_allsearch">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">채용정보</h4>
                </div>
                <div class="modal-body">
                    <input type="text" name="allsearch_value" placeholder="채용정보를 검색하세요." style="width:270px;">
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-default">Search</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
<script>
    $(".logoutbtn").click(function(){
        swal({
            title:"로그아웃을 했습니다.",
            icon:"success",
            button:true,
            closeOnClickOutside:false
        })
            .then(function(){
                window.location.assign("login/logoutaction.jsp");
            });
    })
</script>