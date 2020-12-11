/**
 * ajax 통신이 끝나고 success 함수에서 등록해놓은 콜백을 호출 할 수 있습니다.
 * @param callback
 */
function submitResumeForm(id, name, phonenum, jobtype
    , abletime, career, location, introduce, term, callback = null) {
    $.ajax({
        type: "post",
        url: "controller/resume/add",
        dataType: "html",
        data: {
            "id": id,
            "name": name,
            "phonenum": phonenum,
            "jobtype": jobtype,
            "abletime": abletime,
            "career": career,
            "location": location,
            "introduce": introduce,
            "term": term
        },
        success: function (result) {
            console.log(result);
            if (callback != null) {
                callback();
            }
        },
        error: function (e) {
            console.log(e);
        },
    });
}


/**
 * 잡오퍼 글 등록할 떄.
 */
function submitJobofferForm(id, companyname, phonenum, location, jobtype, term
    , abletime, introduce, pay, needpeople, xpoint, ypoint, callback = null) {
    $.ajax({
        type: "post",
        url: "controller/joboffer/add",
        dataType: "html",
        data: {
            "id": id,
            "companyname": companyname,
            "phonenum": phonenum,
            "location": location,
            "jobtype": jobtype,
            "abletime": abletime,
            "term": term,
            "introduce": introduce,
            "pay": pay,
            "needpeople": needpeople,
            "xpoint": xpoint,
            "ypoint": ypoint,
        },
        success: function (result) {
            console.log(result);
            if (callback != null) {
                callback();
            }
        },
        error: function (e) {
            console.log(e);
        },
    });
}

/**
 * ajax 통신이 끝나고 success 함수
 */
function submitAuthForm(loginId, password) {
    $.ajax({
        type: "post",
        url: "controller/auth/login",
        dataType: "html",
        data: {
            "loginId": loginId,
            "password": password
        },
        success: function (data) {
            console.log(data);
            //alert(data)
            if (data == "NOID") {
                $(".missid").css({
                    "visibility": "visible",
                    "opacity": "1"
                });
            } else if (data == "NOPASS") {
                $(".misspw").css({
                    "visibility": "visible",
                    "opacity": "1"
                });
            } else {
                getMypageInfo(function () {
                    $("div.alert-dismissible").css({
                        "visibility": "hidden",
                        "opacity": "0"
                    })
                    $("div.login_success").css({
                        "visibility": "visible",
                        "opacity": "1"
                    });
                    $(".chick_check").attr("checked", true);
                    setTimeout(function () {
                        location.href = "index.jsp";
                    }, 1500);
                });
            }

        },
        error: function (e) {
            console.log(e);
            alert("error")
        },
    });
}

/**
 * 회원가입 ajax 통신이 끝나고 success 함수
 */
function submitsignupForm(id, name, age, gender, email, phonenum, ishire, pass, pwrepeat) {
    $.ajax({
        type: "post",
        url: "controller/member/add",
        dataType: "html",
        data: {
            "id": id,
            "name": name,
            "age": age,
            "gender": gender,
            "email": email,
            "phonenum": phonenum,
            "ishire": ishire,
            "pass": pass,
            "pwrepeat": pwrepeat
        },
        success: function (result) {
            console.log(result);
            if (pass == pwrepeat) {
                if (result == "no") {
                    swal({
                        title: "중복된 아이디가 있습니다!",
                        icon: "warning",
                        button: true,
                        closeOnClickOutside: false
                    })
                } else {
                    swal({
                        title: "회원가입이 되었습니다.",
                        icon: "success",
                        button: true,
                        closeOnClickOutside: false
                    })
                        .then(function () {
                            location.href = "index.jsp";
                        });

                }
            } else {
                swal({
                    title: "패스워드를 확인해주십시오.",
                    icon: "warning",
                    button: true,
                    closeOnClickOutside: false
                })
            }

        },
        error: function (e) {
            console.log(e);
            alert("error")
        },
    });
}

