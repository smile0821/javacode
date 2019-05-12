package singleton;

/**
 * @author 51
 * 饿汉式是在类加载时进行初始化，天生是线程安全的
 */
public class StarveSingleton {
	private static StarveSingleton starveSingleton = new StarveSingleton();
	
	private StarveSingleton()
	{
	}
	
	public static StarveSingleton getStarveSingleton()
	{
		return starveSingleton;
	}
	
}
