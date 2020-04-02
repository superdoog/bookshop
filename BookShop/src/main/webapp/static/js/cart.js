function add(id) {
    var num = parseInt(document.getElementById("number" + id).value);
    var goodSum = document.getElementById("goodSum" + id);
    var sum = document.getElementById("sum");
    var hiddenSum = document.getElementById("hiddenSum");
    if (num < 100) {
        document.getElementById("number" + id).value = ++num;
        goodSum.innerHTML = document.getElementById("number" + id).value * document.getElementById("price" + id).value;
        hiddenSum.value = parseInt(hiddenSum.value) + parseInt(document.getElementById("price" + id).value);
        sum.innerHTML = parseInt(hiddenSum.value);
        $.post("addGoodsInCart.do", {"number": 1, "bid": id}, function () {

        });
    }
}

function sub(id) {
    var num = parseInt(document.getElementById("number" + id).value);
    var goodSum = document.getElementById("goodSum" + id);
    var sum = document.getElementById("sum");
    var hiddenSum = document.getElementById("hiddenSum");
    if (num > 1) {
        document.getElementById("number" + id).value = --num;
        goodSum.innerHTML = document.getElementById("number" + id).value * document.getElementById("price" + id).value;
        hiddenSum.value = parseInt(hiddenSum.value) - parseInt(document.getElementById("price" + id).value);
        sum.innerHTML = parseInt(hiddenSum.value);
        $.post("addGoodsInCart.do", {"number": -1, "bid": id}, function () {

        });
    }
}

function unLog() {
    alert("请登录后再结算");
}

$(document).ready(function () {
    $("#submit").click(function () {
        $.get(path + "checkStore", "utf-8",
            function (data) {
                if (data.Success == "success") {
                    window.location.href = path + "oderPage";
                } else {
                    alert(data.False);
                }
            });
    });
});