/**
 * 필터링된 이력서 리스트 받아오기.
 */
function getResumeFilterList(
    isfilter = false,
    jobtype = null, term = null, abletime = null, location = null,
    pageNum = null, callback = null) {
    var data = {};

    if (isfilter) {
        if (jobtype == "none" && jobtype == "none" && jobtype == "none" && location == "none") {
            isfilter = false;
        }

        data["isfilter"] = isfilter;
    }
    if (jobtype != null) {
        data["jobtype"] = jobtype;
    }
    if (term != null) {
        data["term"] = term;
    }
    if (abletime != null) {
        data["abletime"] = abletime;
    }
    if (location != null) {
        data["location"] = location;
    }
    if (pageNum != null) {
        data["pageNum"] = pageNum;
    }

    console.log("getResumeFilterList data : " + data);

    $.ajax({
        type: "get",
        url: "controller/resume/getall",
        dataType: "html",
        data: data,
        success: function (result) {
            console.log(result);
            if (callback != null) {
                callback(result);
            }
        },
        error: function (e) {
            console.log(e);
        },
    });
}

/**
 * 필터링된 joboffer 리스트 받아오기.
 */
function getJobofferFilterList(
    isfilter = false,
    jobtype = null, term = null, abletime = null,
    pageNum = null, callback = null) {
    var data = {};

    if (isfilter) {
        if (jobtype == "none" && jobtype == "none" && jobtype == "none") {
            isfilter = false;
        }
        data["isfilter"] = isfilter;
    }
    if (jobtype != null) {
        data["jobtype"] = jobtype;
    }
    if (term != null) {
        data["term"] = term;
    }
    if (abletime != null) {
        data["abletime"] = abletime;
    }
    if (pageNum != null) {
        data["pageNum"] = pageNum;
    }

    console.log("getJobofferFilterList data : " + data);

    $.ajax({
        type: "get",
        url: "controller/joboffer/getall",
        dataType: "html",
        data: data,
        success: function (result) {
            console.log(result);
            if (callback != null) {
                callback(result);
            }
        },
        error: function (e) {
            console.log(e);
        },
    });
}


/**
 * 세션 등록 및 업데이트.
 * / member(MemberDto)
 * / resumelist(List<ResumeDto>)
 * / jobofferlist(List<JobofferDto>)
 */
function getMypageInfo(callback = null) {
    $.ajax({
        type: "get",
        url: "controller/member/mypage",
        dataType: "html",
        // data: ,
        success: function (result) {
            console.log(result);
            if (callback != null) {
                callback();
            } else {
                // location.reload();
                location.href = "index.jsp?main=mypage/mypage.jsp";
            }
        },
        error: function (e) {
            console.log(e);
        },
    });
}


/**
 * 이력서 수정 폼 작성하고 제출할떄.
 */
function submitResumeUpdateForm(
    num, id, name, phonenum, jobtype, term,
    abletime, career, location, introduce, callback = null) {

    $.ajax({
        type: "post",
        url: "controller/resume/update",
        dataType: "html",
        data: {
            "num": num,
            "id": id,
            "name": name,
            "phonenum": phonenum,
            "jobtype": jobtype,
            "term": term,
            "abletime": abletime,
            "career": career,
            "location": location,
            "introduce": introduce,
        },
        success: function (result) {
            console.log(result);
            if (callback != null) {
                callback();
            }
        },
        error: function (e) {
            console.log(e);
        },
    });
}

function submitJobofferUpdateForm(
    num, id, companyname, phonenum, jobtype, abletime,
    pay, needpeople, location, introduce, xpoint, ypoint, callback = null) {
    $.ajax({
        type: "post",
        url: "controller/joboffer/update",
        dataType: "html",
        data: {
            "num": num,
            "id": id,
            "companyname": companyname,
            "phonenum": phonenum,
            "jobtype": jobtype,
            "abletime": abletime,
            "pay": pay,
            "needpeople": needpeople,
            "location": location,
            "introduce": introduce,
            "xpoint": xpoint,
            "ypoint": ypoint,
        },
        success: function (result) {
            console.log(result);
            if (callback != null) {
                callback();
            }
        },
        error: function (e) {
            console.log(e);
        },
    });
}


