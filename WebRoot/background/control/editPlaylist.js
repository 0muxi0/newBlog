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
					url:"playlist_edit", 
					data:{
						pid:pid,
					},
					success:function(res){
						$("#title").val(res.data.pname);
						$("#type").val(res.data.pdesc);
						$("#datepicker").val(res.data.createtime);
						
					}
			})
		})
		
		
		
		//编辑歌单 
		$("#edit_playlist").on("click",function(){
				var pid=req;
				$.ajax({
					type:"post",
					url:"playlist_update",
					data:{
						pid:pid,
						pname:$("#title").val(),
						pdesc:$("#type").val(),
						createtime:$("#datepicker").val(),
					},
					dataType:"json",
					success:function(res){
						if(res.returnCode==0){
							layer.msg("修改歌单成功！");
							pname:$("#title").val('');
							pdesc:$("#type").val('');
							createtime:$("#datepicker").val('');
						}else{
							layer.msg("修改歌单失败！");
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

