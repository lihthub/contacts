package pers.contacts.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VCardUtils {
	/**
	 * BEGIN:VCARD
	 * VERSION:4.0
	 * FN:hollis
	 * TEL;TYPE=CELL:1-870-137-2660
	 * EMAIL;TYPE=HOME:hollisli.dev@google.com
	 * ADR;TYPE=HOME;CHARSET=UTF-8:;;ShanXi;;;;
	 * ORG;CHARSET=UTF-8:Digital China
	 * TITLE;CHARSET=UTF-8:Java
	 * BDAY:1994-01-12
	 * END:VCARD
	 * 
	 * 生成VCard格式字符串
	 */
	public static String format(String fullName, String phone, String email,
			String address, String company, String job, Date birthday) {
		String vCard = "BEGIN:VCARD\n"
				+ "VERSION:3.0\n"
				+ "FN:" + fullName + "\n"
				+ "TEL;TYPE=CELL:" + phone + "\n"
				+ "EMAIL;TYPE=HOME:" + email + "\n"
				+ "ADR;TYPE=HOME;CHARSET=UTF-8:;;" + address + ";;;;\n"
				+ "ORG;CHARSET=UTF-8:" + company + "\n"
				+ "TITLE;CHARSET=UTF-8:" + job + "\n"
				+ "BDAY:" + new SimpleDateFormat("yyyy-MM-dd").format(birthday) + "\n"
				+ "END:VCARD"; 
		return vCard;
	}
}
