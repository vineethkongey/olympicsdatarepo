package javaPrograms;

import org.bouncycastle.crypto.engines.ISAACEngine;

public class SmallestElement {
	
	public static void main(String[] args) {
		
		String []  s = {"abcdef", "avbc","qfb"};
		String a = s[0];
		for(int i=0;i<s.length;i++) {
			if(s[i].length()<=a.length()) {
				a=s[i];
			}
			
		}
		System.out.println(a);
		
	}

}
