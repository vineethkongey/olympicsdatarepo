package javaPrograms;

public class ArrayInOddPosition {
	public static void main(String[] args) {
		int[]a=new int[] {1, 2, 3, 4, 5};
		for(int i=0;i<a.length;i=i+2) {
			
			System.out.print(a[i]+" ");
			
	}

}
}