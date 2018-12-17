$("#addDept").click(function (e) {
    if($("#Did").val()!==""&&$("#Dname").val()!==""&&$("#Dinfo").val()!=="") {
        $.ajax({
            type : "POST",
            url : "/manage/addDept",
            data: JSON.stringify({
                "Did": $("#Did").val(),
                "Dname": $("#Dname").val(),
                "Dinfo": $("#Dinfo").val()
            }),
            dataType : "json",
            contentType : "application/json",
            success: function (data) {
                if(data.result==1) {
                    alert("添加成功！");
                    $("#Did").val("");
                    $("#Dname").val("");
                    $("#Dinfo").val("");
                }else {
                    alert("添加失败！");
                    $("#Did").val("");
                    $("#Dname").val("");
                    $("#Dinfo").val("");
                }
            }
        });
    }else{
        alert("请将信息填写完整！");
    }
});