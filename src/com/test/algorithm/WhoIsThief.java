package com.test.algorithm;

/**
 * @author 51
 * 
 *  警察抓了A\B\C\D四名罪犯，其中一名是小偷，审讯的时候：
 *  A:"我不是小偷"  x!=0
 *  B:"C是小偷"  x=2
 *  C:"小偷肯定是D" x=3
 *  D:"C是在冤枉人" x!=3
 */
public class WhoIsThief {
	public static void main(String[] args) {
		who_is_thief();
	}
	
	public static void who_is_thief()
	{
		for(int x=0;x<4;x++)
		{
			int dis_a=(x!=0)?1:0;
			int dis_b=(x==2)?1:0;
			int dis_c=(x==3)?1:0;
			int dis_d=1-dis_c;
			if((dis_a+dis_b+dis_c+dis_d)==3)
			{
				char thief = (char) ('A'+x);
				System.out.print("The thief is:"+String.valueOf(thief));
//				switch(x)
//				{
//				case 0:
//					System.out.println("A");
//					break;
//				case 1:
//					System.out.println("B");
//					break;
//				case 2:
//					System.out.println("C");
//					break;
//				case 3:
//					System.out.println("D");
//					break;
//				}
			}
		}
		
	}
}
