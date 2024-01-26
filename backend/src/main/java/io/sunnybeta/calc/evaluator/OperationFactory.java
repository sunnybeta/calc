package io.sunnybeta.calc.evaluator;

import java.lang.Override;

class Add implements Operation{
	@Override
	public double compute(double a, double b) {
		return a+b;
	}
}

class Multiply implements Operation{
	@Override
	public double compute(double a, double b) {
		return a*b;
	}
}

class Divide implements Operation{
	@Override
	public double compute(double a, double b) {
		return a/b;
	}
}

class Subtract implements Operation{
	@Override
	public double compute(double a, double b) {
		return a-b;
	}
}

class Power implements Operation{
	@Override
	public double compute(double a, double b) {
		return Math.pow(a,b);
	}
}

class OperationFactory{
	public static Operation generate(String s) {
		char c = s.charAt(0);
		if ( c == Operator.ADD      ) return new Add();
		if ( c == Operator.MULTIPLY ) return new Multiply();
		if ( c == Operator.DIVIDE   ) return new Divide();
		if ( c == Operator.SUBTRACT ) return new Subtract();
		if ( c == Operator.EXPONENT ) return new Power();
		throw new Error("The provided operation " + c + " is not supported");
	}
}
