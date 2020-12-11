<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="action.joboffer.JobofferGetAllAction" %>
<%@ page import="data.dto.JobofferDto" %>
<%@ page import="action.ActionForward" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <title>g</title>
    <script type="text/javascript">
        $(function () {
            $("div .jobofferfind_wrapper")
                .find("select[name='jobtype']")
                .val("${jobtype}").attr("selected","selected");

            $("div .jobofferfind_wrapper")
                .find("select[name='term']")
                .val("${term}").attr("selected","selected");

            $("div .jobofferfind_wrapper")
                .find("select[name='abletime']")
                .val("${abletime}").attr("selected","selected");

        });
    </script>
</head>

<body>
<div class="jobofferfind_wrapper">
    <h1>채용정보</h1><br>
    <form <%--action="#"--%> class="joboffer_searchform">
        직종
        <select name="jobtype">
            <option value="none" selected>없음</option>
            <option value="외식">외식</option>
            <option value="유통판매">유통판매</option>
            <option value="문화 여가 생활">문화 여가 생활</option>
            <option value="서비스">서비스</option>
            <option value="영업">영업</option>
            <option value="생산 건설">생산 건설</option>
            <option value="it컴퓨터">it컴퓨터</option>
            <option value="교육 강사">교육 강사</option>
            <option value="디자인">디자인</option>
            <option value="미디어">미디어</option>
            <option value="병원">병원</option>
            <option value="배달">배달</option>
        </select>
        기간
        <select name="term">
            <option value="none" selected>없음</option>
            <option value="단기">단기</option>
            <option value="장기">장기</option>
        </select>
        시간
        <select name="abletime">
            <option value="none" selected>없음</option>
            <option value="주간">주간</option>
            <option value="야간">야간</option>
        </select>

        <%--<input type="text">--%>
        <button type="submit">검색</button>
    </form>

    <div class="jobofferlist_wrap">
        <table class="board_list">
            <caption>알바 목록</caption>
            <thead>
            <tr>
                <th>NO</th>
                <th>id</th>
                <th>상호명</th>
                <th>전화번호</th>
                <th>주소</th>

                <th>직종</th>
                <th>근무시간</th>
                <th>기간</th>
                <%--<th>소개</th>--%>
                <th>급여</th>
                <th>작성시간</th>
            </tr>
            </thead>
            <tbody id="jobtbody">
            <%--joboffer 데이터 출력부분--%>
            <c:forEach var="joboffer" items="${jobofferlist}" varStatus="status">
                <tr class="joboffer_detail" num="${joboffer.num}">
                    <td><c:out value="${status.index + 1}"></c:out></td>
                    <td><c:out value="${joboffer.id}"></c:out></td>
                    <td><c:out value="${joboffer.companyname}"></c:out></td>
                    <td><c:out value="${joboffer.phonenum}"></c:out></td>
                    <td><c:out value="${joboffer.location}"></c:out></td>

                    <td><c:out value="${joboffer.jobtype}"></c:out></td>
                    <td><c:out value="${joboffer.abletime}"></c:out></td>
                    <td><c:out value="${joboffer.term}"></c:out></td>
                        <%--<td><c:out value="${joboffer.introduce}"></c:out></td>--%>
                    <td><c:out value="${joboffer.pay}"></c:out></td>
                    <td><c:out value="${joboffer.writeday}"></c:out></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="paging">
<%--            ${paging}&nbsp;&nbsp;&nbsp;${paging.totalCount}--%>
            <c:if test="${paging.totalCount > 0}">
                <!-- 페이징 처리 -->
                <div style="width: 900px;text-align: center;">
                    <ul class="pagination">
                        <c:if test="${paging.startPage > 1}">
                            <li>
                                <a link="${requestURI}" name="paging" pagenum="${paging.startPage-1}"> 이전</a>
                            </li>
                        </c:if>
                        <c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}" step="1">
                            <c:set var="total" value="${total+1}"/>
                            <c:choose>
                                <c:when test="${paging.currentPage == i}">
                                    <li class="active">
                                        <a link="${requestURI}" name="paging" pageNum="${i}"> ${i}</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li>
                                        <a link="${requestURI}" name="paging" pagenum="${i}"> ${i}</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:if test="${paging.endPage < paging.totalPage}">
                            <li>
                                <a link="${requestURI}" name="paging" pageNum="${paging.endPage + 1}"> 다음</a>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>