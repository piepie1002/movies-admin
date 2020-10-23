const BASE_URL = "http://localhost:8080/api"
const BASE_IMG_URL = "http://119.23.190.71:8089/im/"
let SORT_URL =BASE_URL+"/sort"
$(function () {
    $.get(SORT_URL,function (result) {
        if (result.status ===200){
            var cateLogs = result.data.cateLogs;
            var locs = result.data.locs;
            var dataList = result.data.pageBean.dataList;
            var bean = result.data.pageBean;
            showCateLogData(cateLogs);
            allCateLogData(cateLogs);
            sortCateLogData(cateLogs);
            showArea(locs);
            showSubClass(result.data.subClasses);
            showDecade(result.data.decades);
            showSortFilm(dataList);
            sortPage(dataList,bean);
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
                            .attr("href","cate.html?cateLog_id="+cate.id)
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
    function showSubClass(subClasses) {
        for (const subClass of subClasses) {
            $("#sort-sub").append(
                $("<a>")
                    .attr("href","xl/l.html?cateLog_id="+subClass.id)
                    .append(
                        $("<li>")
                            .attr("id","subClass_id"+subClass.id)
                            .text(subClass.name)
                    )
            )
        }
    }
   /* <a href="xl/1.html?onDecade=2018">
        <li id="onDecade2018">2018</li></a>*/
    function showDecade(decades) {
        for (const decade of decades) {
            $("#sort-decade").append(
                $("<a>")
                    .attr("href","xl/l.html?onDecade="+decade.name)
                    .append(
                        $("<li>")
                            .attr("id","onDecade"+decade.name)
                            .text(decade.name)
                    )
            )
        }
    }
    /*<li>
        1.<a href="xl/detail.html?film_id=f39c979857a4c8c50157a9020fb8001d">
            1.1<div  class="note-left" title="肖申克的救赎">
            <img class="lazy rounded img-fluids" data-original="public/static/upload/filmPic/1476009214377.jpg" />
            </div>
        </a>
        2.<div class="film-info">
            2.1<div class="info">
                <h2>
                    <a class="film-info-a" href="xl/detail.html?film_id=f39c979857a4c8c50157a9020fb8001d"
                       title="肖申克的救赎"
                       target="_blank">肖申克的救赎</a>
                     <em> 1994</em>
                </h2>
                <em class="star star4"></em>
                <p>主演： 蒂姆·罗宾斯 Tim Robbins   摩根·弗里曼 Morgan Freeman </p>
                <p><i>状态：全集</i>&nbsp;<i>地区：美国</i></p>
                <p><i>类型：犯罪片</i><i>更新：05-11</i></p>
                <p></p>
                <span>
                    <a href="xl/detail.html?film_id=f39c979857a4c8c50157a9020fb8001d#kan" class="watch-btn" target="_blank">观看</a>
                    <a href="xl/detail.html?film_id=f39c979857a4c8c50157a9020fb8001d#down" class="download-btn" target="_blank">下载</a>
                </span>
            </div>
        </div>
    </li>*/
    function showSortFilm(dataList) {
        for (const sortData of dataList) {
            $("#sort-films").append(
                $("<li>").append(
                    $("<a>")
                        .attr("href","xl/detail.html?film_id="+sortData.id)
                        .append(
                            $("<div class='note-left' >")
                                .attr("title",sortData.name)
                                .append(
                                    $("<img class='lazy rounded img-fluids'>")
                                        .attr("data-original",BASE_IMG_URL+sortData.image)
                                        .attr("src",BASE_IMG_URL + sortData.image)
                                )
                            
                        )
                    
                )
                .append(
                    $("<div class='film-info'>").append(
                        $("<div class='info'>")
                            .append(
                            $("<h2>")
                                .append(
                                    $("<a class='film-info-a'>")
                                        .attr("href","xl/detail.html?film_id="+sortData.id)
                                        .attr("title",sortData.name)
                                        .attr("target","_blank")
                                        .text(sortData.name)
                                )
                                .append(
                                    $("<em>").attr("text",sortData.onDecade)
                                )
                        )
                            .append($("<em class='star star4'>"))
                            .append(
                                $("<p>").text("主演:"+sortData.actor)
                            )
                            .append(
                                $("<p>").append(
                                    $("<i>").text("状态:"+sortData.status)
                                )
                                    .append(
                                        $("<i>").text("地区:"+sortData.locName)
                                    )
                            )
                            .append(
                                $("<p>").append(
                                    $("<i>").text("类型:"+sortData.typeName)

                                )
                                    .append(
                                        $("<i>").text("更新:")
                                    )
                                )
                            .append(
                                $("<p>")
                            )
                            .append(
                                $("<span>")
                                    .append(
                                    $("<a class='watch-btn' target='_blank'>")
                                        .attr("href","xl/detail.html?film_id="+sortData.id+"#kan")
                                        .text("观看")
                                    
                                )
                                    .append(
                                        $("<a class='download-btn' target='_blank'>")
                                            .attr("href","xl/detail.html?film_id="+sortData.id+"#down")
                                            .text("下载")
                                    )
                            )
                    )
                )
            )
        }
    }
    /*<p style="text-align: right;">
        <!--1.修改-->
        <script type="text/javascript">
            function _change() {
            var select = document.getElementById("select");
            location = "xl/1.html?&pc=" + select.value;
        }
        </script>
        第1页/共3页
        <a href="javascript:;" class="nouse-btn">首页</a>&nbsp;
        <a href="javascript:;" class="nouse-btn">上一页</a>
        <a href="javascript:;" class="nouse-btn">1</a>
        <a href="xl/1.html?&pc=2" class="use-btn">2</a>
        <a href="xl/1.html?&pc=3" class="use-btn">3</a>
        <a href="xl/1.html?&pc=2" class="use-btn">下一页</a>&nbsp;
        <a href="xl/1.html?&pc=3" class="use-btn">尾页</a>
        总共46部
    </p>*/
    function sortPage(dataList,bean) {
        $("#sort-page")
                .text("第"+bean.curPage+"页/共"+bean.totalPage+"页")
                .append(
                    $("<a class='nouse-btn' href='javascript:;'>")
                        .text("首页")
                )
                .append(
                    $("<a class='nouse-btn'>")
                        .attr("href","/sort.html?&curPage="+bean.prePage)
                        .text("上一页")
                )
        for (let i = 1; i < bean.totalPage+1; i++) {
            if (i==1){
                $("#sort-page").append(
                    $("<a class='nouse-btn'>")
                        .text(i)
                        .attr("href","javascript:;")
                )
            }else {
                $("#sort-page").append(
                    $("<a class='use-btn'>")
                        .text(i)
                        .attr("href","/sort.html?&curPage="+i)
                )
            }
        }
        $("#sort-page").append(
            $("<a class='use-btn'>")
                .attr("href","/sort.html?&curPage="+bean.curPage+1)
                .text("下一页")
        )
            .append(
                $("<a class='use-btn'>")
                    .attr("href","/sort.html?&curPage="+bean.totalPage)
                    .text("尾页")
            )
    }
    
})
