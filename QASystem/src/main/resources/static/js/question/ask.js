$("#deptDrop").change(function (e) {
    if($("#deptDrop").val()===""){
        $("select#courseDrop").html("<option></option><option>请先选择院属</option>");
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
            var select = "<option></option>";
            for(var i = 0;i<list.length;i++){
                select = select+
                    "<option value='"+list[i].cid+"'>"+list[i].cname+"</option>";
            }
            $("#courseDrop").empty();
            $("#courseDrop").html(select);
        }
    });
});

$("button#postQuestion").click(function(e){
    if($("#deptDrop").val()===""||$("#courseDrop").val()===""||$("#Qtitle").val()===""||$("#Qtext").text()===""){
        alert("请将内容填写完整！");
        return;
    }
    $.ajax({
        type : "POST",
        url : "/addQuestion",
        data: JSON.stringify({
            "Did": $("#deptDrop").val(),
            "Cid": $("#courseDrop").val(),
            "Qtitle": $("#Qtitle").val(),
            "Qtext": $("#Qtext").text()
        }),
        dataType : "json",
        contentType : "application/json",
        success: function (data) {
            if($("#uploadFile")!=null){
                var type = "file";
                var id = "uploadFile";
                var formData = new FormData();
                formData.append(type, $("#"+id)[0].files[0]);
                $.ajax({
                    type: "POST",
                    url: '/uploadFile',
                    data: formData,
                    processData: false,
                    contentType: false,
                    success: function (data) {
                        alert(data);
                    }
                });
            }
            alert("提问成功！");
            window.location.href="/";
        }
    });
});

$("button#editQuestion").click(function(e){
    if($("#Qtitle").val()===""||$("#Qtext").text()===""){
        alert("请将内容填写完整！");
        return;
    }
    $.ajax({
        type : "POST",
        url : "/editQuestion",
        data: JSON.stringify({
            "Qid": e.target.value,
            "Qtitle": $("#Qtitle").val(),
            "Qtext": $("#Qtext").text()
        }),
        dataType : "json",
        contentType : "application/json",
        success: function (data) {
            if($("#uploadFile")!=null){
                var type = "file";
                var id = "uploadFile";
                var formData = new FormData();
                formData.append(type, $("#"+id)[0].files[0]);
                formData.append("Qid",e.target.value);
                $.ajax({
                    type: "POST",
                    url: '/editFile',
                    data: formData,
                    processData: false,
                    contentType: false,
                    success: function (data) {
                        alert(data);
                    }
                });
            }
            alert("修改成功！");
            window.location.href="/question?Qid="+data.Qid;
        }
    });
});