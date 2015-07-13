<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
	<div id="loading" class="ui-front loader ui-widget-overlay bg-gray opacity-100">
       <img src="<%=request.getContextPath() %>/public/assets/images/loader-dark.gif" alt="" />
   </div>
   <!-- 公共的确认框 -->
    <div id="modal-confirm" class="force-fixed hide ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-dialog-buttons ui-draggable ui-resizable" tabindex="-1" role="dialog">
        <div class="ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix">
            <span class="ui-dialog-title">确认</span>
            <button data="modal-new-theme" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ui-dialog-titlebar-close dialog-btn-close" role="button" aria-disabled="false" title="close">
                <span class="ui-button-icon-primary ui-icon ui-icon-closethick"></span>
                <span class="ui-button-text">Close</span>
            </button>
        </div>
        <div class="ui-dialog-content ui-widget-content">
            <div class="pad10A">
                
                <input id="confirmRcdId" type="hidden">
                <input id="confirmOperType" type="hidden">
                <label class="tips"></label>
            </div>
        </div>
        <div class="ui-dialog-buttonpane ui-widget-content ui-helper-clearfix">
            <div class="ui-dialog-buttonset">
                <button id="confirm-btn-ok" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only dialog-btn-close">
                    <span class="ui-button-text">确定</span>
                </button>
                <button class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only dialog-btn-close">
                    <span class="ui-button-text">取消</span>
                </button>
            </div>
        </div>
    </div><!-- 确认框结束 -->
   
   