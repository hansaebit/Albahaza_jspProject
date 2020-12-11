<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="resumedetail_wrapper">
    <form <%--action="#"--%> method="post">
        <input type="hidden" name="num" value="${resume.num}" id="resume_num"> <%--넘버 들어갈 곳--%>
        <input type="hidden" name="id" value="${resume.id}"> <%--아이디 들어갈 곳--%>
        <!-- ============================================== -->
        <div class="resumedetail_header_index">
            <label>작성일 :
                <input type="text" name="writeday" value="${resume.writeday}" readonly>
            </label>
        </div>
        <hr>
        <div class="resumedetail_header">
            <div>
                <b>이력서</b><br>
                <label><b style="font-size:25px;"></b><br>
                    <input type="text" name="name" value="${resume.name}" readonly>
                </label>
            </div>
            <div class="resumedetail_image">
                <img src="http://placehold.it/200x250">
            </div>
        </div>

        <hr>


        <div class="resumedetail_body">
            <div class="resumedetail_title">
                <b>인적사항</b>
            </div>
            <div class="resumedetail_contents">
                PhoneNumber
                <input type="text" value="${resume.phonenum}" name="phonenum" readonly/>
                JobType
                <input type="text" value="${resume.jobtype}" name="jobtype" readonly/>
                Term
                <input type="text" value="${resume.term}" name="term" readonly/>
                Able Time
                <input type="text" value="${resume.abletime}" name="abletime" readonly/>
                Carrer
                <input type="text" value="${resume.career}" name="career" readonly/>
                Address
                <input type='text' value="${resume.location}" nae="address" readonly/>
            </div>
        </div>

        <hr>

        <div class="resumedetail_footer">
            <div class="resumedetail_title">
                <b>자기소개</b>
            </div>
            <div class="resumedetail_contents">
                <pre>${resume.introduce}</pre>
            </div>
        </div>

        <hr>

        <div class="resumedetail_button">
            <c:choose>
                <c:when test="${resume.id == loginid}">
                    <button type="button" class="resume_gotoupdatebtn">수정하기</button>
                    <button type="button" class="resume_gotodeletebtn">삭제하기</button>
                </c:when>
                <c:otherwise>
                    <c:if test="${member.ishire == 'true'}">
                        <button type="button" class="resume_pickbtn"
                                joboffernum="${joboffernum}"
                                resumenum="${resume.num}"
                        >채용하기
                        </button>
                    </c:if>
                </c:otherwise>
            </c:choose>
            <button type="button" onclick="history.back();">뒤로가기</button>
        </div>
    </form>
</div>
</body>
</html>
