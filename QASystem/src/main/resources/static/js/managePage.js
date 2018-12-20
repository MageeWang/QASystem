// $("a#deptManage").click(function(e){
//     $.ajax({
//         type : "POST",
//         url : "/rest/getDeptList",
//         data: JSON.stringify({
//         }),
//         dataType : "json",
//         contentType : "application/json",
//         success: function (data) {
//             var table = "";
//             var list = data.DeptList;
//             table = table +
//                 "<tr><td>学院号</td><td>学院名</td><td>学院简介</td></tr>"
//             for(var i=0;i<list.length;i++){
//                 table = table + "<tr>" +
//                 "<td>" + list[i].did + "</td>" +
//                 "<td>" + list[i].dname + "</td>" +
//                 "<td>" + list[i].dinfo + "</td>" +
//                 "</tr>";
//             }
//             $("table#myTable").html("");
//             $("div#myForm").html("");
//             $("table#myTable").html(table);
//             $("div#myForm").html("<p>添加学院信息</p>\n" +
//                 "    学院号：<input type=\"text\" name=\"Did_0\" id=\"Did_0\"><br>\n" +
//                 "    学院名：<input type=\"text\" name=\"Dname_0\" id=\"Dname_0\"><br>\n" +
//                 "    学院信息：<input type=\"text\" name=\"Dinfo_0\" id=\"Dinfo_0\"><br>\n" +
//                 "    <button id=\"addDept\">添加</button>"
//             );
//             $("#addDept").click(function (e) {
//                 if($("#Did_0").val()!==""&&$("#Dname_0").val()!==""&&$("#Dinfo_0").val()!=="") {
//                     $.ajax({
//                         type : "POST",
//                         url : "/manage/addDept",
//                         data: JSON.stringify({
//                             "Did": $("#Did_0").val(),
//                             "Dname": $("#Dname_0").val(),
//                             "Dinfo": $("#Dinfo_0").val()
//                         }),
//                         dataType : "json",
//                         contentType : "application/json",
//                         success: function (data) {
//                             if(data.result==1) {
//                                 alert("添加成功！");
//                             }else {
//                                 alert("添加失败！");
//                             }
//                             $("#Did_0").val("");
//                             $("#Dname_0").val("");
//                             $("#Dinfo_0").val("");
//                         }
//                     });
//                 }else{
//                     alert("请将信息填写完整！");
//                 }
//             });
//         }
//     });
// });
//
// $("a#majorManage").click(function(e){
//     $.ajax({
//         type : "POST",
//         url : "/rest/getDeptList",
//         data: JSON.stringify({
//         }),
//         dataType : "json",
//         contentType : "application/json",
//         success: function (data) {
//             var dropList = "";
//             var list = data.DeptList;
//             dropList = dropList + "<select id='Did_1'>";
//             for(var i = 0;i<list.length;i++){
//                 dropList = dropList + "<option value='"+list[i].did+"'>" +
//                     list[i].dname+"</option>";
//             }
//             dropList = dropList + "</select>";
//             console.log(dropList);
//             $("table#myTable").html("");
//             /*
//             ==============================================================
//              */
//             $("div#myForm").html("");
//             $("myDiv").html(dropList);
//             $("select#Did_1").change(function () {
//                 $.ajax({
//                     type: "POST",
//                     url: "/rest/getMajorList",
//                     data: JSON.stringify({
//                         "Did" : $("select#Did_1").val()
//                     }),
//                     dataType: "json",
//                     contentType: "application/json",
//                     success: function (data) {
//                         var table = "";
//                         var list = data.MajorList;
//                         table = table +
//                             "<tr><td>专业号</td><td>专业名</td><td>专业简介</td></tr>"
//                         for(var i=0;i<list.length;i++){
//                             table = table + "<tr>" +
//                                 "<td>" + list[i].mid + "</td>" +
//                                 "<td>" + list[i].mname + "</td>" +
//                                 "<td>" + list[i].minfo + "</td>" +
//                                 "</tr>";
//                         }
//                         $("table#myTable").html(table);
//                     }
//                 });
//             });
//             $("div#myForm").html("<p>添加专业信息</p>\n" +
//                 "    专业号：<input type=\"text\" name=\"Did_0\" id=\"Did_0\"><br>\n" +
//                 "    专业名：<input type=\"text\" name=\"Dname_0\" id=\"Dname_0\"><br>\n" +
//                 "    专业信息：<input type=\"text\" name=\"Dinfo_0\" id=\"Dinfo_0\"><br>\n" +
//                 "    <button id=\"addDept\">添加</button>"
//             );
//             $("#addMajor").click(function (e) {
//                 if($("#Did_1").val()!==""&&$("#Mid_1").val()!==""&&$("#Mname_1").val()!==""&&$("#Minfo_1").val()!=="") {
//                     $.ajax({
//                         type : "POST",
//                         url : "/manage/addMajor",
//                         data: JSON.stringify({
//                             "Did": $("#Did_1").val(),
//                             "Mid": $("#Mid_1").val(),
//                             "Mname": $("#Mname_1").val(),
//                             "Minfo": $("#Minfo_1").val()
//                         }),
//                         dataType : "json",
//                         contentType : "application/json",
//                         success: function (data) {
//                             if(data.result==1) {
//                                 alert("添加成功！");
//                             }else {
//                                 alert("添加失败！");
//                             }
//                             $("#Did_1").val("");
//                             $("#Mid_1").val("");
//                             $("#Mname_1").val("");
//                             $("#Minfo_1").val("");
//                         }
//                     });
//                 }else{
//                     alert("请将信息填写完整！");
//                 }
//             });
//         }
//     });
// });
//
// $("#addCourse").click(function (e) {
//     if($("#Did_2").val()!==""&&$("#Mid_2").val()!==""&&$("#Cid_2").val()!==""&&$("#Cname_2").val()!==""&&$("#Cinfo_2").val()!=="") {
//         $.ajax({
//             type : "POST",
//             url : "/manage/addCourse",
//             data: JSON.stringify({
//                 "Did": $("#Did_2").val(),
//                 "Mid": $("#Mid_2").val(),
//                 "Cid": $("#Cid_2").val(),
//                 "Cname": $("#Cname_2").val(),
//                 "Cinfo": $("#Cinfo_2").val()
//             }),
//             dataType : "json",
//             contentType : "application/json",
//             success: function (data) {
//                 if(data.result==1) {
//                     alert("添加成功！");
//                 }else {
//                     alert("添加失败！");
//                 }
//                 $("#Did_2").val("");
//                 $("#Mid_2").val("");
//                 $("#Cid_2").val("");
//                 $("#Cname_2").val("");
//                 $("#Cinfo_2").val("");
//             }
//         });
//     }else{
//         alert("请将信息填写完整！");
//     }
// });
$("#addDept").click(function (e) {
    if($("#Did").val()!=="" && $("#Dname").val()!=="" && $("#Dinfo").val()!=="") {
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
                }else {
                    alert("添加失败！");
                }
                window.location.href="/manage/dept";
            }
        });
    }else{
        alert("请将信息填写完整！");
    }
});

