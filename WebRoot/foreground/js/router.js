/**
 * 页面路由
 */

var routes={

		
		
		//前端
		'/articleList':function(){
			pages('articleList')
		},
		
		'/articleDet/:id':function(id){
			pages('articleDet',id)
		},
		
		
		'/message':function(){
			pages('message')
		},
		
		
		'/album':function(){
			pages('album')
		}
};

var router = Router(routes);
router.init();
