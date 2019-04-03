$("button#postAnswer").click(function(e){
    if($("#Atext").text()===""){
        alert("不能提交空回答！");
        return;
    }
    $.ajax({
        type : "POST",
        url : "/addAnswer",
        data: JSON.stringify({
            "Qid": e.target.value,
            "Atext": $("#Atext").text()
        }),
        dataType : "json",
        contentType : "application/json",
        success: function (data) {
            alert("回答成功！");
            window.location.href="/question?Qid="+e.target.value;
        }
    });
});

$("button#editAnswer").click(function (e) {
    $.ajax({
        type : "POST",
        url : "/rest/getAnswer",
        data: JSON.stringify({
            "Qid": e.target.value
        }),
        dataType : "json",
        contentType : "application/json",
        success: function (data) {
            console.log(data);
            var form = "<div id='Atext' contenteditable='true' class='qtext'>"+data.Answer.atext+"</div><br>" +
                "<button id='postEditAnswer' value='"+e.target.value+"'>修改回答</button>";
            $("div#editForm").html(form);
            $("button#postEditAnswer").click(function (e) {
                $.ajax({
                    type : "POST",
                    url : "/editAnswer",
                    data: JSON.stringify({
                        "Qid": e.target.value,
                        "Atext": $("#Atext").text()
                    }),
                    dataType : "json",
                    contentType : "application/json",
                    success: function (data) {
                        alert("修改成功！");
                        window.location.href="/question?Qid="+data.Qid;
                    }
                });
            });
        }
    });
});

$("button#deleteAnswer").click(function (e) {
    $.ajax({
        type : "POST",
        url : "/deleteAnswer",
        data: JSON.stringify({
            "Qid": e.target.value,
        }),
        dataType : "json",
        contentType : "application/json",
        success: function (data) {
            alert("删除成功！");
            window.location.href="/question?Qid="+data.Qid;
        }
    });
});