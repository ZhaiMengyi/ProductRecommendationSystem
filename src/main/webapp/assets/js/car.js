
layui.define(['layer'],function(exports){
	var layer = layui.layer;
    $.ajax({
        url: "../shoppingCarts/queryCart",
        type: "GET",
        dataType: "json",
        success: function (data) {
            showCart(data.extend.carts);
            car.init();
        }
    });

    var car = {
        init : function(){

            var uls = document.getElementById('list-cont').getElementsByTagName('ul');//每一行
            var checkInputs = document.getElementsByClassName('check'); // 所有勾选框
            var checkAll = document.getElementsByClassName('check-all'); //全选框
            var SelectedPieces = document.getElementsByClassName('Selected-pieces')[0];//总件数
            var piecesTotal = document.getElementsByClassName('pieces-total')[0];//总价
            var batchdeletion = document.getElementsByClassName('batch-deletion')[0];//批量删除按钮
            var payBtn = document.getElementById("pay");//结算
            //结算金额
            function getTotal(){
                var seleted = 0,price = 0;
                for(var i = 0; i < uls.length;i++){
                    if(uls[i].getElementsByTagName('input')[0].checked){
                        seleted += parseInt(uls[i].getElementsByClassName('Quantity-input')[0].value);
                        price += parseFloat(uls[i].getElementsByClassName('sum')[0].innerHTML);
                    }
                }
                SelectedPieces.innerHTML = seleted;
                piecesTotal.innerHTML = '￥' + price.toFixed(2);
            }

            // 小计
            function getSubTotal(ul){
                var unitprice = parseFloat(ul.getElementsByClassName('th-su')[0].innerHTML);
                var count = parseInt(ul.getElementsByClassName('Quantity-input')[0].value);
                var SubTotal = parseFloat(unitprice * count);
                ul.getElementsByClassName('sum')[0].innerHTML = SubTotal.toFixed(2);
            }

            for(var i = 0;i < checkInputs.length;i++){
                checkInputs[i].onclick = function(){
                    if(this.className === 'check-all check'){
                        for(var j = 0;j < checkInputs.length; j++){
                            checkInputs[j].checked = this.checked;
                        }
                    }
                    if(this.checked === false){
                        for(var k = 0;k < checkAll.length;k++){
                            checkAll[k].checked = false;
                        }
                    }
                    getTotal()
                }
            }

            for(var i = 0; i < uls.length;i++){
                uls[i].onclick = function(e){
                    e = e || window.event;
                    var el = e.srcElement;
                    var cls = el.className;
                    var input = this.getElementsByClassName('Quantity-input')[0];
                    var less = this.getElementsByClassName('less')[0];
                    var val = parseInt(input.value);
                    var that = this;
                    switch(cls){
                        case 'add layui-btn':
                            input.value = val + 1;
                            getSubTotal(this);
                            break;
                        case 'less layui-btn':
                            if(val > 1){
                                input.value = val - 1;
                            }
                            getSubTotal(this);
                            break;
                        case 'dele-btn':
                            // layer.confirm('你确定要删除吗',{
                            //     yes:function(index,layero){
                            //         layer.close(index);
                                    that.parentNode.removeChild(that);
                            //     }
                            // });
                            break;
                    }
                    getTotal()
                }
            }
            batchdeletion.onclick = function(){

                if(SelectedPieces.innerHTML != 0){
                    // layer.confirm('你确定要删除吗',{
                        // yes:function(index,layero){
                        //     layer.close(index);
                            for(var i = 0;i < uls.length;i++){
                                var input = uls[i].getElementsByTagName('input')[0];
                                if(input.checked){
                                    uls[i].parentNode.removeChild(uls[i]);
                                    i--;
                                }
                            }
                            getTotal()
                        // }

                    // })
                }else{
                    layer.msg('请选择商品')
                }

            };

            payBtn.onclick = function(){
                console.log(123);
                if(SelectedPieces.innerHTML != 0){
                    console.log(312);
                    console.log(uls.length);
                    // layer.confirm('确定结算吗',{
                    //     yes:function(index,layero){
                    //         layer.close(index);
                            var cartIds = [];
                            console.log(111);
                            for(var i = 0;i < uls.length;i++){
                                console.log(222);
                                var input = uls[i].getElementsByTagName('input')[0];
                                if(input.checked){
                                    cartIds.push($(uls[i]).attr("cartId"));
                                    uls[i].parentNode.removeChild(uls[i]);
                                    i--;
                                }
                            }
                            $.ajax({
                                url: "../userOrder/payCart",
                                type: "POST",
                                dataType: "json",
                                data:{
                                    "cartIds": cartIds
                                },
                                success: function (data) {
                                    if (data.code === 666){
                                        layer.msg("购买成功！", {icon: 1})
                                    } else {
                                        layer.msg("创建订单发生异常！", {icon: 2})
                                    }
                                }
                            });
                            getTotal();

                    //     }
                    // })
                }else{
                    layer.msg('请选择商品')
                }

            };
            checkAll[0].checked = true;
            checkAll[0].onclick();
        }

    };


    exports('car',car)

});

function showCart(carts) {
    var container = $("#list-cont");
    $(carts).each(function (index) {
        $("<ul></ul>")
            .attr("cartId", this.cartId)
            .addClass("item-content layui-clear")
            .append($("<li></li>")
                .addClass("th th-chk")
                .append($("<div></div>")
                    .addClass("select-all")
                    .append($("<div></div>")
                        .addClass("cart-checkbox")
                        .append($("<input>")
                            .addClass("CheckBoxShop check")
                            .attr("id", this.cartId)
                            .attr("type", "checkbox")
                            .attr("num", "all")
                            .attr("name", "select-all")
                            .attr("value", true)
                        )
                    )
                )
            )
            .append($("<li></li>")
                .addClass("th th-item")
                .append($("<div></div>")
                    .addClass("item-cont")
                    .append($("<a></a>")
                        .attr("href", "#")
                        .append($("<img/>")
                            .attr("src", this.product.proImg)
                        )
                    )
                    .append($("<div></div>")
                        .addClass("text")
                        .append($("<div></div>")
                            .addClass("title")

                            .text(this.product.proName)
                        )
                    )
                )
            )
            .append($("<li></li>")
                .addClass("th th-price")
                .append($("<span></span>")
                    .addClass("th-su")

                    .text(this.product.proPrice.toFixed(2))
                )
            )
            .append($("<li></li>")
                .addClass("th th-amount")
                .append($("<div></div>")
                    .addClass("box-btn layui-clear")
                    .append($("<div></div>")
                        .addClass("less layui-btn").text("-")
                    )
                    .append($("<input>")
                        .addClass("Quantity-input")

                        .attr("id", this.cartId)
                        .attr("name", "")
                        .attr("type", "")
                        .attr("value", this.proNum)
                        .attr("disabled", true)
                    )
                    .append($("<div></div>")
                        .addClass("add layui-btn").text("+"))
                )
            )
            .append($("<li></li>")
                .addClass("th th-sum")
                .append($("<span></span>")
                    .addClass("sum")

                    .text((this.product.proPrice * this.proNum).toFixed(2))
                )
            )
            .append($("<li></li>")
                .addClass("th th-op")
                .append($("<span></span>")
                    .addClass("dele-btn").text("删除")
                )
            ).appendTo(container);
    });
}

