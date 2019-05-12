package singleton;

/**
 * @author 51
 * 懒汉式单例是调用时进行初始化，所以线程不安全，需要加上同步锁
 */
public class LazySingleton {
	private LazySingleton()
	{
	}
	
	private static LazySingleton lazySingleton;
	
	public static LazySingleton getLazySingleton()
	{
		if(null == lazySingleton)
		{
			synchronized (LazySingleton.class) {
				lazySingleton =  new LazySingleton();
			}
		}
		return lazySingleton;
	}
}
