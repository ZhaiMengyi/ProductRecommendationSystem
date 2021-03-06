layui.use(['table', 'form', 'jquery', 'layer'], function () {
    var table = layui.table,
        form = layui.form,
        layer = layui.layer,
        $ = layui.jquery;


    //修改表单提交事件
    layui.form.on('submit(updateBtnSubmit)',function (data) {
        console.log(data.field);
        layer.load(1);
        $.post("../user/modifyUserInfo",data.field,function (data) {
            if(data.code==666){
                layer.msg(data.msg,{icon:1});
                layer.closeAll('page');

            }else{
                layer.msg(data.msg,{icon:2});
            }

        },"JSON");
        return false;
    });
});

//修改个人信息
function updateInfo() {
    var user = getCurrentUser();
    layer.open({
        type:1,
        title:"修改用户信息",
        area:'400px',
        offset:'120px',
        content: $("#pswModel").html()
    });
    $("#updateForm")[0].reset();
    $("#updateForm").attr("method", "POST");
    if (user != null){
        $("#updateForm input[name=userName]").val(user.extend.user.userName);
        $("#updateForm input[name=userPassword]").val(user.extend.user.userPassword);
        $("#updateForm input[name=userMobile]").val(user.extend.user.userMobile);
        $("#updateForm input[name=userAddress]").val(user.extend.user.userAddress);
        $("#updateForm").attr("method", "PUT");
    }
    $("#updateBtnCancel").click(function () {
        layer.closeAll('page');
    });
}

//个人信息
function myInfo() {
    var user = getCurrentUser();
    var content = '<ul class="site-dir" style="padding: 25px 35px 8px 35px;">'
        + '<li>用户名：'+user.extend.user.userName+'</li>'
    content += '<li>手机号：'+user.extend.user.userMobile+'</li>'
        + '<li>地址：'+user.extend.user.userAddress+'</li></ul>';
    layer.open({
        type:1,
        title:'个人信息',
        area:'350px',
        offset:'120px',
        content: content,
        btn:['关闭'],
        btnAlign:'c'
    });
}


//退出登录
function loginOut() {
    $.ajax({
        url:"../user/logoutUser",
        type:"delete",
        dataType:"JSON",
        success:function (data) {
            sessionStorage.removeItem("user");
            location.replace("../views/login.html");
        }
    })
}

