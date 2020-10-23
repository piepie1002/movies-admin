const URL = "http://localhost:8080/api/AddFilmController";


$(function () {
    //给类型二级下拉框传入数据
    $("#catalog-1").change(function () {
        var cataLog_id = $(this).val();
        let params = {
            action: "getSubClassData",
            cataLogId: cataLog_id
        }
        $.post(URL, params, function (result) {
            if (result.status == 200) {
                $("#subClass_id").find("option").remove();
                showSubClassData(result.data.subClasses);
            } else {
                alert("系统繁忙，请稍后再试");
            }
        })
    })

    //给类型三级下拉框传入数据
    $("#subClass_id").change(function () {
        var subClass_id = $(this).val();
        let params = {
            action: "getTypeData",
            subClassId: subClass_id
        }
        $.post(URL, params, function (result) {
            if (result.status == 200) {
                $("#type_id").find("option").remove();
                showTypeData(result.data.types);
            } else {
                alert("系统繁忙，请稍后再试");
            }
        })
    })

    function showSubClassData(subClasses) {
        for (const subClass of subClasses) {
            $("#subClass_id").append(
                $("<option value='" + subClass.id + "'>" + subClass.name + "</option>")
            )
        }
    }

    function showTypeData(types) {
        for (const type of types) {
            $("#type_id").append(
                $("<option value='" + type.id + "'>" + type.name + "</option>")
            )
        }
    }


    $("#addFilm-btn").click(function () {
        var film_id = "";
        var name_val = $("#name").val();
        var image_val = $("#image").attr("src");
        var onDecade_val = $("#onDecade").val();
        var status_val = $("#status").val();
        var resolution_val = $("#resolution").val();
        var typeName_val = $("#type_id").find("option:selected").text();
        var type_id_val = $("#type_id").val();
        var actor_val = $("#actor").val();
        var locName_val = $("#locName").find("option:selected").text();
        var loc_id_val = $("#locName").val();
        var plot_val = $("#plot").val();
        var is_vip = $("#isVip").val();
        if (name_val == ""
            || image_val == ""
            || image_val == undefined
            || onDecade_val == ""
            || status_val == ""
            || resolution_val == ""
            || typeName_val == ""
            || type_id_val == ""
            || actor_val == ""
            || locName_val == ""
            || loc_id_val == ""
            || plot_val == ""
            || is_vip == ""
        ) {
            if (name_val == "") {
                alert("片名不能为空");
            } else if (image_val == "") {
                alert("海报不能为空");
            } else if (image_val == undefined) {
                alert("海报不能为空");
            } else if (onDecade_val == "") {
                alert("年代不能为空");
            } else if (status_val == "") {
                alert("状态不能为空");
            } else if (resolution_val == "") {
                alert("分辨率不能为空");
            } else if (typeName_val == "") {
                alert("类型名称不能为空");
            } else if (type_id_val == "") {
                alert("类型编码不能为空");
            } else if (actor_val == "") {
                alert("演员不能为空");
            } else if (locName_val == "") {
                alert("地区名不能为空");
            } else if (loc_id_val == "") {
                alert("地区编码不能为空");
            } else if (plot_val == "") {
                alert("剧情不能为空");
            } else if (is_vip == "") {
                alert("请选择是否为VIP");
            }
        } else {

            let params ={
                action: "addFilm",
                filmId : film_id,
                name : name_val,
                image : image_val,
                onDecade : onDecade_val,
                status : status_val,
                resolution : resolution_val,
                typeName : typeName_val,
                type_id : type_id_val,
                actor : actor_val,
                locName : locName_val,
                loc_id : loc_id_val,
                plot : plot_val,
                isVip : is_vip
            }
            $.post(URL,params,function (result) {

            })

        }
    })
})

//清空影片表单
function clearAddFilmInput() {
    $(".addFilmInput").val("");
}