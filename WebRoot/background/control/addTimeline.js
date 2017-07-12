/**
 * 添加文章
 */
define([ 'text!addTimelineTmp' ], function(html) {
	return function(req) {
		main.html(html);

		//时间控件
		$(function() {
			//Date picker
			$('#datepicker').datepicker({
				autoclose : true
			});
		})

		//添加说说
		$("#add_timeline").on("click",function(){
			var mydate = new Date();
			var t = mydate.toLocaleString();
			console.log(t);
			$.ajax({
				type : "post",
				dataType : "json",
				url : "timeline_add",
				data : {
					"content" : $(".form-control").val(),
					"uptime" : t,
				},
				success : function(res) {
					if(res.ret==0){
						layer.msg("说说发表成功成功！");
						window.history.back();
					}else{
						layer.msg("说说发表失败！");
					}
				}
			})
		})
		
		
		
		
		

	}
});