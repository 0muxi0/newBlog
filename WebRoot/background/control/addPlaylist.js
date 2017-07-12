/**
 * 添加文章
 */
define(['text!addPlaylistTmp'],function(html){
	return function(req){
		main.html(html);
		
		//时间控件
		$(function() {
			//Date picker
			$('#datepicker').datepicker({
				autoclose : true
			});
		})
		//保存文章 
		$("#add_playlist").on("click",function(){
				
				$.ajax({
					type:"post",
					url:"playlist_add",
					data:{
						pname:$("#pname").val(),
						pdesc:$("#pdesc").val(),
						createtime:$("#datepicker").val(),
						
					},
					dataType:"json",
					success:function(res){
						layer.msg("新建歌单成功！")
					},
					error:function(){
						layer.msg("新建歌单失败！")
					}
				})	
		})

		
	}
});

