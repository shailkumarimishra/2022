package dsa.stack;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BalancedParenthesisTest {
	private String input;
	private boolean expected;
	private BalancedBracked balance;
	
	@Before
	public void setUp() throws Exception {
		this.balance = new BalancedBracked();
	}
	
	public BalancedParenthesisTest(String input, boolean expected) {
		this.input = input;
		this.expected = expected;
	}
	
	@Test
	public void testIsParenthesisBalanced() {
		assertEquals(expected, balance.isBalanced(input));
	}
	
	@Parameterized.Parameters
	public static Collection inputData() {
		return Arrays.asList(new Object[][] { { " ", false }, { "{}",true  }, { "({[}})", false} ,{"}()[]",false}});
	}
}
