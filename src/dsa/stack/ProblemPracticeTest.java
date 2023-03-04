package dsa.stack;

import org.junit.Assert;
import org.junit.Test;

public class ProblemPracticeTest {

	@Test
	public void validateBracketTest() {
		ProblemPractice test= new ProblemPractice();
		//given 
		String data = "()((()))";
		//when
		boolean result = test.validateBracket(data);
		//then
		Assert.assertTrue(result);
	}
	
	@Test
	public void validateBracketFail() {
		ProblemPractice test= new ProblemPractice();
		//given 
		String data = "(()((()))";
		//when
		boolean result = test.validateBracket(data);
		//then
		Assert.assertFalse(result);
	}

}
