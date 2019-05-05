$(function () {
    getRecommended();
});
function getRecommended() {
    $.ajax({
        url: '../product/getRecommended',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            console.log(data);
            showRecommended(data.extend.recommended)
        }
    })
}

function showRecommended(products) {
    $(products).each(function () {
        var box = $("#recommendation");
        $("<div></div>")
            .addClass("list-item")
            .append($("<a></a>")
                .attr("href", "details.html?proId=" + this.proId)
                .append($("<img/>")
                    .attr("style", "width: 160px; height: 160px")
                    .attr("src", this.proImg)
                )
            )
            .append($("<p></p>")
                .text(this.proName)
            )
            .append($("<span></span>")
                .text("￥" + this.proPrice)
            ).appendTo(box);
    })
}