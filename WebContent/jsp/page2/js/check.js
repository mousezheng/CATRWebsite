//登陆校验
function judge() {
	if (document.form1.username.value == ""
			|| document.form1.password.value == "") {
		window.alert("用户名或者密码不能为空");
		return;
	}
	validatemobile(document.form1.phone.value);
	if (document.form1.phone.value == "" || document.form1.password.value == "") {
		window.alert("用户名或者密码不能为空");
		return;
	}
	if (document.form1.password.value.length < 6) {
		window.alert("密码不能少于6位");
		return;
	}
	if (document.form1.password.value != document.form1.confirmPassword.value) {
		window.alert("确认密码与新密码不一致");
		return;
	}
	document.form1.submit();
}
//号码校验
function validatemobile(mobile) {
	if (mobile.length == 0) {
		alert('请输入手机号码！');
		document.form1.mobile.focus();
		return false;
	}
	if (mobile.length != 11) {
		alert('请输入有效的手机号码！');
		document.form1.mobile.focus();
		return false;
	}

	var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
	if (!myreg.test(mobile)) {
		alert('请输入有效的手机号码！');
		document.form1.mobile.focus();
		return false;
	}
}

//重置密码校验
function passworld_check() {
	if (document.form1.password.value == "") {
		window.alert("密码不能为空");
		return;
	}
	if (document.form1.password.value.length < 6) {
		window.alert("密码不能少于6位");
		return;
	}
	if (document.form1.password.value != document.form1.confirmPassword.value) {
		window.alert("确认密码与新密码不一致");
		return;
	}
	document.form1.submit();
}
//登陆校验
function login_check()
{
	if(document.form1.name.value == "" ||
	 document.form1.password.value == "")
	 {
	 	window.alert("用户名或者密码不能为空");
	 	return;
	 }
	 if(document.form1.password.value.length < 6)
	 {
	 	window.alert("密码不能少于6位");
	 	return;
	 }
	 document.getElementById("form1").submit();
}