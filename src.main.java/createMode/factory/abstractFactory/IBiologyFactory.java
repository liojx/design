package createMode.factory.abstractFactory;

/**
 * @Author: liaosijun
 * @Time: 2020/1/21 16:59
 */
public abstract class IBiologyFactory {
	public abstract Animal getAnimal(String name);
	public abstract Botany getBotany(String name);
}
