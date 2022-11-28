package javaPrograms;

public class LargestElementInArray {

	public static void main(String[] args) {
		int[]a=new int[] {25, 11, 7, 75, 100};
		int max=a[0];
		for(int i=0;i<a.length;i++) {
			if(a[i]>max) {
				max=a[i];
			}
			
			
		}
		System.out.println(max);
	}

}
