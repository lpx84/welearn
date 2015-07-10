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
       .tips-span {
        padding: 10px;
    }
    
    .tips-span span {
        margin-top: 5px;
    }   
</style>
</head>
<body>
<div class="content-box bg-white">
    <div class="button-pane button-pane-top pad10A">
        <div class="form-row pad0B">
            <div class="form-input col-md-12">
                <div class="form-input-icon">
                <form id="search-course" action="<%=request.getContextPath() %>/student/query/public/school-course-query" method="POST">
                    <i class="glyph-icon icon-search transparent"></i>
                    <input type="text" placeholder="输入查询课程" class="radius-all-100" name="keyword" id="keyword" onkeydown="javascript:enterSearch();"/>
                    <input type="submit" style="display:none;">
                </form>
                </div>
            </div>
        </div>
    </div>
    <div class="tips-span">
        <span class="label primary-bg">软件学院</span>
        <span class="label bg-blue">电子信息学院</span>
        <span class="label bg-green">建筑与艺术学院</span>
        <span class="label bg-azure">计算机科学与技术学院</span>
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
				/*
				$.ajax({
					url: "",
					type: "POST",
					data: {
						keyword: key
					},
					dataType: "JSON",
					success: function(res) {
						
					},
					complete: completeHandler
				});
				*/
				$("#search-course").submit();
				//location.href = 'school-course-list.html';
			}
			
		}
	}
	
	

</script>
</body>
</html>