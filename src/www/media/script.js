function getPath(){
    var res = "";
    var url = document.location.href;
    var param = url.substring(url.lastIndexOf("=")+1);
    return param;
}

function getById(id){
    $(function(){
        $(function(){
            var path = "../rest/bookrest/get/" + id;
            $.getJSON(path, function(result){
                $.each(result, function(i, field){
                    $("#details").append(field + " ");
                });
                $("#details").append("<br>");
            });
        });
    });
}

/*function newGetById(id){
    $(function(){
        $(function(){
            var path = "../rest/bookrest/get/" + id;
            $.getJSON(path, function(result){
                $.each(result, function(i, field){
                var item =
                    //$("#details").append(field + " ");
                });
                $("#details").append(item + "<br>");
            });
        });
    });
}*/

function executeQuery(){
    var param = getPath();
    if(param == "all"){
        var count = 1;
        while(count <= 10){
            getById(count);
            ++count;
        }
    } else {
        getById(param);
    }
}

executeQuery();