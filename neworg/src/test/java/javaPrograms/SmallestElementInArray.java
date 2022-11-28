package javaPrograms;

public class SmallestElementInArray {

	public static void main(String[] args) {
		int[]a=new int[] {25, 11, 7, 75, 100};
		int min=a[0];
		for(int i=0;i<a.length;i++) {
			if(a[i]<min) {
				min=a[i];
			}
			
			
		}
		System.out.println(min);
	}

	}

