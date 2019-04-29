

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
    });

    $.ajax({
        url: "../product/allProduct",
        type: "GET",
        dataType: "json",
        success: function (data) {
            listProducts(data.extend.allProduct);
        }
    })

});




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
                    console.log("delete")
                    location.replace("../show.html");
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
                    .attr("href", "details.html?proId=" + this.proId)
                    .append($("<img/>")
                        .attr("src",this.proImg)
                        .attr("style", "width: 280px; height: 280px"))))
            .append($("<div></div>")
                .addClass("text")
                .append($("<p></p>")
                    .addClass("title")
                    .text(this.proName))
                .append($("<p></p>")
                    .addClass("price")
                    .append($("<span></span>")
                        .addClass("pri")
                        .text("￥"+this.proPrice))
                    .append($("<span></span>")
                        .addClass("nub")
                        .text(this.proBought + "付款")))).appendTo(list);
    })
}