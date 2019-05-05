$(function () {
    $.ajax({
        url: "../product/allProduct",
        type: "GET",
        dataType: "json",
        success: function (data) {
            console.log(data);
            listProducts(data.extend.allProduct);
        }
    });
});



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