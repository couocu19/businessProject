var select = document.getElementsByName('user');

function submit(){
	console.log('ok');
	if(select[0].checked){
		console.log(0);
		window.location.href = '../manage/manage.html'
	}
	else if(select[1].checked){
		console.log(1);
		window.location.href = '../user/user.html'
	}else{
		alert("您未选择,请选择您的身份")
	}
}