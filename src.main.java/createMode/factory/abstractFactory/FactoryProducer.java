package createMode.factory.abstractFactory;

/**
 * @Author: liaosijun
 * @Time: 2020/1/21 17:20
 */
public class FactoryProducer {

	public static IBiologyFactory getFactory(String choice) {
		if (choice.equals("animal")) {
			return new AnimalFactory();
		} else if (choice.equals("botany")) {
			return  new BotanyFactory();
		} else  {
			return null;
		}
	}
}
