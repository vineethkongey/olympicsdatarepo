package stringProg;

public class DuplicateCharacter {

	public static void main(String[] args) {
		String s="responsibility";

		for(int i=0;i<s.length()-1;i++) {

			for(int j=i+1;i<s.length();j++) {
				if(s.charAt(i)==s.charAt(j)) {
					System.out.println(s.charAt(j));
				}
		}

	}

	}
}
