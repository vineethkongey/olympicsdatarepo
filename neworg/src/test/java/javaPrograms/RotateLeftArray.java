package javaPrograms;

public class RotateLeftArray {

	public static void main(String[] args) {
		
		int []a=new int[] {1,2,3,4,5};
		int n=3;
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		//rotate the given array n number of times
		for(int i=0;i<n;i++) {
			int j,first;
			//store the first elements of the arry
			first=a[0];
			for(j=0;j<a.length-1;j++) {
				
				a[j]=a[j+1];
				
				
			}
			a[j]=first;
			System.out.println(first);
		}
		System.out.println();
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+ " ");
		}
	}

}
