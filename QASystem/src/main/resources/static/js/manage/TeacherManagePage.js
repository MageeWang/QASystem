$("#deptDrop").change(function (e) {
    if($("#deptDrop").val()===""){
        $("table#teacherTable").html("");
        return;
    }
    $.ajax({
        type : "POST",
        url : "/rest/getTeacherList",
        data: JSON.stringify({
            "Did": $("#deptDrop").val()
        }),
        dataType : "json",
        contentType : "application/json",
        success: function (data) {
            var list = data.TeacherList;
            console.log(list);
            var table = "<thead>课程列表：</thead>" +
                "<tr>" +
                "<td style='width: 20%'>工号</td>" +
                "<td style='width: 20%'>姓名</td>" +
                "<td style='width: 20%'>教师信息</td>" +
                "<td style='width: 20%'>职称</td>" +
                "<td style='width: 20%'>" +
                "<button id='addNewTeacher'>添加</button></td>" +
                "</tr>";
            for(var i = 0;i<list.length;i++){
                table = table+"<tr id='tr_"+list[i].tid+"'>" +
                    "<td style='width: 20%'>"+list[i].tid+"</td>" +
                    "<td style='width: 20%'>"+list[i].tname+"</td>" +
                    "<td style='width: 20%'>"+list[i].tinfo+"</td>" +
                    "<td style='width: 20%'>"+list[i].tlevel+"</td>" +
                    "<td style='width: 20%'>"+
                    "<button id='editTeacher' value='"+list[i].tid+"'>修改</button>" +
                    "<button id='addTeachInTeacher' value='"+list[i].tid+"'>添加课程</button>" +
                    "<button id='deleteTeacher' value='"+list[i].tid+"'>删除</button>" +
                    "</td>" +
                    "</tr>";
            }
            $("#teacherTable").empty();
            $("#teacherTable").html(table);
            $("#addNewTeacher").click(function (e) {
                var form =
                    "工号：<input type='text' id='addTid'><br>" +
                    "姓名：<input type='text' id='addTname'><br>" +
                    "信息：<input type='text' id='addTinfo'><br>" +
                    "职称：<select id='addTlevel'><option></option><option>讲师</option><option>副教授</option><option>教授</option></select>" +
                    "<br><button id='addTeacherSubmit'>提交</button>";
                $("#addTeacher").html(form);
                $("#addTeacherSubmit").click(function () {
                    if($("#addTid").val()===""||$("#addTname").val()===""||$("#addTinfo").val()===""||$("#addTlevel").val()===""){
                        alert("请将信息填写完整！");
                        return;
                    }
                    $.ajax({
                        type : "POST",
                        url : "/manage/addTeacher",
                        data: JSON.stringify({
                            "Did": $("#deptDrop").val(),
                            "Tid": $("#addTid").val(),
                            "Tname": $("#addTname").val(),
                            "Tpsw": "123",
                            "Tinfo": $("#addTinfo").val(),
                            "Tlevel": $("#addTlevel").val()
                        }),
                        dataType : "json",
                        contentType : "application/json",
                        success: function (data) {
                            if(data.result==1) {
                                alert("添加成功！");
                            }else {
                                alert("添加失败！");
                            }
                            window.location.href="/manage/teacher";
                        }
                    });
                });
            });

            $("button#addTeachInTeacher").click(function (e) {
                window.location.href="/teacher?Tid="+e.target.value;
            });

            $("button#deleteTeacher").click(function (e) {
                $.ajax({
                    type : "POST",
                    url : "/manage/deleteTeacher",
                    data: JSON.stringify({
                        "Tid": e.target.value,
                    }),
                    dataType : "json",
                    contentType : "application/json",
                    success: function (data) {
                        alert("删除成功！");
                        window.location.href="/manage/teacher";
                    }
                });
            });

            $("button#editTeacher").click(function (e) {
                if(window.lock1){
                    alert("请先完成其他修改！");
                    return;
                }
                window.lock1 = true;
                $.ajax({
                    type: "POST",
                    url: "/rest/getTeacherByTid",
                    data: JSON.stringify({
                        "Tid": e.target.value
                    }),
                    dataType: "json",
                    contentType: "application/json",
                    success: function (data){
                        var editTr = "";
                        var teacher = data.teacher;
                        var tid = teacher.tid;
                        var tname = teacher.tname;
                        var tinfo = teacher.tinfo;
                        var tlevel = teacher.tlevel;
                        editTr = editTr + "<td style='width: 20%'>" + tid + "</td>" +
                            "<td style='width: 20%'><input type='text' value='" + tname + "' id='editTname' style='width: 100%;margin=0;padding: 0;'></td>" +
                            "<td style='width: 20%'><input type='text' value='" + tinfo + "' id='editTinfo' style='width: 100%;margin=0;padding: 0;'></td>" +
                            "<td style='width: 20%'><input type='text' value='" + tlevel + "' id='editTlevel' style='width: 100%;margin=0;padding: 0;'></td>" +
                        "<td><button value='" + tid + "' id='editTinfoSubmit'>确认</button></td>";
                        var teacherTr = "tr#tr_" + tid;
                        $(teacherTr).empty();
                        $(teacherTr).html(editTr);
                        $("button#editTinfoSubmit").click(function (e) {
                            window.lock1 = false;
                            $.ajax({
                                type: "POST",
                                url: "/manage/editTeacher",
                                data: JSON.stringify({
                                    "Did": $("#deptDrop").val(),
                                    "Tid": e.target.value,
                                    "Tname": $("#editTname").val(),
                                    "Tinfo": $("#editTinfo").val(),
                                    "Tlevel": $("#editTlevel").val()
                                }),
                                dataType: "json",
                                contentType: "application/json",
                                success: function (data) {
                                    if(data.result===1){
                                        alert("修改成功！");
                                    }else{
                                        alert("修改失败!");
                                    }
                                    window.location.href = "/manage/teacher";
                                }
                            });
                        });
                    }
                });
            });

        }
    });
});