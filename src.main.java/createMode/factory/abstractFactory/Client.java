package createMode.factory.abstractFactory;

/**
 * @Author: liaosijun
 * @Time: 2020/1/21 17:04
 */
public class Client {
	public static void main(String[] args) {
		// 获取动物工厂
		IBiologyFactory animalFactory = FactoryProducer.getFactory("animal");

		// 获取猴子
		Animal monkey = animalFactory.getAnimal("monkey");
		monkey.eat("banana");

		// 获取植物工厂
		IBiologyFactory botanyFactory = FactoryProducer.getFactory("botany");

		// 获取水仙花
		Botany daffodil = botanyFactory.getBotany("shuixianhua");
		daffodil.getName("水仙花");
	}
}
