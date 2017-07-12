/**
 * 管理所有说说
 */
define(['text!showTimelineTmp'],function(html){
	return function(){
		main.html(html);
		

	    	
     	//根据id删除说说
	    	$("#timeline").on("click","a",function(){
	    		var tid =$(this).attr('data-id');
				$.ajax({
					type:"post",
					dataType:"json",
					url:"timeline_delete",
					data:{
						tid:tid,
					},
					success:function(res){
						if(res.ret==0){
							layer.msg("说说删除成功！")
						}else{
							layer.msg("说说删除失败！")
						}
					}
				})
	    	}); 
	}
});

