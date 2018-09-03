function getParameter(str){
    var name = "?" + str + "=";
    var url = document.location.href;
    var idLocation = "";
    if (url.lastIndexOf(name) < 0){
        return "none";
    }
    while(url.lastIndexOf(name) != url.lastIndexOf("?")){
        url = url.substring(0, url.lastIndexOf("?"));
    }
    if(url.lastIndexOf(name) == url.lastIndexOf("?")){
        idLocation = url.substring(url.lastIndexOf(name)).substring(name.length);
    }
    return idLocation;
}

function getId(){
    return getParameter("id");
}

function getTitle(){
    return getParameter("title");
}

function getById(){
    $(function(){
        $(function(){
            var path = "../rest/bookrest/get/" + getId();
            $.getJSON(path, function(json) {
                  var type = json.type;
                  var id = json.id;
                  var price = json.price;
                  var title = json.title;
                  $("#tbody").append("<tr><td>" + id + "</td><td>" + title + "</td><td><a href=\"detail.html?id=" + id + "\">detail</td></tr>");
            });
        });
    });
}

function getAll(){
    $(function(){
        $(function(){
            var path = "../rest/bookrest/get/all";
            $.getJSON(path, function(json) {
                $.each(json, function(i, item){
                  var type = item.type;
                  var id = item.id;
                  var price = item.price;
                  var title = item.title;
                  $("#tbody").append("<tr><td>" + id + "</td><td>" + title + "</td><td><a href=\"detail.html?id=" + id + "\">detail</td></tr>");
                });
            });
        });
    });
}

function getByTitle(title){
    $(function(){
        $(function(){
            var path = "../rest/bookrest/title/" + title;
            $.getJSON(path, function(json) {
                $.each(json, function(i, item){
                  var type = item.type;
                  var id = item.id;
                  var price = item.price;
                  var title = item.title;
                  $("#tbody").append("<tr><td>" + id + "</td><td>" + title + "</td><td><a href=\"detail.html?id=" + id + "\">detail</td></tr>");
                });
            });
        });
    });
}

function displayBooks(){
    var message = "";
    var parameter = getId();
    if (parameter == "none"){
        parameter = getTitle();
        if (parameter != "none"){
            getByTitle(parameter);
        }
    } else if(parameter == "all"){
        if(getTitle() != "none"){
            getAll();
        } else {
            getByTitle();
        }
    } else {
        getById();
    }
}

function displayBooks(){
    $(function(){
        $(function(){
            var path = "../rest/bookrest/get/" + getId();
            $.getJSON(path, function(json) {
                $("#id").append(json.id);
                $("#title").append(json.title);
                $("#price").append(json.price);
            });
        });
    });

};

//getById(4);
displayBooks();
displayBookDetails();


/*$(function(){
    $("#tr").append("<td>test</td><td>test</td><td>test</td>");
});*/
