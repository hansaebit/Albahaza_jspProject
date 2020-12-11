<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="data.dto.MemberDto" %>
<%@ page import="data.dto.ResumeDto" %>
<%@ page import="java.util.List" %>
<%@ page import="data.dto.JobofferDto" %>
<%@ page import="data.dao.MemberDao" %>
<%@ page import="data.dao.ResumeDao" %>
<%@ page import="data.dao.JobofferDao" %>
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
    <%
        //        MemberDto memberDto = (MemberDto) session.getAttribute("member");
//        List<ResumeDto> resumeList = (List<ResumeDto>) session.getAttribute("resumelist");
//        List<JobofferDto> jobofferList = (List<JobofferDto>) session.getAttribute("jobofferlist");
//        System.out.println(memberDto);
//        System.out.println(resumeList);
//        System.out.println(jobofferList);
    %>
</head>
<body>
<div class="mp_wrapper">
    <div class="mp_category">
        <h1>마이페이지</h1>
        <br>
        <ul>
            <li><a href="#mp_content1">개인정보</a></li>
            <li><a href="#mp_content2">나의 구직정보</a></li>
            <ul>
                <li>이력서</li>
                <li>지원현황</li>
            </ul>
            <li><a href="#mp_content3">나의 구인정보</a></li>
            <ul>
                <li>채용공고</li>
                <li>구인현황</li>
            </ul>
            <li><a href="index.jsp?main=login/signout.jsp">회원탈퇴</a></li>
        </ul>
    </div>
    <div class="mp_main">
        <a name="mp_content1"></a>
        <div class="mp_content1">
            <div class="mp_title">
                <a data-toggle="collapse" href="#collapse1"><h1>&nbsp;개인정보</h1>click</a>
                <button type="button" id="memberupdatefrombtn" name="${loginid}">개인정보 수정</button>
            </div>
            <hr>
            <div id="collapse1" class="panel-collapse collapse in myinfo">
                <table class="table table-bordered">
                    <tr>
                        <th style="width:150px">아이디</th>
                        <td>${member.id}</td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td>${member.name}</td>
                    </tr>
                    <tr>
                        <th>나이</th>
                        <td>${member.age}</td>
                    </tr>
                    <tr>
                        <th>성별</th>
                        <td>${member.gender}</td>
                    </tr>
                    <tr>
                        <th>핸드폰번호</th>
                        <td>${member.phonenum}</td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td>${member.email}</td>
                    </tr>
                    <tr>
                        <th>가입날짜</th>
                        <td>${member.createday}</td>
                    </tr>
                    <tr>
                        <th>회원종류</th>
                        <td>
                            <c:choose>
                                <c:when test="${member.ishire == 'true'}">
                                    고용인
                                </c:when>
                                <c:otherwise>
                                    구직자
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <hr>
        <a name="mp_content2"></a>
        <div class="mp_content2">
            <div class="mp_title">
                <a data-toggle="collapse" href="#collapse2"><h1>&nbsp;나의 구직정보</h1>click</a>
                <button type="button" onclick="location.href='index.jsp?main=form/resume.jsp'">이력서 추가</button>
            </div>
            <hr>
            <div id="collapse2" class="panel-collapse collapse">
                <div class="my_jobinfo">
                    <h3>&nbsp;&nbsp;&nbsp;이력서</h3>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>No</th>
                            <th>이름</th>
                            <th>지역</th>
                            <th>직종</th>
                            <th>가능시간</th>
                            <th>기간</th>
                            <th>날짜</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="resume" items="${resumelist}" varStatus="status">
                            <tr class="resume_detail" num="${resume.num}">
                                <td>${status.index+1}</td>
                                <td>${resume.name}</td>
                                <td>${resume.location}</td>
                                <td>${resume.jobtype}</td>
                                <td>${resume.abletime}</td>
                                <td>${resume.term}</td>
                                <td>${resume.writeday}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <hr>
                <div>
                    <h3>&nbsp;&nbsp;&nbsp;지원 현황</h3>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>No</th>
                            <th>지원한 공고</th>
                            <th>지원날짜</th>
                            <th>상태</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="joboffer" items="${applyjobofferlist}" varStatus="status">
                            <tr joboffernum="${joboffer.num}" class="myapply">
                                <td>${status.index+1}</td>
                                <td>${joboffer.companyname}</td>
                                <td>${favoriteslist[status.index].createday}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${favoriteslist[status.index].matchday == null}">
                                            보류
                                        </c:when>
                                        <c:otherwise>
                                            채용 (${favoriteslist[status.index].matchday})
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <hr>
        <a name="mp_content3"></a>
        <div class="mp_content3">
            <div class="mp_title">
                <a data-toggle="collapse" href="#collapse3"><h1>&nbsp;나의 구인정보</h1>click</a>
                <button type="button" onclick="location.href='index.jsp?main=form/jobofferform.jsp'">공고 추가</button>
            </div>
            <hr>
            <div id="collapse3" class="panel-collapse collapse">
                <div>
                    <h3>&nbsp;&nbsp;&nbsp;채용공고</h3>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>No</th>
                            <th>상호명</th>
                            <th>지역</th>
                            <th>직종</th>
                            <th>가능시간</th>
                            <th>시급</th>
                            <th>날짜</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="joboffer" items="${jobofferlist}" varStatus="status">
                            <tr class="joboffer_detail" num="${joboffer.num}">
                                <td>${status.index+1}</td>
                                <td>${joboffer.companyname}</td>
                                <td>${joboffer.location}</td>
                                <td>${joboffer.jobtype}</td>
                                <td>${joboffer.abletime}</td>
                                <td>${joboffer.pay}</td>
                                <td>${joboffer.writeday}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <hr>
                <div>
                    <h3>&nbsp;&nbsp;&nbsp;구인 현황</h3>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>No</th>
                            <th>채용공고 제목</th>
                            <th>이름</th>
                            <th>날짜</th>
                            <th>관리</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tbody>
                        <c:forEach var="element" items="${mapapply}" varStatus="s1">
                            <c:forEach var="info" items="${element.value}" varStatus="s2">
                                <%--${info}--%>
                                <tr resume="${fn:split(info,',')[0]}">
                                    <td>${s1.index * s2.count + s2.index}</td>
                                    <td>${fn:split(element.key,',')[1]}</td>
                                    <td>${fn:split(info,"," )[1]}</td>
                                    <td>${fn:split(info,',')[2]}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${fn:split(info,',')[3] == 'null'}">
                                                <button class="btn_myjob resume_detail" type="button"
                                                        joboffernum="${fn:split(element.key,',')[0]}"
                                                        num="${fn:split(info,',')[0]}"
                                                >
                                                    이력서 보기
                                                </button>
                                            </c:when>
                                            <c:otherwise>
                                                채용
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:forEach>
                        </tbody>
                        <%-- <tr>
                             <td>1</td>
                             <td>안녕하십니까</td>
                             <td>한건희</td>
                             <td>2000-00-00</td>
                             <td style="text-align: center">
                                 <button class="btn_myjob" type="button">이력서 보기</button>
                             </td>
                         </tr>--%>
                    </table>
                </div>
            </div>

        </div>

    </div>

</div>
</body>
</html>
<script>

</script>