var lendObj;
var path = $("#path").val();

function deleteLend(obj) {
    $.ajax({
        type: "GET",
        url: path + "/deleteLend",
        data: {ser_num: obj.attr("ser_num")},
        dataType: "json",
        success: function (data) {
            if (data.delResult == "true") {//删除成功：移除删除行
                cancleBtn();
                obj.parents("tr").remove();
            } else if (data.delResult == "false") {//删除失败
                changeDLGContent("对不起，还书失败");
            } else if (data.delResult == "notexist") {
                changeDLGContent("对不起，记录不存在");
            }
        },
        error: function (data) {
            changeDLGContent("对不起，还书失败");
        }
    });
}

function openYesOrNoDLG() {
    $('.zhezhao').css('display', 'block');
    $('#removeUse').fadeIn();
}

function cancleBtn() {
    $('.zhezhao').css('display', 'none');
    $('#removeUse').fadeOut();
}

function changeDLGContent(contentStr) {
    var p = $(".removeMain").find("p");
    p.html(contentStr);
}

$(function () {

    $('#no').click(function () {
        cancleBtn();
    });

    $('#yes').click(function () {
        deleteLend(lendObj);
    });

    $(".deleteLend").on("click", function () {
        lendObj = $(this);
        changeDLGContent("你确定要归还【" + lendObj.attr("book_name") + "】吗？");
        openYesOrNoDLG();
    });

});