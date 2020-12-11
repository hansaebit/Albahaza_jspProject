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
<div class="signup_wrapper">
    <form method="post" id="signupform">
        <!-- ============================================== -->
        <div class="signup_header">
            <div>
                <b>회원가입</b><br>
            </div>
            <div><br>
                <p>계정을 생성하시려면 정보를 입력해 주세요.</p>
            </div>
        </div>

        <hr>


        <div class="signup_body">
            <div class="signup_title">

            </div>
            <div class="signup_contents">
                <label>
                    ID<br>
                    <input type="text" name="id" required />
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
                    <input type="text" name="name" required />
                </label>
                <label>
                    Age<br>
                    <input type="text" name="age" required />
                </label>

                <label>
                    PhoneNumber<br>
                    <input type="text" name="phonenum" required />
                </label>
                <label>
                    Email<br>
                    <input type="email" name="email" required/>
                </label>
                <div>
                    Gender<br>
                    <label>
                        <input type='radio' name='gender' value='male' checked/>
                        남자
                    </label>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <label>
                        <input type='radio' name='gender' value='female'/>
                        여자
                    </label>
                </div>

                <div>
                    Job<br>
                    <label>
                        <input type='radio' name='ishire' value='false' checked/>
                        구직자
                    </label>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <label>
                        <input type='radio' name='ishire' value='true'/>
                        고용인
                    </label>
                </div>
            </div>
        </div>

        <hr>

        <div class="signup_button">
            <button type="submit">가입하기</button>
            <button type="button">뒤로가기</button>
        </div>
    </form>
</div>
</body>
</html>
