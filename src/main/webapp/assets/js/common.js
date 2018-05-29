$(function() {
	var localeMessage = {
		'zh-CN': '请填写此字段。',
		'en-US': 'Please fill in this field.',
		'en-GB': 'Please fill in this field.'
	};
	
	// 设置input表单校验默认提示语
	$(document)
	.on('invalid', 'input:not(:submit,:button)', function() {
		this.setCustomValidity($(this).data('title'));
	})
	.on('input', 'input:not(:submit,:button)', function() {
		if (this.validity.valueMissing === true) {
			this.setCustomValidity(localeMessage[languageTag]);
		} else if (this.validity.patternMismatch === true) {
			this.setCustomValidity($(this).data('title'));
		} else {
			this.setCustomValidity('');
		}
	})
	.on('click.change-captcha', '.change-captcha', function () {
		$(this).prop('src', webContext + '/getCaptcha?v=' + utils.random());
	});
	
	// 返回顶部事件
	$('.icon-backtop').on('click', function() {
		window.scrollTo(0,0);
	});
	
	// 返回顶部按钮显示与隐藏
	$(window).on('scroll', function() {
		if (window.scrollY > window.screenY + 300) {
			$('.icon-backtop').addClass('active');
		} else {
			$('.icon-backtop').removeClass('active');
		}
	});
	
});