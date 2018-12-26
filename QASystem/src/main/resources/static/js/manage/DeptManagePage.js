$("#addDept").click(function (e) {
    var oldHTML = $("table#deptTable").html();
    var addTr = "<tr>";
    addTr = addTr +
        "<td><input type='text' id='addDid' style='width: 100%;'></td>" +
        "<td><input type='text' id='addDname' style='width: 100%;'></td>" +
        "<td><input type='text' id='addDinfo' style='width: 100%;'></td>" +
        "<td><button id='addOneDept'>确认</button></td>";
    addTr = addTr + "</tr>";
    $("table#deptTable").empty();
    $("table#deptTable").html(oldHTML+addTr);
    $("#addOneDept").click(function (e) {
        if ($("#addDid").val()==="" && $("#addDname").val()==="" && $("#addDinfo").val()==="") {
            window.location.href="/manage/dept";
        }else{
            if($("#addDid").val()==="" || $("#addDname").val()==="" || $("#addDinfo").val()===""){
                alert("请将信息填完整！");
                return
            }else{
                $.ajax({
                    type : "POST",
                    url : "/manage/addDept",
                    data: JSON.stringify({
                        "Did": $("#addDid").val(),
                        "Dname": $("#addDname").val(),
                        "Dinfo": $("#addDinfo").val()
                    }),
                    dataType : "json",
                    contentType : "application/json",
                    success: function (data) {
                        if(data.result==1) {
                            alert("添加成功！");
                        }else {
                            alert("添加失败！");
                        }
                        window.location.href="/manage/dept";
                    }
                });
            }
        }
    });
});

window.lock1 = false;

$("button#editDept").click(function (e) {
    if(window.lock1){
        alert("请先完成其他修改！");
        return;
    }
    window.lock1 = true;
    $.ajax({
        type: "POST",
        url: "/rest/getDeptByDid",
        data: JSON.stringify({
            "Did": e.target.value
        }),
        dataType: "json",
        contentType: "application/json",
        success: function (data){
            var editTr = "";
            var dept = data.dept;
            var did = dept.did;
            var dname = dept.dname;
            var dinfo = dept.dinfo;
            editTr = editTr + "<td>" + did + "</td>" +
                "<td><input type='text' value='" + dname + "' id='editDname' style='width: 100%;margin=0;padding: 0;'></td>" +
                "<td><input type='text' value='" + dinfo + "' id='editDinfo' style='width: 100%;margin=0;padding: 0;'></td>" +
                "<td><button value='" + did + "' id='editDinfoSubmit'>确认</button></td>";
            var deptTr = "tr#tr_" + did;
            $(deptTr).empty();
            $(deptTr).html(editTr);
            $("button#editDinfoSubmit").click(function (e) {
                window.lock1 = false;
                $.ajax({
                    type: "POST",
                    url: "/manage/editDept",
                    data: JSON.stringify({
                        "Did": e.target.value,
                        "Dname": $("#editDname").val(),
                        "Dinfo": $("#editDinfo").val()
                    }),
                    dataType: "json",
                    contentType: "application/json",
                    success: function (data) {
                        if(data.result===1){
                            alert("修改成功！");
                        }else{
                            alert("修改失败!");
                        }
                        window.location.href = "/manage/dept";
                    }
                });
            });

        }
    });
});