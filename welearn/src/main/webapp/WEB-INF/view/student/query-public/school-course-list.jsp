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
</style>
</head>
<body>
<div class="content-box bg-white">
    <h3 class="title-span content-box-header ui-state-default">
        <div class="glyph-icon icon-separator transparent">
            <i class="glyph-icon icon-chevron-left"></i>
        </div>
        <label class="pad0L">软件系统分析以设计技术</label>
    </h3>
    <div class="content-box-wrapper" style="padding-top: 50px;">
        <div class="scrollable-content">

            <ul class="chat-box">
                <li>
                    <div class="chat-author">
                        <img width="36" src="../assets/images/gravatar.jpg" alt="" />
                    </div>
                    <div class="popover left no-shadow">
                        <div class="arrow"></div>
                        <div class="popover-content">
                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec odio. Quisque volutpat mattis eros. Nullam malesuada erat ut turpis. Suspendisse urna nibh, viverra non, semper suscipit, posuere a, pede.
                                <div class="chat-time">
                                    <i class="glyph-icon icon-time"></i>
                                    a few seconds ago
                                </div>
                        </div>
                    </div>
                </li>
                <li class="float-left">
                    <div class="chat-author">
                        <img width="36" src="../assets/images/gravatar.jpg" alt="" />
                    </div>
                    <div class="popover right no-shadow">
                        <div class="arrow"></div>
                        <div class="popover-content">
                                <h3>
                                    <a href="#" title="Horia Simon">Horia Simon</a>
                                    <div class="float-right">
                                        <a href="#" class="btn glyph-icon icon-inbox font-gray tooltip-button" data-placement="bottom" title="This chat line was received in the mail."></a>
                                    </div>
                                </h3>
                                This comment line has a title (author name) and a right button panel.
                                <div class="chat-time">
                                    <i class="glyph-icon icon-time"></i>
                                    a few seconds ago
                                </div>
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
                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec odio. Quisque volutpat mattis eros. Nullam malesuada erat ut turpis. Suspendisse urna nibh, viverra non, semper suscipit, posuere a, pede.
                                <div class="chat-time">
                                    <i class="glyph-icon icon-time"></i>
                                    a few seconds ago
                                </div>
                        </div>
                    </div>
                </li>
                <li class="float-left">
                    <div class="chat-author">
                        <img width="36" src="../assets/images/gravatar.jpg" alt="" />
                    </div>
                    <div class="popover right no-shadow">
                        <div class="arrow"></div>
                        <div class="popover-content">
                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec odio. Quisque volutpat mattis eros. Nullam malesuada erat ut turpis. Suspendisse urna nibh, viverra non, semper suscipit, posuere a, pede.
                                <div class="chat-time">
                                    <i class="glyph-icon icon-time"></i>
                                    a few seconds ago
                                </div>
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
                        <i class="glyph-icon icon-mail-reply"></i>
                    </a>
                    <div class="append-right">
                        <input type="text" placeholder="Say something here..." name="" id="" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
</body>
</html>