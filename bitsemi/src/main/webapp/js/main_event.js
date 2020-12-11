/**
 * event callback setting.
 */
$(function () {
    /**
     * resume submit action.
     */
    $("#resume_form").submit(function (e) {
        e.preventDefault();
        console.log("resumeform submit event");

        var id = $(this).find("input[name='id']").val();
        var name = $(this).find("input[name='name']").val();
        var phonenum = $(this).find("input[name='phonenum']").val();
        var jobtype = $(this).find("select[name='jobtype']").val();
        var abletime = $(this).find("input[name='abletime']:checked").val();
        var career = $(this).find("input[name='career']").val();
        var location = $(this).find("select[name='location2']").val();
        var introduce = $(this).find("textarea[name='introduce']").val();
        var term = $(this).find("input[name='term']:checked").val();
        console.log(id, name, phonenum, jobtype, abletime, career, location, introduce, term);

        submitResumeForm(id, name, phonenum, jobtype
            , abletime, career, location
            , introduce, term, function () {
                console.log("submitResumeForm() callback");
                swal({
                    title: "이력서를 작성하였습니다.",
                    icon: "success",
                    button: true,
                    closeOnClickOutside: false
                })
                    .then(function () {
                        getMypageInfo();
                    });
            });
    });

    /**
     * resume jobtype select event -> auto input.
     */
    $("#resume_form_jobtype_select").change(function () {
        var jabtype = $(this).val();
        console.log(jabtype);
        $("#resume_form_jobtype_input").val(jabtype);
    });

    /**
     * joboffer submit action.
     */
    $("#joboffer_form").submit(function (e) {
        e.preventDefault();
        console.log("joboffer_form submit event");

        var id = $(this).find("input[name='id']").val();
        var companyname = $(this).find("input[name='companyname']").val();
        var phonenum = $(this).find("input[name='phonenum']").val();
        var location = $(this).find("select[name='location2']").val();
        var jobtype = $(this).find("select[name='jobtype']").val();
        var term = $(this).find("input[name='term']:checked").val();
        var abletime = $(this).find("input[name='abletime']:checked").val();
        var introduce = $(this).find("textarea[name='introduce']").val();
        var pay = $(this).find("input[name='pay']").val();
        var needpeople = $(this).find("input[name='needpeople']").val();
        var xpoint = $(this).find("input[name='xpoint']").val();
        var ypoint = $(this).find("input[name='ypoint']").val();

        if (xpoint.length == 0 || ypoint.length == 0) {
            xpoint = "37.56682870714292";
            ypoint = "126.97864942777319";
        }

        console.log(id, companyname, phonenum, location, jobtype, term);
        console.log(abletime, introduce, pay, needpeople, xpoint, ypoint);

        submitJobofferForm(id, companyname, phonenum, location, jobtype, term
            , abletime, introduce, pay, needpeople, xpoint, ypoint
            , function () {
                console.log("submitJobofferForm() callback");
                swal({
                    title: "공고를 작성하였습니다.",
                    icon: "success",
                    button: true,
                    closeOnClickOutside: false
                })
                    .then(function () {
                        getMypageInfo();
                    });
            });
    });

    //로그인
    /**
     * login action.
     */
    $("#authForm").submit(function (e) {
        e.preventDefault();
        console.log("authForm submit event");

        var loginId = $(this).find("input[name='loginId']").val();
        var password = $(this).find("input[name='password']").val();

        console.log(loginId, password);

        submitAuthForm(loginId, password, function () {
            console.log("submitAuthForm() callback");

        });
    });


    //회원가입
    /**
     * member submit action.
     */
    $("#signupform").submit(function (e) {
        e.preventDefault();
        console.log("signupForm submit even  t");

        var id = $(this).find("input[name='id']").val();
        var name = $(this).find("input[name='name']").val();
        var age = $(this).find("input[name='age']").val();
        var gender = $(this).find("input[name='gender']:checked").val();
        var email = $(this).find("input[name='email']").val();
        var phonenum = $(this).find("input[name='phonenum']").val();
        var ishire = $(this).find("input[name='ishire']:checked").val();
        var pass = $(this).find("input[name='pass']").val();
        var pwrepeat = $(this).find("input[name='pwrepeat']").val();


        console.log(id, name, age, gender, email, phonenum, ishire, pass, pwrepeat);

        submitsignupForm(id, name, age, gender, email, phonenum, ishire, pass, pwrepeat, function () {
            console.log("submitsignupForm() callback");

        });
    });

    /**
     * 메인페이지->인재정보
     */
    $(".goto_resumelist").click(function () {
        getResumeFilterList(false, null, null, null, null,
            null, function (result) {
                location.href = "index.jsp?main=filter/resumefilterlist.jsp";
                // console.log(result); //페이지가 전환되면서 안보임.
            });
    });

    /**
     * 메인페이지->인재정보->필터입력 후 검색.
     */
    $(".resume_searchform").submit(function (e) {
        e.preventDefault();
        console.log("resume_searchform submit");

        var jobtype = $(this).find("select[name='jobtype']").val();
        var term = $(this).find("select[name='term']").val();
        var abletime = $(this).find("select[name='abletime']").val();
        var location = $(this).find("select[name='location']").val();

        getResumeFilterList(true, jobtype, term, abletime, location, null, function (result) {
            window.location.href = "index.jsp?main=filter/resumefilterlist.jsp";
            // console.log(result); //페이지가 전환되면서 안보임.
        });
    });

    /**
     * 메인페이지->구인정보
     */
    $(".goto_jobofferlist").click(function () {
        getJobofferFilterList(false, null, null, null,
            null, function (result) {
                location.href = "index.jsp?main=filter/jobofferlist.jsp";
                // console.log(result); //페이지가 전환되면서 안보임.
            });
    });

    /**
     * 메인페이지->구인정보->필터입력 후 검색.
     */
    $(".joboffer_searchform").submit(function (e) {
        e.preventDefault();
        console.log("joboffer_searchform submit");

        var jobtype = $(this).find("select[name='jobtype']").val();
        var term = $(this).find("select[name='term']").val();
        var abletime = $(this).find("select[name='abletime']").val();

        getJobofferFilterList(true, jobtype, term, abletime, null, function (result) {
            location.href = "index.jsp?main=filter/jobofferlist.jsp";
            // console.log(result); //페이지가 전환되면서 안보임.
        });
    });

    /**
     * paging 버튼 클릭.
     * 서버에서 페이징 처리 객체 자체를 세션으로 줌.
     */
    $("a[name='paging']").mousedown(function () {
        var link = $(this).attr("link");
        var pagenum = $(this).attr("pagenum");

        var jobtype = $("select[name='jobtype']").val();
        var term = $("select[name='term']").val();
        var abletime = $("select[name='abletime']").val();

        var isfilter = true;

        if (jobtype == "none" && jobtype == "none" && jobtype == "none") {
            isfilter = false;
        }

        console.log(link, pagenum);
        console.log(jobtype, term, abletime);

        $.ajax({
            type: "get",
            url: link,
            dataType: "html",
            data: {
                "pageNum": pagenum,
                "jobtype": jobtype,
                "term": term,
                "abletime": abletime,
                "isfilter": isfilter,
            },
            success: function (result) {
                console.log(result);
                location.reload();
            },
            error: function (e) {
                console.log(e);
            },
        });
    });

    /**
     * header2.jsp 에서 mypage 버튼 클릭.
     * session :
     * / member(MemberDto)
     * / resumelist(List<ResumeDto>)
     * / jobofferlist(List<JobofferDto>)
     */
    $(".mypagebtn").click(function () {
        getMypageInfo();
    });

    /**
     * 리스트중 하나를 클릭 했을때.
     * session : resume(ResumeDto)
     */
    $(".resume_detail").click(function () {
        var num = $(this).attr("num");
        console.log(num);

        var joboffernum = $(this).attr("joboffernum");
        console.log(joboffernum);

        if (joboffernum) {
            getResumeDetail(num, joboffernum, function () {
                location.href = "index.jsp?main=detailfiles/resumedetail.jsp";
            });
        } else {
            getResumeDetail(num, function () {
                location.href = "index.jsp?main=detailfiles/resumedetail.jsp";
            });
        }
    });

    /**
     * 리스트중 하나를 클릭 했을때.
     * session : joboffer(JobofferDto)
     */
    $(".joboffer_detail").click(function () {
        var num = $(this).attr("num");
        console.log(num);

        getJobofferDetail(num, function () {
            location.href = "index.jsp?main=detailfiles/jobofferdetail.jsp";
        });

    });

    /**
     * 이력서 디테일에서 수정하기 눌렀을때.
     * session : resume(ResumeDto)
     */
    $("button.resume_gotoupdatebtn").click(function () {
        console.log("button.resume_gotoupdatebtn");
        location.href = "index.jsp?main=updateform/resumeupdateform.jsp";
    });


    /**
     * 이력서 디테일에서 수정하기 눌렀을때.
     * session : resume(ResumeDto)
     */
    $("button.joboffer_gotoupdatebtn").click(function () {
        console.log("button.joboffer_gotoupdatebtn");
        location.href = "index.jsp?main=updateform/jobofferupdateform.jsp";
    });


    /**
     * 이력서 수정을 마치고 제출.
     * 업데이트 -> 리스트 & 멤버 세션 갱신 -> dto session 갱신 -> 페이지 이동.
     */
    $("form.resume_updateform").submit(function (e) {
        e.preventDefault();

        var num = $(this).find("input[name='num']").val();
        var id = $(this).find("input[name='id']").val();
        var name = $(this).find("input[name='name']").val();
        var phonenum = $(this).find("input[name='phonenum']").val();
        var jobtype = $(this).find("input[name='jobtype']").val();
        var term = $(this).find("input[name='term']:checked").val();
        var abletime = $(this).find("input[name='abletime']:checked").val();
        var career = $(this).find("input[name='career']").val();
        var location = $(this).find("select[name='location2']").val();
        var introduce = $(this).find("textarea[name='introduce']").val();

        console.log(num, id, name, phonenum, jobtype, term);
        console.log(abletime, career, location, introduce);

        submitResumeUpdateForm(num, id, name, phonenum, jobtype, term, abletime
            , career, location, introduce, function () {
                getMypageInfo(function () {
                    getResumeDetail(num, function () {
                        // location.href = "index.jsp?main=detailfiles/resumedetail.jsp";
                        swal({
                            title: "이력서를 수정하였습니다.",
                            icon: "success",
                            button: true,
                            closeOnClickOutside: false
                        })
                            .then(function () {
                                window.location.assign("index.jsp?main=detailfiles/resumedetail.jsp");
                            });

                    });
                });
            });
    });


    /**
     * 잡오퍼 수정을 마치고 제출.
     */
    $("form.joboffer_updateform").submit(function (e) {
        e.preventDefault();

        var num = $(this).find("input[name='num']").val();
        var id = $(this).find("input[name='id']").val();
        var companyname = $(this).find("input[name='companyname']").val();
        var phonenum = $(this).find("input[name='phonenum']").val();
        var jobtype = $(this).find("input[name='jobtype']").val();
        var abletime = $(this).find("input[name='abletime']:checked").val();
        var pay = $(this).find("input[name='pay']").val();
        var needpeople = $(this).find("input[name='needpeople']").val();
        var location = $(this).find("select[name='location2']").val();
        var introduce = $(this).find("textarea[name='introduce']").val();
        var xpoint = $(this).find("input[name='xpoint']").val();
        var ypoint = $(this).find("input[name='ypoint']").val();

        console.log(num, id, companyname, phonenum, jobtype, abletime);
        console.log(pay, needpeople, location, introduce);
        console.log(xpoint, ypoint);

        if (xpoint.length == 0 || ypoint.length == 0) {
            xpoint = "37.56682870714292";
            ypoint = "126.97864942777319";
        }

        submitJobofferUpdateForm(num, id, companyname, phonenum, jobtype, abletime,
            pay, needpeople, location, introduce, xpoint, ypoint, function () {
                getMypageInfo(function () {
                    getJobofferDetail(num, function () {
                        // location.href = "index.jsp?main=detailfiles/jobofferdetail.jsp";
                        swal({
                            title: "공고를 수정하였습니다.",
                            icon: "success",
                            button: true,
                            closeOnClickOutside: false
                        })
                            .then(function () {
                                window.location.assign("index.jsp?main=detailfiles/jobofferdetail.jsp");
                            });
                    });
                });
            });
    });

    /**
     * Mypage - 나의이력서에서 삭제하기 눌렀을때.
     * 이력서 num
     */
    $("button.resume_gotodeletebtn").click(function () {
        var num = $("#resume_num").val();
        console.log(num);
        DeleteResumeDetail(num, function () {
            console.log("mypage resume detail - resume delete!")
            swal({
                title: "이력서를 삭제하였습니다.",
                icon: "success",
                button: true,
                closeOnClickOutside: false
            })
                .then(function () {
                    history.back();
                });


        });
    });

    /**
     * Mypage - 나의 구인정보에서 삭제하기 눌렀을때.
     * joboffer num
     */
    $("button.joboffer_gotodeletebtn").click(function () {
        var num = $("#joboffer_num").val();
        console.log(num);
        DeleteJobofferDetail(num, function () {
            console.log("mypage joboffer detail - joboffer delete!");
            swal({
                title: "공고를 삭제하였습니다.",
                icon: "success",
                button: true,
                closeOnClickOutside: false
            })
                .then(function () {
                    history.back();
                });


        });
    });

    /**
     * Joboffer - 구인정보에서 좋아요 눌렀을때.
     * joboffer num
     */
    $(".likebutton").click(function () {
        var id = $("#joboffer_id").val(); //글주인
        var loginid = $("#loginid").val() //로그인한사람
        console.log(id);
        console.log(loginid);
        if (id == loginid) {
            swal({
                title: "경고!",
                text: "본인 글에는 좋아요를 누를 수 없습니다.",
                icon: "error",
                button: true,
                closeOnClickOutside: false
            })

        } else if (loginid == "") {
            swal({
                title: "로그인을 해주세요.",
                icon: "error",
                button: true,
                closeOnClickOutside: false
            })
                .then(function () {
                    window.location.assign("index.jsp?main=login/login.jsp");
                });
        } else {
            UpdateMemberLike(id, function () {
                console.log("UpdateMemberLike + 1 !!");
                swal({
                    title: "해당 공고를 추천했습니다.",
                    icon: "success",
                    button: true,
                    closeOnClickOutside: false
                })
            });
        }
    });


    /**
     * 잡오퍼 디테일 -> 지원하기.
     */
    $(".joboffer_pickbtn").click(function () {
        //이력서 검색할 정보.
        var resumenum = $(this).attr("resumenum");
        var resumeid = $(this).attr("resumeid");

        //잡 오퍼 정보.
        var joboffernum = $(this).attr("joboffernum");
        var jobofferid = $(this).attr("jobofferid");

        console.log(resumenum, resumeid, joboffernum, jobofferid);

        if (resumenum == "" || resumeid == "") {
            swal({
                title: "이력서를 등록하십시오.",
                icon: "warning",
                button: true,
                closeOnClickOutside: false
            })
                .then(function () {
                    location.href = "index.jsp?main=form/resume.jsp";
                });
        } else {
            ApplyToCompany(resumenum, resumeid, joboffernum, jobofferid, function () {
                getMypageInfo();    //mypage 로 이동.
            });
        }

    })

    /**
     * allsearch submit 검색버튼 눌렀을때.
     */
    $("#btn_allsearch").submit(function (e) {
        e.preventDefault();
        console.log("allsearch click event");

        var param = $(this).find("input[name='allsearch_value']").val();

        console.log(param);

        AllSearch(param, function () {
            console.log("AllSearch() callback");
            location.href = "index.jsp?main=searchresult.jsp";
        });


    });


    $("tr.myapply").click(function () {
        var num = $(this).attr("joboffernum");

        getJobofferDetail(num, function () {
            location.href = "index.jsp?main=detailfiles/jobofferdetail.jsp";
        });
    });

    $("button.resume_pickbtn").click(function () {
        var joboffernum = $(this).attr("joboffernum");
        var resumenum = $(this).attr("resumenum");

        $.ajax({
            type: "get",
            url: "controller/joboffer/pick",
            dataType: "html",
            data: {
                "resumenum": resumenum,
                "joboffernum": joboffernum,
            },
            success: function (result) {
                console.log(result);
                getMypageInfo();
                // if (callback != null) {
                //     callback();
                // }
            },
            error: function (e) {
                console.log(e);
            },
        });
    })


});
