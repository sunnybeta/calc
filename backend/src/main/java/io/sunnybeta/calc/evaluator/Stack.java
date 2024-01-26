package io.sunnybeta.calc.evaluator;

/** Custom Stack implementation consisting of string elements */
public class Stack{

	private Node<String> top;

	/** Constructor */
	public Stack() {
		top = null;
	}

	/** Push a string on top of the Stack
	 * @param data string element
	 */
	public void push(String data){
		Node<String> node = new Node<>(data);
		node.next = top;
		top = node;
	}

	/** Pop the top most element off the stack
	 * @return Returns the top most element of the stack
	 */
	public String pop(){
		String data = top.data;
		top = top.next;
		return data;
	}

	/** Checks whether the stack is empty or not
	 * @return True if stack is empty; False otherwise
	 */
	public boolean isEmpty() {
		return top == null;
	}

	/** Returns the element on top of the stack
	 * @return value of the element
	 */
	public String top() {
		if (top == null) return null;
		return top.data;
	}

	/** Print all the elements in the stack */
	public void debug() {
		Node<String> p = top;
		System.out.print("END <- ");
		while (p != null) {
			System.out.print(p.data + " <- ");
			p = p.next;
		}
		System.out.println("TOP");
	}
}
