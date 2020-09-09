package com.helpful.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Administrator
 * @MD5加密
 */
public class Md5Util {

	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));

		}

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n += 256;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return HEX_DIGITS[d1] + HEX_DIGITS[d2];
	}

	public static String md5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname))
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes()));
			else {
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes(charsetname)));
			}
		} catch (Exception exception) {
		}
		return resultString;
	}

	private static final String[] HEX_DIGITS = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };


	//张涛
	//静态方法，便于作为工具类
     public static String getMd5(String plainText) {
			try {
				   MessageDigest md = MessageDigest.getInstance("MD5");
					md.update(plainText.getBytes());
					byte b[] = md.digest();

				   int i;

				   StringBuffer buf = new StringBuffer("");
				  for (int offset = 0; offset < b.length; offset++) {
						   i = b[offset];
						   if (i < 0)
									i += 256;
							if (i < 16)
									buf.append("0");
						  buf.append(Integer.toHexString(i));
					   }
				  //32位加密
				  return buf.toString();
				   // 16位的加密
				   //return buf.toString().substring(8, 24);
			   } catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
					return null;
			   }

		}

}
