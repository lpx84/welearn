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
	ul.menu-float {
        position: fixed;
        top: 40px;
        left: 0;
        min-width: 100px;
        font-size: 1.2em;
        line-height: 1.8em;
        box-shadow: 1px 1px 5px #B2B2B2;
        background-color: #F2F2F0;
        text-align: center;
        z-index: 10;
    }
    
    ul.menu-float li {
        border-bottom: solid 1px #DBDBD9;
    }
    
    .content-list li span {
        font-size: 1.2em;
        line-height: 2em;
    }
    
    ul.ul-inner li:nth-child(even) {
        background-color: #F7F7F7;
    }

	.content-box {
		border: none;
	}
	
	.nav-list li {
		border: solid 1px #e9ecf1;
		line-height: 2.5em;
	}
	  
</style>
</head>
<body>
	<div class="content-box">
		<ul class="menu-float" style="display: none;">
			<li><a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fstudent%2Fquery%2Fpersonal%2Fcet-grade&response_type=code&scope=snsapi_base&state=123#wechat_redirect">英语成绩</a></li>
		</ul>
		<h3 class="content-box-header bg-gray">
			<div class="glyph-icon icon-separator transparent menu-toggle">
				<i class="glyph-icon fa-bars"></i>
			</div>
			<span class="pad0L  menu-toggle">课程成绩</span>
			<div class="glyph-icon icon-separator transparent float-right">
				<i class="glyph-icon"></i>
			</div>
		</h3>
		<div class="">
			<div class="profile-box content-box">
				<div class="nav-list">
					<ul>
						<% int count=345; %>
						<c:forEach var="mapItem" items="${gradeMap }">

							<li id="rcd<%=count %>">
								<a href="javascript:gradeToggle(<%=count %>);"
									class="grade-toggle" title="" data-id="<%=count%>"> <i
										class="glyph-icon font-purple icon-time"></i> ${mapItem.key} <i
										class="glyph-icon icon-chevron-right float-right"></i>
								</a>
								<ul class="ul-inner" style="display: none;">
									<%  count=count+1; %>
									<c:forEach var="listItem" items="${mapItem.value}">
										<li class="row">
											<div class="col-xs-8">【${listItem.getType()}】${listItem.getName()}</div>
											<div class="col-xs-2">${listItem.getCredit()}</div>
											<div class="col-xs-2">${listItem.getGrade()}</div>
										</li>
									</c:forEach>
								</ul>
							</li>

						</c:forEach>

					</ul>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/public/section/public.jsp"%>
	<%@ include file="/public/section/home/footer.jsp"%>
	<script type="text/javascript">
	$(document).ready(function(){
		$(".menu-toggle").click(function(){
		    $("ul.menu-float").slideToggle("fast");
		});
		$(".menu-toggle li").click(function(){
		    $("ul.menu-float").slideToggle("fast");
		});
		$(".grade-toggle").click(function(){
		    
		});
	});
	
	function gradeToggle(id) {
		//var id = $(this).attr("data-id");
	    $("#rcd"+id+" .ul-inner").slideToggle();
	    var ico = $("#rcd"+id+" a i.float-right");
	    if(ico.hasClass("icon-chevron-right")){
	        ico.removeClass("icon-chevron-right");
	        ico.addClass("icon-chevron-down");
	    } else {
	        ico.addClass("icon-chevron-right");
	        ico.removeClass("icon-chevron-down");
	    }
	}
	</script>
</body>
</html>