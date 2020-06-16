<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
var boardNum = '${inquiry.boardNum}'; //게시글 번호

/* 댓글 내용이 없으면 alert창 띄우기  */
$(document).on('click', '#btnReply', function(e){
	if($("#replyContent").val()==""){
		alert("댓글 내용을 입력하세요");
		$("#replyContent").focus();
		return false;
	}
	 var insertData = $('#replyForm').serialize();
	 alert(insertData);
	 replyInsert(insertData); 
});
	   
//댓글 목록 
function replyList(){
	var url = '${pageContext.request.contextPath}/answerList';
    $.ajax({
        url : url,
        type : 'get',
        data : {"boardNum":boardNum},
        dataType: 'json',
        success : function(data){
            var html =''; 
            if(data.length < 1){
				html += ("등록된 댓글이 없습니다.");
			}
            else {
	            $.each(data, function(key, value){
	            	var userID = "<%=(String)session.getAttribute("userID")%>"
	            	/* 부모 댓글일 경우  */
	            	if (value.replyParents == 0) {
		            	html += '<li class="comment">';
		                html += '<div class="comment-body" id="answerNum' + this.answerNum + '">'
		                html += '<h3>' + value.userID + '</h3>';
		                html += '<div class="meta">' + value.replyDate + '</div>';
	                    html += '<p>' + value.replyContent + '</p>';
	                    /* 로그인한 사용자에게만 적용 */
	                    if (userID != 'null') {
	                    	html += '<p><a onclick="insertReReply('+value.answerNum+',\''+ value.boardNum+'\');" class="reply">Reply</a></p>';
	                   		/* 현재 사용자가 댓글 작성자일 때  */
		                   	if (userID == value.userID) {
		                       	html += '<a style="padding-right:5px" onclick="replyUpdate(' + this.answerNum + ', \'' + this.replyContent + '\', \'' + this.userID + '\' );"> 수정 </a>';
		                        html += '<a onclick="replyDelete('+value.answerNum+',\''+ value.boardNum+'\');"> 삭제 </a>';
		                    }
	                    }
	  	              	html += '</div>';
	  	              	html += '</li>';
	  	              	html += '<div id="reReply' + this.answerNum +'"></div>';
	            	}
	            	/* 답글일 경우, 부모 댓글과 답글 기능이 없다는 점 빼고는 동일  */
	            	else {
		            		html += '<ul class="children">';
		            		html += '<li class="comment">';
			                html += '<div class="comment-body" id="answerNum' + this.answerNum + '">'
			                html += '<h3>' + value.userID + '</h3>';
			                html += '<div class="meta">' + value.replyDate + '</div>';
		                    html += '<p>' + value.replyContent + '</p>';
		                    /* 로그인한 사용자에게만 적용 */
		                    if (userID != 'null') {
		                   		/* 현재 사용자가 댓글 작성자일 때  */
			                   	if (userID == value.userID) {
			                       	html += '<a style="padding-right:5px" onclick="replyUpdate(' + this.answerNum + ', \'' + this.replyContent + '\', \'' + this.userID + '\' );"> 수정 </a>';
			                        html += '<a onclick="replyDelete('+value.answerNum+',\''+ value.boardNum+'\');"> 삭제 </a>';
			                    }
		                    }
		  	              	html += '</div>';
		  	              	html += '</li>';
		  	              	html += '</ul>'
		            }
	            }); 
            }
            $("#replyList").html(html);
        }
    });
}
 
//댓글 등록
function replyInsert(insertData){
    $.ajax({
        url : '${pageContext.request.contextPath}/insertAnswer',
        type : 'post',
        data : insertData,
        success : function(data){
        	replyList();
            $('#replyContent').val('');
        }
    });
}

//댓글 수정 - 댓글 내용 출력을 input 폼으로 변경 
function replyUpdate(answerNum, replyContent, userID){
	var htmls = "";
	htmls += '<div class="form-group" id="answerNum' + replyNum + '">';
	htmls += '<textarea class="form-control" cols="10" rows="5" id="editContent" name="editContent" style="border:1px solid #ccc">';
	htmls += replyContent;
	htmls += '</textarea>';
	htmls+= '<div style="float:right">';
	htmls += '<a onclick="replyUpdateProc('+answerNum+')">저장</a>';
	htmls += '<a onClick="replyList()" style="padding-left:5px">취소<a>';
	htmls += '</div>';
	htmls += '</div>';
	$('#replyNum' + answerNum).replaceWith(htmls);
	$('#replyNum' + answerNum + ' #editContent').focus();
}
 
//댓글 수정
function replyUpdateProc(answerNum){
	if($("#editContent").val()==""){
		alert("댓글 내용을 입력하세요");
		$("#editContent").focus();
		return false;
	}
    var updateContent = $('#editContent').val(); 
    $.ajax({
        url : '${pageContext.request.contextPath}/updateAnswer',
        type : 'post',
        data : {"answerNum" : replyNum, "replyContent" : updateContent},
        success : function(data){
             replyList();
        }
    });
}

// 답글 작성
function insertReReply(answerNum, boardNum){
	var htmls = "";
	htmls += '<form id="reReplyForm">';
	htmls += '<ul class="children">';
	htmls += '<li class="comment">';
    htmls += '<div class="comment-body" id="replyNum' + this.answerNum + '">'
	htmls += '<textarea class="form-control" cols="10" rows="5" id="reReplyContent" name="reReplyContent" style="border:1px solid #ccc"></textarea>';
	htmls+= '<div style="float:right">';
	htmls += '<a onclick="reReplyProc('+answerNum+')" style="padding-right:15px">저장</a>';
	htmls += '<a onClick="replyList()">취소<a>';
	htmls += '</div>';
	htmls += '</div>';
	htmls += '</form>';
	$("#reReply" + answerNum).html(htmls);
}
//답글 저장
function reReplyProc(answerNum){
	if($("#reReplyContent").val()==""){
		alert("댓글 내용을 입력하세요");
		$("#reReplyContent").focus();
		return false;
	}
	var reReplyContent = $('#reReplyContent').val();
    $.ajax({
        url : '${pageContext.request.contextPath}/answerReReply',
        type : 'post',
        data : {'replyContent' : reReplyContent, 'answerNum' : answerNum},
        success : function(data){
            replyList();
        }
    });
}
 
//댓글 삭제 
function replyDelete(answerNum, boardNum){
	if (confirm('댓글을 삭제하시겠습니까?')) {
	    $.ajax({
	        url : '${pageContext.request.contextPath}/deleteAnswerReply',
	        data: {"answerNum":answerNum, 'boardNum':boardNum},
	        type : 'post',
	        success : function(data){
	          	replyList(); //댓글 삭제후 목록 출력 
	        }
	    });
	}
}

$(document).ready(function(){
    replyList(); //페이지 로딩시 댓글 목록 출력 
});
</script>