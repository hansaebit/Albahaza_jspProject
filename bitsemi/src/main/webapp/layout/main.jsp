<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <div class="main_wrapper">
    
        <div class="main_content1">
            <div class="swiper-container">
                <div class="swiper-wrapper">
                    <div class="swiper-slide"><a href="#"><img src="img/mainpage1.png"></a></div>
                    <div class="swiper-slide"><a href="#"><img src="http://placehold.it/350x200"></a></div>
                    <div class="swiper-slide"><a href="#"><img src="http://placehold.it/350x200"></a></div>
                    <div class="swiper-slide"><a href="#"><img src="http://placehold.it/350x200"></a></div>
                    <div class="swiper-slide"><a href="#"><img src="http://placehold.it/350x200"></a></div>
                    <div class="swiper-slide"><a href="#"><img src="http://placehold.it/350x200"></a></div>
                    <div class="swiper-slide"><a href="#"><img src="http://placehold.it/350x200"></a></div>
                    <div class="swiper-slide"><a href="#"><img src="http://placehold.it/350x200"></a></div>
                </div>
            <!-- Add Arrows -->
                <div class="swiper-button-next"></div>
                <div class="swiper-button-prev"></div>
                <!-- Add Pagination -->
                <div class="swiper-pagination"></div>
            </div>
        </div>
        <script>
            var swiper = new Swiper('.swiper-container', {
                slidesPerView: 1,
                spaceBetween: 50,
                keyboard: {
                    enabled: true,
                },
                pagination: {
                    el: '.swiper-pagination',
                    clickable: true,
                },
                navigation: {
                    nextEl: '.swiper-button-next',
                    prevEl: '.swiper-button-prev',
                },
            });
        </script>



        <!-- main content2 start -->
        <div class="main_content2_title">
            구인 목록
        </div>
        <div class="main_content2"> <!--나중에 for문 으로 반복 -->
            <ul>
                <li>
                    <img src="http://placehold.it/350x200">
                    <a href="#">
                        <div class="content2_hover">
                            <h2>img title</h2>
                            <p>
                                img description
                            </p>
                        </div>
                    </a>
                </li>
                <li>
                    <img src="http://placehold.it/350x200">
                    <a href="#">
                        <div class="content2_hover">
                            <h2>img title</h2>
                            <p>
                                img description
                            </p>
                        </div>
                    </a>
                </li>
                <li>
                    <img src="http://placehold.it/350x200">
                    <a href="#">
                        <div class="content2_hover">
                            <h2>img title</h2>
                            <p>
                                img description
                            </p>
                        </div>
                    </a>
                </li>
                <li>
                    <img src="http://placehold.it/350x200">
                    <a href="#">
                        <div class="content2_hover">
                            <h2>img title</h2>
                            <p>
                                img description
                            </p>
                        </div>
                    </a>
                </li>
                <li>
                    <img src="http://placehold.it/350x200">
                    <a href="#">
                        <div class="content2_hover">
                            <h2>img title</h2>
                            <p>
                                img description
                            </p>
                        </div>
                    </a>
                </li>
                <li>
                    <img src="http://placehold.it/350x200">
                    <a href="#">
                        <div class="content2_hover">
                            <h2>img title</h2>
                            <p>
                                img description
                            </p>
                        </div>
                    </a>
                </li>
                <li>
                    <img src="http://placehold.it/350x200">
                    <a href="#">
                        <div class="content2_hover">
                            <h2>img title</h2>
                            <p>
                                img description
                            </p>
                        </div>
                    </a>
                </li>
                <li>
                    <img src="http://placehold.it/350x200">
                    <a href="#">
                        <div class="content2_hover">
                            <h2>img title</h2>
                            <p>
                                img description
                            </p>
                        </div>
                    </a>
                </li>
                
            </ul>
        </div>
        
        <div class="main_content3">
            <p>광    고</p>
        </div>
    </div>
</body>
</html>