/**
 * 이력서 리스트중 하나 눌러서 디테일 페이지 들어갈떄.
 */
function getResumeDetail(num, callback = null) {
    $.ajax({
        type: "get",
        url: "controller/resume/get",
        dataType: "html",
        data: {"num": num},
        success: function (result) {
            console.log(result);
            if (callback != null) {
                callback();
            }
        },
        error: function (e) {
            console.log(e);
        },
    });
}

/**
 * 이력서 리스트중 하나 눌러서 디테일 페이지 들어갈떄.
 */
function getResumeDetail(num, joboffernum, callback = null) {
    $.ajax({
        type: "get",
        url: "controller/resume/get",
        dataType: "html",
        data: {
            "num": num,
            "joboffernum": joboffernum,
        },
        success: function (result) {
            console.log(result);
            if (callback != null) {
                callback();
            }
        },
        error: function (e) {
            console.log(e);
        },
    });
}


/**
 * 잡오퍼 리스트 중 하나 눌러서 디테일 페이지 들어갈때.
 */
function getJobofferDetail(num, callback = null) {
    $.ajax({
        type: "get",
        url: "controller/joboffer/get",
        dataType: "html",
        data: {"num": num},
        success: function (result) {
            console.log(result);
            if (callback != null) {
                callback();
            }
        },
        error: function (e) {
            console.log(e);
        },
    });
}

/**
 * Mypage - 나의이력서에서 삭제하기 눌렀을때.
 */
function DeleteResumeDetail(num, callback = null) {
    $.ajax({
        type: "get",
        url: "controller/resume/delete",
        dataType: "html",
        data: {"num": num},
        success: function (result) {
            console.log(result);
            if (callback != null) {
                callback();
            }
        },
        error: function (e) {
            console.log(e);
        },
    });
}

/**
 * Mypage - 나의 구인정보에서 삭제하기 눌렀을때.
 */
function DeleteJobofferDetail(num, callback = null) {
    $.ajax({
        type: "get",
        url: "controller/joboffer/delete",
        dataType: "html",
        data: {"num": num},
        success: function (result) {
            console.log(result);

            if (callback != null) {
                callback();
            }
        },
        error: function (e) {
            console.log(e);
        },
    });
}

/**
 * Joboffer 좋아요 - joboffer detail에서 좋아요 눌렀을때.
 */
function UpdateMemberLike(id, callback = null) {
    $.ajax({
        type: "get",
        url: "controller/member/like",
        dataType: "html",
        data: {"id": id},
        success: function (result) {
            console.log(result);

            if (callback != null) {
                callback();
            }
        },
        error: function (e) {
            console.log(e);
        },
    });
}

/**
 * allsearch 결과 출력
 * */
function AllSearch(param, callback = null) {
    $.ajax({
        type: "post",
        url: "controller/others/search",
        dataType: "html",
        data: {"param": param},
        success: function (result) {
            console.log(result);
            if (callback != null) {
                callback();
            }
        },
        error: function (e) {
            console.log(e);
        },
    });
}

function ApplyToCompany(
    resumenum, resumeid, joboffernum, jobofferid, callback = null) {

    $.ajax({
        type: "get",
        url: "controller/favorite/add",
        dataType: "html",
        data:
            {
                "employeenum": resumenum,
                "employeeid": resumeid,
                "employernum": joboffernum,
                "employerid": jobofferid,
            },
        success: function (result) {
            console.log(result);
            if (callback != null) {
                callback();
            }
        },
        error: function (e) {
            console.log(e);
        },
    });
}