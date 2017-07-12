/**
 * 添加文章
 */
define(['text!addArtTmp'],function(html){
	return function(req){
		main.html(html);
		
		//时间控件
		$(function() {
			//Date picker
			$('#datepicker').datepicker({
				autoclose : true
			});
		})
		
		//销毁um  重新渲染
		$(function() {
			if(typeof(UM.getEditor('myEditor')) !='undefined'){
		         UM.getEditor('myEditor').destroy();
		         UM.getEditor('myEditor');
			}
		})
		
		
		//保存文章 
		$("#add_art").on("click",function(){
				var ue = UM.getEditor('myEditor');
				var html = ue.getContent();
				$.ajax({
					type:"post",
					url:"article_save",
					data:{
						title:$("#title").val(),
						type:$("#type").val(),
						author:$("#author").val(),
						address:$("#address").val(),
						uptime:$("#datepicker").val(),
						content:html,
						remark:$("#remark").val(),
					},
					dataType:"json",
					success:function(res){
						layer.msg("添加文章成功！")
					},
					error:function(){
						layer.msg("添加文章失败！")
					}
				})	
		})

		
	}
});

