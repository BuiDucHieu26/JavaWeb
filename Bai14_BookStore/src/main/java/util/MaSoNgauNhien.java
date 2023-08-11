package util;

import java.util.Random;

public class MaSoNgauNhien {
	public static String getSoNgauNhien() {
		Random rd = new Random();
		String s = "";
		for(int i=0;i<=5;i++) {
			s+= rd.nextInt(10)+""; 
		}
		return s;
	}

}
