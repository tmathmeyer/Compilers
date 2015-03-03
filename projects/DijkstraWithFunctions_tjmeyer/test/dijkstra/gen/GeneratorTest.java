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
		runCode("int a; a <- 1; print a;");
		runCode("float a; a <- 1.5; print a;");
		runCode("boolean a; a <- true; print a;");
	}
	
	@Test
	public void testInput() throws Exception
	{	
		runCode("boolean a; input a; print a;");
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
