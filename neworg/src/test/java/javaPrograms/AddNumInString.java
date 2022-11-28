package javaPrograms;


public class AddNumInString {
	public static void main(String[] args) {
		String s = "b21c31d11";//6
		int sum=0;
		int num=0;
		for(int i=0;i<s.length();i++) {
			for(int j=i+1;j<s.length();j++) {
			if(s.charAt(i)>='0' && s.charAt(i)<='9') {
				System.out.println(s.charAt(i));
				sum=s.charAt(i)-'0';
				num=s.charAt(i)-'0';
			}
			
		}
		System.out.print(sum+num);
	
		
		
	}

	}
}
