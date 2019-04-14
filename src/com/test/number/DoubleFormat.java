package com.test.number;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;

public class DoubleFormat {

	public static void main(String[] args) {
		//方法一   这个的优势是得出的double  使用这个方法还有个问题当num=4.015得到的值是4.01  下面两种方法的结果是4.02
//		double num = 4.016;
//		double v1 = (double)Math.round(num*100)/100;
//		System.out.println(v1);
//		//输出 4.02
		
		//方法二
//		long t1 = new Date().getTime();
//		for (int i = 0; i < 50000; i++) {
//			Random ran = new Random(80);
//			double d1 = ran.nextDouble();
//			formatDouble(d1);
//		}
//		System.out.println("End Time:"+(new Date().getTime()-t1));
        //输出4.02
        
        //方法三   这个方法如果设置scale为0  依然保留一位小数*.0
//        num = 4.016;
//		System.out.println();
		
		
//		long t1 = new Date().getTime();
//		for (int i = 0; i < 50000; i++) {
//			Random ran = new Random(80);
//			double d1 = ran.nextDouble();
//			round(d1,8);
//		}
//		System.out.println("End Time:"+(new Date().getTime()-t1));
//		//输出 4.02
	}

	private static double formatDouble(double num) {
//		1011843464
		DecimalFormat formater = new DecimalFormat();
		//保留几位小数
        formater.setMaximumFractionDigits(8);
        //模式  四舍五入
        formater.setRoundingMode(RoundingMode.UP);
        return Double.valueOf(formater.format(num));
	}
	
	public   static   double   round(double   v,int   scale){    
        if(scale<0){    
                throw   new   IllegalArgumentException(    
                        "The   scale   must   be   a   positive   integer   or   zero");    
        }    
        BigDecimal   b   =   new   BigDecimal(Double.toString(v));    
        BigDecimal   one   =   new   BigDecimal("1");    
        return   b.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();    
	}
}
