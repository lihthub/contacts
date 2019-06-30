package com.example.contacts.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 国际化工具类
 * 
 * @author 李海涛 2016年7月19日
 */
public class I18nUtils {
	private static I18nUtils instance = null;
	private Locale defaultLocale = Locale.SIMPLIFIED_CHINESE;

	private I18nUtils() {
	}

	private synchronized static I18nUtils getInstance() {
		if (instance == null) {
			instance = new I18nUtils();
		}
		return instance;
	}

	/**
	 * 设置语言
	 * 
	 * @param locale
	 */
	public static void setLocale(Locale locale) {
		getInstance().defaultLocale = locale;
	}

	/**
	 * 根据key获取字符串
	 * 
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("message", getInstance().defaultLocale);
		return bundle.getString(key);
	}

	/**
	 * 获取页面标题
	 * 
	 * @param key
	 * @return
	 */
	public static String getPageTitle(String key) {
		return getString(key) + " - " + getString("contacts.title");
	}

}
