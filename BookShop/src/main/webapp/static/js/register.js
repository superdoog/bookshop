var userName = null;
var userPassword = null;
var ruserPassword = null;
var addBtn = null;
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
    userName = $("#userName");
    userPassword = $("#userPassword");
    ruserPassword = $("#ruserPassword");
    addBtn = $("#add");
    //文本框后加上 * 为必须填写
    userName.next().html("*");
    userPassword.next().html("*");
    ruserPassword.next().html("*");

    userName.bind("focus", function () {
        //获取焦点后显示提示
        validate(userName.next(), {"color": "#666666"}, " 用户名长度必须是大于1小于10的字符", false);
    }).bind("blur", function () {
        //失去焦点判断值
        if (userName.val() != null && userName.val().length > 1 && userName.val().length < 10) {
            //满足条件 提示 并设置状态为true
            validate(userName.next(), {"color": "green"}, "<span class='glyphicon glyphicon-ok'></span>", true);
        } else {
            //不满足条件 提示 设置状态false
            validate(userName.next(), {"color": "red"}, " 用户名输入的不符合规范，请重新输入", false);
        }
    });

    userPassword.bind("focus", function () {
        validate(userPassword.next(), {"color": "#666666"}, " 密码长度必须是大于等于6小于20", false);
    }).bind("blur", function () {
        if (userPassword.val() != null && userPassword.val().length >= 6 && userPassword.val().length < 20) {
            validate(userPassword.next(), {"color": "green"}, "<span class='glyphicon glyphicon-ok'></span>", true);
        } else {
            validate(userPassword.next(), {"color": "red"}, " 密码输入不符合规范，请重新输入", false);
        }
    });

    ruserPassword.bind("focus", function () {
        validate(ruserPassword.next(), {"color": "#666666"}, " 请输入与上面一致的密码", false);
    }).bind("blur", function () {
        if ( userPassword.val() == ruserPassword.val()) {
            validate(ruserPassword.next(), {"color": "green"}, "<span class='glyphicon glyphicon-ok'></span>", true);
        } else {
            validate(ruserPassword.next(), {"color": "red"}, " 两次密码输入不一致，请重新输入", false);
        }
    });

    addBtn.bind("click", function () {
        //点击按钮判断是否全部符合，不符合的文本框获取焦点
        if (userName.attr("validateStatus") != "true") {
            userName.focus();
        } else if (userPassword.attr("validateStatus") != "true") {
            userPassword.focus();
        } else if (ruserPassword.attr("validateStatus") != "true") {
            ruserPassword.focus();
        } else {
            //全部满足提交数据
            if (confirm("是否确认注册？")) {
                $("#userForm").submit();
            }
        }
    });

});