
$(function () {
    if(getCurrentUser()==null){
        location.replace("login.html")
    }
});

//获取当前登录的user
function getCurrentUser() {
    // console.log(localStorage.getItem("user"));
    return JSON.parse(sessionStorage.getItem("user"));
}

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
            localStorage.removeItem("user");
            location.replace("../login.html");
        }
    })
}