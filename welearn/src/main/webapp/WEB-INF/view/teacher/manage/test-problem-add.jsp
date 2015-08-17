<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/section/teacher/header-mobile.jsp" %>
<title>${title }</title>
<style type="text/css">
   
    .content {
        padding: 10px;
    }
    .options>.input-append-wrapper {
        margin-bottom: 10px;
    }
    
    a.btn {
        padding-right: 10px;
    }   
</style>
</head>
<body>
<div class="main">
    <div class="header">
        <i class="glyph-icon icon-chevron-left float-left btn-back"></i>
        <p>增加题目</p>
    </div>
    
    <div class="content">
        <div class="form-row">
            <div class="form-label  col-md-2">
                <label for="">题目：</label>
            </div>
            <div class="form-input col-md-10">
                <textarea id="problem-content" placeholder="问题内容" type="text" name="" rows='2'></textarea>
            </div>
        </div>
        <div class="form-row">
            <div class="form-label col-md-2">
                <label for="">
                    <span>选项：</span>
                    <a href="javascript:addOption();" class="btn small bg-blue float-right">
                        <span class="button-content">
                            <i class="glyph-icon icon-plus float-left"></i> 选项
                        </span>
                    </a>
                </label>
                
            </div>
            <div class="options form-input col-md-10">
                <div id="option-template" style="display: none;">
                    <div class="option input-append-wrapper" data-code="A">
                        <div class="code input-append bg-purple">A</div>
                        <div class="form-input-icon icon-right append-left">
                            <i class="glyph-icon icon-remove-circle bg-gray-alt"></i>
                            <input class="option-content" type="text" placeholder="选项内容"/>
                        </div>
                    </div>
                </div>
                
                
            </div>
            
        </div>
        <div class="form-row">
            <div class="form-label col-xs-2 col-md-2">
                <label for="">答案：</label>
            </div>
            <div class="form-input col-xs-2 col-md-10">
                <select class="answer">
                </select>
            </div>
        </div>
    </div>
    
    <div class="nav-footer footer btn-footer">
        <div class="footer-item bg-blue" onclick="javascript: void(0);">
            提交
        </div>
    </div>
</div>
<%@ include file="/public/section/public.jsp" %>
<script type="text/javascript">
var index = 0;
var codes = ['A','B','C','D','E','F','G','H','I','J'];
$(document).ready(function() {
    for(index = 0;index < 4; index++) {
        var opt = $("#option-template").find('.option').clone();
        opt.attr('data-code',codes[index]);
        opt.find('.code').html(codes[index]);
        $('.options').append(opt);
        $('select.answer').append("<option value='"+codes[index]+"'>"+codes[index]+"</option>");
    }
});

function addOption() {
    
}
</script>
</body>
</html>