package createMode.factory.abstractFactory;

/**
 * @Author: liaosijun
 * @Time: 2020/1/21 17:16
 */
public class BotanyFactory extends IBiologyFactory {
	public Animal getAnimal(String name) {
		return null;
	}

	public Botany getBotany(String name) {
		if ("baishu".equals(name)) {
			return new Cypress();
		} else if ("shuixianhua".equals(name)) {
			return  new Daffodil();
		} else {
			return null;
		}
	}
}
