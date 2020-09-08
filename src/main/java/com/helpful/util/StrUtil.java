package com.helpful.util;

/**
 * 字符串工具类
 * @author sunjian
 *
 * @date 2020年9月8日
 */
public class StrUtil {

	/**
	 * 判断一个字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		boolean b = false;
		if("" == str || null == str){
			b = true;
		}
		return b;
	}
	
}
