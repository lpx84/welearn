/**
 * 当ajax请求时的公用的处理complete函数
 * @param e
 * @param status
 */
function completeHandle(e,status) {
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
