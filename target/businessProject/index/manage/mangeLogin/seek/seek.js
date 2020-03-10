var seek = document.getElementsByName('seek');

function submit(){
	if(seek[0].checked){
		window.location.href="./all/all.html"
	}else if(seek[1].checked){
		window.location.href="./one/one.html"
	}else{
		alert("您未选择，请重新选择")
	}
}