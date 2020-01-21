package createMode.singleton;

/**
 * 懒汉式同步块，线程不安全
 * @Author: liaosijun
 * @Time: 2020/1/21 11:10
 */
public class LanHanBuAnquanTBK {
	private static LanHanBuAnquanTBK lanHanBuAnquanTBK;
	private LanHanBuAnquanTBK(){}
	public static LanHanBuAnquanTBK getInstance() {
		if (lanHanBuAnquanTBK == null) {
			synchronized (LanHanBuAnquanTBK.class) {
				lanHanBuAnquanTBK = new LanHanBuAnquanTBK();
			}
		}
		return lanHanBuAnquanTBK;
	}
}
