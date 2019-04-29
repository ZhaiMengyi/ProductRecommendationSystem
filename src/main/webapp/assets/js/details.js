layui.use('layer', function(){
    var layer = layui.layer;

});
var proId;
$(function () {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    // 获取搜索字符串
    var search = location.search;
    if (search.indexOf("?") != -1) {
        var str = search.substr(1);
        proId = decodeURIComponent(str.replace("proId=",""));
    }

    $.ajax({
        url: "../product/inquireProductById",
        type: "GET",
        dataType: "json",
        data:{
            "proId" : proId
        },
        success: function (data) {
            $("div.product-intro.layui-clear").attr("id", data.extend.product.proId);
            $("#proName").append(data.extend.product.proName);
            $("#proPrice").text(data.extend.product.proPrice);
            $("#proImg").attr("src", data.extend.product.proImg);
        }
    })
});


function addToCart() {
    var proNum = $("div.number-cont").find("input").val();
    $.ajax({
        url: "../shoppingCarts/addProToCarts",
        type: "POST",
        dataType: "JSON",
        data:{
            "proId": proId,
            "proNum": proNum
        },
        success: function (data) {
            if (data.code === 666){
                layui.layer.msg("添加购物车成功！", {icon: 1})
            } else {
                layui.layer.msg("添加购物车失败！", {icon: 2})
            }
        }
    });
}

function buy() {
    $.ajax({
        url: "../userOrder/payProduct",
        type: "POST",
        dataType: "json",
        data:{
            "proId": proId
        },
        success: function (data) {
            if (data.code === 666){
                layui.layer.msg("购买成功！", {icon: 1})
            } else {
                layui.layer.msg("创建订单发生异常！", {icon: 2})
            }
        }
    });
}