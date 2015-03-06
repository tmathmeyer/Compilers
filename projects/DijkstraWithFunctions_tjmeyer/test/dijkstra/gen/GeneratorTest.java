package dijkstra.gen;

import org.junit.Test;
import org.objectweb.asm.ClassWriter;

import dijkstra.Tuple;
import dijkstra.ast.AST;
import dijkstra.unify.TypeUnificationTable;
import dijkstra.utility.TypeCheckRunner;

public class GeneratorTest extends ClassLoader
{
	@Test
	public void testeasy() throws Exception
	{
		System.out.println("====testeasy====");
		runCode("int a; a <- 1; print a;");
		runCode("float a; a <- 1.5; print a;");
		runCode("boolean a; a <- true; print a;");
		System.out.println("\n\n");
	}
	
	@Test
	public void testInput() throws Exception
	{	
		System.out.println("====testInput====");
		//runCode("boolean a; input a; print a;");
		//runCode("int a; input a; print a;");
		System.out.println("\n\n");
	}
	
	@Test
	public void testBasicMath() throws Exception
	{
		System.out.println("====testBasicMath====");
		runCode("int a; a <- 1 + 2; print a;");
		runCode("float a; a <- 1.5 + 2.5; print a;");
		
		runCode("int a; a <- 1 - 2; print a;");
		runCode("float a; a <- 1.5 - 2.5; print a;");
		
		runCode("int a; a <- 1 * 2; print a;");
		runCode("float a; a <- 1.5 * 2.5; print a;");
		runCode("float a; a <- 1 * 2.5; print a;");
		
		runCode("float a; a <- 1.5 / 2.5; print a;");
		runCode("float a; a <- 1 / 4; print a;");
		
		runCode("int a; a <- 1 mod 4; print a;");
		runCode("int a; a <- 1 div 4; print a;");

		System.out.println(">> equality");
		runCode("boolean a; a <- 1 = 4; print a;");
		runCode("boolean a; a <- 1.0 = 1.0; print a;");
		
		System.out.println(">> greater than");
		runCode("boolean a; a <- 1 > 4; print a;");
		runCode("boolean a; a <- 4 > 1; print a;");
		runCode("boolean a; a <- 1.0 > 4; print a;");
		runCode("boolean a; a <- 1.0 > 1.0; print a;");
		
		System.out.println(">> less than");
		runCode("boolean a; a <- 1 < 4; print a;");
		runCode("boolean a; a <- 4 < 1; print a;");
		runCode("boolean a; a <- 1.0 < 4; print a;");
		runCode("boolean a; a <- 1.0 < 1.0; print a;");
		
		System.out.println(">> lteq gteq");
		runCode("boolean a; a <- 1 <= 4; print a;");
		runCode("boolean a; a <- 1 >= 4; print a;");
		
		System.out.println(">> not");
		runCode("boolean a; a <- ~true; print a;");
		runCode("boolean a; a <- ~false; print a;");
		
		System.out.println(">> and / or");
		runCode("boolean a; a <- true & true; print a;");
		runCode("boolean a; a <- false | false; print a;");
		
		System.out.println(">> negate");
		runCode("int a; a <- -3; print a;");
		runCode("float a; a <- -3.5; print a;");
		
		
		System.out.println(">> complex math");
		runCode("int a; a <- 1 * (2 + 3) * 4; print a;");
		
		System.out.println("\n\n");
	}

	
	@Test
	public void testArrays() throws Exception
	{	
		System.out.println("====testArrays====");
		runCode("int[2] a; a[1] <- 5+4; print a[1];");
		runCode("float[2] a; a[1] <- 5.0; print a[1];");
		System.out.println("\n\n");
	}
	
	
	@Test
	public void testFunctions() throws Exception
	{	
		System.out.println("====testFunctions====");
		System.out.println("\n\n");
	}
	
	
	@Test
	public void testConditionals() throws Exception
	{	
		System.out.println("====testConditionals====");
		System.out.println("\n\n");
	}
	
	
	@Test
	public void testLoops() throws Exception
	{	
		System.out.println("====testLoops====");
		System.out.println("\n\n");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void runCode(String inputText) throws Exception
	{
		Tuple<TypeUnificationTable, AST> res = TypeCheckRunner.check(inputText);
		
		TypeUnificationTable t = res.a;
		AST ast = res.b;
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		
		ast.generateCode(cw, null, t);
		byte[] code = cw.toByteArray();
		GeneratorTest loader = new GeneratorTest();
		
		
		Class<?> testClass = loader.defineClass("djkcode.test", code, 0, code.length);

		testClass.getMethods()[0].invoke(null, new Object[] { null });
	}
}
