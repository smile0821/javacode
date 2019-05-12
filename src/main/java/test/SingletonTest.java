package test;

import singleton.LazySingleton;
import singleton.StarveSingleton;

public class SingletonTest {
	public static void main(String[] args) {
		LazySingleton l1 = LazySingleton.getLazySingleton();
		LazySingleton l2 = LazySingleton.getLazySingleton();
		System.out.println("lazy singleton:"+(l1==l2));
		
		StarveSingleton s1 = StarveSingleton.getStarveSingleton();
		StarveSingleton s2 = StarveSingleton.getStarveSingleton();
		System.out.println("starve singleton:"+(s1==s2));
	}
}
