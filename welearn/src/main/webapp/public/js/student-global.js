/**
 * 当ajax请求时的公用的处理complete函数
 * @param e
 * @param status
 */
function completeHandler(e,status) {
	$("#loading").fadeOut();
	if(status == 'success') {
		return ;
	}
	if(status == 'timeout') {
		alert("请求超时，请检查网络是否正常！");
	} else if(status == 'error') {
		alert(e.statusText);
	}
	console.log(e);
}

$(document).ready(function(){
	
	//如果页面内容高度小于屏幕高度，div#footer将绝对定位到屏幕底部，否则div#footer保留它的正常静态定位
	if (($(document.body).height() + 10) < $(window).height()) {
	    $(".btn-more").addClass("fixed-bottom");
	};
});