package io.sunnybeta.calc.evaluator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StackTest{

	@Test
	public void stackTest(){
		Stack st = new Stack();
		st.push("data-1");
		st.push("data-2");
		st.push("data-3");
		st.push("data-4");
		assertEquals(st.pop(), "data-4");
		assertNotEquals(st.top(), null);
		assertEquals(st.pop(), "data-3");
		assertNotEquals(st.top(), null);
		assertEquals(st.pop(), "data-2");
		assertNotEquals(st.top(), null);
		assertEquals(st.pop(), "data-1");
		assertEquals(st.top(), null);
	}
}
