/**
 * 页面路由
 */

var routes={
		'/addArticle':function(){
			pages('addArt')
		},
		'/showArticles':function(){
			pages('showArt')
		},
		
		'/editArticle/:id':function(id){
			pages('editArt',id)
		},
		
		'/showMsgs':function(){
			pages('showMsgs')
		},
		
		'/addTimeline':function(){
			pages('addTimeline')
		},
		
		'/showTimeline':function(){
			pages('showTimeline')
		},
		
		'/addPlaylist':function(){
			pages('addPlaylist')
		},
		
		'/editPlaylist/:id':function(id){
			pages('editPlaylist',id)
		},
		
		'/showPlaylist':function(){
			pages('showPlaylist')
		},
		
		
		
	
		
		
};

var router = Router(routes);
router.init();
