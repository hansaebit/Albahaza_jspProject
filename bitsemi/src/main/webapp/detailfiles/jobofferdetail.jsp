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
<div class="jobofferdetail_wrapper">
    <form action="#">
        <input type="hidden" name="num" value="${joboffer.num}" id="joboffer_num"> <%--넘버 들어갈 곳--%>
        <input type="hidden" name="id" value="${joboffer.id}" id="joboffer_id"> <%--아이디 들어갈 곳--%>
        <input type="hidden" name="xpoint" value="${joboffer.xpoint}"> <%--xpoint--%>
        <input type="hidden" name="ypoint" value="${joboffer.ypoint}"> <%--ypoint--%>
        <input type="hidden" name="loginid" value="${loginid}" id="loginid"> <%--현재로그인한 아이디--%>
        <!-- ============================================== -->
        <div class="jobofferdetail_header_index">
            <label>작성일 :
                <input type="text" name="writeday" value="${joboffer.writeday}">
            </label>
            <div class="likebutton">
            </div>
        </div>
        <hr>
        <div class="jobofferdetail_header">
            <div>
                <b>채용공고</b><br>
                <label><b style="font-size:25px;"></b><br>
                    <input type="text" name="companyname" value="${joboffer.companyname}" readonly>
                </label>
            </div>
            <div class="jobofferdetail_image" style="display:inline-block;">
                <img src="http://placehold.it/400x250">
            </div>
        </div>

        <hr>


        <div class="jobofferdetail_body">
            <div class="jobofferdetail_title">
                <b>내&nbsp;&nbsp;용</b>
            </div>
            <div class="jobofferdetail_contents">
                PhoneNumber
                <input type="text" value="${joboffer.phonenum}" name="phonenum" readonly/>
                JobType
                <input type="text" value="${joboffer.jobtype}" name="jobtype" readonly/>
                Term
                <input type="text" value="${joboffer.term}" name="term" readonly/>
                Able Time
                <input type="text" value="${joboffer.abletime}" name="abletime" readonly/>
                Pay
                <input type="text" value="${joboffer.pay}" name="pay" readonly/>
                Need People
                <input type="text" value="${joboffer.needpeople}" name="needpeople" readonly/>
                Address
                <input type='text' value="${joboffer.location}" name="location" readonly/>
            </div>
        </div>
        <hr>
        <div class="jobofferdetail_body">
            <div class="jobofferdetail_title">
                <b>Map</b>
            </div>
            <div class="jobofferdetail_contents">
                <div id="map" style="width:100%;height:350px;"></div>
                <script type="text/javascript"
                        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9108a045e14efbfd66e60abc30889ad2"></script>
                <script src="js/kakaomap.js"></script>
            </div>
        </div>


        <hr>

        <div class="jobofferdetail_footer">
            <div class="jobofferdetail_title">
                <b>Introduce</b>
            </div>
            <div class="jobofferdetail_contents">
                <pre>${joboffer.introduce}</pre>
            </div>
        </div>

        <hr>

        <div class="jobofferdetail_button">
            <%--<button type="button">지원하기</button>
            <button type="button">뒤로가기</button>--%>
            <c:choose>
                <c:when test="${joboffer.id == loginid}">
                    <button type="button" class="joboffer_gotoupdatebtn">수정하기</button>
                    <button type="button" class="joboffer_gotodeletebtn">삭제하기</button>
                </c:when>
                <c:otherwise>
                    <%--${member.ishire}--%>
                    <c:if test="${member.ishire == 'false'}">
                        <button type="button" class="joboffer_pickbtn"
                                <%--membernum="${member.num}" memberid="${member.id}"--%>
                                joboffernum="${joboffer.num}" jobofferid="${joboffer.id}"
                                resumenum="${resumelist[0].num}" resumeid="${resumelist[0].id}"
                        >지원하기
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
