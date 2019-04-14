package com.test.demo1;

import java.util.ArrayList;
import java.util.List;


public class Test {
public static void main(String[] args) {
//	System.out.println(514/256);
//	int[] bubbleSort = bubbleSort(new int[] {11,8,6,3,15,32});
//	System.out.println(bubbleSort);
	List<String> pointCopy = new ArrayList<>(3);
	pointCopy.add(0,"添加第一个值");
	pointCopy.add(1,"添加第二个值");
	pointCopy.add(2,"添加第三个值");
	pointCopy.set(1,"替换第二个值");
	System.out.println(pointCopy);
	
}

public static int[] bubbleSort(int[] array) {
         if (array.length == 0)
             return array;
         for (int i = 0; i < array.length; i++)
             for (int j = 0; j < array.length - 1 - i; j++)
             {
                 if (array[j + 1] < array[j]) {
                     int temp = array[j + 1];
                     array[j + 1] = array[j];
                     array[j] = temp;
                 }
             }
         return array;
     }

}
