window.lock1 = false;
$("#deptDrop").change(function (e) {
    if($("#deptDrop").val()===""){
        $("table#courseTable").html("");
        return;
    }
    $.ajax({
        type : "POST",
        url : "/rest/getCourseList",
        data: JSON.stringify({
            "Did": $("#deptDrop").val()
        }),
        dataType : "json",
        contentType : "application/json",
        success: function (data) {
            var list = data.CourseList;
            console.log(list);
            var table = "<thead>课程列表：</thead><tr><td>课程号</td><td>课程名</td><td>课程信息</td><td><button id='addNewCourse'>添加</button></td></tr>";
            for(var i = 0;i<list.length;i++){
                table = table+"<tr id='tr_"+list[i].cid+"'>" +
                    "<td>"+list[i].cid+"</td>" +
                    "<td>"+list[i].cname+"</td>" +
                    "<td>"+list[i].cinfo+"</td>" +
                    "<td>"+
                    "<button id='editCourse' value='"+list[i].cid+"'>修改</button>"+
                    "<button id='addTeachInCourse' value='"+list[i].cid+"'>添加教师</button>" +
                    "<button id='deleteCourse' value='"+list[i].cid+"'>删除</button>" +
                    "</td>" +
                    "</tr>";
            }
            $("#courseTable").empty();
            $("#courseTable").html(table);
            $("button#editCourse").click(function (e) {
                if(window.lock1){
                    alert("请先完成其他修改！");
                    return;
                }
                window.lock1 = true;
                $.ajax({
                    type: "POST",
                    url: "/rest/getCourseByCid",
                    data: JSON.stringify({
                        "Cid": e.target.value
                    }),
                    dataType: "json",
                    contentType: "application/json",
                    success: function (data){
                        var editTr = "";
                        var course = data.course;
                        var cid = course.cid;
                        var cname = course.cname;
                        var cinfo = course.cinfo;
                        editTr = editTr + "<td>" + cid + "</td>" +
                            "<td><input type='text' value='" + cname + "' id='editCname' style='width: 100%;margin=0;padding: 0;'></td>" +
                            "<td><input type='text' value='" + cinfo + "' id='editCinfo' style='width: 100%;margin=0;padding: 0;'></td>" +
                            "<td><button value='" + cid + "' id='editCinfoSubmit'>确认</button></td>";
                        var courseTr = "tr#tr_" + cid;
                        $(courseTr).empty();
                        $(courseTr).html(editTr);
                        $("button#editCinfoSubmit").click(function (e) {
                            window.lock1 = false;
                            $.ajax({
                                type: "POST",
                                url: "/manage/editCourse",
                                data: JSON.stringify({
                                    "Did": $("#deptDrop").val(),
                                    "Cid": e.target.value,
                                    "Cname": $("#editCname").val(),
                                    "Cinfo": $("#editCinfo").val()
                                }),
                                dataType: "json",
                                contentType: "application/json",
                                success: function (data) {
                                    if(data.result===1){
                                        alert("修改成功！");
                                    }else{
                                        alert("修改失败!");
                                    }
                                    window.location.href = "/manage/course";
                                }
                            });
                        });
                    }
                });
            });

            $("button#addTeachInCourse").click(function (e) {
                window.location.href="/course?Cid="+e.target.value;
            });

            $("button#deleteCourse").click(function (e) {
                $.ajax({
                    type : "POST",
                    url : "/manage/deleteCourse",
                    data: JSON.stringify({
                        "Cid": e.target.value,
                    }),
                    dataType : "json",
                    contentType : "application/json",
                    success: function (data) {
                        alert("删除成功！");
                        window.location.href="/manage/course";
                    }
                });
            });

            $("#addNewCourse").click(function (e) {
                var oldHTML = $("table#courseTable").html();
                var addTr = "<tr>";
                addTr = addTr +
                    "<td><input type='text' id='addCid' style='width: 100%;'></td>" +
                    "<td><input type='text' id='addCname' style='width: 100%;'></td>" +
                    "<td><input type='text' id='addCinfo' style='width: 100%;'></td>" +
                    "<td><button id='addCourse'>确认</button></td>";
                addTr = addTr + "</tr>";
                $("table#courseTable").empty();
                $("table#courseTable").html(oldHTML+addTr);
                $("#addCourse").click(function (e) {
                    if ($("#addCid").val()==="" && $("#addCname").val()==="" && $("#addCinfo").val()==="") {
                        window.location.href="/manage/course";
                    }else{
                        if($("#addCid").val()==="" || $("#addCname").val()==="" || $("#addCinfo").val()===""){
                            alert("请将信息填完整！");
                            return
                        }else{
                            $.ajax({
                                type : "POST",
                                url : "/manage/addCourse",
                                data: JSON.stringify({
                                    "Did": $("#deptDrop").val(),
                                    "Cid": $("#addCid").val(),
                                    "Cname": $("#addCname").val(),
                                    "Cinfo": $("#addCinfo").val()
                                }),
                                dataType : "json",
                                contentType : "application/json",
                                success: function (data) {
                                    if(data.result==1) {
                                        alert("添加成功！");
                                    }else {
                                        alert("添加失败！");
                                    }
                                    window.location.href="/manage/course";
                                }
                            });
                        }
                    }
                });
            });
        }
    });
});