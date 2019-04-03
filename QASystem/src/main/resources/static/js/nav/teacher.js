$("#deptDrop").change(function (e) {
    if($("#deptDrop").val()===""){
        $("#teacherTable").html("");
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
            var table = "<li>教师列表：</li>";
            for(var i = 0;i<list.length;i++){
                table = table +
                    "<li><a href='/teacher?Tid="+list[i].tid+"'>"+ list[i].tname +"</li>";
            }
            console.log(table);
            $("#teacherTable").empty();
            $("#teacherTable").html(table);
        }
    });
});


$("#addTeach").click(function (e) {
    if($("#courseDrop").val()===""){
        alert("请选择课程！");
        return;
    }
    $.ajax({
        type : "POST",
        url : "/manage/addTeach",
        data: JSON.stringify({
            "Cid": $("#courseDrop").val(),
            "Tid": e.target.value
        }),
        dataType : "json",
        contentType : "application/json",
        success: function (data) {
            if(data.result===1){
                alert("添加成功！");
                window.location.href="/manage";
            }else{
                alert("已有该课程！");
            }
        }
    });
});