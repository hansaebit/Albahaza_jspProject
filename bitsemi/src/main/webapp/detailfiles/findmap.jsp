<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>키워드로 장소검색하기</title>

</head>
<body>
<div>
    <div id="map" style="width:100%;height:300px;"></div>
    <form onsubmit="searchPlaces(); return false;">
        키워드 : <input type="text" value="이태원 맛집" id="keyword" size="15">
        <button type="submit">검색하기</button>
    </form>
    <input type="hidden" id="message1"/>
    <input type="hidden" id="message2"/>
</div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9108a045e14efbfd66e60abc30889ad2&libraries=services"></script>
<script src="../js/jobofferkakaomap.js"></script>
</body>
</html>