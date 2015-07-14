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
    .title {
        text-align: center;
    }
   
</style>
</head>
<body>
<div class="content-box" style="border: none;">
    <h3 class="content-box-header bg-gray">
        <div class="glyph-icon icon-separator transparent back-btn">
            <i class="glyph-icon fa-chevron-left"></i>
        </div>
        <span class="title">课程反馈</span>
        <div class="glyph-icon icon-separator transparent float-right">
            <i class="glyph-icon"></i>
        </div>
    </h3>
    <div class="row">
        <div class="col-md-12">
            <form class="content-box bg-white post-box">
                <textarea name="content" class="textarea-autoresize" id="" placeholder="请填写对本门课程的意见和建议" style="height: 200px;"></textarea>
                <div class="button-pane">
                    <div class="btn x-large" title="" style="font-size: 1.2em; margin-left:10px;">
                        <input name="anonymity" id="anonymity" type="checkbox" checked="checked" style="width: 1.5em;">
                        <label for="anonymity">匿名</label>
                    </div>
                    
                    <a href="javascript:;" class="btn btn-post large bg-green" title="">
                        <span class="button-content">提交</span>
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">

</script>
</body>
</html>