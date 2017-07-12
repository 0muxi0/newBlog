/**
 * 添加文章
 */
define([ 'text!articleDetTmp' ], function(html) {
	return function(req) {
		main.html(html);


		//根据id请求文章并渲染
		$(function() {
			var aid = req;
			console.log(aid);
			$.ajax({
				type : "post",
				dataType : "json",
				url : "article_edit",
				data : {
					aid : aid,
				},
				success : function(res) {
					$("#title").html(res.data.title);
					$("#time").html(res.data.uptime);
					$("#author").html(res.data.author);
					$("#content").html(res.data.content);
				}
			})
		})
		
		
		
		//添加评论
		$("#form-submit").on("click",function(){
			var mydate = new Date();
			var t = mydate.toLocaleString();
			var aid = req;
			/*console.log(t);*/
			$.ajax({
				type : "post",
				dataType : "json",
				url : "artDisc_add",
				data : {
					"toId" : aid,
					"content" :$("#cont").val(),
					"oname" : $("#name").val(),
					"uptime" : t,
//					"sid":$("#").val(),
				},
				success : function(res) {
					if(res.ret==0){
						layer.msg("评论成功！");
						getartDisc(function(){});
						$("#cont").val('');
						$("#name").val('');
						$("#email").val('');
						$("#subject").val('');
					}else{
						layer.msg("评论失败！");
					}
				}
			})
		})

		
		
		//根据文章id查询文章所属评论
		function  getartDisc(callback){
			var aid = req;
			$.ajax({
				type : "post",
				dataType : "json",
				url : "artDisc_findArtDisc",
				data:{
					"toId":aid,
				},
				success:function(res){
					if(res.ret==0){
						$("#artDisc").html(_.template($("#artDisc-t").html())({
							list : res.list,
						}));
					}else{
						layer.msg("查询评论失败！")
					}
					callback();
				}
			})
		}
		
		
		getartDisc(function(){});
		
		
		
		//回复评论
		$("#exampleModal").on('show.bs.modal',(function(event ) {
//			$("#discs").modal();
			var button = $(event.relatedTarget);
			var recipient = button.data('whatever'); 
			var modal=$(this)
			modal.find('.modal-title').text('回复@' + recipient)
			/*modal.find('.modal-body input').val(recipient)*/
			var toId=button.data('id');
			
			$("#sendM").click(function(){
			var mydate = new Date();
			var t = mydate.toLocaleString();
			var oname=$("#recipient-name").val();
			var content=$("#message-text").val();
			var aid=req;
				$.ajax({
					type : "post",
					dataType : "json",
					url : "artDisc_add",
					data:{
						"toId":aid,
						"toname":recipient,
						"content":content,
						"uptime":t,
						"oname":oname,
						"sid":toId,
					},
					success:function(res){
						if(res.ret==0){
							layer.msg("评论成功！");
							getartDisc(function(){});
							$("#recipient-name").val('');
							$("#message-text").val('');
						}else{
							layer.msg("评论失败！");
						}
					}
					
				})
			})
		}))
		
		
		
		
		
		

	}
});