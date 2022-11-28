package practice;

public class Practice {
	public static void main(String[] args) {
		 int[]a={6,4,5,3,2,1};
		 for(int i=0;i<a.length;i++) {
			 for(int j=i+1;j<a.length;j++) {
				 int temp =a[i];
				 a[i]=a[j];
				a[j]=temp;
				 
			 }
			 System.out.println(a[i]);
		 }
		 System.out.println(" ");
	}
	

}
