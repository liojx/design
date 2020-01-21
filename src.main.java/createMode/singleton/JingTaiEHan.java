package createMode.singleton;

/**
 * 静态饿汉，线程安全
 * @Author: liaosijun
 * @Time: 2020/1/20 15:26
 */
public class JingTaiEHan {

	private static JingTaiEHan jingTaiEHan;

	// 静态块, 线程安全，不论你多少个线程来取这个实例，都是同一个。在加载的时候就完成实例。
	static {
		jingTaiEHan = new JingTaiEHan();
	}
	private JingTaiEHan(){}

	public static JingTaiEHan getInstance(){
		return  jingTaiEHan;
	}

	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {
				JingTaiEHan jingTaiEHan1 = JingTaiEHan.getInstance();
				System.out.println(jingTaiEHan1.toString());
			}
		};
		Thread t1 = new Thread(r);
		t1.start();

		Runnable r2 = new Runnable() {
			public void run() {
				int i = 10;
				while (i-- > 0) {
					JingTaiEHan jingTaiEHan1 = JingTaiEHan.getInstance();
					System.out.println(jingTaiEHan1.toString());

				}
			}
		};
		Thread t2 = new Thread(r2);
		t2.start();

		Runnable r3 = new Runnable() {
			public void run() {
				JingTaiEHan jingTaiEHan1 = JingTaiEHan.getInstance();
				System.out.println(jingTaiEHan1.toString());
			}
		};
		Thread t3 = new Thread(r3);
		t3.start();


	}


}
