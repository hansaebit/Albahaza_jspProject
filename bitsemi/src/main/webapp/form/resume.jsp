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
        String id = (String) session.getAttribute("loginid");
        //session.setAttribute("myid", "yang0");// for testcase.
    %>
</head>

<body>
<div class="resume_wrapper">
    <form action="#" method="post" id="resume_form">
        <input type="hidden" name="num" value="#"> <%--넘버 들어갈 곳--%>
        <input type="hidden" name="id" value="${loginid}"> <%--아이디 들어갈 곳--%>
        <!-- ============================================== -->
        <div class="resume_header">
            <div>
                <b>이력서 등록</b><br>
            </div>
            <div class="resume_image">
                <img src="http://placehold.it/200x250">
            </div>
        </div>

        <hr>


        <div class="resume_body">
            <div class="resume_title">
                <b>인적사항</b>
            </div>
            <div class="resume_contents">
                <label>
                    Name<br>
                    <input type="text" name="name" required value="${member.name}"/>
                </label>
                <label>
                    PhoneNumber<br>
                    <input type="text" name="phonenum" required value="${member.phonenum}"/>
                </label>


                <label>
                    JobType<br>
                    <select name="jobtype" >
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
                </label>

                <div>
                    Term<br>

                    <label>
                        <input type='radio' name='term' value='장기' checked/>
                        장기
                    </label>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <label>
                        <input type='radio' name='term' value='단기'/>
                        단기
                    </label>
                </div>
                <div>
                    Able Time<br>

                    <label>
                        <input type='radio' name='abletime' value='주간' checked/>
                        주간
                    </label>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <label>
                        <input type='radio' name='abletime' value='야간'/>
                        야간
                    </label>
                </div>
                <label>
                    Carrer<br>
                    <input type="text" name="career" />
                </label>
                <label>
                    Address<br>
                    <select name="location1" required>
                        <option value="시,광역시">시,광역시</option>
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
                        <option value="제주도">제주도</option>
                    </select>
                    <select name="location2" required>
                        <option value="구">구</option>
                        <option value="강서구">서울 강서구</option>
                        <option value="구로구">서울 구로구</option>
                        <option value="양천구">서울 양천구</option>
                        <option value="금천구">서울 금천구</option>
                        <option value="관악구">서울 관악구</option>
                        <option value="서초구">서울 서초구</option>
                        <option value="강남구">서울 강남구</option>
                        <option value="송파구">서울 송파구</option>
                        <option value="강동구">서울 강동구</option>
                        <option value="광진구">서울 광진구</option>
                        <option value="성동구">서울 성동구</option>
                        <option value="용산구">서울 용산구</option>
                        <option value="마포구">서울 마포구</option>
                        <option value="서대문구">서울 서대문구</option>
                        <option value="은평구">서울 은평구</option>
                        <option value="종로구">서울 종로구</option>
                        <option value="성북구">서울 성북구</option>
                        <option value="동대문구">서울 동대문구</option>
                        <option value="성북구">서울 성북구</option>
                        <option value="중랑구">서울 중랑구</option>
                        <option value="노원구">서울 노원구</option>
                        <option value="강북구">서울 강북구</option>
                        <option value="도봉구">서울 도봉구</option>
                        <option value="영등포구">서울 영등포구</option>
                    </select>
                    <input type='text' name="location3" required />
                </label>
            </div>
        </div>

        <hr>

        <div class="resume_footer">
            <div class="resume_title">
                <b>Introduce</b>
            </div>
            <div class="resume_contents">
                <textarea name="introduce" required></textarea>
            </div>
        </div>

        <hr>

        <div class="resume_button">
            <button type="submit">이력서 작성하기</button>
            <button type="button">뒤로가기</button>
        </div>
    </form>
</div>
</body>
</html>