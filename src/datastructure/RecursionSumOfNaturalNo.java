package datastructure;

public class RecursionSumOfNaturalNo {
	
	public static int fun(int num) {
		if(num==0)
			return 0;
		return num+fun(num-1);
	}
	
	public static void main(String[] args) {
		System.out.println(fun(5));
		
	}

}
