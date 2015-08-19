<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/section/home/header.jsp"%>
<title>${title }</title>
<style type="text/css">
.content-box {
	margin: 5px;
}
</style>
</head>
<body>
<div class="main">
	<div class="header">
		<i class="glyph-icon icon-chevron-left float-left btn-back"></i>
        <p>考试安排</p>
    </div>
	<%int count =0; %>
	<c:forEach var="item" items="${list }">
	    <%count++; %>
		<div id="subject<%=count %>" class="content-box">
			<h3 class="content-box-header ui-state-default" data-id="<%=count%>">
				<div class="glyph-icon icon-separator transparent float-right">
					<i class="glyph-icon fa-chevron-down"></i>
				</div>
				<span>${item.getName() }</span>
			</h3>
			<div class="content-box-wrapper">
				<div class="row">
					<div class="col-md-2 col-sm-2 col-xs-4">
						<label class="font-gray">校区：</label>
					</div>
					<div class="col-md-10 col-sm-10 col-xs-8">
						<span>${item.getSection() }</span>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 col-sm-2 col-xs-4">
						<label class="font-gray">教学楼：</label>
					</div>
					<div class="col-md-10 col-sm-10 col-xs-8">
						<span>${item.getBuilding() }</span>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 col-sm-2 col-xs-4">
						<label class="font-gray">教室：</label>
					</div>
					<div class="col-md-10 col-sm-10 col-xs-8">
						<span class="label bg-yellow">${item.getClassRoom() }</span>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 col-sm-2 col-xs-4">
						<label class="font-gray">准考证号：</label>
					</div>
					<div class="col-md-10 col-sm-10 col-xs-8">
						<span class="label bg-green">${item.getExamNo() }</span>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 col-sm-2 col-xs-4">
						<label class="font-gray">考试时间：</label>
					</div>
					<div class="col-md-10 col-sm-10 col-xs-8">					
							<span>${item.getTime() }</span>	
					</div>
				</div>
			</div>
		</div>
	
	</c:forEach>
</div>
	<%@ include file="/public/section/public.jsp"%>
	<%@ include file="/public/section/home/footer.jsp"%>
	<script type="text/javascript">
    $(".content-box .content-box-header").click(function(event){
        var id=$(this).attr("data-id");
        var i = $("#subject"+id+" .glyph-icon i");
        var content = $("#subject"+id+" .content-box-wrapper");
        if(i.hasClass("fa-chevron-down")) {
            i.removeClass("fa-chevron-down");
            i.addClass("fa-chevron-right");
            content.slideUp();
        } else {
            i.removeClass("fa-chevron-right");
            i.addClass("fa-chevron-down");
            content.slideDown();
        }
    });
</script>
</body>
</html>