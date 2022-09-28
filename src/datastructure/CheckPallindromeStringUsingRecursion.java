package datastructure;

public class CheckPallindromeStringUsingRecursion {
	
	public static boolean func(String str) {
		return helper(str, 0, str.length()-1);
	}
	
	private static boolean helper(String str,int start,int end) {
		if(start>=end) {
			return true;
		}
		return ((str.charAt(start)==str.charAt(end)) && helper(str, start+1, end-1));
	}

public static void main(String[] args) {
	String s="malayalam";
	System.out.println(func(s));
}
}
