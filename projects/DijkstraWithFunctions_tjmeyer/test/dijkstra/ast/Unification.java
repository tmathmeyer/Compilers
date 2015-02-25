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
				 			 +"print  (b + c) mod (b - c) "
		);
	}
	
	
	@Test(expected = RuntimeException.class)
	public void testFail()
	{
		TypeCheckRunner.check("float a "
				 +"int b "
				 +"print a+b "
				 +"print a mod b "
		);
	}
	
	@Test
	public void testArrays()
	{
		TypeCheckRunner.check(
				  "input a "
				 +"int[a] arr "
				 +"a <- 4.2 ");
	}
	
	@Test(expected = RuntimeException.class)
	public void testArraysEasy()
	{
		TypeCheckRunner.check(
				  "input a "
				 +"int[a / 4] arr "
				 +"a <- 4.2 ");
	}
	
	@Test(expected = RuntimeException.class)
	public void testShouldReallyFail()
	{
		TypeCheckRunner.check(
				  "print 7.2 mod 3 "
		);
	}
	
	@Test(expected = RuntimeException.class)
	public void testShouldReallyFail2()
	{
		TypeCheckRunner.check(
				  "float a "
				+ "print a mod 3 "
		);
	}
	
	@Test(expected = RuntimeException.class)
	public void testCastingThings()
	{
		TypeCheckRunner.check(
				  "input a "
				 +"a <- (1+(6/3)) mod 3 "
		);
	}
	
	
	@Test
	public void testfunc()
	{
		TypeCheckRunner.check(
				  "fun test(a):int { "
				 +"   return 4 mod a; "
				 +"} "
				 +"a <- test(5) + 0.5"
				 +"print a");
	}
	
	@Test
	public void testfutenc()
	{
		System.out.println(TypeCheckRunner.check(
				  "int a "
				 +"float[a+1] first "
				 +"a <- first[a] "
		));
	}
	
	
	
	@Test
	public void testNotFail()
	{
		TypeCheckRunner.check(
				  "float a "
				 +"int b "
				 +"b <- a "
				 +"print b+a "
		);
	}
	
	
	@Test
	public void testCreepy()
	{
		TypeCheckRunner.check("a <- 6/7 = 3*4");
	}
	
	
	@Test
	public void uhh()
	{
		TypeCheckRunner.check("a <- 1 "
							 +"input b, c "
							 +"if "
							 +"  a=b :: print a "
							 +"  c :: print b "
							 +"fi ");
	}

}
