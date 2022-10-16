package gc_assignment;

/* 
 * BigInt.java
 *
 * A class for objects that represent non-negative integers of 
 * up to 20 digits.
 */

public class BigInt {
	// the maximum number of digits in a BigInt -- and thus the length
	// of the digits array
	private static final int SIZE = 20;

	// the array of digits for this BigInt object
	private int[] digits;

	// the number of significant digits in this BigInt object
	private int numSigDigits;

	/*
	 * Default, no-argument constructor -- creates a BigInt that represents the
	 * number 0.
	 */
	public BigInt() {
		this.digits = new int[SIZE];
		this.numSigDigits = 1; // 0 has one sig. digit--the rightmost 0!
	}
	
	public BigInt(int n) {
		if(n<0)
			throw new IllegalArgumentException();
		int length=String.valueOf(n).length();
		int[] arr=new int[length];
		int index=arr.length-1;
		while(n/10!=0) {
			arr[index--]=n%10;
			n=n/10;
		}
		if(n/10==0)
			arr[index]=n%10;
		this.digits=getDigitsArray(arr);
		this.numSigDigits = getNumSigDigits(arr);
	}

	public BigInt(int[] arr) {
		if (arr == null || arr.length == 0 || arr.length > SIZE)
			throw new IllegalArgumentException();
		else if (!isValidArray(arr))
			throw new IllegalArgumentException();
		else {
			this.digits = getDigitsArray(arr);
//			this.digits=arr;
			this.numSigDigits = getNumSigDigits(arr);
		}
	}

	private int[] getDigitsArray(int[] arr) {
		int[] temp = new int[SIZE];
		int range = temp.length - 1;
		for (int i = 0; i < arr.length; i++) {
			int data = arr[i];
			for (int j = range; j < temp.length - 1; j++) {
				temp[j] = temp[j + 1];
			}
			temp[temp.length - 1] = data;
			range--;
		}
		return temp;
	}

