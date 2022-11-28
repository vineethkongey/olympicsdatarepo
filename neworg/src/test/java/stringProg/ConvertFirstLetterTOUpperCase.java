package stringProg;

public class ConvertFirstLetterTOUpperCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "welcome to india";
		String[]p=s.split(" ");
				for(int i=0;i<p.length;i++) {
					String word= p[i];
			word=word.substring(0,1).toUpperCase()+word.substring(1);
			System.out.print(word+" ");
				}
		

	}

}
