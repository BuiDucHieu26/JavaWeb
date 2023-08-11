package util;

import static org.hamcrest.CoreMatchers.nullValue;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;

public class MaHoa {
	public static String toSHA1(String str) {
		String salt = "._abcdefhijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String result = null;
		str += salt;
		try {
			byte [] dataBytes = str.getBytes("UTF-8");
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
			result = Base64.encodeBase64String(messageDigest.digest(dataBytes));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(toSHA1("BuiHieu"));
	}
}
