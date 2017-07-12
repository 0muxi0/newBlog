/**
 * 管理所有文章
 */
define(['text!showMsgsTmp'],function(html){
	return function(){
		main.html(html);
		

	    	
     	//根据id删除说说
	    	$("#msg").on("click","a",function(){
	    		var mid =$(this).attr('data-id');
				$.ajax({
					type:"post",
					dataType:"json",
					url:"msg_delete",
					data:{
						mid:mid,
					},
					success:function(res){
						if(res.ret==0){
							layer.msg("说说删除成功！")
							findAll();
						}else{
							layer.msg("说说删除失败！")
						}
					}
				})
	    	}); 
	}
});

