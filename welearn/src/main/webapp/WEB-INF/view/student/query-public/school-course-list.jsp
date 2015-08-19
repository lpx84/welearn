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
<div class="main bg-white">
	<div class="header">
		<i class="glyph-icon icon-chevron-left float-left btn-back"></i>
        <p>课程列表</p>
    </div>

    <div class="button-pane button-pane-top pad10A">
        <div class="form-row pad0B">
            <div class="form-input col-md-12">
                <div class="form-input-icon">
                <form id="search-course" action="<%=request.getContextPath() %>/student/query/public/school-course-query" method="POST">
                    <i class="glyph-icon fa-search"></i>
                    <input type="text" placeholder="输入查询课程" class="radius-all-100" name="keyword" id="keyword" onkeydown="javascript:enterSearch();"/>
                    <input type="submit" style="display:none;">
                </form>
                </div>
            </div>
        </div>
    </div>
    <div class="">
        <div class="scrollable-content">

            <ul class="notifications-box">
            <c:forEach var="item" items="${list }">
                <li onclick="javascript:location.href='school-course-detail?courseid=${item.getId() }';">
                    <span class="btn bg-green icon-notification glyph-icon fa-book"></span>
                    <span class="notification-text">${item.getName() }</span>
                    <div class="notification-time">${item.getAcademyEntity().getName() }</div>
                </li>
            </c:forEach>
                
            </ul>

        </div>
        <a href="javascript:fetchData();" class="btn btn-more medium float-none ui-state-default">
        <span class="button-content">查看更多</span>
        </a>
    </div>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">
function enterSearch() {
	var event = window.event || arguments.callee.caller.arguments[0];
	if (event.keyCode == 13) {
		var key = $("#keyword").val();
		if('' != key) {
			$("#search-course").submit();			
		}
		
	}
}

var pageno=1;
var key = "${key}"
function fetchData() {
	//记录当前页数
	pageno++;
	//用ajax获取页面信息

	$.ajax({
		
		url: $("#appName").val()+"/student/query/public/school-course-query-page",
		type: "POST",
		data: {
			keyword: key,
			pageNo: pageno,
		},
		timeout: 5000,
		dataType: "JSON",
		success: function(res) {
			if(res.code == 100) {
				alert(res.msg);
				$(".btn-more").html("查看更多");
			} else {
				if(res.length<1){
					$(".btn-more").removeAttr("href");
					$(".btn-more").hide();	
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
			"<li onclick=\"javascript:location.href='school-course-detail?courseid=",
			"id",
			"';\"><span class='btn bg-green icon-notification glyph-icon fa-book'></span><span class='notification-text'>",
			"name",
			"</span><div class='notification-time'>",
			"academy",
			"</div></li>"			
	);
	for(var i=0; i<res.length; ++i) {
		html[1]=res[i].id;
		html[3]=res[i].name;
		html[5]=res[i].academyEntity.name;
		$(".notifications-box").append(html.join(''));
	}
}


</script>
</body>
</html>