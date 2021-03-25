package org.jayUnit;

import org.baseclass.BaseClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class Day1 extends BaseClass {
	@Ignore
	@Test
	public void tc3() {
		System.out.println("test 3");
	}

	@Test
	public void tc2() {
		System.out.println("test 2");
	}

	@Test
	public void tc1() {
	System.out.println("test 1");
}

@Before
public void start() {
	System.out.println("test case starts");
}

@After
public void end() {
	System.out.println("test case ends");

}


}
	

