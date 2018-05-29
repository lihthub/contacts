$(function() {
	
	// eg: pattern = "yyyy-MM-dd hh:mm:ss";
	Date.prototype.getFormattedDate = function(pattern){

	    function getFullStr(i) {
			return i > 9 ? "" + i : "0" + i;
		}
	    
	    pattern = pattern.replace(/yyyy/,this.getFullYear())
	        .replace(/MM/, getFullStr(this.getMonth() + 1))
	        .replace(/dd/, getFullStr(this.getDate()))
	        .replace(/hh/, getFullStr(this.getHours()))
	        .replace(/mm/, getFullStr(this.getMinutes()))
	        .replace(/ss/, getFullStr(this.getSeconds()));
	
	    return pattern;
	};
	
	function updateSystime() {
		var date = new Date();
		$('#systime').html(date.getFormattedDate("yyyy-MM-dd hh:mm:ss"));
	}
	
	// 设置系统时间
	updateSystime();
	setInterval(updateSystime, 1000);
	
	// 注销
	$('.signout').on('click', function() {
		location.href = webContext + "/logout";
	});
	
	// 添加联系人
	$('.addlinkman').on('click', function() {
		$('.window,.window-mask').show();
	});
	
	$('.choose-pic').on('click', function() {
		$(this).find('input').click();
	});
	
	// 保存联系人
	$('.window-ok').on('click', function() {
		var $form = $('.linkman-form');
		$form.find('input, select').each(function() {
			if (!$(this)[0].checkValidity()) {
				alert("error!");
			}
		});
		$.post(webContext + "/linkmen", utils.formToObj($form), function(result) {
			if (result.success) {
				$('.window,.window-mask').hide();
				queryLinkmen();
			}
			else {
				alert("error!");
			}
			utils.formReset($form);
		});
	});
	
	// 取消
	$('.window-buttons .window-cancel,.window .window-close').on('click.window-cancel', function() {
		$('.window,.window-mask').hide();
		utils.formReset($form);
	});
	
	// 联系人列表
	function queryLinkmen() {
		$.get(webContext + "/linkmen", {name: $('#keyword').val()}, function(result) {
			$('.linkmen').html("");
			$.each(result.obj, function(i, obj) {
				$('.linkmen').append(
						"<div class=\"linkman-bar\" data-id=\"" + obj.id + "\" data-initial=\"" + obj.initial + "\">" +
							"<div class=\"photo\">" +
								"<img src=\"" + webContext + "/assets/images/signin-logo.png\"/>" +
							"</div>" +
							"<div class=\"information\">" +
								"<span class=\"name\">" + obj.name + "</span>" +
								"<span class=\"other\">" + obj.sex + " " + obj.age + "岁  " + obj.address + "</span>" +
							"</div>" +
						"</div>");
			});
		});
	}
	
	queryLinkmen();
	
	$(document).keydown(function(event) {
		if (event.which == 13) {
			queryLinkmen();
		}
	});
	
	// 个人资料
	$('.userinfo .photo').on('click.click-user', function() {
		$('.linkmen .linkman-bar.current').removeClass('current');
		$.post(webContext + "/users/findCurUser", function(result) {
			$('#linkman-id').val(result.obj.id);
			$('#nameSpan').text(result.obj.name);
			$('#sexSpan').text(result.obj.sex);
			$('#phoneSpan').text(result.obj.phone);
			$('#emailSpan').text(result.obj.email);
			$('#ageSpan').text(result.obj.age);
			$('#birthdaySpan').text(result.obj.birthday.substring(0, 9));
			$('#companySpan').text(result.obj.company);
			$('#jobSpan').text(result.obj.job);
			$('#addressSpan').text(result.obj.address);
			$('#linkman-id').data('role', 'user');
		});
	})
	
	// 联系人信息
	$('.linkmen').on('click.click-linkman', '.linkman-bar', function () {
		$(this).addClass('current').siblings('.current').removeClass('current');
		var id = $(this).data('id');
		$.get(webContext + "/linkmen/" + id, function(result) {
			$('#linkman-id').val(id);
			$('#nameSpan').text(result.obj.name);
			$('#sexSpan').text(result.obj.sex);
			$('#phoneSpan').text(result.obj.phone);
			$('#emailSpan').text(result.obj.email);
			$('#ageSpan').text(result.obj.age);
			$('#birthdaySpan').text(result.obj.birthday.substring(0, 9));
			$('#companySpan').text(result.obj.company);
			$('#jobSpan').text(result.obj.job);
			$('#addressSpan').text(result.obj.address);
			$('#linkman-id').data('role', 'linkman');
			$('.letters ul li').removeClass('current').each(function() {
				if ($(this).text() == result.obj.initial) {
					$(this).addClass('current');
					return false;
				}
			});
		});
	});
	
	// 二维码
	$('.fa-qrcode').on('click', function() {
		var role = $('#linkman-id').data('role');
		if (role == 'user') {
			$('.qrcode-win img').attr('src', webContext + "/users/" + $('#linkman-id').val() + "/qrcode");
		}
		else {
			$('.qrcode-win img').attr('src', webContext + "/linkmen/" + $('#linkman-id').val() + "/qrcode");
		}
		$('.qrcode-win,.window-mask').show();
	});
	
	$('.qrcode-win .close').on('click', function() {
		$('.qrcode-win,.window-mask').hide();
	});
	
});