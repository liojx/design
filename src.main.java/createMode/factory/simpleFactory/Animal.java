package createMode.factory.simpleFactory;

/**
 * @Author: liaosijun
 * @Time: 2020/1/21 14:31
 */
public class Animal {

	public Animal(String type){
		System.out.println("创建：" + type);
	}

	public void eat(String s){
		System.out.println("eat " + s);
	}

	public void move(String s) {
		System.out.println("move " + s);
	}
}
