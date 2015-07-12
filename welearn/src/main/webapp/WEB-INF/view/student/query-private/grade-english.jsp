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
    
    table.cet {
        width: 100%;
        border-color: #EFEFEF;
    }
    table.cet td,
    table.cet th {
        padding: 8px;
    }
</style>
</head>
<body>
	<ul class="menu-float" style="display: none;">
		<li><a
			href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fquery%2Fpersonal%2Fcourse-grade&response_type=code&scope=snsapi_base&state=123#wechat_redirect">课程成绩</a></li>
	</ul>
	<h3 class="content-box-header bg-gray" style="  margin-top: 0;font-size: 14px;">
		<div class="glyph-icon icon-separator transparent menu-toggle">
			<i class="glyph-icon fa-bars"></i>
		</div>
		<span class="pad0L  menu-toggle">英语成绩</span>
		<div class="glyph-icon icon-separator transparent float-right">
			<i class="glyph-icon"></i>
		</div>
	</h3>
	<div class="">
		<div class="profile-box content-box">
			<div class="nav-list">
				<ul>
					<li id="rcd342"><a href="javascript:;" class="grade-toggle"
						title="" data-id="342"> <i
							class="glyph-icon font-purple icon-dashboard"></i> 大学英语四级 <i
							class="glyph-icon icon-chevron-right float-right"></i>
					</a> <c:forEach var="cet4Item" items="${cet4List }">
							<ul class="ul-inner" style="display: none;">
								<table class="cet" border="1" align="center" cellpadding="0"
									cellspacing="6">
									<tbody>
										<tr>
											<th>姓名：</th>
											<td>${cet4Item.getName() }</td>
										</tr>
										<tr>
											<th>学校：</th>
											<td>${cet4Item.getSchool() }</td>
										</tr>
										<tr>
											<th>考试类别：</th>
											<td>${cet4Item.getType() }</td>
										</tr>
										<tr>
											<th>准考证号：</th>
											<td>${cet4Item.getExamNo() }</td>
										</tr>
										<tr>
											<th>考试时间：</th>
											<td>${cet4Item.getTime() }</td>
										</tr>
										<tr>
											<th>听力：</th>
											<td>${cet4Item.getListen() }</td>
										</tr>
										<tr>
											<th>阅读：</th>
											<td>${cet4Item.getRead() }</td>
										</tr>
										<tr>
											<th>写作与翻译：</th>
											<td>${cet4Item.getWrite() }</td>
										</tr>
										<tr>
											<th>总分：</th>
											<td>${cet4Item.getTotal() }</td>
										</tr>
									</tbody>
								</table>
							</ul>
						</c:forEach></li>

					<li id="rcd343"><a href="javascript:;" class="grade-toggle"
						title="" data-id="343"> <i
							class="glyph-icon font-purple icon-dashboard"></i> 大学英语六级 <i
							class="glyph-icon icon-chevron-right float-right"></i>
					</a> <c:forEach var="cet6Item" items="${cet6List }">
							<ul class="ul-inner" style="display: none;">
								<table class="cet" border="1" align="center" cellpadding="0"
									cellspacing="6">
									<tbody>
										<tr>
											<th>姓名：</th>
											<td>${cet6Item.getName() }</td>
										</tr>
										<tr>
											<th>学校：</th>
											<td>${cet6Item.getSchool() }</td>
										</tr>
										<tr>
											<th>考试类别：</th>
											<td>${cet6Item.getType() }</td>
										</tr>
										<tr>
											<th>准考证号：</th>
											<td>${cet6Item.getExamNo() }</td>
										</tr>
										<tr>
											<th>考试时间：</th>
											<td>${cet6Item.getTime() }</td>
										</tr>
										<tr>
											<th>听力：</th>
											<td>${cet6Item.getListen() }</td>
										</tr>
										<tr>
											<th>阅读：</th>
											<td>${cet6Item.getRead() }</td>
										</tr>
										<tr>
											<th>写作与翻译：</th>
											<td>${cet6Item.getWrite() }</td>
										</tr>
										<tr>
											<th>总分：</th>
											<td>${cet6Item.getTotal() }</td>
										</tr>
									</tbody>
								</table>
							</ul>
						</c:forEach></li>
				</ul>
			</div>
		</div>
	</div>
	</div>
	<%@ include file="/public/section/public.jsp"%>
	<%@ include file="/public/section/home/footer.jsp"%>
	<script type="text/javascript">
		$(".menu-toggle").click(function() {
			$("ul.menu-float").slideToggle("fast");
		});
		$(".menu-toggle li").click(function() {
			$("ul.menu-float").slideToggle("fast");
		});

		$(".grade-toggle").click(function() {
			var id = $(this).attr("data-id");
			$("#rcd" + id + " .ul-inner").slideToggle();
			var ico = $("#rcd" + id + " a i.float-right");
			if (ico.hasClass("icon-chevron-right")) {
				ico.removeClass("icon-chevron-right");
				ico.addClass("icon-chevron-down");
			} else {
				ico.addClass("icon-chevron-right");
				ico.removeClass("icon-chevron-down");
			}
		});
	</script>
</body>
</html>