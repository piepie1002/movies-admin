const BASE_URL = "http://localhost:8080/api"

const LIST_URL = BASE_URL+"/list"

$(function () {
    $.get(LIST_URL,function (result) {
        if(result.status === 200){
            showAllData(result.data.films);
        }else{
            alert("网络繁忙，稍后再试！！！")
        }
    });


    /**<li>
     <a href="film.html?film_id=f39c979857a4c8c50157a9020fb8001d">
     <div title="肖申克的救赎"><img src="public/static/upload/filmPic/1476009214377.jpg"></div>
     </a>
     <div class="film-info">
     <a href="film.html?film_id=f39c979857a4c8c50157a9020fb8001d" title="肖申克的救赎">肖申克的救赎</a>
     <p>1994-犯罪片</p>
     </div>
     </li>**/
    function showAllData(films) {
        for(const film of films){
            $("#all-list")
                .append(
                    $("<li>")
                        .append(
                            $("<a>")
                                .attr("href","film.html?film_id="+film.id)
                                .append(
                                    $("<div>")
                                        .attr("title",film.name)
                                        .append(
                                            $("<img>")
                                                .attr("src",film.image)
                                        )
                                )
                        )
                        .append(
                            $("<div class='film-info'>")
                                .append(
                                    $("<a>")
                                        .attr("href","film.html?film_id="+film.id)
                                        .attr("title",film.name)
                                        .text(film.name)
                                        .append(
                                            $("<p>").text(film.onDecade + "-" + film.typeName)
                                        )
                                )
                        )
                )
        }
    }

    $("#btn").click(function () {
        let val = $("#cha").val();
        let param = {
            name:val,
            action:"find"
        };
        // alert(val)
        $.get(LIST_URL,param,function (result) {
            alert(val)
            if(result.status === 200){
                showOneData(result.data);
            }else{
                alert("网络繁忙，稍后再试！！！")
            }
        })
    });

    function showOneData(data) {
        $("#all-list")
            .append(
                $("<li>")
                    .append(
                        $("<a>")
                            .attr("href","film.html?film_id="+data.id)
                            .append(
                                $("<div>")
                                    .attr("title",data.name)
                                    .append(
                                        $("<img>")
                                            .attr("src",data.image)
                                    )
                            )
                    )
                    .append(
                        $("<div class='film-info'>")
                            .append(
                                $("<a>")
                                    .attr("href","film.html?film_id="+data.id)
                                    .attr("title",data.name)
                                    .text(data.name)
                                    .append(
                                        $("<p>").text(data.onDecade + "-" + data.typeName)
                                    )
                            )
                    )
            )
    }


});





