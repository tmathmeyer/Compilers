package dijkstra.gen;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassWriter;

import dijkstra.Tuple;
import dijkstra.ast.AST;
import dijkstra.unify.TypeUnificationTable;
import dijkstra.utility.TypeCheckRunner;

public class ClassGen
{
	public static void writeCode(String inputText)
	{
		Tuple<TypeUnificationTable, AST> res = TypeCheckRunner.check(inputText);
		
		TypeUnificationTable t = res.a;
		AST ast = res.b;
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		
		ast.generateCode(cw, null, t);
		byte[] code = cw.toByteArray();
		
		
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("classes/djkcode/Test.class");
			fos.write(code);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
