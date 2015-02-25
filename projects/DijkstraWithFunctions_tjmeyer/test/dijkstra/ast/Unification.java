package dijkstra.ast;

import org.junit.Test;
import dijkstra.utility.TypeCheckRunner;

public class Unification {
	
	@Test
	public void test()
	{
		TypeCheckRunner.check("input b "
				 			 +"input c "
				 			 +"print 1 "
				 			 +"print  (b + c) mod (b - c) ");
	}
	
	
	@Test
	public void testFail()
	{
		System.out.println(TypeCheckRunner.check("float a "
				 +"int b "
				 +"print a+b "
				 +"print a mod b "));
	}
	
	
	@Test
	public void testfunc()
	{
		TypeCheckRunner.check("fun test(a):int { "
				 +"   return 4 mod a; "
				 +"} "
				 +"a <- test(5) + 0.5"
				 +"print a");
	}
	
	
	
	@Test
	public void testNotFail()
	{
		TypeCheckRunner.check("float a "
				 +"int b "
				 +"b <- a "
				 +"print b+a ");
	}
	
	
	
	@Test
	public void testNotFailHAHA()
	{
		TypeCheckRunner.check("float a "
				 +"a <- b "
				 +"float b ");
	}

}
