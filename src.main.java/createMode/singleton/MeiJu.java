package createMode.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: liaosijun
 * @Time: 2020/1/21 11:30
 */
public enum MeiJu {
	MEI_JU;
	private MySingleton mySingleton;
	MeiJu(){
		mySingleton = new MySingleton();
	}
	public MySingleton getMysingleton(){
		return mySingleton;
	}

	private class MySingleton{

	}
	private static SingletonFile singletonFile = SingletonFile.getSingletonFile();

	static void test() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		final AtomicInteger atomicInteger = new AtomicInteger();
		for (int i = 0;i < 100000; i++ ){
			executorService.execute(new Runnable() {
				public void run() {
					MySingleton mysingleton = MeiJu.MEI_JU.getMysingleton();
					int b = atomicInteger.addAndGet(1);
					String s = "----" + b + " " + Thread.currentThread().getName() + " ---- " + mysingleton.toString();
					System.out.println(s);
					singletonFile.log(s);
				}
			});
		}
	}
	public static void main(String[] args) {
		MySingleton mySingleton1 = MeiJu.MEI_JU.getMysingleton();
		MySingleton mySingleton2 = MeiJu.MEI_JU.getMysingleton();
		System.out.println(mySingleton1 == mySingleton2);

		long l1 = System.currentTimeMillis();
		test();
		long l2 = System.currentTimeMillis();
		System.out.println((l2 - l1)/1000 + "s");

	}
}
