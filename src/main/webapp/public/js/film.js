const BASE_URL = "http://localhost:8080/api"

const  FILM_URL = BASE_URL+"/film"
$(function () {
    var url = location.href;
    // alert(url);
    var id = url.substring(url.lastIndexOf('=')+1);

    let param = {
        id:id
    }
    //将id携带给下一个页面
    $("#send").attr("href","modify-film.html?film_id="+id)

    $.get(FILM_URL,param,function (result) {
        if(result.status === 200){
            showData(result.data);
        }else {
            alert("网络错误，请稍后再试！！！")
        }
    });

    function showData(data) {
        $("#name").append(
            $("<p>").text(data.name)
        )
        $("#img").append(
            $("<img>").attr("src",data.image)
        )
        $("#on-decade").append(
            $("<p>").text(data.onDecade)
        )
        $("#status").append(
            $("<p>").text(data.status)
        )
        $("#resolution").append(
            $("<p>").text(data.resolution)
        )
        $("#type-name").append(
            $("<p>").text(data.typeName)
        )
        $("#actor").append(
            $("<p>").text(data.actor)
        )
        $("#loc-name").append(
            $("<p>").text(data.locName)
        )
        $("#plot").append(
            $("<span style='color: rgb(74, 74, 74); font-family: 微软雅黑; font-size: 12px; text-align: center; background-color: rgb(255, 255, 255);'>")
                .text(data.plot)
        )
    }
});