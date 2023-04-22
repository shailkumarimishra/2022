package datastructure;

public class SwapString {

	public static void main(String[] args) {
		String s1 = "Ambe";
		String s2 = "Kalawati";
		s2=s1+s2;
//		s1=s2+s1;
		s1 = s2.substring(s1.length(),s2.length());
		s2 = s2.substring(0,s2.length()-s1.length());
		System.out.println(s1);
		System.out.println(s2);
	}

}
