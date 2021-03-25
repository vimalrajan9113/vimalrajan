package org.jayUnit;

import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class RunClass {
@Test
public void tcfinal() {
	Result r = JUnitCore.runClasses(Day3Sample1.class,Day3Sample2.class);
	System.out.println("total run count:"+r.getRunCount());
	System.out.println("failed testcase:"+r.getFailureCount());
	System.out.println("ignored testcase count:"+r.getIgnoreCount());
	System.out.println("execution status:"+r.wasSuccessful());
	System.out.println("total run time:"+r.getRunTime());
	
	List<Failure> allfailures = r.getFailures();
	System.out.println("failed test cases");
	for (Failure f : allfailures) {
		System.out.println(f);
	}

}
}
