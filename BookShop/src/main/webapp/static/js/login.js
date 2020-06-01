var path = $("#path").val();

function Refresh(){
    location.reload();
}

$(document).ready(function () {
    $("#submit").click(function () {
        $.ajax({
            type: "post",
            url: path + "/loginCheck",
            data: {
                userName: $("#userName").val(),
                passWord: $("#passWord").val(),
                yan: $("#yan").val()
            },
            dataType: "json",
            success: function (data) {
                if (data.Result == "yanFalse") {
                    alert("验证码不正确");
                }
                if (data.Result == "null") {
                    alert("用户名不正确");
                }
                if (data.Result == "false") {
                    alert("密码不正确");
                }
                if (data.Result == "success") {
                    window.location.href = path + "/index";
                }
            },
            error: function () {
                alert("登录失败");
            }
        });
    });
});




