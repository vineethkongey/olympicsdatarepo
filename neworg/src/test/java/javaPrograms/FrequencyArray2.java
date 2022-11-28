package javaPrograms;

public class FrequencyArray2 {

	public static void main(String[] args) {
		
		int arr[]=new int[] {1,2,8,3,2,2,5,1};
		int fr[]=new int[arr.length];
		int repeated=-1;

		
		for(int i=0;i<arr.length;i++) {
			int count=1;
			for(int j=i+1;i<arr.length;j++) {
				if(arr[i]==arr[j]) {
					count++;
					fr[j]=repeated;
				}
			}
			if(fr[i]!=repeated) 
				fr[i]=count;
			}
	
			for(int i = 0; i < fr.length; i++){  
	            if(fr[i] != repeated)  
	                System.out.println("    " + arr[i] + "    |    " + fr[i]);  
	         
	        System.out.println("----------------------------------------");  
			}
			}
		
	}
	
		

		

