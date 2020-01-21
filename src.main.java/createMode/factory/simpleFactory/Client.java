package createMode.factory.simpleFactory;

/**
 * @Author: liaosijun
 * @Time: 2020/1/21 14:40
 */
public class Client {
	public static void main(String[] args) {
		Animal fish = AnimalFactory.createAnimal("fish");
		fish.eat("xiao xia mi...");
		Animal monkey = AnimalFactory.createAnimal("monkey");
		monkey.move(" to top of tree...");
	}
}
