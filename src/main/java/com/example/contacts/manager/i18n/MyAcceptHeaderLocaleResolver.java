package com.example.contacts.manager.i18n;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import com.example.contacts.util.I18nUtils;

/**
 * 国际化区域解析器
 *
 * @author 李海涛 2016年8月25日
 */
public class MyAcceptHeaderLocaleResolver extends AcceptHeaderLocaleResolver {
	private Locale myLocal = Locale.CHINESE;

	public Locale resolveLocale(HttpServletRequest request) {
		request.setAttribute("languageTag", myLocal.toLanguageTag());
		return myLocal;
	}

	public void setLocale(HttpServletRequest request,
			HttpServletResponse response, Locale locale) {
		myLocal = locale;
		I18nUtils.setLocale(locale);
	}

}
