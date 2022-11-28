package javaPrograms;

public class RotateRight {

	public static void main(String[] args) {
		int [] a = new int [] {1, 2, 3, 4, 5}; //34512  
		int n=3;
		for(int i=0;i<n;i++) {
			int j,last;
			last=a[a.length-1];
			for(j=a.length-1;j>0;j--) {
				a[j]=a[j-1];
			}
			a[0]=last;
			System.out.println(last);
		}
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
			
		}
	}

}
