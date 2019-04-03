$("#deptDrop").change(function () {
    if($("#deptDrop").val()===""){
        $("#courseTable").html("");
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
            var table = "<tr><td>课程号</td><td>课程名</td><td>课程信息</td></tr>";
            for(var i = 0;i<list.length;i++){
                table = table+"<tr>" +
                    "<td>"+list[i].cid+"</td>" +
                    "<td>"+list[i].cname+"</td>" +
                    "<td>"+list[i].cinfo+"</td>" +
                    "<td><a href='course?Cid="+list[i].cid+"' id='href'>进入</a></td>" +
                    "</tr>";
            }
            console.log(table);
            $("table#courseTable").empty();
            $("table#courseTable").html(table);
        }
    });
});

$("#addTeach").click(function (e) {
    if($("#teacherDrop").val()===""){
        alert("请选择教师！");
        return;
    }
    $.ajax({
        type : "POST",
        url : "/manage/addTeach",
        data: JSON.stringify({
            "Tid": $("#teacherDrop").val(),
            "Cid": e.target.value
        }),
        dataType : "json",
        contentType : "application/json",
        success: function (data) {
            if(data.result===1){
                alert("添加成功！");
                window.location.href="/manage";
            }else{
                alert("已有该教师！");
            }
        }
    });
});