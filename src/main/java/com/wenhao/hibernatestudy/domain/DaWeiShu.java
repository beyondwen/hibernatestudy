package com.wenhao.hibernatestudy.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 自己实现大位数的加减
 * 
 * @author ZhangBo
 *
 */
public class DaWeiShu {
	
	private static final String DIGITAL_REG_EXP = "\\d";
	
	String num1;
	
	String num2;

	public DaWeiShu(String num1, String num2) {
		super();
		if (!validateDigital(num1)) {
			throw new IllegalArgumentException("参数错误: " + num1);
		}
		if (!validateDigital(num2)) {
			throw new IllegalArgumentException("参数错误: " + num2);
		}
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public String sum() {
		
		List<String> sum = new ArrayList<String>();
		
		String[] tmpArr1 = reverse(this.num1.split(""));
		String[] tmpArr2 = reverse(this.num2.split(""));
		
		String[] charArr1 = removeEmpty(tmpArr1);
		String[] charArr2 = removeEmpty(tmpArr2);
		
		int length1 = charArr1.length;
		int length2 = charArr2.length;
		
		int maxLength = length1 > length2 ? length1 : length2;
		
		int tmp = 0;
		
		for (int i = 0; i < maxLength; i++) {
			
			if (i < charArr1.length && i < charArr2.length) {
				String c1 = charArr1[i];
				String c2 = charArr2[i];
				
				int t = Integer.valueOf(c1) + Integer.valueOf(c2) + tmp;
				
				if (t >= 10) {
					tmp = 1;
					t = t - 10;
				} else {
					tmp = 0;
				}
				
				sum.add(String.valueOf(t));
				
			} else if (i < charArr1.length) {
				
				String c1 = charArr1[i];
				int t = Integer.valueOf(c1) + tmp;
				
				if (t >= 10) {
					tmp = 1;
					t = t - 10;
				} else {
					tmp = 0;
				}
				sum.add(String.valueOf(t));
			} else {

				String c1 = charArr2[i];
				int t = Integer.valueOf(c1) + tmp;
				
				if (t >= 10) {
					tmp = 1;
					t = t - 10;
				} else {
					tmp = 0;
				}
				sum.add(String.valueOf(t));
			}
			
		}
		
		if (tmp == 1) {
			sum.add(String.valueOf(tmp));
		}
		
		String[] reverse = reverse(sum.toArray(new String[sum.size()]));
		return printArr(reverse);
	}
	
	private String[] removeEmpty(String[] tmpArr1) {
		List<String> list = new ArrayList<String>(Arrays.asList(tmpArr1));
		
		Iterator<String> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			String s = iterator.next();
			if (isEmpty(s)) {
				iterator.remove();
			}
		}
		return list.toArray(new String[list.size()]);
	}

	private String[] reverse(String[] arr) {
		
		String[] c = new String[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			c[i] = arr[arr.length - (i + 1)];
		}
		
		return c;
	}
	
	private String printArr(String[] arr) {
		StringBuffer sb = new StringBuffer();
		for (String s : arr) {
			sb.append(s);
		}
		return sb.toString();
	}
	

	public static boolean validateDigital(String digital) {
		if (isEmpty(digital)) {
			return false;
		}
		String patternStr = DIGITAL_REG_EXP + "+";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(digital);
		return matcher.matches();
		
	}
	
	public static boolean isEmpty(String string) {
		
		if (string == null || string.trim().length() == 0) {
            return true;
        }
		
		return false;
    }
	
	public static void main(String[] args) {
		
		DaWeiShu d = new DaWeiShu("9232543249", "9999999912131321399993232499999999999");
		
		System.out.println(d.sum());
		
		System.out.println(new BigDecimal("9232543249").add(new BigDecimal("9999999912131321399993232499999999999")));
	}
	
}
