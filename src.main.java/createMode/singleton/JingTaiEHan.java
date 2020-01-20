package createMode.singleton;

/**
 * @Author: liaosijun
 * @Time: 2020/1/20 15:26
 */
public class JingTaiEHan {

	private static JingTaiEHan jingTaiEHan;

	// 构造块，构造函数之前调用
	{
		jingTaiEHan = new JingTaiEHan();
	}
	private JingTaiEHan(){}

	public static JingTaiEHan getInstance(){
		return  jingTaiEHan;
	}
}
