var userPassword = null;
var newPassword = null;
var ruserPassword = null;
var updateBtn = null;
/**
 * 验证是否符合要求
 * @param element   页面元素
 * @param css       样式
 * @param tipString 显示信息
 * @param status    状态
 */
function validate(element, css, tipString, status) {
    element.css(css);
    element.html(tipString);
    element.prev().attr("validateStatus", status);
}

$(function () {
    userPassword = $("#userPassword");
    newPassword = $("#newPassword");
    ruserPassword = $("#ruserPassword");
    updateBtn = $("#update");
    //文本框后加上 * 为必须填写
    userPassword.next().html("*");
    newPassword.next().html("*");
    ruserPassword.next().html("*");


    userPassword.bind("focus", function () {
        validate(userPassword.next(), {"color": "#666666"}, " <span class='glyphicon glyphicon-remove'></span>", false);
    }).bind("blur", function () {
        if (userPassword.val() != null && userPassword.val() == ss) {
            validate(userPassword.next(), {"color": "green"}, "<span class='glyphicon glyphicon-ok'></span>", true);
        } else {
            validate(userPassword.next(), {"color": "red"}, " 密码错误，请重新输入", false);
        }
    });

    newPassword.bind("focus", function () {
        validate(newPassword.next(), {"color": "#666666"}, "<span class='glyphicon glyphicon-remove'></span> 密码长度必须是大于等于6小于20", false);
    }).bind("blur", function () {
        if (newPassword.val() != null && newPassword.val().length >= 6
            && newPassword.val().length < 20) {
            validate(newPassword.next(), {"color": "green"}, "<span class='glyphicon glyphicon-ok'></span>", true);
        } else {
            validate(newPassword.next(), {"color": "red"}, " 密码输入不符合规范，请重新输入", false);
        }
    });

    ruserPassword.bind("focus", function () {
        validate(ruserPassword.next(), {"color": "#666666"}, "<span class='glyphicon glyphicon-remove'></span> 请输入与上面一致的密码", false);
    }).bind("blur", function () {
        if (ruserPassword.val().length < 20 && newPassword.val() == ruserPassword.val()) {
            validate(ruserPassword.next(), {"color": "green"}, "<span class='glyphicon glyphicon-ok'></span>", true);
        } else {
            validate(ruserPassword.next(), {"color": "red"}, " 两次密码输入不一致，请重新输入", false);
        }
    });

    updateBtn.bind("click", function () {
        //点击按钮判断是否全部符合，不符合的文本框获取焦点
        if (userPassword.attr("validateStatus") != "true") {
            userPassword.focus();
        } else if (newPassword.attr("validateStatus") != "true") {
            newPassword.focus();
        } else if (ruserPassword.attr("validateStatus") != "true") {
            ruserPassword.focus();
        } else {
            //全部满足提交数据
            if (confirm("是否修改？")) {
                $("#updatePwd").submit();
            }
        }
    });

});