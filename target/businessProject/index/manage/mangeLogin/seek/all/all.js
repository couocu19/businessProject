var tab = document.getElementById('tab');

ajax();
function ajax(){
	var xhr = new XMLHttpRequest;
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var jsonObj = xhr.responseText;
			var jsonText = JSON.parse(jsonObj);
			callBack(jsonText);
		}
	}
	xhr.open("GET","http://www.hongyaoz.club/business/admin/selectenergys.action");
	xhr.withCredentials = true;
	xhr.send(null);
}

function callBack(data){
	if(data.code==0){
		var str = "";//定义用于拼接的字符串
		var len = data.result.length;
		if(len == 0){
			alert('无能源信息~');
		}else{
			for(var i =0 ; i < len ; i++){
				str = "<tr><td>"+data.result[i].energyId+"</td><td>"+data.result[i].name+"</td><td>"+data.result[i].price+"</td><td>"+data.result[i].count+"</td></tr>";
				//追加至table中
				tab.innerHTML+=str;
			}
		}
	}else{
		alert(data.error)
	}
}