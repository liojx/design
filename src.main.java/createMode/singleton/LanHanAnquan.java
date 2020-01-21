package createMode.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 懒汉线程安全，同步方法
 * @Author: liaosijun
 * @Time: 2020/1/21 9:55
 */
public class LanHanAnquan {
	private static LanHanAnquan lanHanAnquan;
	private LanHanAnquan() {}

	public static synchronized LanHanAnquan getInstance() {
		if (lanHanAnquan == null) {
			lanHanAnquan = new LanHanAnquan();
		}
		return lanHanAnquan;
	}

	private static  SingletonFile singletonFile = SingletonFile.getSingletonFile();

	static void test() {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		final AtomicInteger cnt = new AtomicInteger();
		for (int i = 0; i< 100000; i++) {
			threadPool.execute(new Runnable() {
				public void run() {
					LanHanAnquan instance = LanHanAnquan.getInstance();
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
					LanHanAnquan instance = LanHanAnquan.getInstance();
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
