package dijkstra.utility;

import static dijkstra.ParseUtils.getTree;
import dijkstra.Tuple;
import dijkstra.ast.AST;
import dijkstra.ast.ASTBuilder;
import dijkstra.lexparse.DijkstraParser;
import dijkstra.lexparse.DijkstraParser.DijkstraTextContext;
import dijkstra.unify.ReverseNameIndex;
import dijkstra.unify.TypeUnificationTable;
import dijkstra.unify.rlist.RList;

public class TypeCheckRunner
{
	public static TypeUnificationTable check(String code, String ... x)
	{
		
		Tuple<DijkstraTextContext, DijkstraParser> tree = getTree(code);

		ReverseNameIndex rsi = new ReverseNameIndex();
		
		AST t = AST.makeUnique(true, tree.a.accept(new ASTBuilder(tree.b)), x.length==0 ? rsi : new ReverseNameIndex());
		
		TypeUnificationTable tut = new TypeUnificationTable(rsi);
		
		t.buildTUT(tut);
		
		return tut.check(RList.emptyList());
	}
	
	public static Tuple<TypeUnificationTable, AST> check(String code)
	{
		Tuple<DijkstraTextContext, DijkstraParser> tree = getTree(code);

		ReverseNameIndex rsi = new ReverseNameIndex();
		
		AST t = AST.makeUnique(true, tree.a.accept(new ASTBuilder(tree.b)), rsi);
		
		TypeUnificationTable tut = new TypeUnificationTable(rsi);
		
		t.buildTUT(tut);
		
		return new Tuple<TypeUnificationTable, AST>(tut.check(RList.emptyList()), t);
	}
}
