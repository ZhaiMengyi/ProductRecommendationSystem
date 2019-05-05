
$(function () {
    if(getCurrentUser()==null){
        location.replace("../views/login.html")
    }
});

//获取当前登录的user
function getCurrentUser() {
    console.log(localStorage.getItem("user"));
    return JSON.parse(sessionStorage.getItem("user"));
}

