// Generated from Dijkstra.g4 by ANTLR 4.5


package dijkstra.lexparse;


import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DijkstraLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ASSIGN=1, EQ=2, GT=3, GUARD=4, LBRACE=5, LPAR=6, LT=7, MINUS=8, NEQ=9, 
		PLUS=10, RBRACE=11, RPAR=12, SEMICOLON=13, SLASH=14, STAR=15, TILDE=16, 
		LBRACK=17, RBRACK=18, COLON=19, COMMA=20, AMP=21, BAR=22, GTEQ=23, LTEQ=24, 
		MOD=25, DIV=26, BOOLEAN=27, FALSE=28, FI=29, IF=30, DO=31, OD=32, INPUT=33, 
		INT=34, PRINT=35, PROGRAM=36, TRUE=37, FUN=38, PROC=39, FLOAT=40, RETURN=41, 
		ID=42, INTEGER=43, FLOAT_CONST=44, WS=45, COMMENT=46;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"ASSIGN", "EQ", "GT", "GUARD", "LBRACE", "LPAR", "LT", "MINUS", "NEQ", 
		"PLUS", "RBRACE", "RPAR", "SEMICOLON", "SLASH", "STAR", "TILDE", "LBRACK", 
		"RBRACK", "COLON", "COMMA", "AMP", "BAR", "GTEQ", "LTEQ", "MOD", "DIV", 
		"BOOLEAN", "FALSE", "FI", "IF", "DO", "OD", "INPUT", "INT", "PRINT", "PROGRAM", 
		"TRUE", "FUN", "PROC", "FLOAT", "RETURN", "ID", "INTEGER", "FLOAT_CONST", 
		"WS", "COMMENT", "LETTER", "DIGIT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'<-'", "'='", "'>'", "'::'", "'{'", "'('", "'<'", "'-'", "'~='", 
		"'+'", "'}'", "')'", "';'", "'/'", "'*'", "'~'", "'['", "']'", "':'", 
		"','", "'&'", "'|'", "'>='", "'<='", "'mod'", "'div'", "'boolean'", "'false'", 
		"'fi'", "'if'", "'do'", "'od'", "'input'", "'int'", "'print'", "'program'", 
		"'true'", "'fun'", "'proc'", "'float'", "'return'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ASSIGN", "EQ", "GT", "GUARD", "LBRACE", "LPAR", "LT", "MINUS", 
		"NEQ", "PLUS", "RBRACE", "RPAR", "SEMICOLON", "SLASH", "STAR", "TILDE", 
		"LBRACK", "RBRACK", "COLON", "COMMA", "AMP", "BAR", "GTEQ", "LTEQ", "MOD", 
		"DIV", "BOOLEAN", "FALSE", "FI", "IF", "DO", "OD", "INPUT", "INT", "PRINT", 
		"PROGRAM", "TRUE", "FUN", "PROC", "FLOAT", "RETURN", "ID", "INTEGER", 
		"FLOAT_CONST", "WS", "COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public DijkstraLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Dijkstra.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\60\u0114\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3"+
		"$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3"+
		"(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\7+\u00f2\n"+
		"+\f+\16+\u00f5\13+\3,\6,\u00f8\n,\r,\16,\u00f9\3-\3-\3-\3-\3.\6.\u0101"+
		"\n.\r.\16.\u0102\3.\3.\3/\3/\7/\u0109\n/\f/\16/\u010c\13/\3/\5/\u010f"+
		"\n/\3\60\3\60\3\61\3\61\3\u010a\2\62\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\2a\2\3\2\7\4\2AAaa\5\2\13\f\17\17\"\"\3\3\f\f\4\2C\\c|\3\2\62;"+
		"\u0117\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3"+
		"\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3c\3\2\2"+
		"\2\5f\3\2\2\2\7h\3\2\2\2\tj\3\2\2\2\13m\3\2\2\2\ro\3\2\2\2\17q\3\2\2\2"+
		"\21s\3\2\2\2\23u\3\2\2\2\25x\3\2\2\2\27z\3\2\2\2\31|\3\2\2\2\33~\3\2\2"+
		"\2\35\u0080\3\2\2\2\37\u0082\3\2\2\2!\u0084\3\2\2\2#\u0086\3\2\2\2%\u0088"+
		"\3\2\2\2\'\u008a\3\2\2\2)\u008c\3\2\2\2+\u008e\3\2\2\2-\u0090\3\2\2\2"+
		"/\u0092\3\2\2\2\61\u0095\3\2\2\2\63\u0098\3\2\2\2\65\u009c\3\2\2\2\67"+
		"\u00a0\3\2\2\29\u00a8\3\2\2\2;\u00ae\3\2\2\2=\u00b1\3\2\2\2?\u00b4\3\2"+
		"\2\2A\u00b7\3\2\2\2C\u00ba\3\2\2\2E\u00c0\3\2\2\2G\u00c4\3\2\2\2I\u00ca"+
		"\3\2\2\2K\u00d2\3\2\2\2M\u00d7\3\2\2\2O\u00db\3\2\2\2Q\u00e0\3\2\2\2S"+
		"\u00e6\3\2\2\2U\u00ed\3\2\2\2W\u00f7\3\2\2\2Y\u00fb\3\2\2\2[\u0100\3\2"+
		"\2\2]\u0106\3\2\2\2_\u0110\3\2\2\2a\u0112\3\2\2\2cd\7>\2\2de\7/\2\2e\4"+
		"\3\2\2\2fg\7?\2\2g\6\3\2\2\2hi\7@\2\2i\b\3\2\2\2jk\7<\2\2kl\7<\2\2l\n"+
		"\3\2\2\2mn\7}\2\2n\f\3\2\2\2op\7*\2\2p\16\3\2\2\2qr\7>\2\2r\20\3\2\2\2"+
		"st\7/\2\2t\22\3\2\2\2uv\7\u0080\2\2vw\7?\2\2w\24\3\2\2\2xy\7-\2\2y\26"+
		"\3\2\2\2z{\7\177\2\2{\30\3\2\2\2|}\7+\2\2}\32\3\2\2\2~\177\7=\2\2\177"+
		"\34\3\2\2\2\u0080\u0081\7\61\2\2\u0081\36\3\2\2\2\u0082\u0083\7,\2\2\u0083"+
		" \3\2\2\2\u0084\u0085\7\u0080\2\2\u0085\"\3\2\2\2\u0086\u0087\7]\2\2\u0087"+
		"$\3\2\2\2\u0088\u0089\7_\2\2\u0089&\3\2\2\2\u008a\u008b\7<\2\2\u008b("+
		"\3\2\2\2\u008c\u008d\7.\2\2\u008d*\3\2\2\2\u008e\u008f\7(\2\2\u008f,\3"+
		"\2\2\2\u0090\u0091\7~\2\2\u0091.\3\2\2\2\u0092\u0093\7@\2\2\u0093\u0094"+
		"\7?\2\2\u0094\60\3\2\2\2\u0095\u0096\7>\2\2\u0096\u0097\7?\2\2\u0097\62"+
		"\3\2\2\2\u0098\u0099\7o\2\2\u0099\u009a\7q\2\2\u009a\u009b\7f\2\2\u009b"+
		"\64\3\2\2\2\u009c\u009d\7f\2\2\u009d\u009e\7k\2\2\u009e\u009f\7x\2\2\u009f"+
		"\66\3\2\2\2\u00a0\u00a1\7d\2\2\u00a1\u00a2\7q\2\2\u00a2\u00a3\7q\2\2\u00a3"+
		"\u00a4\7n\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7c\2\2\u00a6\u00a7\7p\2\2"+
		"\u00a78\3\2\2\2\u00a8\u00a9\7h\2\2\u00a9\u00aa\7c\2\2\u00aa\u00ab\7n\2"+
		"\2\u00ab\u00ac\7u\2\2\u00ac\u00ad\7g\2\2\u00ad:\3\2\2\2\u00ae\u00af\7"+
		"h\2\2\u00af\u00b0\7k\2\2\u00b0<\3\2\2\2\u00b1\u00b2\7k\2\2\u00b2\u00b3"+
		"\7h\2\2\u00b3>\3\2\2\2\u00b4\u00b5\7f\2\2\u00b5\u00b6\7q\2\2\u00b6@\3"+
		"\2\2\2\u00b7\u00b8\7q\2\2\u00b8\u00b9\7f\2\2\u00b9B\3\2\2\2\u00ba\u00bb"+
		"\7k\2\2\u00bb\u00bc\7p\2\2\u00bc\u00bd\7r\2\2\u00bd\u00be\7w\2\2\u00be"+
		"\u00bf\7v\2\2\u00bfD\3\2\2\2\u00c0\u00c1\7k\2\2\u00c1\u00c2\7p\2\2\u00c2"+
		"\u00c3\7v\2\2\u00c3F\3\2\2\2\u00c4\u00c5\7r\2\2\u00c5\u00c6\7t\2\2\u00c6"+
		"\u00c7\7k\2\2\u00c7\u00c8\7p\2\2\u00c8\u00c9\7v\2\2\u00c9H\3\2\2\2\u00ca"+
		"\u00cb\7r\2\2\u00cb\u00cc\7t\2\2\u00cc\u00cd\7q\2\2\u00cd\u00ce\7i\2\2"+
		"\u00ce\u00cf\7t\2\2\u00cf\u00d0\7c\2\2\u00d0\u00d1\7o\2\2\u00d1J\3\2\2"+
		"\2\u00d2\u00d3\7v\2\2\u00d3\u00d4\7t\2\2\u00d4\u00d5\7w\2\2\u00d5\u00d6"+
		"\7g\2\2\u00d6L\3\2\2\2\u00d7\u00d8\7h\2\2\u00d8\u00d9\7w\2\2\u00d9\u00da"+
		"\7p\2\2\u00daN\3\2\2\2\u00db\u00dc\7r\2\2\u00dc\u00dd\7t\2\2\u00dd\u00de"+
		"\7q\2\2\u00de\u00df\7e\2\2\u00dfP\3\2\2\2\u00e0\u00e1\7h\2\2\u00e1\u00e2"+
		"\7n\2\2\u00e2\u00e3\7q\2\2\u00e3\u00e4\7c\2\2\u00e4\u00e5\7v\2\2\u00e5"+
		"R\3\2\2\2\u00e6\u00e7\7t\2\2\u00e7\u00e8\7g\2\2\u00e8\u00e9\7v\2\2\u00e9"+
		"\u00ea\7w\2\2\u00ea\u00eb\7t\2\2\u00eb\u00ec\7p\2\2\u00ecT\3\2\2\2\u00ed"+
		"\u00f3\5_\60\2\u00ee\u00f2\5_\60\2\u00ef\u00f2\5a\61\2\u00f0\u00f2\t\2"+
		"\2\2\u00f1\u00ee\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2"+
		"\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4V\3\2\2\2"+
		"\u00f5\u00f3\3\2\2\2\u00f6\u00f8\5a\61\2\u00f7\u00f6\3\2\2\2\u00f8\u00f9"+
		"\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00faX\3\2\2\2\u00fb"+
		"\u00fc\5W,\2\u00fc\u00fd\7\60\2\2\u00fd\u00fe\5W,\2\u00feZ\3\2\2\2\u00ff"+
		"\u0101\t\3\2\2\u0100\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0100\3\2"+
		"\2\2\u0102\u0103\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\b.\2\2\u0105"+
		"\\\3\2\2\2\u0106\u010a\7%\2\2\u0107\u0109\13\2\2\2\u0108\u0107\3\2\2\2"+
		"\u0109\u010c\3\2\2\2\u010a\u010b\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u010e"+
		"\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010f\t\4\2\2\u010e\u010d\3\2\2\2\u010f"+
		"^\3\2\2\2\u0110\u0111\t\5\2\2\u0111`\3\2\2\2\u0112\u0113\t\6\2\2\u0113"+
		"b\3\2\2\2\t\2\u00f1\u00f3\u00f9\u0102\u010a\u010e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}