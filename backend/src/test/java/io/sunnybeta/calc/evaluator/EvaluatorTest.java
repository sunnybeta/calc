package io.sunnybeta.calc.evaluator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class EvaluatorTest{
	
	@Test
	public void tokenizeTest(){
		String expression = " 2/  4 *3 - 100 +4";
		String[] evalTokens = {"2","/","4","*","3","-","100","+","4"};
		Evaluator evaluator = new Evaluator();
		List<String> infix = evaluator.tokenize(expression);
		for (int i = 0; i < evalTokens.length; i++) {
			assertTrue(evalTokens[i].equals(infix.get(i)));
		}
	}

	@Test
	public void tokenizeWithBracketsTest(){
		String expression = "(2-3)*4";
		String[] evalTokens = {"(","2","-","3",")","*","4"};
		Evaluator evaluator = new Evaluator();
		List<String> infix = evaluator.tokenize(expression);
		for (int i = 0; i < evalTokens.length; i++) {
			assertTrue(evalTokens[i].equals(infix.get(i)));
		}
	}
	
	@Test
	public void postfixConversionTest(){
		String[] infix = {"2","/","4","*","3","-","100","+","4"};
		String[] evalTokens = {"2","4","/","3","*","100","-","4","+"};
		Evaluator evaluator = new Evaluator();
		List<String> postfix = evaluator.postfix(new ArrayList<String>(Arrays.asList(infix)));
		for (int i = 0; i < evalTokens.length; i++) {
			assertTrue(evalTokens[i].equals(postfix.get(i)));
		}
	}
	
	@Test
	public void postfixConversionWithBracketsTest(){
		String[] infix = {"(","2","-","3",")","*","4"};
		String[] evalTokens = {"2","3","-","4","*"};
		Evaluator evaluator = new Evaluator();
		List<String> postfix = evaluator.postfix(new ArrayList<String>(Arrays.asList(infix)));
		for (int i = 0; i < evalTokens.length; i++) {
			assertTrue(evalTokens[i].equals(postfix.get(i)));
		}
	}

	@Test
	public void resultTest(){
		Evaluator evaluator = new Evaluator();
		String[] testCases = {
			" 2/  4 *3 - 100 +4",
			"(2-3)*4",
			"2+(3+4)-(4-6)",
			// "2*(-40)",
		};
		double[] expected = {
			-94.5,
			-4.0,
			11,
			// -80,
		};
		double actual;
		for (int i = 0; i < testCases.length; i++){
			actual = evaluator.compute(testCases[i]);
			assertTrue(actual == expected[i]);
		}
	}
}
