var id = document.getElementsByClassName('num')[0];
var param;

function submit(){
	
	var xhr = new XMLHttpRequest;
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var jsonObj = xhr.responseText;
			var jsonText = JSON.parse(jsonObj);
			callBack(jsonText);
		}
	}
	xhr.open("GET","http://www.hongyaoz.club/business/department/userDelete.action?id="+id.value);
	xhr.withCredentials = true;
	xhr.setRequestHeader('Content-Type','application/json');
	xhr.send(null);
}

function callBack(data){
	if(data.status == 0){
		alert('成功删除');
		id.value = '';
	}else{
		alert(data.msg);
	}
}