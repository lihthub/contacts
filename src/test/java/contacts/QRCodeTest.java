package contacts;

import java.util.Date;

import pers.contacts.util.QRCodeUtils;
import pers.contacts.util.VCardUtils;

public class QRCodeTest {

	public static void main(String[] args) {
		String vCard = VCardUtils.format("李海涛", "18701372660", "hollisli.dev@google.com", "山西省吕梁市", "神州数码集团股份有限公司", "软件工程师", new Date());
		System.out.println(vCard);
		QRCodeUtils.encode(vCard, "d:/vcard.png", 300, 300);
	}
	
}
