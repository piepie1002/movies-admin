const BASE_URL = "http://localhost:8080/api"

const MODIFY_URL=BASE_URL+"/modifyController"
const CATELOG_URL=BASE_URL+"/AddFilmController"

$(function () {
    //获取id
    var url = location.href;
    // alert(url);
    var id = url.substring(url.lastIndexOf('=')+1);

    $.get(MODIFY_URL,function (result) {
        if(result.status === 200){
            showData(result.data);
        }else {
            alert("网络错误，请稍后再试！！！")
        }
    });

    function showData(data) {
        for(const decade of data.decades){
            $("#on-decade").append(
                $("<option>").text(decade.name)
            )
        }

        for(const loc of data.locs){
            $("#loc-name").append(
                $("<option>").text(loc.name)
            )
        }

        for(const cate of data.cateLogs){
            $("#type-name1").append(
                $("<option value='" + cate.id + "'>")
                    .text(cate.name)
            )
        }
    }

    //给类型二级下拉框传入数据
    $("#type-name1").change(function () {
        var cataLog_id = $(this).val();
        let params = {
            action: "getSubClassData",
            cataLogId: cataLog_id
        }
        $.post(CATELOG_URL, params, function (result) {
            if (result.status == 200) {
                $("#type-name2").find("option").remove();
                showSubClassData(result.data.subClasses);
            } else {
                alert("系统繁忙，请稍后再试");
            }
        })
    })

    //给类型三级下拉框传入数据
    $("#type-name2").change(function () {
        var subClass_id = $(this).val();
        let params = {
            action: "getTypeData",
            subClassId: subClass_id
        }
        $.post(CATELOG_URL, params, function (result) {
            if (result.status == 200) {
                $("#type-name3").find("option").remove();
                showTypeData(result.data.types);
            } else {
                alert("系统繁忙，请稍后再试");
            }
        })
    })

    function showSubClassData(subClasses) {
        for (const subClass of subClasses) {
            $("#type-name2").append(
                $("<option value='" + subClass.id + "'>" + subClass.name + "</option>")
            )
        }
    }

    function showTypeData(types) {
        for (const type of types) {
            $("#type-name3").append(
                $("<option value='" + type.id + "'>" + type.name + "</option>")
            )
        }
    }

    var imgStr;

    $("#img").change(function () {
        var strimg = $(this).val().split("\\")[2];
        imgStr = "public/static/upload/filmPic/"+strimg
    });

    $("#btn").click(function () {

        var idStr = id;
        var nameStr = $("#name").val();
        var updateStr = $("#on-decade").val();
        var statusStr = $("#status").val();
        var resolutionStr = $("#resolution option:selected").val();
        var typeNameStr1 = $("#type-name1 option:selected").text();
        var typeNameStr2 = $("#type-name2 option:selected").text();
        var typeNameStr3 = $("#type-name3 option:selected").text();
        var actorStr = $("#actor").val();
        var locNameStr = $("#loc-name").val();
        var plotStr = $("#plot").val();
        alert(plotStr)

        var param={
            id:idStr,
            name:nameStr,
            img:imgStr,
            onDecade:updateStr,
            status:statusStr,
            resolution:resolutionStr,
            cateLogName:typeNameStr1,
            subClassName:typeNameStr2,
            typeName:typeNameStr3,
            actor:actorStr,
            locName:locNameStr,
            plot:plotStr
        }
        $.post(MODIFY_URL,param,function (result) {

        });
    })

});