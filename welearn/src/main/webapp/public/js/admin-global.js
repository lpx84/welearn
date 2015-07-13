$(document).ready(function(){
    
    $(".dialog-btn-close").click(function(event){
        closeDlg();
    });
    
});

/**
 * 关闭所有.ui-dialog窗口
 */
function closeDlg() {
    $(".ui-dialog").addClass("hide");
    $("#overlay").addClass("hide");
}

/**
 * 打开指定id窗口 此id没有‘#’号
 */
function openDlg(dlgId) {    
    $("#overlay").removeClass("hide");
    $("#"+dlgId).removeClass("hide");
}

/**
 * 打开公共的确认框
 * @param type 打开的类型：
 * 				1. null -> 点击确定只会关闭窗口
 * 				2. del	-> 点击确定之后就会进行删除操作
 * 				3. edit	-> 点击确定之后就会提交修改
 * @param id	条目的id 若为空 则点击确定只会关闭窗口
 * @param msg	显示的信息
 */
function confirmDlg(type,id,msg) {
	closeDlg();
	$("#modal-confirm label.tips").html(msg);
	$("#confirmRcdId").val(id);
	$("#confirmOperType").val(type);
	openDlg("modal-confirm");
}

//对Date的扩展，将 Date 转化为指定格式的String   
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
//例子：   
//(new Date()).format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423   
//(new Date()).format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18   
Date.prototype.format = function(fmt)   
{
var o = {
 "M+" : this.getMonth()+1,                 //月份   
 "d+" : this.getDate(),                    //日   
 "h+" : this.getHours(),                   //小时   
 "m+" : this.getMinutes(),                 //分   
 "s+" : this.getSeconds(),                 //秒   
 "q+" : Math.floor((this.getMonth()+3)/3), //季度   
 "S"  : this.getMilliseconds()             //毫秒   
};
if(/(y+)/.test(fmt))
 fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
for(var k in o)
 if(new RegExp("("+ k +")").test(fmt))   
fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
return fmt;
}

/**
 * 当ajax请求完成时调用，进行错误处理
 */
function completeHandle(e,status) {
	$("#loading").fadeOut();
	if(status == 'success') {
		return ;
	}
	if(status == 'timeout') {
		confirmDlg(null,null,"请求超时，请检查网络是否正常！");
	} else if(status == 'error') {
		confirmDlg(null,null,e.statusText);
	}
	console.log(e);
}


/**
 * 点击编辑模态框的确定按钮，此模态框是私有的，每个页面都不一样，但是基本属性相同
 */
 $("#btn-confirm-submit").click(function() {
 	if($("#mainOperType").val() == "add") {
 		submitAdd();
 	} else if($("#mainOperType").val() == "edit") {
 		submitEdit();
 	}
 });
 
 /**
 * 点击确定框的确定按钮，此确定框是公共的，每个页面都一样
 */
 $("#confirm-btn-ok").click(function() {
 	if($("#confirmOperType").val() == "del") {
 		submitDel();
 	}
 });
 
 
 /**
  * 上传文件设置
  */
 var uploadOptions = {
			beforeSubmit: function() {
	        	if($("#upload").val() == "") {
	        		alert("没有选择文件！");
	        		return false;
	        	} else {
	        		$("#loading").fadeIn();
	        		return true;
	        	}
	        },  //提交前处理 
	        success: function(res) {
	        	$("#loading").fadeOut();
	        	if(res.code == 200) {
	        		var str = "<div class='file-name-item'><a href='"+res.msg+"' target='_blank'>"+res.msg+"</a></div>";
	        		$(".file-list").append(str);
	        	} else {
	        		alert(res.msg);
		        	if(res.code == 100) {
	     				location.href = $("#appName").val()+"/admin/admin/login";
	        		}
	        	}
	        	
	        },
	        error: completeHandle,  //处理完成 
	        resetForm: true,
	        dataType:  'json'
	};
 
 /**
  * 上传文件是触发事件
  */
 $("#form-file").submit(function(){
 	$(this).ajaxSubmit(uploadOptions);
 	return false;
 });