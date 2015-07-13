<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
						<div class="form-label col-md-2">
                            <label for="">上传文件：</label>
                        </div>
                        <div class="form-input col-md-10">
                        	<h5>附件列表：</h5>
                            <div class="file-list"></div>
                            <form id="form-file" action="<%=request.getContextPath() %>/upload/attach" method="POST" enctype="multipart/form-data">
                            	<input id="file" name="file" style="margin-top:10px;" type="file" onchange="javascript:$('#form-file').submit();">
                            </form>
                            <p class="font-gray">文件大小限制是5M，格式支持jpg,png,gif,bmp,,doc,docx,xls,xlsx,rar,zip格式</p>
                        </div>