$("button#editDept").click(function (e) {
    $.ajax({
        type : "POST",
        url : "/rest/getMajorList",
        data: JSON.stringify({
            "Did": e.target.value
        }),
        dataType : "json",
        contentType : "application/json",
        success: function (data) {

        }
    });
});

$("#deptDrop").change(function (e) {
    if($("#deptDrop").val()===""){
        $("table#majorTable").empty();
        return;
    }
    $.ajax({
        type : "POST",
        url : "/rest/getMajorList",
        data: JSON.stringify({
            "Did": $("#deptDrop").val()
        }),
        dataType : "json",
        contentType : "application/json",
        success: function (data) {
            var list = data.CourseList;
            console.log(list);
            var table = "<tr><td>课程号</td><td>课程名</td><td>课程信息</td></tr>";
            for(var i = 0;i<list.length;i++){
                table = table+"<tr>" +
                    "<td>"+list[i].cid+"</td>" +
                    "<td>"+list[i].cname+"</td>" +
                    "<td>"+list[i].cinfo+"</td>" +
                    "<td>"+"<button id='editCourse' value='"+list[i].cid+"'>修改</button>"+"</td>" +
                    "</tr>";
            }
            $("#courseTable").empty();
            $("#courseTable").html(table);
            $("button#editCourse").click(function(e){
                console.log(e.target.value);
                $.ajax({
                    type : "POST",
                    url : "/rest/getMajorList",
                    data: JSON.stringify({
                        "Cid": e.target.value
                    }),
                    dataType : "json",
                    contentType : "application/json",
                    success: function (data) {

                    }
                });
            });
        }
    });
});

$("#addCourse").click(function (e) {
    if($("#deptDrop").val()!=="" && $("#Cid").val()!=="" && $("#Cname").val()!=="" && $("#Cinfo").val()!=="") {
        $.ajax({
            type : "POST",
            url : "/manage/addCourse",
            data: JSON.stringify({
                "Did": $("#deptDrop").val(),
                "Cid": $("#Cid").val(),
                "Cname": $("#Cname").val(),
                "Cinfo": $("#Cinfo").val()
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
    }else{
        alert("请将信息填写完整！");
    }
});