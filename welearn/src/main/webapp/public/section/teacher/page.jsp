<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    				<div class="row">
                        <div class="col-md-3">
                            <a id="prePage" class="btn medium hover-blue" href="javascript:query(-1);">
                                <i class="glyph-icon icon-double-angle-left float-left"></i>
                                <span class="button-content">上一页</span>
                            </a>
                            <span id="currPage" class="label bg-gray">0</span>/<span id="totalPage" class="label bg-gray">0</span>
                            <a id="nextPage" class="btn medium hover-blue" href="javascript:query(1);">
                                <span class="button-content">下一页</span>
                                <i class="glyph-icon icon-double-angle-right"></i>
                            </a>
                        </div>
                    </div>