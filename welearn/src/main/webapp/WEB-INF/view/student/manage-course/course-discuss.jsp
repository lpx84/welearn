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
    .title-span {
        position: fixed;
        width: 100%;
        z-index: 100;
        text-align: center;
    }
    
    .reply-span {
        position: fixed;
        z-index: 100;
        bottom: 0;
        width: calc(100% - 20px);
    }
    
    .user-name,.info {
        font-size: 0.7em !important;
        line-height: 2em;
        color: #bebebe;
    }
    
    .popover {
        width: 95% !important;
    }
    
    .content-box {
        position: fixed;
        width: 100%;
        height: 90%;
        padding-bottom: 50px;
        overflow: auto;
    }   
   
</style>
</head>
<body>
<div class="content-box bg-white">
    <h3 class="title-span content-box-header ui-state-default">
        <label class="pad0L">软件系统分析以设计技术</label>
    </h3>
    <div class="content-box-wrapper" style="padding-top: 50px;">
        <div class="scrollable-content">

            <ul class="chat-box">
                <li class="float-left">
                    <div class="chat-author">
                        <img width="36" src="../assets/images/gravatar.jpg" alt="" />
                    </div>
                    <div class="popover right no-shadow">
                        <div class="arrow"></div>
                        <div class="popover-content">
                            <div class="info">
                                <span>张红延</span>
                                <span class="float-right"><i class="glyph-icon icon-time"></i> 02:43:23</span>
                            </div>
                            大家有什么问题尽管提
                        </div>
                    </div>
                </li>

                <li>
                    <div class="chat-author">
                        <img width="36" src="../assets/images/gravatar.jpg" alt="" />
                    </div>
                    <div class="popover left no-shadow">
                        <div class="arrow"></div>
                        <div class="popover-content">
                            <div class="info">
                                <span>陈朝朝</span>
                                <span class="float-right"><i class="glyph-icon icon-time"></i> 02:43:23</span>
                            </div>
                            老师辛苦了！！！
                        </div>
                    </div>
                </li>
                
            </ul>

        </div>
    </div>
    <div class="button-pane reply-span pad10A">
        <div class="form-row pad0B">
            <div class="form-input col-lg-12">
                <div class="input-append-wrapper input-append-right">
                    <a href="javascript:;" class="btn input-append primary-bg">
                        <i class="glyph-icon fa-send"></i>
                    </a>
                    <div class="append-right">
                        <input type="text" placeholder="输入你的问题" name="" id="" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">

</script>
</body>
</html>