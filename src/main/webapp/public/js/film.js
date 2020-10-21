const BASE_URL = "http://localhost:8080/api"

const  FILM_URL = BASE_URL+"/film"
$(function () {
    var url = location.href;
    // alert(url);
    var id = url.substring(url.lastIndexOf('=')+1);
    alert(id)

    $.get(FILM_URL,function (result) {
        if(result.status === 200){
            showData(result.data);
        }else {
            alert("网络错误，请稍后再试！！！")
        }
    });

    function showData(data) {
        $("#name").append(
            $("<p>").text()
        )
    }
});