<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/section/teacher/header-mobile.jsp"%>
<title>${title }</title>
<style type="text/css">
.nav-footer {
	font-size: 2em;
}

.item .glyph-icon {
	padding: 0 6px;
	vertical-align: top;
	margin-top: 10px;
}

.name {
	margin-left: 7px;
}
</style>
</head>
<body>
	<div class="main">
		<div class="header">
			<i class="glyph-icon icon-chevron-left float-left btn-back"></i>
			<p>签到任务列表</p>
		</div>
		<div class="course-list">
			<c:forEach var="item" items="${list }">
				<div class="item pad5A"
					onclick="javascript: location.href='attend-detail?taskId=${item.getAttendId() }';">
					<i class="btn bg-blue glyph-icon icon-picture"></i>
					<div class="display-inline">
						<div class="name">
							<label>${item.getContent() }</label> <span
								class="label bg-purple mrg5L">${item.getAttendNum() }/${item.getStuNum() }</span>
						</div>
						<div class="comment pad5L">
							<span class="font-gray"> <i class="glyph-icon icon-time"></i>${item.getStartTime() }&nbsp;~&nbsp;${item.getEndTime() }
							</span>

						</div>
					</div>
					<div class="display-inline float-right">
						<i class="glyph-icon icon-chevron-right"></i>
					</div>
				</div>
			</c:forEach>

			<div class="span-more">
				<a href="javascript:void(0);"
					class="btn btn-more medium ui-state-default"> <span
					class="button-content">已显示全部</span>
				</a>
			</div>

			<div class="nav-footer footer bg-blue" onclick="location.href='add-attend-task'">
				<i class="glyph-icon icon-plus-sign font-gray"></i> 添加签到任务
			</div>
		</div>
		<%@ include file="/public/section/public.jsp"%>
</body>
</html>