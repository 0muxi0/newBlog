/**
 * 管理所有歌单
 */
define(['text!showPlaylistTmp'],function(html){
	return function(){
		main.html(html);
		
		var page=1;
		function findAll() {
				$.ajax({
					type : "post",
				 	url : "playlist_findAll", 
					data:{
						"currPage":page,	
					},
					success : function(res) {
						$("#playlist").html(_.template($("#playlist-t").html())({
							list:res.list,
						}));
						var pages = res.list.totalPage;//数据总量
						var currPage=res.list.currPage;//当前页
	                    if (pages !== 0) {
	                        var element = $('#pageUl');//对应下面ul的ID
	                        var options = {
	                            bootstrapMajorVersion: 3, 
	                            currentPage: currPage,//当前页面
	                            numberOfPages: 5,//一页显示10个按钮（在ul里面生成10个li）
	                            totalPages: pages //总页数
	                        }
	                        element.bootstrapPaginator(options);
	                    }
					},
				});
			}
			
			 //获取当前页
	    	function paging(pageNow) {
			        page = pageNow;
			        findAll();
	    	}
	    	//自执行查询所有歌单
	    	$(function(){
	    		 findAll();
	    	})
	    	
	    	
	    	
	    	//页面跳转及传输歌单id
	    	$("#playlist").on("click","a",function(){
	    		var pid =$(this).attr('data-id');
	    		window.location.href="background/home.jsp#editPlaylist/"+pid;
	    	});
	    	
	    	
	    	
	}
});

