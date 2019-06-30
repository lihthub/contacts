package com.example.contacts.manager.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * Controller传递参数时转换时间类型属性
 *
 * @author 李海涛 2016年10月28日
 */
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		if (StringUtils.hasText(source)) {
			try {
				if (source.indexOf(":") == -1 && source.length() == 10) {
					String pattern = "yyyy" + source.charAt(4) + "MM" + source.charAt(7) + "dd";
					SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
					return dateFormat.parse(source);
				} else if (source.indexOf(":") > 0 && source.length() == 19) {
					String pattern = "yyyy" + source.charAt(4) + "MM" + source.charAt(7) + "dd HH:mm:ss";
					SimpleDateFormat datetimeFormat = new SimpleDateFormat(pattern);
					return datetimeFormat.parse(source);
				} else {
					throw new IllegalArgumentException("Could not parse date, date format is error ");
				}
			} catch (ParseException ex) {
				IllegalArgumentException iae = new IllegalArgumentException("Could not parse date: " + ex.getMessage());
				iae.initCause(ex);
				throw iae;
			}
		} else {
			return null;
		}
	}

}
