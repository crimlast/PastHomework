package problem5;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrimeTest {

	@Test
	public void test2() {
		Prime p = new Prime();
		boolean pri = p.isPrime(2);
		assertEquals(true, pri);
	}
	
	@Test
	public void test3() {
		Prime p = new Prime();
		boolean pri = p.isPrime(3);
		assertEquals(true, pri);
	}
	
	@Test
	public void test4() {
		Prime p = new Prime();
		boolean pri = p.isPrime(4);
		assertEquals(true, pri);
	}
	
	@Test
	public void test5() {
		Prime p = new Prime();
		boolean pri = p.isPrime(5);
		assertEquals(true, pri);
	}
	
	@Test
	public void test6() {
		Prime p = new Prime();
		boolean pri = p.isPrime(6);
		assertEquals(true, pri);
	}

}
