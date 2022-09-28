package datastructure;

public class RecursiveFactorial {
	
	private static int fun(int num) {
		if(num==0)
			return 1;
		return num*fun(num-1);
	}

	public static void main(String[] args) {
		System.out.println(fun(4));
	}


}
