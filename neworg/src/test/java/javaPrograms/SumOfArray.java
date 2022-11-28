package javaPrograms;

public class SumOfArray {

	public static void main(String[] args) {
		int[]a=new int[] {25, 11, 7, 75, 100};
		
		int sum=0;
		for(int i=0;i<a.length;i++) {
			sum=sum+a[i];
		}
		System.out.println(sum);
	}

}
