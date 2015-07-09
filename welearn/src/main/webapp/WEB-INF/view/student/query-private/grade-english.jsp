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
	<div id="subject22" class="content-box">
		<h3 class="content-box-header ui-state-default" data-id="22">
			<div class="glyph-icon icon-separator transparent float-right">
				<i class="glyph-icon icon-chevron-down"></i>
			</div>
			<span>软件系统分析与设计技术</span>
		</h3>
		<div class="content-box-wrapper">
			<div class="row">
				<div class="col-md-2 col-sm-2 col-xs-4">
					<label class="font-gray">校区：</label>
				</div>
				<div class="col-md-10 col-sm-10 col-xs-8">
					<span>主校区</span>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2 col-sm-2 col-xs-4">
					<label class="font-gray">教学楼：</label>
				</div>
				<div class="col-md-10 col-sm-10 col-xs-8">
					<span>第九教学楼</span>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2 col-sm-2 col-xs-4">
					<label class="font-gray">教室：</label>
				</div>
				<div class="col-md-10 col-sm-10 col-xs-8">
					<span class="label bg-yellow">中101</span>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2 col-sm-2 col-xs-4">
					<label class="font-gray">准考证号：</label>
				</div>
				<div class="col-md-10 col-sm-10 col-xs-8">
					<span class="label bg-green">201050706312432</span>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2 col-sm-2 col-xs-4">
					<label class="font-gray">考试时间：</label>
				</div>
				<div class="col-md-10 col-sm-10 col-xs-8">
					<p>
						<span>2015-07-06 7:00</span> ——
					</p>
					<p>
						<span>2015-07-06 9:00</span>
					</p>
				</div>
			</div>
		</div>
	</div>

	<div id="subject23" class="content-box">
		<h3 class="content-box-header ui-state-default" data-id="23">
			<div class="glyph-icon icon-separator transparent float-right">
				<i class="glyph-icon icon-chevron-down"></i>
			</div>
			<span>软件系统分析与设计技术</span>
		</h3>
		<div class="content-box-wrapper">
			<div class="row">
				<div class="col-md-2 col-sm-2 col-xs-4">
					<label class="font-gray">校区：</label>
				</div>
				<div class="col-md-10 col-sm-10 col-xs-8">
					<span>主校区</span>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2 col-sm-2 col-xs-4">
					<label class="font-gray">教学楼：</label>
				</div>
				<div class="col-md-10 col-sm-10 col-xs-8">
					<span>第九教学楼</span>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2 col-sm-2 col-xs-4">
					<label class="font-gray">教室：</label>
				</div>
				<div class="col-md-10 col-sm-10 col-xs-8">
					<span class="label bg-yellow">中101</span>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2 col-sm-2 col-xs-4">
					<label class="font-gray">准考证号：</label>
				</div>
				<div class="col-md-10 col-sm-10 col-xs-8">
					<span class="label bg-green">201050706312432</span>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2 col-sm-2 col-xs-4">
					<label class="font-gray">考试时间：</label>
				</div>
				<div class="col-md-10 col-sm-10 col-xs-8">
					<p>
						<span>2015-07-06 7:00</span> ——
					</p>
					<p>
						<span>2015-07-06 9:00</span>
					</p>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/public/section/public.jsp"%>
	<%@ include file="/public/section/home/footer.jsp"%>
<script type="text/javascript">
    $(".content-box .content-box-header").click(function(event){
        var id=$(this).attr("data-id");
        var i = $("#subject"+id+" .glyph-icon i");
        var content = $("#subject"+id+" .content-box-wrapper");
        if(i.hasClass("icon-chevron-down")) {
            i.removeClass("icon-chevron-down");
            i.addClass("icon-chevron-right");
            content.slideUp();
        } else {
            i.removeClass("icon-chevron-right");
            i.addClass("icon-chevron-down");
            content.slideDown();
        }
    });
</script>
</body>
</html>