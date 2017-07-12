/**
 * 
 */
define(['text!albumTmp'],function(html){
	return function(req){
		main.html(html);
		
		
		//根据id请求文章并渲染
		$(function(){
			var aid=req;
			console.log(aid);
			$.ajax({
					type:"post",
					dataType:"json",
//					url:"article_edit", 
					data:{
						aid:aid,
					},
					success:function(res){
						$("#title").html(res.data.title);
						$("#time").html(res.data.uptime);
						$("#author").html(res.data.author);
						$("#content").html(res.data.content);
					}
			})
		})
	}
});

