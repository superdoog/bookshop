var readerObj;
var path = $("#path").val();

function deleteReader(obj){
	$.ajax({
		type:"GET",
		url:path+"/deleteReader",
		data:{reader_id:obj.attr("reader_id")},
		dataType:"json",
		success:function(data){
			if(data.delResult == "true"){//删除成功：移除删除行
				cancleBtn();
				obj.parents("tr").remove();
			}else if(data.delResult == "false"){//删除失败
				//alert("对不起，删除用户【"+obj.attr("username")+"】失败");
				changeDLGContent("对不起，删除读者【"+obj.attr("username")+"】失败");
			}else if(data.delResult == "notexist"){
				//alert("对不起，用户【"+obj.attr("username")+"】不存在");
				changeDLGContent("对不起，读者【"+obj.attr("username")+"】不存在");
			}
		},
		error:function(data){
			//alert("对不起，删除失败");
			changeDLGContent("对不起，删除失败");
		}
	});
}

function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeUse').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeUse').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}

$(function(){
	//通过jquery的class选择器（数组）
	//进行动作绑定（click）
	/**
	 * bind、live、delegate
	 * on
	 */

	$('#no').click(function () {
		cancleBtn();
	});
	
	$('#yes').click(function () {
		deleteReader(readerObj);
	});

	$(".deleteReader").on("click",function(){
		readerObj = $(this);
		changeDLGContent("你确定要删除【"+readerObj.attr("username")+"】吗？");
		openYesOrNoDLG();
	});

});