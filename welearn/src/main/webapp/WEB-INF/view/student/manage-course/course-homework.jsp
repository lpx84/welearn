<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/section/home/header.jsp" %>
<title>${title }</title>
<style type="text/css">
    .btn-more .button-content {
        font-size: 1.3em;
        line-height: 2em;
    }
    
    .fixed-bottom {
        position: fixed !important;
        bottom: 0;
        width: 100%;
    }
    
    .title {
        display: inline-block;
        text-align: center;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
        width: 72%;
    }
    
    .content-box {
        border: none;
    }
    
    .content {
        font-size: 1.2em;
    }
    
    .inline-block {
        display: inline-block;
    }
    
    .rcd {
        margin: 3px 3px;
        padding: 5px 10px;
        border: solid 1px #c3c3c3;
        border-radius: 3px;
    }
    
    .lab {
        color: #c3c0c0;
    }
    
    .rows12 {
        font-size: 0.8em;
    }
    
    .name {
        font-weight: bold;
        line-height: 2em;
    }
    
    .rows1 {
        position: relative;
        margin-left: auto;
    }
    
    .i-toggle {
        position: absolute;
        top: 15px;
        right: 0px;
    }
    
    .rows.rows2.text {
        margin-top: 5px;
        margin-bottom: -5px;
        padding: 10px 5px;
        background: #fafafa;
    }
   
    .btn-more {
   		display: block;
   		width: 100%;
   }
   
   .btn-more span {
   		position: absolute;
   		width: 100%;
   		text-align: center;
   }
</style>
</head>
<body>
<div class="content-box">
    <h3 class="content-box-header bg-gray text-center">
    	<div class="glyph-icon icon-separator transparent back-btn">
            <i class="glyph-icon fa-chevron-left"></i>
        </div>
        <label class="title">${courseName }</label>
        <div class="glyph-icon icon-separator transparent float-right">
            <i class="glyph-icon"></i>
        </div>
    </h3>
    <div class="content">
    <c:forEach var="item" items="${list }"> 
        <div class="rcd">
            <div class="rows rows1">
                <div class="inline-block">
                    <!-- font-red表示消息未读 已读消息设为font-gray -->
                    <div class="rows rows11 name"><i class="glyph-icon font-red fa-file-text-o"></i>&nbsp;${item.getTitle() }</div>
                    <div class="rows rows12">
                        <span class="time ">
                            <span class="lab">发布：</span>
                            <span class="label bg-gray">${item.getCreate_time() }</span>
                        </span>
                        <p></p>
                        <span class="time ">
                            <span class="lab">截止：</span>
                            <span class="label bg-green">${item.getDeadline() }</span>
                        </span>
                    </div>
                </div>
                <div class="inline-block i-toggle">
                    <i class="fa fa-chevron-right"></i>
                </div>
            </div>
            <div class="row rows rows2 text" style="display: none;">
                ${item.getContent() }
            </div>
        </div>
        </c:forEach>
    </div>
    
    <a href="javascript:fetchData();" class="btn btn-more medium float-none ui-state-default">
        <span class="button-content">查看更多</span>
    </a>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">
$(".text-toggle").click(function(){
    if($(this).hasClass("fa-angle-double-down")) {
        $(".large-text").removeClass("limit-text");
        $(this).removeClass("fa-angle-double-down");            
        $(this).addClass("fa-angle-double-up");            
    } else {
        $(".large-text").addClass("limit-text");
        $(this).removeClass("fa-angle-double-up");            
        $(this).addClass("fa-angle-double-down");
    }
});

$(".rows.rows1").click(function(){
    $(this).siblings(".rows.text").slideToggle();
    var $i = $(this).children(".i-toggle").children("i.fa");
    if($i.hasClass("fa-chevron-right")) {
        $i.removeClass("fa-chevron-right");
        $i.addClass("fa-chevron-down");
    } else {
        $i.removeClass("fa-chevron-down");
        $i.addClass("fa-chevron-right");
    }
});

//如果页面内容高度小于屏幕高度，div#footer将绝对定位到屏幕底部，否则div#footer保留它的正常静态定位
if (($(document.body).height() + 10) < $(window).height()) {
    $(".btn-more").addClass("fixed-bottom");
};

var pageno=1;
var courseid= ${courseid };
function fetchData() {
	//记录当前页数
	pageno++;
	//用ajax获取页面信息
	
	$.ajax({
		
		url: $("#appName").val()+"/student/manage/course/more-course-notify",
		type: "POST",
		data: {
			courseid:courseid,
			pageNo: pageno,
		},
		timeout: 5000,
		dataType: "JSON",
		success: function(res) {
			if(res.code == 100) {
				alert(res.msg);
			} else {
				if(res.length<1){
					$(".btn-more").removeAttr("href");
					$(".btn-more").html("没有更多了");		
				}else{
					joinData(res);
					$(".btn-more").html("查看更多");	
				}	
			}
		},
		complete: completeHandler
	});
	$(".btn-more").html("获取中...");
}

function joinData(res) {              
	var html = new Array(
		"<div class='rcd'><div class='rows rows1'><div class='inline-block'><div class='rows rows11 name'><i class='glyph-icon font-red fa-bullhorn'></i>&nbsp;",
		"title",
		"</div><div class='rows rows12'><span class='time '><span class='lab'><i class='fa fa-clock-o'></i>&nbsp;</span><span>",
		"time",
		" </span></span><span class='time'><span class='lab'>截止：</span><span class='label bg-green'>",
		"deadline",
		"</span></span></div></div><div class='inline-block i-toggle'> <i class='fa fa-chevron-right'></i></div></div><div class='row rows rows2 text' style='display: none;'>",
		"content",
		"</div></div>"
	);
	for(var i=0; i<res.length; ++i) {
		html[1]=res[i].title;
		html[3]=res[i].create_time;
		html[5]=res[i].deadline;
		html[7]=res[i].content;
		$(".content").append(html.join(''));
	}
}
</script>
</body>
</html>