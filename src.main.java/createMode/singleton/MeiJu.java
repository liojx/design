package createMode.singleton;

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

	public static void main(String[] args) {
		MySingleton mySingleton1 = MeiJu.MEI_JU.getMysingleton();
		MySingleton mySingleton2 = MeiJu.MEI_JU.getMysingleton();
		System.out.println(mySingleton1 == mySingleton2);
	}
}
