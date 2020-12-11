<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>통합검색</title>
</head>
<body>
<%--<form action="#" class="header_allsearch" id="btn_allsearch">--%>
<%--    <h1>통합검색</h1>--%>
<%--    <div class="title" &lt;%&ndash;name="pageCont"&ndash;%&gt;>--%>
<%--        <input type="text" class="inbox" name="allsearch_value" title="검색어 입력" placeholder="검색어를 입력하세요"--%>
<%--               maxlength="25"--%>
<%--               autocomplete="off">--%>
<%--        <button type="submit">검색</button>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--    </div>--%>
<%--</form>--%>
<div class="memberfind-list">
    <table class="board_list">
        <b>회원정보</b>
        <thead>
        <tr>
            <th>ID</th>
            <th>이름</th>
            <th>전화번호</th>
            <th>E메일</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="member" items="${memberlist}" varStatus="status">
            <tr class="memberfind" num="${member.num}">
                <td><c:out value="${member.id}"></c:out></td>
                <td><c:out value="${member.name}"></c:out></td>
                <td><c:out value="${member.phonenum}"></c:out></td>
                <td><c:out value="${member.email}"></c:out></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<br><br>
<div class="jobofferfind-list">
    <table class="board_list">
        <b>구인</b>
        <thead>
        <tr>
            <th>ID</th>
            <th>회사명</th>
            <th>주소</th>
            <th>직종</th>
            <th>근무시간</th>
            <th>기간</th>
            <th>전화번호</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="joboffer" items="${jobofferlist}" varStatus="status">
            <tr class="jobofferfind" num="${joboffer.num}">
                <td><c:out value="${joboffer.id}"></c:out></td>
                <td><c:out value="${joboffer.companyname}"></c:out></td>
                <td><c:out value="${joboffer.location}"></c:out></td>
                <td><c:out value="${joboffer.jobtype}"></c:out></td>
                <td><c:out value="${joboffer.abletime}"></c:out></td>
                <td><c:out value="${joboffer.term}"></c:out></td>
                <td><c:out value="${joboffer.phonenum}"></c:out></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<br><br>
<div class="resumelist">
    <table class="board_list">
        <b>구직</b>
        <thead>
        <tr>
            <th>ID</th>
            <th>이름</th>
            <th>지역</th>
            <th>직종</th>
            <th>근무시간</th>
            <th>기간</th>
            <th>전화번호</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="resume" items="${resumelist}" varStatus="status">
            <tr class="resumefind" num="${resume.num}">
                <td><c:out value="${resume.id}"></c:out></td>
                <td><c:out value="${resume.name}"></c:out></td>
                <td><c:out value="${resume.location}"></c:out></td>
                <td><c:out value="${resume.jobtype}"></c:out></td>
                <td><c:out value="${resume.abletime}"></c:out></td>
                <td><c:out value="${resume.term}"></c:out></td>
                <td><c:out value="${resume.phonenum}"></c:out></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>


</html>
