layui.use(['form'], function () {
    var form = layui.form;
    checkLogin();
    form.on('submit(User-login-submit)', function (obj) {
        layer.load(1);
        $.post("../user/loginUser", obj.field, function (data) {
            if (data.code == 666) {
                layer.msg(data.msg, {icon: 1});
                sessionStorage.setItem("user", JSON.stringify(data));
                location.replace("../views/show.html");
            } else {
                layer.closeAll('loading');
                layer.msg(data.msg, {
                    icon: 2});
            }
        }, "json");
        return false;
    });
});

// 检查是否登录
function checkLogin() {
    var tempUser = JSON.parse(sessionStorage.getItem("user"));
    console.log(tempUser);
    if (tempUser != null) {
        location.replace("../views/show.html");
    }
}


