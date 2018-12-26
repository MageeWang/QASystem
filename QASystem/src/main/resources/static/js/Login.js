$("#Login").click(function (e) {
    if($("#username").val()!==""&&$("#password").val()!==""){
        $.ajax({
            type : "POST",
            url : "/loginconfirm",
            data : JSON.stringify({
                "username" : $("#username").val(),
                "password" : $("#password").val(),
                "iden" : $('input[type=radio][name=iden]:checked').val()
            }),
            dataType : "json",
            contentType:'application/json',
            success : function(data) {
                if (data.result == "1") {
                    window.location.href = "/";
                } else {
                    alert("账号密码错误！");
                    $("#password").val("");
                }
            }
        });
    }else{
        alert("账号密码不能为空！");
    }
});

$("#Register").click(function (e) {
    window.location.href="/register";
});
