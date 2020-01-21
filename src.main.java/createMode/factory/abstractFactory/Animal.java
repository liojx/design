package createMode.factory.abstractFactory;

/**
 * @Author: liaosijun
 * @Time: 2020/1/21 15:08
 */
public class Animal implements Biology {
	public void eat(String s){
		System.out.println("eat " + s);
	}

	public void move(String s) {
		System.out.println("move " + s);
	}

}
