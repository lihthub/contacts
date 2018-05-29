$(function() {
	$('.signin-form-error .close').on('click', function() {
		$(this).closest('.signin-form-error').removeClass('error');
	});
});