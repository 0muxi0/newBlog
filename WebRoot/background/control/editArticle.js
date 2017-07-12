/**
 * 添加文章
 */
define(['text!editArtTmp'],function(html){
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
			}else{
				UM.getEditor('myEditor');
			}
		})
		
		
		//根据id请求文章并渲染
		$(function(){
			var aid=req;
			console.log(aid);
			$.ajax({
					type:"post",
					dataType:"json",
					url:"article_edit", 
					data:{
						aid:aid,
					},
					success:function(res){
						$("#title").val(res.data.title);
						$("#type").val(res.data.type);
						$("#author").val(res.data.author);
						$("#datepicker").val(res.data.uptime);
						$("#address").val(res.data.address);
						$("#remark").val(res.data.remark);
						/*UE.getEditor('editor').ready(function() {
						    //this是当前创建的编辑器实例
							console.log(res.data.remark);
						    this.setContent('ss')
						});*/
						var s=res.data.content;
						//渲染数据到ueditor
						var um = UM.getEditor('myEditor');
						um.setContent(s);
			
						/*um.ready(function() {
						    um.setContent(s);
						});*/
					}
			})
		})
		
		
		
		//修改文章 
		$("#edit_art").on("click",function(){
				var um = UM.getEditor('myEditor');
				var html = um.getContent();
				var aid=req;
				$.ajax({
					type:"post",
					url:"article_update",
					data:{
						aid:aid,
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
						if(res.returnCode==0){
							layer.msg("文章修改成功！");
							window.history.back();
						}else{
							layer.msg("文章修改失败！");
						}
					},
				})	
		});
		
		
		//删除文章
		$("#delete_art").on("click",function(){
			var aid=req;
			$.ajax({
				type:"post",
				dataType:"json",
				url:"article_delete",
				data:{
					aid:aid,
				},
				success:function(res){
					if(res.returnCode==0){
						layer.msg("文章删除成功！")
						window.history.back();
					}else{
						layer.msg("文章删除失败！")
					}
				}
			})
		})
		
		
		
		
		
		
		
	}
});

