package com.xatu.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ���ڹ�����
 * 
 * @author zsl
 *
 */
public class DateUtil {

	public static boolean isReightDate(String[] date) {
		int year = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int day = Integer.parseInt(date[2]);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// �������ڸ�ʽ
		String[] nowDate = df.format(new Date()).split("-");
		if (year < Integer.parseInt(nowDate[0])||month<Integer.parseInt(nowDate[1])||day<Integer.parseInt(nowDate[2])) {
			return false;
		}
		return true;
	}
}
