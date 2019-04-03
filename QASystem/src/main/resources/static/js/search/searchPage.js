$("button#searchButton").click(function (e) {
    $("#searchResult").empty();
    var searchParam = $("#searchParam").val();
    var option = $("#searchType").val();
    var stype;
    if(option==="所有"){
        stype = "*";
    }else if(option==="学院"){
        stype = "Dname";
    }else if(option==="课程"){
        stype = "Cname";
    }else if(option==="教师"){
        stype = "Tname";
    }else if(option==="内容"){
        stype = "All";
    }
    $.ajax({
        type : "POST",
        url : "/rest/getSearchList",
        data: JSON.stringify({
            "searchType" : stype,
            "searchParam" : searchParam
        }),
        dataType : "json",
        contentType : "application/json",
        success: function (data) {
            var list = data.SearchList;
            if(list.length==0){
                $("div#searchResult").empty();
                $("div#searchResult").html("<span>没有搜索到结果！</span>");
                return;
            }else{
                var searchResult = "";
                for(var i=0;i<list.length;i++){
                    searchResult = searchResult +
                        "<div>" +
                        "<a href='/question?Qid="+list[i].qid+"'><h4><span>"+list[i].qtitle+"</span></h4></a>" +
                        "<p><span>提问者:" + list[i].sname + " 同学</span></p>" +
                        "<p><span>Tag："+ list[i].dname + " " + list[i].cname +"</span></p>" +
                        "</div>";
                }
                $("div#searchResult").empty();
                $("div#searchResult").html(searchResult);
            }
        }
    });
});