	private int getNumSigDigits(int[] arr) {
		int count = 0;
		boolean flag = false;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != 0)
				flag = true;
			if (!(arr[i] == 0 && arr[i + 1] == 0) || flag)
				count++;
		}
		return count;
	}
	
	public int getNumSigDigits() {
		return numSigDigits;
	}
	private boolean isValidArray(int[] arr) {
		for (int a : arr) {
			if (!(a >= 0 && a <= 9))
				return false;
		}
		return true;
	}

	public String toString() {
		// your code here
		String s = "";
		int i = getMSDIndex(digits);
		for (; i < digits.length; i++) {
			if(i==-1)
				return "0";
			s = s + this.digits[i];
		}
		return s;
	}

	public int compareTo(BigInt other) {
		if (this.digits == null || other == null)
			throw new IllegalArgumentException();
		if (numSigDigits < other.numSigDigits)
			return -1;
		else if (numSigDigits > other.numSigDigits)
			return 1;
		else {
			for (int i = 0; i < digits.length; i++) {
				if (digits[i] != 0 && other.digits[i] != 0) {
					if (digits[i] > other.digits[i])
						return 1;
					else if (digits[i] < other.digits[i])
						return -1;
				}
			}
		}
		return 0;
	}

	public BigInt add(BigInt other) {
		if (digits == null || other == null)
			throw new IllegalArgumentException();
		BigInt result = new BigInt();
		int carry = 0;
		int msd = getMSDIndex(digits);
		int otherMSD = getMSDIndex(other.digits);
		int range;
		if (msd <= otherMSD)
			range = msd;
		else
			range = otherMSD;
		try {
			int[] sumArr = new int[SIZE];
			int index = sumArr.length - 1;
			for (int i = digits.length - 1; i >= range; i--) {
				int num1 = digits[i];
				int num2 = other.digits[i];
				if (num1 == 0 && num2 == 0 && carry == 0)
					break;
				int sum = num1 + num2 + carry;
				carry = findCarry(sum);
				int val = findSumValue(sum);
				sumArr[index--] = val;
			}
			sumArr[index] = carry;
			result.digits = getDigitsArray(sumArr);
			result.numSigDigits=getNumSigDigits(sumArr);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArithmeticException();
		}
		return result;
	}

	public BigInt mul(BigInt other) {
		
		if (digits == null || other == null)
			throw new IllegalArgumentException();
		BigInt result = new BigInt();
		int carry = 0;
		int msd = getMSDIndex(digits);
		int otherMSD = getMSDIndex(other.digits);
		int count=-1;
		try {
			for(int i=other.digits.length-1;i>=otherMSD;i--) {
				int num=other.digits[i];
				String row="";
				for(int j=digits.length-1;j>=msd;j--) {
					int val=num*digits[j]+carry;
					carry = findCarry(val);
					val = findSumValue(val);
					row=row+val;
				}
				if(carry!=0)
					row=row+carry;
				row=new StringBuilder(row).reverse().toString();
				count++;
				result=getMultiple(result,row,count);
				result.numSigDigits=getNumSigDigits(result.digits);
			}
			
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArithmeticException();
		}
		return result;
	}

	private BigInt getMultiple(BigInt result, String row,int count) {
		if(result.getNumSigDigits()==1 && count==0) {
			int range=result.digits.length-row.length();
			int j=row.length()-1;
			for(int i=result.digits.length-1;i>=range;i--) {
				result.digits[i]=Integer.valueOf(Character.toString(row.charAt(j--)));
			}
		}else {
			int i=result.digits.length-1-count;
			int len=row.length()-1;
			int carry=0;
			while(len!=-1) {
				int num=result.digits[i]+Integer.valueOf(Character.toString(row.charAt(len--)))+carry;
				carry=findCarry(num);
				num=findSumValue(num);
				result.digits[i--]=num;
			}
			if(carry!=0)
				result.digits[i]=carry;
		}
		return result;
	}

	private int findSumValue(int sum) {
		return sum % 10;
	}

	private int findCarry(int sum) {
		return sum / 10;
	}

	private int getMSDIndex(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println("Unit tests for the BigInt class.");
		System.out.println();

		/*
		 * You should uncomment and run each test--one at a time-- after you build the
		 * corresponding methods of the class.
		 */
		   System.out.println("Test 1: result should be 7");
//		   int[] a1 = { 1,2,3,4,5,6,7};
		   int[] a1 = { 0,0,0,1,0,2,0,3,0,0};
		   BigInt b1 = new BigInt(a1);
		   System.out.println(b1.getNumSigDigits());
		   System.out.println();
		   
		   System.out.println("Test 2: result should be 1234567");
		   b1 = new BigInt(a1);
		   System.out.println(b1);
		   System.out.println();
		   
		   System.out.println("Test 3: result should be 0");
		   int[] a2 = { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 };
		   BigInt b2 = new BigInt(a2);
		   System.out.println(b2);
		   System.out.println();
		   
		   System.out.println("Test 4: should throw an IllegalArgumentException");
		   try {
			   int[] a3 = { 0,0,0,0,23,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 }; 
			   BigInt b3 = new BigInt(a3); 
			   System.out.println("Test failed."); 
		   } catch(IllegalArgumentException e) { 
			   System.out.println("Test passed."); 
		   } catch(Exception e) {
			   System.out.println("Test failed: threw wrong type of exception.");
		   }
		   System.out.println();
		   
		   System.out.println("Test 5: result should be 1234567");
		   b1 = new BigInt(1234567);
		   System.out.println(b1); 
		   System.out.println();
		   
		   System.out.println("Test 6: result should be 0");
		   b2 = new BigInt(0);
		   System.out.println(b2); 
		   System.out.println();
		   
		   System.out.println("Test 7: should throw an IllegalArgumentException");
		   try {
			   BigInt b3 = new BigInt(-4);
			   System.out.println("Test failed."); 
		   } catch(IllegalArgumentException e) {
			   System.out.println("Test passed.");
		   } catch(Exception e) {
			   System.out.println("Test failed: threw wrong type of exception.");
		   }
		   System.out.println();
		   
		   System.out.println("Test 8: result should be 0");
		   b1 = new BigInt(12375);
		   b2= new BigInt(12375);
		   System.out.println(b1.compareTo(b2));
		   System.out.println();
		   
		   System.out.println("Test 9: result should be -1");
		   b2 = new BigInt(12378);
		   System.out.println(b1.compareTo(b2));
		   System.out.println();
		   
		   System.out.println("Test 10: result should be 1");
		   System.out.println(b2.compareTo(b1));
		   System.out.println();
		   
		   System.out.println("Test 11: result should be 0");
		   b1 = new BigInt(0);
		   b2 =new BigInt(0); 
		   System.out.println(b1.compareTo(b2));
		   System.out.println();
		   
		   System.out.println("Test 12: result should be\n123456789123456789");
		   int[] a4= { 3,6,1,8,2,7,3,6,0,3,6,1,8,2,7,3,6 };
		   int[] a5 = {8,7,2,7,4,0,5,3,0,8,7,2,7,4,0,5,3 }; 
		   BigInt b4 = new BigInt(a4); 
		   BigInt b5 =new BigInt(a5);
		   BigInt sum = b4.add(b5); 
		   System.out.println(sum);
		   System.out.println();
		   
		   System.out.println("Test 13: result should be\n123456789123456789");
		   System.out.println(b5.add(b4));
		   System.out.println();
		   
		   System.out.println("Test 14: result should be\n3141592653598");
		   b1 = new BigInt(0); 
		   int[] a6 = { 3,1,4,1,5,9,2,6,5,3,5,9,8 };
		   b2 = new BigInt(a6);
		   System.out.println(b1.add(b2)); 
		   System.out.println();
		   
		   System.out.println("Test 15: result should be\n10000000000000000000");
		   int[]a19 = { 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9 }; 
		   // 19 nines! 
		   b1 = new BigInt(a19); 
		   b2 = new BigInt(1);
		   System.out.println(b1.add(b2));
		   System.out.println();
		   
		   System.out.println("Test 16: should throw an ArithmeticException"); 
		   int[] a20= { 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9 }; // 20 nines!
		   try {
			   b1 = new BigInt(a20);
			   System.out.println(b1.add(b2));
		   } catch (ArithmeticException e){
			   System.out.println("Test passed.");
		   } catch (Exception e) {
			   System.out.println("Test failed: threw wrong type of exception.");
		   }
		   System.out.println();
		   
		   System.out.println("Test 17: result should be 5670"); 
		   b1 = new BigInt(135);
		   b2 = new BigInt(42); 
		   BigInt product = b1.mul(b2);
		   System.out.println(product); 
		   System.out.println();
		   
		   System.out.println("Test 18: result should be\n99999999999999999999");
		   b1 = new BigInt(a20); // 20 nines -- see above 
		   b2 = new BigInt(1);
		   System.out.println(b1.mul(b2));
		   System.out.println();
		   
		   System.out.println("Test 19: should throw an ArithmeticException"); 
		   try { 
			   b1  = new BigInt(a20); 
			   b2 = new BigInt(2); 
			   System.out.println(b1.mul(b2));
		   }
		   catch (ArithmeticException e) {
			   System.out.println("Test passed."); 
		   } catch(Exception e) {
			   System.out.println("Test failed: threw wrong type of exception."); 
		   }
		   System.out.println();
	}
}