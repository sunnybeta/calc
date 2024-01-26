package io.sunnybeta.calc.evaluator;

/** The Operation interface which must implement the compute method */
public interface Operation{
	/** Function which performs the required operation with two operands
	 * @param a first operand
	 * @param b second operand
	 * @return double value computed at the end of the operation
	 */
	public abstract double compute(double a, double b);
}
