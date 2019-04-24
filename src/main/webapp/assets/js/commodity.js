$(function () {
    //修改表单提交事件
    layui.form.on('submit(updateBtnSubmit)',function (data) {
        data.field._method = $("#updateForm").attr("method");
        layer.load(1);
        $.post("../user/modifyUserInfo",data.field,function (data) {
            if(data.code==666){
                layer.msg(data.msg,{icon:1});

            }else{
                layer.closeAll('loading');
                layer.msg(data.msg,{icon:2});
            }

        },"JSON");
        return false;
    })
});
//修改个人信息
function updateInfo() {
    layer.open({
        type:1,
        title:"修改用户信息",
        area:'400px',
        offset:'120px',
        content:$("#updateForm").html()
    });
    $("#updateForm")[0].reset();
    $("#updateBtnCancel").click(function () {
        layer.closeAll('page');
    })
}

//个人信息
function myInfo() {
    var user = getCurrentUser();
    console.log(user);
    var content = '<ul class="site-dir" style="padding: 25px 35px 8px 35px;">'
        + '<li>用户名：'+user.extend.user.userName+'</li>'
        + '<li>密码：'+user.extend.user.userPassword+'</li>';
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
    layer.load(1);
    $.ajax({
        url:"../user/logoutUser",
        type:"delete",
        dataType:"JSON",
        success:function (data) {
            localStorage.removeItem("user");
            location.replace("../index.html");
        }
    })
}

//注销
function deleteUser() {
    var user = getCurrentUser();
    layer.confirm('确定要注销吗？', function (index) {
        layer.close(index);
        layer.load(1);
        $.ajax({
            url: "../user/deleteUser/" + user.extend.user.userId,
            type: "DELETE",
            dataType: "JSON",
            success: function (data) {
                layer.closeAll('loading');
                if (data.code == 666) {
                    layer.msg(data.msg, {icon: 1});
                    location.replace("../index.html");
                } else {
                    layer.msg(data.msg, {icon: 2});
                }
            }
        });
    });
}




function listProducts(products) {
    $(products).each(function (index) {
        var list = $("#list-cont");
        $("<div></div>")
            .addClass("item")
            .append($("<div></div>")
                .addClass("img")
                .append($("<a></a>")
                    .attr("href", "#")
                    .append($("<img>")
                        .attr("src",this.productImg)
                        .attr("style", "width: 280px; height: 280px"))))
            .append($("<div></div>")
                .addClass("text")
                .append($("<p></p>")
                    .addClass("title")
                    .text(this.productName))
                .append($("<p></p>")
                    .addClass("price")
                    .append($("<span></span>")
                        .addClass("pri")
                        .text(this.productPrice))
                    .append($("<span></span>")
                        .addClass("nub")
                        .text(this.productBought))))
    })
}