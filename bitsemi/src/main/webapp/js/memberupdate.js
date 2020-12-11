$(function () {

    $("#memberupdatefrombtn").click(function () {
        console.log("btn click")
        var id = $(this).attr("name");
        console.log(id);
        callmyinformation(id);
    });

    $("#memberupdate_form").submit(function (e) {
        e.preventDefault();
        var num = $(this).find("input[name='num']").val();
        var id = $(this).find("input[name='id']").val();
        var name = $(this).find("input[name='name']").val();
        var age = $(this).find("input[name='age']").val();
        var phonenum = $(this).find("input[name='phonenum']").val();
        var email = $(this).find("input[name='email']").val();
        var gender = $(this).find("input[name='gender']:checked").val();
        var ishire = $(this).find("input[name='ishire']:checked").val();

        var pass = $(this).find("input[name='pass']").val();
        var passrepeat = $(this).find("input[name='pwrepeat']").val();

        console.log(num, id, name, age);
        console.log(phonenum, email, gender, ishire);
        console.log(pass, passrepeat);

        submitMemberUpdateForm(num, id, name, age
            , phonenum, email, gender, ishire, function () {
                location.href = "index.jsp?main=mypage/mypage.jsp";
            });
    })
});

function callmyinformation(id) {
    $.ajax({
        type: "post",
        url: "controller/member/getall",
        dataType: "html",
        data: {
            "id": id
        },
        success: function (result) {
            console.log("success");
            location.href = "index.jsp?main=updateform/memberupdateform.jsp";
        }
    });
}

function submitMemberUpdateForm(num, id, name, age
    , phonenum, email, gender, ishire, callback = null) {
    $.ajax({
        type: "post",
        url: "controller/member/update",
        dataType: "html",
        data: {
            "num": num,
            "id": id,
            "name": name,
            "age": age,
            "phonenum": phonenum,
            "email": email,
            "gender": gender,
            "ishire": ishire,
        },
        success: function (result) {
            console.log("success");
            if (callback != null) {
                callback();
            }
            // location.href = "index.jsp?main=updateform/memberupdateform.jsp";
        }
    });
}