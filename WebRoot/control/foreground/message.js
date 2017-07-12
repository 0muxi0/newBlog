/**
 * 
 */
define(['text!messageTmp'],function(html){
	return function(req){
		main.html(html);
		
		
		/*function msgAdd(){
			var mydate = new Date();
			var t = mydate.toLocaleString();
			$.ajax({
				type:"post",
				dataType:"json",
				url : "msg_add",
				data:{
					"name":$("#name").val(),
					"content":$("message").val(),
					"uptime" : t,
				},
				success : function(res) {
					if(res.returnCode==0){
						layer.msg("添加成功！");
					}else{
						layer.msg("添加失败！");
					}
				}
			
			})
			
		}*/
		
		
		
		
//		
//		//请求留言并渲染
//		function getData(callback ){
//			
////			console.log(aid);
//			$.ajax({
//					type:"post",
//					dataType:"json",
//					url : "msg_findAll",
//					ansyc:false,
//					data:{
//						"currPage" : "2",
//					},
//					success:function(res){
//						$("#wish").html(_.template($("#msg-t").html())({
//							list:res.list.list,
//						}));
//						
//						var pages = res.list.totalPage; //数据总量
//						var currPage = res.list.currPage; //当前页
//						if (pages !== 0) {
//							var element = $('#pageUl'); //对应下面ul的ID
//							var options = {
//								bootstrapMajorVersion : 3,
//								currentPage : currPage, //当前页面
//								numberOfPages : 5, //一页显示10个按钮（在ul里面生成10个li）
//								totalPages : pages //总页数
//							}
//							element.bootstrapPaginator(options);
//						}
//						callback();
//					},
//			});
//		}
//		getData(function(){
//			$('#wish').wish();
//		    $('.wish').draggable({containment:'#wish',scroll:false});
//			
//		})
		
		
		

		
		
		
		
	}
});

