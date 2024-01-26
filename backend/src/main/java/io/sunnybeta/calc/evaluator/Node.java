package io.sunnybeta.calc.evaluator;

/**
 * This class represents an element on the token Stack
 * @see Stack
 */
public class Node<T>{
 /** Value of the element */
	public T data;
 /** Pointer to the next element */
	public Node<T> next = null;

/**
 * Constructor
 * @param data Value of the current element
 */
	public Node(T data) { this.data = data; }
}
