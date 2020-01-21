package createMode.singleton;

/**
 * 双重检查
 * @Author: liaosijun
 * @Time: 2020/1/21 11:19
 */
public class ShuangChongJC {
	private static ShuangChongJC shuangChongJC;
	private ShuangChongJC() {}
	public static ShuangChongJC getInstance() {
		if (shuangChongJC == null) {
			synchronized (ShuangChongJC.class) {
				shuangChongJC = new ShuangChongJC();
			}
		}
		return shuangChongJC;
	}
}
