/**
 * 
 */

/*
var data = [];

data.push({
    'date'  : '2016-12-1',
    'intro' : '我要这天，再遮不住我眼，要这地，再埋不了我心，要这众生，都明白我意，要那诸佛，都烟消云散! ',
    
})
*/
//格式化日期
/*	Date.prototype.Format = function (fmt) { //author: meizz 
	    var o = {
	        "M+": this.getMonth() + 1, //月份 
	        "d+": this.getDate(), //日 
	        "h+": this.getHours(), //小时 
	        "m+": this.getMinutes(), //分 
	        "s+": this.getSeconds(), //秒 
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	        "S": this.getMilliseconds() //毫秒 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	}*/


	var data=[];

	$.ajax({
		type:"post",
		dataType:"json",
		url:"timeline_find", 
		async:false,
		success:function(res){
			console.log(res)
			var x=res.list
			var arr=[];
			for(var i in x){
				arr.push({
					'date':(x[i].uptime).substr(0,(x[i].uptime).indexOf(' ')),//截取空格以前的日期
//					'date':new Date((x[i].uptime).substr(0,(x[i].uptime).indexOf(' '))).Format("yyyy-MM-dd"),//截取空格以前的日期
					'intro':x[i].content,
				})
			}  
			data=arr;
			/*var str=JSON.stringify(arr);
			sessionStorage.arr=str;*/
			/*console.log(arr)*/
		}
	})

	
	
	
/*var sts=sessionStorage.arr;
console.log(sts);
obj=JSON.parse(sts);
var data = obj;
*/
/*var data=$(getdata(function(arr){
	console.log(arr)
    return arr;//这里可以得到值
}));
console.log(data)
*/


/*data.push({
    'date'  : '2016-11-30',
    'intro' : '金钱可以使人卑微，也可以使人卑贱，可以使人高傲，却无法使人高贵。',
    'media' : '<img src="images/psb.jpeg" width="370" >',
    'like' : 35038,
    'comment' : 817
})


data.push({
    'date'  : '2016-7-31',
    'intro' : '在这春林初盛，草长莺飞的日子，QQ空间愿你关掉电脑，放下手机，与三五好友相约青山绿水中，感受春天带来的勃勃生机···',
    'media' : '<img src="images/psb.jpeg" width="370" >',
    'like' : 302,
    'comment' : 883
})
*/
