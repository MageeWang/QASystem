$("#Register").click(function (e) {
    if($("#Sid").val()!==""&&$("#Sname").val()!==""&&$("#Spsw").val()!==""&&$("#Did").val()!==""&&$("#Syear").val()!==""){
        $.ajax({
            type : "POST",
            url : "/registerconfirm",
            data : JSON.stringify({
                "Sid" : $("#Sid").val(),
                "Sname" : $("#Sname").val(),
                "Spsw" : $("#Spsw").val(),
                "Did" : $("#Did").val(),
                "Syear" : $("#Syear").val()
            }),
            dataType : "json",
            contentType:'application/json',
            success : function(data) {
                if (data.result == "1") {
                    alert("注册成功！");
                    window.location.href="/login";
                } else {
                    alert("注册失败！");
                }
            }
        });
    }else{
        alert("账号密码不能为空！");
    }
});

$("#Login").click(function (e) {
    window.location.href="/login";
});
