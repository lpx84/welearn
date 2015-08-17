<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String path = request.getContextPath(); %>
<div class="nav-footer footer">
	<div class="row">
        <c:if test="${type ==  1}">
            <div class="col-xs-4 nav-item selected" onclick="location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fteacher%2Fnotify%2Fnotify-index&response_type=code&scope=snsapi_base&state=123#wechat_redirect'">
        </c:if> 	
        <c:if test="${type !=  1}">
            <div class="col-xs-4 nav-item" onclick="location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fteacher%2Fnotify%2Fnotify-index&response_type=code&scope=snsapi_base&state=123#wechat_redirect'">
        </c:if> 
			<div class="icon">
				<i class="glyph-icon fa-bell"></i>
			</div>			
			<div class="text">通知</div>
		</div>
        <c:if test="${type ==  2}">
            <div class="col-xs-4 nav-item selected" onclick="location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fteacher%2Fcourse%2Fcourse-index&response_type=code&scope=snsapi_base&state=123#wechat_redirect'">
        </c:if> 	
        <c:if test="${type != 2}">
            <div class="col-xs-4 nav-item" onclick="location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fteacher%2Fcourse%2Fcourse-index&response_type=code&scope=snsapi_base&state=123#wechat_redirect'">
        </c:if> 
			<div class="icon">
				<i class="glyph-icon fa-book"></i>
			</div>
			<div class="text">课程</div>
		</div>
        <c:if test="${type ==  3}">
            <div class="col-xs-4 nav-item selected" onclick="location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fteacher%2Fpersonal%2Fpersonal-index&response_type=code&scope=snsapi_base&state=123#wechat_redirect'">
        </c:if> 	
        <c:if test="${type != 3}">
            <div class="col-xs-4 nav-item" onclick="location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fteacher%2Fpersonal%2Fpersonal-index&response_type=code&scope=snsapi_base&state=123#wechat_redirect'">
        </c:if> 
			<div class="icon">
				<i class="glyph-icon fa-user"></i>
			</div>
			<div class="text">个人</div>
		</div>
	</div>
</div>
