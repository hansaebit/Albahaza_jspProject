<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	//session 에 saveid 가 있을경우(아이디저장체크한경우)
	//세션에서 myid를 얻는다
	String saveid=(String)session.getAttribute("saveid");
	String id="";
	if(saveid!=null){
		id=(String)session.getAttribute("myid");
	}
%>
<body>
    <div class="login_success">
        <div class="login_success_icon">
            <input class="chick_check" type="checkbox" style="display:none">
            <div class="chickicon chickmove">
            </div>
        </div>
    </div>
    <div class="login_wrapper">

        <form method="post" id="authForm" action="#">

            <fieldset>
                <div class="alert alert-danger alert-dismissible fade in missid">
                    <p><strong>Warning!</strong> 아이디가 존재하지 않습니다.</p> <b class="alert_close">&times;</b>
                </div>
                <div class="alert alert-danger alert-dismissible fade in misspw">
                    <p><strong>Warning!</strong> 비밀번호가 일치하지 않습니다.</p> <b class="alert_close">&times;</b>
                </div>
                <legend class="screen_out">Login</legend>
                <div class="login_form">Login</div>
                <div class="box_login">
                    <div class="login form-group">

                        <input type="text" class="form-control" name="loginId" placeholder="ID" value="<%=id%>" required >
                    </div>
                    <div class="login form-group">

                        <input type="password" class="form-control" name="password" placeholder="Password" required >
                    </div>
                </div>
                <button type="submit" class="btn_login">L o g i n</button>
                <br>
                <div class="login_append">
                    <div class="inp_chk">
                        <input type="checkbox" id="saveid" name="saveid"
                        <%=saveid==null?"":"checked"%>>
                        <label for="saveid">
                            <span class="txt_lab">아이디 저장</span>
                        </label>
                    </div>
                    <span class="txt_find">
                        <a href="#" class="link_find">아이디</a>
                            / 
                        <a href="#" class="link_find">비밀번호 찾기</a>
                    </span>
                </div>
            </fieldset>
        </form>
    </div>
</body>
</html>
<script>
    $(".alert_close").click(function(){
        $(".alert").css({
            "visibility":"hidden",
            "opacity":"0"
        });
    })
</script>