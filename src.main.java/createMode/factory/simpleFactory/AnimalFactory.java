package createMode.factory.simpleFactory;

/**
 * @Author: liaosijun
 * @Time: 2020/1/21 14:37
 */
public class AnimalFactory {

	/**
	 * 静态工厂方法，也称简单工厂： 负责传一个类型，实例化你要的类型。
	 * 缺点是：随着产品种类不断增多，工厂的创建方法会更改，不符合开闭原则，对已有的代码关闭更改。
	 * @param type
	 * @return
	 */
	public static Animal createAnimal(String type) {
		if ("fish".equals(type)) {
			return new Fish(type);
		} else if ("monkey".equals(type)) {
			return new Monkey(type);
		} else {
			return null;
		}
	}
}
