var lend;
var path = $("#path").val();

function LendBook(obj) {
    $.ajax({
        type: "GET",
        url: path + "/LendBook",
        data: {book_id: obj.attr("book_id")},
        dataType: "json",
        success: function (data) {
            if (data.Result == "true") {
                cancleBtn();
                window.location.reload();
            } else if (data.Result == "false") {
                changeDLGContent("对不起，借书失败");
            } else if (data.Result == "notexist") {
                changeDLGContent("对不起，本书无库存");
            }
        },
        error: function (data) {
            changeDLGContent("对不起，借书失败");
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
        LendBook(lend);
    });

    $(".LendBook").on("click", function () {
        lend = $(this);
        changeDLGContent("你确定要借阅【" + lend.attr("book_name") + "】吗？");
        openYesOrNoDLG();
    });

});