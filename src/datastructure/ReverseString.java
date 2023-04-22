package datastructure;

public class ReverseString {

	public static void main(String[] args) {
		String s1 = "My Name is Khan";
		String temp="";
		String result="";
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)==' ') {
				result=temp+" "+result;
				temp="";
			}else {
				temp=temp+s1.charAt(i);
			}
		}
		result=temp+" "+result;
		System.out.println(result);
	}

}
