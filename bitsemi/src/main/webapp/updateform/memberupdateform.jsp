<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="data.dto.MemberDto" %>
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

<body>
<div class="memberupdate_wrapper">
    <form action="#" method="post" id="memberupdate_form">
        <input type="hidden" name="num" value="${member.num}">
        <!-- ============================================== -->
        <div class="memberupdate_header">
            <div>
                <b>회원정보 수정</b><br>
            </div>
            <div><br>
                <p>정보을 수정하시려면 모든 빈칸을 입력해 주세요.</p>
            </div>
        </div>

        <hr>


        <div class="memberupdate_body">
            <div class="memberupdate_title">
            </div>
            <div class="memberupdate_contents">
                <label>
                    ID<span style="color:red; font-size:15px;"> (수정불가)</span><br>
                    <input type="text" name="ID" value="${member.id}" required readonly/>
                </label>
                <label>
                    Password<br>
                    <input type="password" name="pass" required />
                </label>
                <label>
                    Repeat Password<br>
                    <input type="password" name="pwrepeat" required />
                </label>
                <label>
                    Name<br>
                    <input type="text" name="name" value="${member.name}" required />
                </label>
                <label>
                    Age<br>
                    <input type="text" name="age" value="${member.age}" required />
                </label>

                <label>
                    PhoneNumber<br>
                    <input type="text" name="phonenum" value="${member.phonenum}" required />
                </label>
                <label>
                    Email<br>
                    <input type="email" name="email" value="${member.email}" required/>
                </label>
                <div>
                    Gender<br>
                    <label>
                        <input type='radio' name='gender' value='male' <c:if test="${member.gender eq 'male'}">checked</c:if>/>
                        남자
                    </label>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <label>
                        <input type='radio' name='gender' value='female' <c:if test="${member.gender eq 'female'}">checked</c:if>/>
                        여자
                    </label>
                </div>

                <div>
                    Job<br>
                    <label>
                        <input type='radio' name='ishire' value='false' <c:if test="${member.ishire eq 'false'}">checked</c:if>/>
                        구직자
                    </label>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <label>
                        <input type='radio' name='ishire' value='true' <c:if test="${member.ishire eq 'true'}">checked</c:if>/>
                        고용인
                    </label>
                </div>
            </div>
        </div>

        <hr>

        <div class="memberupdate_button">
            <button type="submit">수정하기</button>
            <button type="button" onclick="history.back();">뒤로가기</button>
        </div>
    </form>
</div>
</body>
</html>
