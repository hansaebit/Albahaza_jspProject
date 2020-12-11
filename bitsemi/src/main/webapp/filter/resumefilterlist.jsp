<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <title>g</title>
    <script type="text/javascript">
        $(function () {
            $("div .resumefind_wrapper")
                .find("select[name='location']")
                .val("${location}").attr("selected","selected");

            $("div .resumefind_wrapper")
                .find("select[name='jobtype']")
                .val("${jobtype}").attr("selected","selected");

            $("div .resumefind_wrapper")
                .find("select[name='term']")
                .val("${term}").attr("selected","selected");

            $("div .resumefind_wrapper")
                .find("select[name='abletime']")
                .val("${abletime}").attr("selected","selected");

        });
    </script>
</head>
<body>
<div class="resumefind_wrapper">
    <h1>인재정보</h1><br>
    <form <%--action="#"--%> class="resume_searchform">
        지역
        <select name="location">
            <option value="none" selected>없음</option>
            <c:forEach var="zipcode" items="${zipcodelist}">
                <option value="${zipcode.gu}">
                    <c:out value="${zipcode.gu}"></c:out>
                </option>
            </c:forEach>
            <%--<option value="시,광역시">시,광역시</option>
            <option value="서울특별시">서울시</option>
            <option value="경기도">경기도</option>
            <option value="강원도">강원도</option>
            <option value="충청남도">충청남도</option>
            <option value="충청북도">충청북도</option>
            <option value="전라남도">전라남도</option>
            <option value="전라북도">전라북도</option>
            <option value="경상남도">경상남도</option>
            <option value="경상북도">경상북도</option>
            <option value="부산광역시">부산광역시</option>
            <option value="대구광역시">대구광역시</option>
            <option value="대전광역시">대전광역시</option>
            <option value="울산광역시">울산광역시</option>
            <option value="인천광역시">인천광역시</option>
            <option value="광주광역시">광주광역시</option>
            <option value="제주도">제주도</option>--%>
        </select>
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

    <div class="resumelist_wrap">
        <table class="board_list">
            <caption>인재 목록</caption>
            <thead>
            <tr>
                <th>NO</th>
                <th>이름</th>
                <th>지역</th>

                <th>알바종류</th>
                <%--                <th>급여</th>--%>
                <th>장기/단기</th>
                <th>주간/야간</th>
                <%--                <th>근무시간</th>--%>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="resume" items="${resumelist}" varStatus="status">
                <tr class="resume_detail" num="${resume.num}">
                    <td><c:out value="${status.index + 1}"></c:out></td>
                    <td><c:out value="${resume.name}"></c:out></td>
                    <td><c:out value="${resume.location}"></c:out></td>

                    <td><c:out value="${resume.jobtype}"></c:out></td>
                    <td><c:out value="${resume.term}"></c:out></td>
                    <td><c:out value="${resume.abletime}"></c:out></td>
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