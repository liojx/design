package createMode.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 静态内部类, 线程安全的
 * @Author: liaosijun
 * @Time: 2020/1/21 11:21
 */
public class JingTaiNeiBuLei {
	private static class Instance{
		private static final JingTaiNeiBuLei jingTaiNeiBuLei = new JingTaiNeiBuLei();
	}

	public static JingTaiNeiBuLei getInstance() {
		return Instance.jingTaiNeiBuLei;
	}

	private static  SingletonFile singletonFile = SingletonFile.getSingletonFile();

	static void test() {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		final AtomicInteger cnt = new AtomicInteger();
		for (int i = 0; i< 100000; i++) {
			threadPool.execute(new Runnable() {
				public void run() {
					JingTaiNeiBuLei instance = JingTaiNeiBuLei.getInstance();
					int b = cnt.addAndGet(1);
					System.out.println("  " +  b + "--" + Thread.currentThread().getName() + "--" + instance.toString());
					singletonFile.log("  " + b + "--" + Thread.currentThread().getName() + "--" + instance.toString());
				}
			});
		}
		threadPool.shutdown();
		ExecutorService threadPool2 = Executors.newCachedThreadPool();
		final AtomicInteger cnt2 = new AtomicInteger();
		for (int i = 0; i< 100000; i++) {
			threadPool2.execute(new Runnable() {
				public void run() {
					JingTaiNeiBuLei instance = JingTaiNeiBuLei.getInstance();
					int b = cnt2.addAndGet(1);
					System.out.println("  " +  b + "--" + Thread.currentThread().getName() + "--" + instance.toString());
					singletonFile.log("  " + b + "--" + Thread.currentThread().getName() + "--" + instance.toString());
				}
			});
		}
		threadPool2.shutdown();
	}

	public static void main(String[] args) {
		Long start = System.currentTimeMillis();
		test();
		Long end = System.currentTimeMillis();
		System.out.println("complete...");
		System.out.println((end - start)/1000 + "s");
	}
}
