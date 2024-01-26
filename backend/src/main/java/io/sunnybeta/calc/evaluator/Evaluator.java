package io.sunnybeta.calc.evaluator;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/** This class handles all the computation given the arithmetic expression */

@Configuration
public class Evaluator{

	/** Constructor */
	public Evaluator() {}

	/**
	 * Evaluates the given arithmetic expression
	 * @param expression A string which is a valid arithmetic expression
	 * @return Double value of the computed expression 
	 */
	public double compute(String expression) {
		double ans;
		List<String> tokenize = tokenize(expression);
		List<String> postfix = postfix(tokenize);
		ans = evaluate(postfix);
		return ans;
	}

	/**
	 * Collects relevant tokens from the given arithmetic expression
	 * @param expression A string which is a valid arithmetic expression
	 * @return A List of useful tokens
	 */
	public List<String> tokenize(String expression) {
		List<String> infix = new ArrayList<>();
		String tmp = "";
		char c = '\0';
		for (int i = 0; i < expression.length(); i++){
			c = expression.charAt(i);
			if (c == ' ') continue;
			if (Operator.isOperator(c)) {
				if (!tmp.equals("")) infix.add(tmp);
				tmp = "";
				infix.add(Character.toString(c));
			}
			else {
				tmp += c;
			}
		}
		if (!tmp.equals("")) infix.add(tmp);
		return infix;
	}

	/**
	 * Converts an infix list of tokens into its postfix form
	 * @param infix A List of string tokens which represent an arithmetic expression
	 * @return The list of tokens corresponding to the postfix expression
	 */
	public List<String> postfix(List<String> infix) {
		Stack st = new Stack();
		List<String> postfix = new ArrayList<>(infix.size());
		for (String token: infix) {
			if (!Operator.isOperator(token)) postfix.add(token);
			else {
				if (token.equals("(")) st.push(token);
				else if (token.equals(")")) {
					while (st.top() != null && !st.top().equals("(")) postfix.add(st.pop());
					st.pop();
				}
				else if (st.top() == null) st.push(token);
				else if (Operator.hasHigherPrecedence(st.top(), token)) {
					while (Operator.hasHigherPrecedence(st.top(), token) && st.top() != "(" && st.top() != ")") postfix.add(st.pop());
					st.push(token);
				}
				else if (!Operator.hasHigherPrecedence(st.top(), token)) st.push(token);
			}
		}
		while(!st.isEmpty()) postfix.add(st.pop());
		return postfix;
	}

	/**
	 * Evaluates the given postfix expression
	 * @param postfix A List of string tokens which represents the postfix form of the arithmetic expression
	 * @return Final value after evaluating the postfix form
	 */
	public double evaluate(List<String> postfix) {
		String token;
		double operand_a, operand_b;
		for (int i = 0; i < postfix.size(); i++) {
			token = postfix.get(i);
			if (!Operator.isOperator(token)) continue;
			Operation operation = OperationFactory.generate(token);
			operand_b = Double.parseDouble(postfix.get(i-1));
			operand_a = Double.parseDouble(postfix.get(i-2));
			postfix.set(i-2, Double.toString(operation.compute(operand_a, operand_b)));
			postfix.remove(i--); // Remove the operator
			postfix.remove(i--); // Remove operand_b
		}
		return Double.parseDouble(postfix.get(0));
	}
}
