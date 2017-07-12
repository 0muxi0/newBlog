/**
 * 添加文章
 */
define(['text!editPlaylistTmp'],function(html){
	return function(req){
		main.html(html);
		
		//时间控件
		$(function() {
			//Date picker
			$('#datepicker').datepicker({
				autoclose : true
			});
		})
		
		
		
		
		//根据id请求歌单并渲染
		$(function(){
			var pid=req;
			$.ajax({
					type:"post",
					dataType:"json",
				/*	url:"playlist_edit", */
					data:{
						pid:pid,
					},
					success:function(res){
						$("#title").val(res.data.title);
						$("#type").val(res.data.type);
						$("#author").val(res.data.author);
						$("#datepicker").val(res.data.uptime);
						$("#address").val(res.data.address);
						$("#remark").val(res.data.remark);
						
						
						
					}
			})
		})
		
		
		
		//编辑歌单 
		$("#edit_playlist").on("click",function(){
				var um = UM.getEditor('myEditor');
				var html = um.getContent();
				var pid=req;
				$.ajax({
					type:"post",
					url:"playlist_edit",
					data:{
						pid:pid,
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
							layer.msg("添加歌单成功！");
						}else{
							layer.msg("添加歌单失败！");
						}
					},
				})	
		});
		
		
		//删除歌单
		$("#delete_playlist").on("click",function(){
			var pid=req;
			$.ajax({
				type:"post",
				dataType:"json",
				url:"playlist_delete",
				data:{
					pid:pid,
				},
				success:function(res){
					if(res.returnCode==0){
						layer.msg("歌单删除成功！")
					}else{
						layer.msg("歌单删除失败！")
					}
				}
			})
		})
		
		
		
		
		
		
	}
});

