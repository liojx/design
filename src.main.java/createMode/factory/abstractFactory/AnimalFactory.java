package createMode.factory.abstractFactory;

/**
 * @Author: liaosijun
 * @Time: 2020/1/21 17:03
 */
public class AnimalFactory extends IBiologyFactory {


	public Animal getAnimal(String name) {
		if ("monkey".equals(name)) {
			return new Monkey();
		} else if ("rabbit".equals(name)) {
			return new Rabbit();
		} else {
			return null;
		}
	}

	public Botany getBotany(String name) {
		return null;
	}


}
