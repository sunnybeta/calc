package io.sunnybeta.calc.evaluator;

import java.util.Map;
import java.util.AbstractMap;

/** The Operator class consisting of several static helper methods required by Evaluator
 * @see Evaluator
 */
public class Operator{
	/** Operation Add */
	public final static char ADD      = '+';
	/** Operation Subtract */
	public final static char SUBTRACT = '-';
	/** Operation Multiply */
	public final static char MULTIPLY = '*';
	/** Operation Divide */
	public final static char DIVIDE   = '/';
	/** Operation Exponent */
	public final static char EXPONENT = '^';
	/** Operation Left Parenthesis */
	public final static char LPAR     = '(';
	/** Operation Right Parenthesis */
	public final static char RPAR     = ')';

	/** Table of operations along with their precedence order */
	private static Map<Character, Integer> precedenceMap = Map.ofEntries(
		new AbstractMap.SimpleEntry<>(ADD     , 1),
		new AbstractMap.SimpleEntry<>(SUBTRACT, 1),
		new AbstractMap.SimpleEntry<>(MULTIPLY, 2),
		new AbstractMap.SimpleEntry<>(DIVIDE  , 2),
		new AbstractMap.SimpleEntry<>(EXPONENT, 3),
		new AbstractMap.SimpleEntry<>(LPAR    , 4),
		new AbstractMap.SimpleEntry<>(RPAR    , 4) 
	);

	/** Check whether a given token is an operator
	 * @param token the token to check
	 * @return True if the token is an operator; False otherwise
	 */
	public static boolean isOperator(String token) {
		return isOperator(token.charAt(0));
	}

	/** Check whether a given character is an operator
	 * @param c the character to check
	 * @return True if the character is an operator; False otherwise
	 */
	public static boolean isOperator(char c) {
		return precedenceMap.containsKey(c);
	}

	/** Check whether a given character is a parenthesis
	 * @param c the character to check
	 * @return True if the character is a parenthesis; False otherwise
	 */
	public static boolean isParenthesis(char c) {
		return c == LPAR || c == RPAR;
	}

	/** Compares the precedence value of two tokens
	 * @param operator1 first token (convention: this token is on the stack)
	 * @param operator2 second token (convention: this token is from infix/postfix list)
	 * @return True if the character is a parenthesis; False otherwise
	 */
	public static boolean hasHigherPrecedence(String operator1, String operator2) {
		if (operator1 == null) return false;
		if (isParenthesis(operator1.charAt(0))) return false;
		if (operator2 == null) return true;
		return precedenceMap.get(operator1.charAt(0)) >= precedenceMap.get(operator2.charAt(0));
	}
}
