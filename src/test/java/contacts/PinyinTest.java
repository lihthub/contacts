package contacts;

import net.sourceforge.pinyin4j.PinyinHelper;

public class PinyinTest {
	
	public static void main(String[] args) {
		char ch = '李';
		String[] array = PinyinHelper.toHanyuPinyinStringArray(ch);
		System.out.println(array[0]);
	}
	
}
