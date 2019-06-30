package com.example.contacts.util;

import java.util.Arrays;

public class StringUtils {

	/**
	 * 在原有字符串后追加字符串，以逗号隔开
	 * 
	 * @param original
	 *            原来的字符串
	 * @param appendStr
	 *            追加字符串
	 * @return
	 */
	public static String append(String original, String appendStr) {
		String separator = ",";
		if (original == null || original.isEmpty()) {
			return appendStr;
		}
		if (appendStr == null || appendStr.isEmpty()) {
			return original;
		}
		StringBuffer sb = new StringBuffer(original);
		if ((separator + sb + separator).indexOf(separator + appendStr
				+ separator) == -1) {
			sb.append(separator).append(appendStr);
		}
		return sb.toString();
	}
	
	/**
	 * 替换字符串中指定下标的字符
	 * @param str 字符串
	 * @param index 下标
	 * @param replaceChar 替换字符
	 * @return
	 */
	public static String replaceChar(String str, int index, char replaceChar) {
		char[] charArray = str.toCharArray();
		charArray[index] = replaceChar;
		return Arrays.toString(charArray).replaceAll("[\\[\\],\\s]", "");
	}
	
	public static void main(String[] args) {
		System.out.println(replaceChar("123456", 3, '8'));
	}

}
