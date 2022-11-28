package javaPrograms;

public class FrequencyArray {

	public static void main(String[] args) {

		int arr[]={1,2,8,8,2,2,5,1};
		for(int i=0;i<arr.length;i++) {
			int count=1;
			for(int j=i+1; j<arr.length;j++) {
				if(arr[i]!=0 && arr[i]==arr[j]) {
					arr[j]=0;
					count++;
				}
				
			}
			if(count>1) {System.out.println(arr[i] +" is repeatating "+ count +" times");}

		}
	}


}

