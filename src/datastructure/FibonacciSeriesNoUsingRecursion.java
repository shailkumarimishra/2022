package datastructure;

public class FibonacciSeriesNoUsingRecursion {
	public static int fun(int num) {
		if(num==0)
			return num;
		if(num == 1)
			return num;
		return fun(num-1)+fun(num-2);
	}
public static void main(String[] args) {
	System.out.println(fun(6));
}
}
