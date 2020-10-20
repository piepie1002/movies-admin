const BASE_URL = "http://localhost:8080/api"
const BASE_IMG_URL = "http://119.23.190.71:8089/im/"
let SORT_URL =BASE_URL+"/sort"
$(function () {
    $.get(SORT_URL,function (result) {
        if (result.status ===200){
            var cateLogs = result.data.cateLogs;
            var locs = result.data.locs;
            showCateLogData(cateLogs);
            allCateLogData(cateLogs);
            sortCateLogData(cateLogs);
            showArea(locs);
        }else {
            alert("系统繁忙,请稍后再试");
        }
    });
    function showCateLogData(cateLogs) {
        for (const cate of cateLogs) {
            $("#sort-ul1").append(
                $("<li class='nav-item'>")
                    .append(
                        $("<a>")
                            .addClass("nav-link")
                            .attr("href","cate.html?cateId="+cate.id)
                            .text(cate.name)
                    )
            )
        }
    }
    /*<a href="xl/1.html?cataLog_id=f39c979857a4c8c50157a8eaaee30019"><li>动漫</li></a>*/
    function allCateLogData(cateLogs) {
        for (const cate of cateLogs) {
            $("#sort-ul2").append(
                $("<a>")
                    .attr("href","xl/l.html?cateLog_id="+cate.id)
                    .append(
                        $("<li>").text(cate.name)
                    )
            )
        }
    }
    /*<a href="xl/1.html?cataLog_id=f39c979857a4c8c50157a8eaaee30019">
        <li id="cataLog_idf39c979857a4c8c50157a8eaaee30019">动漫</li></a>*/
    function sortCateLogData(cateLogs) {
        for (const cate of cateLogs) {
            $("#sort-ul3").append(
                $("<a>")
                    .attr("href","xl/l.html?cateLog_id="+cate.id)
                    .append(
                        $("<li>")
                            .attr("id","cateLog_id"+cate.id)
                            .text(cate.name)
                    )
            )
        }
    }
   /* <a href="xl/1.html?loc_id=0ecfa003a636b90ed367e5e7dabf3a75">
        <li id="loc_id0ecfa003a636b90ed367e5e7dabf3a75">香港</li></a>*/
    function showArea(locs) {
        for (const loc of locs) {
            $("#sort-ul4").append(
                $("<a>")
                    .attr("href","xl/l.html?loc_id="+loc.id)
                    .append(
                        $("<li>")
                            .attr("id","loc_id"+loc.id)
                            .text(loc.name)
                    )
            )
        }
    }
    /*<a href="xl/1.html?cataLog_id=f39c979857a4874a0157a4a6a4fe0000&subClass_id=f39c979857a4874a0157a4a723560001">
        <li id="subClass_idf39c979857a4874a0157a4a723560001">动作片</li></a>*/
    function showSubClass(subClass) {
        
    }
})
