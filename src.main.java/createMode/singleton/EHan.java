package createMode.singleton;

/**
 * 静态饿汉
 * @Author: liaosijun
 * @Time: 2020/1/20 13:38
 */
public class EHan {

	private final static EHan inst = new EHan();

	private EHan() {}

	public static EHan getInst() {
		return inst;
	}

	public static void main(String[] args) {
		EHan e1 = EHan.getInst();
		EHan e2 = EHan.getInst();
		EHan e3 = EHan.getInst();
		EHan e4 = EHan.getInst();
		System.out.println(e1.equals(e2));
		System.out.println(e2.equals(e3));
		System.out.println(e3.equals(e4));
		System.out.println(e4.equals(e1));
		System.out.println(e2==e3);
	}
}
