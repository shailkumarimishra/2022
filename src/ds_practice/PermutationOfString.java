package ds_practice;

public class PermutationOfString {
	public static void permutate(String str,int s,int l) {
		if(s==l) {
			System.out.println(str);
		}
		else {
			for(int i=s;i<=l;i++) {
				str = swap(str,s,i);
				permutate(str, s+1, l);
				str = swap(str, s, i);// To get original string back.
			}
		}
	}

	private  static String swap(String str, int i, int j) {
		char temp;
		char[] charArray = str.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j]=temp;
		return String.valueOf(charArray);
	}

	public static void main(String[] args) {
		String s="ABC";
		int l = s.length();
		permutate(s, 0, l-1);
	}

}
