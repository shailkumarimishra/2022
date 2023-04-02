package dsa.stack;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class InfixConversionTest {
	private String inputNumber;
	private String expectedResult;
	private InfixConversion infix;

	@Before
	public void setUp() throws Exception {
		infix = new InfixConversion();
	}

	public InfixConversionTest(String inputNumber, String expectedResult) {
		this.inputNumber = inputNumber;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] { { "a+b", "ab+" }, { "a+(b/c)", "abc/+" }, { "a+(b*(c+a))", "abca+*+" } });
	}

	@Test
	public void testInfixToPostfix() {
		System.out.println("Parameterized Number is : " + inputNumber);
		assertEquals(expectedResult, infix.infixToPostfix(inputNumber));
	}

}
