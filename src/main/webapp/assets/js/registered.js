layui.use(['form'],function () {
    var form = layui.form;
    form.on('submit(User-register-submit)',function (obj) {
        $("#registerForm")[0].reset();
        $("#registerForm").attr("method", "POST");
        layer.load(1);
        $.post("../user/registerUser",obj.field,function (data) {
            if(data.code == 666){
                layer.msg(data.msg,{icon:1});
                setTimeout(function () {
                    location.replace("../views/login.html");
                },1000)
            }else {
                layer.closeAll('loading');
                layer.msg(data.msg,{icon:2});
            }
        },"json");
        return false;
    });
});

