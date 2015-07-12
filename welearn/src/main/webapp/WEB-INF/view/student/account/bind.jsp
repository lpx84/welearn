<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/section/home/header.jsp" %>
<script type="text/javascript" src="<%=request.getContextPath() %>/public/js/md5.js"></script>
<title>${title }</title>
<style type="text/css">
   .title {
          text-align: center;
    }
</style>
</head>
<body>
<div class="content-box">
    <h3 class="content-box-header bg-gray">
        <p class="pad0L title">绑定学号</p>
    </h3>
    <form id="student-bind" action="<%=request.getContextPath()%>/student/account/bind.act" class="col-md-3 center-margin form-vertical mrg25T" method="POST">

        <div id="login-form" class="content-box">
            
            <div class="content-box-wrapper pad20A pad0B">
            	<input type="hidden" name="openId" value="${openId }">
            	<input type="hidden" name="pwd" id="pwd" value="">
                <div class="form-row">
                    <div class="form-label col-md-2">
                        <label for="login_email">学号:
                            <span class="required">*</span>
                        </label>
                    </div>
                    <div class="form-input col-md-10">
                        <div class="form-input-icon">
                            <i class="glyph-icon fa-user ui-state-default"></i>
                            <input placeholder="8位数字" data-type="number" data-trigger="change" data-required="true" type="text" name="studentNo" id="studentNo" />
                        </div>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-label col-md-2">
                        <label for="login_pass">密码:
                            <span class="required">*</span>
                        </label>
                    </div>
                    <div class="form-input col-md-10">
                        <div class="form-input-icon">
                            <i class="glyph-icon fa-lock ui-state-default"></i>
                            <input placeholder="教务处密码" data-trigger="keyup" data-rangelength="[3,25]" type="password" name="prepwd" id="prepwd" />
                        </div>
                    </div>
                </div>
            </div>
            <div class="button-pane text-center">
                <button id="btn-bind" type="button" class="btn large primary-bg text-transform-upr font-size-11" id="demo-form-valid" title="Validate!">
                    <span class="button-content">绑定 </span>
                </button>
            </div>
        </div>
        
    </form>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">
$("#btn-bind").click(function() {
	var prepwd = $("#prepwd").val();
	if('' != prepwd) {
		$("#pwd").val(hex_md5(prepwd));
		$("#student-bind").submit();
	}
});
</script>
</body>
</html>