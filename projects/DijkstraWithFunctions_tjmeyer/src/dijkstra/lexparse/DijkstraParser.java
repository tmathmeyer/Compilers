// Generated from Dijkstra.g4 by ANTLR 4.5


package dijkstra.lexparse;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DijkstraParser extends Parser {
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
	public static final int
		RULE_dijkstraText = 0, RULE_program = 1, RULE_declaration = 2, RULE_type = 3, 
		RULE_var = 4, RULE_parameter = 5, RULE_argument = 6, RULE_separator = 7, 
		RULE_guard = 8, RULE_varList = 9, RULE_parameterList = 10, RULE_idList = 11, 
		RULE_expressionList = 12, RULE_argList = 13, RULE_guardedStatementList = 14, 
		RULE_procedureDeclaration = 15, RULE_functionDeclaration = 16, RULE_arrayDeclaration = 17, 
		RULE_variableDeclaration = 18, RULE_statement = 19, RULE_assignStatement = 20, 
		RULE_inputStatement = 21, RULE_outputStatement = 22, RULE_iterativeStatement = 23, 
		RULE_compoundStatement = 24, RULE_alternativeStatement = 25, RULE_returnStatement = 26, 
		RULE_procedureCall = 27, RULE_functionCall = 28, RULE_compoundBody = 29, 
		RULE_compDeclOrStatement = 30, RULE_arrayAccessor = 31, RULE_expr = 32;
	public static final String[] ruleNames = {
		"dijkstraText", "program", "declaration", "type", "var", "parameter", 
		"argument", "separator", "guard", "varList", "parameterList", "idList", 
		"expressionList", "argList", "guardedStatementList", "procedureDeclaration", 
		"functionDeclaration", "arrayDeclaration", "variableDeclaration", "statement", 
		"assignStatement", "inputStatement", "outputStatement", "iterativeStatement", 
		"compoundStatement", "alternativeStatement", "returnStatement", "procedureCall", 
		"functionCall", "compoundBody", "compDeclOrStatement", "arrayAccessor", 
		"expr"
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

	@Override
	public String getGrammarFileName() { return "Dijkstra.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DijkstraParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class DijkstraTextContext extends ParserRuleContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public TerminalNode EOF() { return getToken(DijkstraParser.EOF, 0); }
		public DijkstraTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dijkstraText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterDijkstraText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitDijkstraText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitDijkstraText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DijkstraTextContext dijkstraText() throws RecognitionException {
		DijkstraTextContext _localctx = new DijkstraTextContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_dijkstraText);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			program();
			setState(67);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(DijkstraParser.PROGRAM, 0); }
		public TerminalNode ID() { return getToken(DijkstraParser.ID, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(PROGRAM);
			setState(70);
			match(ID);
			setState(73); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(73);
				switch (_input.LA(1)) {
				case BOOLEAN:
				case INT:
				case FUN:
				case PROC:
				case FLOAT:
					{
					setState(71);
					declaration();
					}
					break;
				case LBRACE:
				case IF:
				case DO:
				case INPUT:
				case PRINT:
				case RETURN:
				case ID:
					{
					setState(72);
					statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(75); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACE) | (1L << BOOLEAN) | (1L << IF) | (1L << DO) | (1L << INPUT) | (1L << INT) | (1L << PRINT) | (1L << FUN) | (1L << PROC) | (1L << FLOAT) | (1L << RETURN) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public ArrayDeclarationContext arrayDeclaration() {
			return getRuleContext(ArrayDeclarationContext.class,0);
		}
		public ProcedureDeclarationContext procedureDeclaration() {
			return getRuleContext(ProcedureDeclarationContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			setState(81);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				arrayDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				procedureDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				functionDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(DijkstraParser.FLOAT, 0); }
		public TerminalNode BOOLEAN() { return getToken(DijkstraParser.BOOLEAN, 0); }
		public TerminalNode INT() { return getToken(DijkstraParser.INT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << FLOAT))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DijkstraParser.ID, 0); }
		public ArrayAccessorContext arrayAccessor() {
			return getRuleContext(ArrayAccessorContext.class,0);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_var);
		try {
			setState(87);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				arrayAccessor();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DijkstraParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameter);
		try {
			setState(93);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				match(ID);
				}
				break;
			case BOOLEAN:
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				type();
				setState(91);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SeparatorContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(DijkstraParser.SEMICOLON, 0); }
		public SeparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_separator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterSeparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitSeparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitSeparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeparatorContext separator() throws RecognitionException {
		SeparatorContext _localctx = new SeparatorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_separator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(97);
				match(SEMICOLON);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GuardContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode GUARD() { return getToken(DijkstraParser.GUARD, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public GuardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterGuard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitGuard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitGuard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GuardContext guard() throws RecognitionException {
		GuardContext _localctx = new GuardContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			expr(0);
			setState(101);
			match(GUARD);
			setState(102);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarListContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public VarListContext varList() {
			return getRuleContext(VarListContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(DijkstraParser.COMMA, 0); }
		public VarListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterVarList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitVarList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitVarList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarListContext varList() throws RecognitionException {
		return varList(0);
	}

	private VarListContext varList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VarListContext _localctx = new VarListContext(_ctx, _parentState);
		VarListContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_varList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(105);
			var();
			}
			_ctx.stop = _input.LT(-1);
			setState(112);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VarListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_varList);
					setState(107);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(108);
					match(COMMA);
					setState(109);
					var();
					}
					} 
				}
				setState(114);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ParameterListContext extends ParserRuleContext {
		public ParameterContext parameter() {
			return getRuleContext(ParameterContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(DijkstraParser.COMMA, 0); }
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		return parameterList(0);
	}

	private ParameterListContext parameterList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ParameterListContext _localctx = new ParameterListContext(_ctx, _parentState);
		ParameterListContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_parameterList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(116);
			parameter();
			}
			_ctx.stop = _input.LT(-1);
			setState(123);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ParameterListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_parameterList);
					setState(118);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(119);
					match(COMMA);
					setState(120);
					parameter();
					}
					} 
				}
				setState(125);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class IdListContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DijkstraParser.ID, 0); }
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(DijkstraParser.COMMA, 0); }
		public IdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterIdList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitIdList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitIdList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdListContext idList() throws RecognitionException {
		return idList(0);
	}

	private IdListContext idList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IdListContext _localctx = new IdListContext(_ctx, _parentState);
		IdListContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_idList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(127);
			match(ID);
			}
			_ctx.stop = _input.LT(-1);
			setState(134);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new IdListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_idList);
					setState(129);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(130);
					match(COMMA);
					setState(131);
					match(ID);
					}
					} 
				}
				setState(136);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(DijkstraParser.COMMA, 0); }
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		return expressionList(0);
	}

	private ExpressionListContext expressionList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, _parentState);
		ExpressionListContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expressionList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(138);
			expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(145);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expressionList);
					setState(140);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(141);
					match(COMMA);
					setState(142);
					expr(0);
					}
					} 
				}
				setState(147);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArgListContext extends ParserRuleContext {
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(DijkstraParser.COMMA, 0); }
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitArgList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		return argList(0);
	}

	private ArgListContext argList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArgListContext _localctx = new ArgListContext(_ctx, _parentState);
		ArgListContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_argList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(149);
			argument();
			}
			_ctx.stop = _input.LT(-1);
			setState(156);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_argList);
					setState(151);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(152);
					match(COMMA);
					setState(153);
					argument();
					}
					} 
				}
				setState(158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class GuardedStatementListContext extends ParserRuleContext {
		public GuardContext guard() {
			return getRuleContext(GuardContext.class,0);
		}
		public GuardedStatementListContext guardedStatementList() {
			return getRuleContext(GuardedStatementListContext.class,0);
		}
		public GuardedStatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guardedStatementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterGuardedStatementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitGuardedStatementList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitGuardedStatementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GuardedStatementListContext guardedStatementList() throws RecognitionException {
		return guardedStatementList(0);
	}

	private GuardedStatementListContext guardedStatementList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		GuardedStatementListContext _localctx = new GuardedStatementListContext(_ctx, _parentState);
		GuardedStatementListContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_guardedStatementList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(160);
			guard();
			}
			_ctx.stop = _input.LT(-1);
			setState(166);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new GuardedStatementListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_guardedStatementList);
					setState(162);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(163);
					guard();
					}
					} 
				}
				setState(168);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ProcedureDeclarationContext extends ParserRuleContext {
		public TerminalNode PROC() { return getToken(DijkstraParser.PROC, 0); }
		public TerminalNode ID() { return getToken(DijkstraParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(DijkstraParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(DijkstraParser.RPAR, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ProcedureDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterProcedureDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitProcedureDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitProcedureDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureDeclarationContext procedureDeclaration() throws RecognitionException {
		ProcedureDeclarationContext _localctx = new ProcedureDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_procedureDeclaration);
		try {
			setState(181);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				match(PROC);
				setState(170);
				match(ID);
				setState(171);
				match(LPAR);
				setState(172);
				match(RPAR);
				setState(173);
				compoundStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(PROC);
				setState(175);
				match(ID);
				setState(176);
				match(LPAR);
				setState(177);
				parameterList(0);
				setState(178);
				match(RPAR);
				setState(179);
				compoundStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode FUN() { return getToken(DijkstraParser.FUN, 0); }
		public TerminalNode ID() { return getToken(DijkstraParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(DijkstraParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(DijkstraParser.RPAR, 0); }
		public TerminalNode COLON() { return getToken(DijkstraParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_functionDeclaration);
		try {
			setState(200);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				match(FUN);
				setState(184);
				match(ID);
				setState(185);
				match(LPAR);
				setState(186);
				match(RPAR);
				setState(187);
				match(COLON);
				setState(188);
				type();
				setState(189);
				compoundStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				match(FUN);
				setState(192);
				match(ID);
				setState(193);
				match(LPAR);
				setState(194);
				parameterList(0);
				setState(195);
				match(RPAR);
				setState(196);
				match(COLON);
				setState(197);
				type();
				setState(198);
				compoundStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(DijkstraParser.LBRACK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(DijkstraParser.RBRACK, 0); }
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public SeparatorContext separator() {
			return getRuleContext(SeparatorContext.class,0);
		}
		public ArrayDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterArrayDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitArrayDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitArrayDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDeclarationContext arrayDeclaration() throws RecognitionException {
		ArrayDeclarationContext _localctx = new ArrayDeclarationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_arrayDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			type();
			setState(203);
			match(LBRACK);
			setState(204);
			expr(0);
			setState(205);
			match(RBRACK);
			setState(206);
			idList(0);
			setState(207);
			separator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public SeparatorContext separator() {
			return getRuleContext(SeparatorContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			type();
			setState(210);
			idList(0);
			setState(211);
			separator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public AssignStatementContext assignStatement() {
			return getRuleContext(AssignStatementContext.class,0);
		}
		public InputStatementContext inputStatement() {
			return getRuleContext(InputStatementContext.class,0);
		}
		public OutputStatementContext outputStatement() {
			return getRuleContext(OutputStatementContext.class,0);
		}
		public IterativeStatementContext iterativeStatement() {
			return getRuleContext(IterativeStatementContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public AlternativeStatementContext alternativeStatement() {
			return getRuleContext(AlternativeStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public ProcedureCallContext procedureCall() {
			return getRuleContext(ProcedureCallContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_statement);
		try {
			setState(221);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				assignStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				inputStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				outputStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(216);
				iterativeStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(217);
				compoundStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(218);
				alternativeStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(219);
				returnStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(220);
				procedureCall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignStatementContext extends ParserRuleContext {
		public VarListContext varList() {
			return getRuleContext(VarListContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(DijkstraParser.ASSIGN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(DijkstraParser.SEMICOLON, 0); }
		public AssignStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterAssignStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitAssignStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitAssignStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStatementContext assignStatement() throws RecognitionException {
		AssignStatementContext _localctx = new AssignStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assignStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			varList(0);
			setState(224);
			match(ASSIGN);
			setState(225);
			expressionList(0);
			setState(227);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(226);
				match(SEMICOLON);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InputStatementContext extends ParserRuleContext {
		public TerminalNode INPUT() { return getToken(DijkstraParser.INPUT, 0); }
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(DijkstraParser.SEMICOLON, 0); }
		public InputStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterInputStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitInputStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitInputStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputStatementContext inputStatement() throws RecognitionException {
		InputStatementContext _localctx = new InputStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_inputStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(INPUT);
			setState(230);
			idList(0);
			setState(232);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(231);
				match(SEMICOLON);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OutputStatementContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(DijkstraParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(DijkstraParser.SEMICOLON, 0); }
		public OutputStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterOutputStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitOutputStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitOutputStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputStatementContext outputStatement() throws RecognitionException {
		OutputStatementContext _localctx = new OutputStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_outputStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(PRINT);
			setState(235);
			expr(0);
			setState(237);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(236);
				match(SEMICOLON);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IterativeStatementContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(DijkstraParser.DO, 0); }
		public TerminalNode OD() { return getToken(DijkstraParser.OD, 0); }
		public List<GuardContext> guard() {
			return getRuleContexts(GuardContext.class);
		}
		public GuardContext guard(int i) {
			return getRuleContext(GuardContext.class,i);
		}
		public IterativeStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterativeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterIterativeStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitIterativeStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitIterativeStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterativeStatementContext iterativeStatement() throws RecognitionException {
		IterativeStatementContext _localctx = new IterativeStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_iterativeStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(DO);
			setState(241); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(240);
				guard();
				}
				}
				setState(243); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAR) | (1L << MINUS) | (1L << TILDE) | (1L << FALSE) | (1L << TRUE) | (1L << ID) | (1L << INTEGER) | (1L << FLOAT_CONST))) != 0) );
			setState(245);
			match(OD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompoundStatementContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(DijkstraParser.LBRACE, 0); }
		public CompoundBodyContext compoundBody() {
			return getRuleContext(CompoundBodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(DijkstraParser.RBRACE, 0); }
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterCompoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitCompoundStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitCompoundStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_compoundStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(LBRACE);
			setState(248);
			compoundBody();
			setState(249);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlternativeStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(DijkstraParser.IF, 0); }
		public TerminalNode FI() { return getToken(DijkstraParser.FI, 0); }
		public List<GuardContext> guard() {
			return getRuleContexts(GuardContext.class);
		}
		public GuardContext guard(int i) {
			return getRuleContext(GuardContext.class,i);
		}
		public AlternativeStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alternativeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterAlternativeStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitAlternativeStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitAlternativeStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlternativeStatementContext alternativeStatement() throws RecognitionException {
		AlternativeStatementContext _localctx = new AlternativeStatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_alternativeStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(IF);
			setState(253); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(252);
				guard();
				}
				}
				setState(255); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAR) | (1L << MINUS) | (1L << TILDE) | (1L << FALSE) | (1L << TRUE) | (1L << ID) | (1L << INTEGER) | (1L << FLOAT_CONST))) != 0) );
			setState(257);
			match(FI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(DijkstraParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(DijkstraParser.SEMICOLON, 0); }
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(RETURN);
			setState(260);
			expr(0);
			setState(262);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(261);
				match(SEMICOLON);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcedureCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DijkstraParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(DijkstraParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(DijkstraParser.RPAR, 0); }
		public TerminalNode SEMICOLON() { return getToken(DijkstraParser.SEMICOLON, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public ProcedureCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterProcedureCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitProcedureCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitProcedureCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureCallContext procedureCall() throws RecognitionException {
		ProcedureCallContext _localctx = new ProcedureCallContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_procedureCall);
		try {
			setState(277);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				match(ID);
				setState(265);
				match(LPAR);
				setState(266);
				match(RPAR);
				setState(268);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(267);
					match(SEMICOLON);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(270);
				match(ID);
				setState(271);
				match(LPAR);
				setState(272);
				argList(0);
				setState(273);
				match(RPAR);
				setState(275);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(274);
					match(SEMICOLON);
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DijkstraParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(DijkstraParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(DijkstraParser.RPAR, 0); }
		public TerminalNode SEMICOLON() { return getToken(DijkstraParser.SEMICOLON, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_functionCall);
		try {
			setState(292);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				match(ID);
				setState(280);
				match(LPAR);
				setState(281);
				match(RPAR);
				setState(283);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(282);
					match(SEMICOLON);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				match(ID);
				setState(286);
				match(LPAR);
				setState(287);
				argList(0);
				setState(288);
				match(RPAR);
				setState(290);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(289);
					match(SEMICOLON);
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompoundBodyContext extends ParserRuleContext {
		public CompDeclOrStatementContext compDeclOrStatement() {
			return getRuleContext(CompDeclOrStatementContext.class,0);
		}
		public CompoundBodyContext compoundBody() {
			return getRuleContext(CompoundBodyContext.class,0);
		}
		public CompoundBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterCompoundBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitCompoundBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitCompoundBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundBodyContext compoundBody() throws RecognitionException {
		CompoundBodyContext _localctx = new CompoundBodyContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_compoundBody);
		try {
			setState(298);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				compDeclOrStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(295);
				compDeclOrStatement();
				setState(296);
				compoundBody();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompDeclOrStatementContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public ArrayDeclarationContext arrayDeclaration() {
			return getRuleContext(ArrayDeclarationContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public CompDeclOrStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compDeclOrStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterCompDeclOrStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitCompDeclOrStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitCompDeclOrStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompDeclOrStatementContext compDeclOrStatement() throws RecognitionException {
		CompDeclOrStatementContext _localctx = new CompDeclOrStatementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_compDeclOrStatement);
		try {
			setState(303);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(300);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(301);
				arrayDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(302);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayAccessorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DijkstraParser.ID, 0); }
		public TerminalNode LBRACK() { return getToken(DijkstraParser.LBRACK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(DijkstraParser.RBRACK, 0); }
		public ArrayAccessorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccessor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterArrayAccessor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitArrayAccessor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitArrayAccessor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAccessorContext arrayAccessor() throws RecognitionException {
		ArrayAccessorContext _localctx = new ArrayAccessorContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_arrayAccessor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(ID);
			setState(306);
			match(LBRACK);
			setState(307);
			expr(0);
			setState(308);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode TILDE() { return getToken(DijkstraParser.TILDE, 0); }
		public TerminalNode MINUS() { return getToken(DijkstraParser.MINUS, 0); }
		public ArrayAccessorContext arrayAccessor() {
			return getRuleContext(ArrayAccessorContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(DijkstraParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(DijkstraParser.RPAR, 0); }
		public TerminalNode ID() { return getToken(DijkstraParser.ID, 0); }
		public TerminalNode TRUE() { return getToken(DijkstraParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(DijkstraParser.FALSE, 0); }
		public TerminalNode FLOAT_CONST() { return getToken(DijkstraParser.FLOAT_CONST, 0); }
		public TerminalNode INTEGER() { return getToken(DijkstraParser.INTEGER, 0); }
		public TerminalNode STAR() { return getToken(DijkstraParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(DijkstraParser.SLASH, 0); }
		public TerminalNode MOD() { return getToken(DijkstraParser.MOD, 0); }
		public TerminalNode DIV() { return getToken(DijkstraParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(DijkstraParser.PLUS, 0); }
		public TerminalNode LT() { return getToken(DijkstraParser.LT, 0); }
		public TerminalNode GT() { return getToken(DijkstraParser.GT, 0); }
		public TerminalNode GTEQ() { return getToken(DijkstraParser.GTEQ, 0); }
		public TerminalNode LTEQ() { return getToken(DijkstraParser.LTEQ, 0); }
		public TerminalNode EQ() { return getToken(DijkstraParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(DijkstraParser.NEQ, 0); }
		public TerminalNode AMP() { return getToken(DijkstraParser.AMP, 0); }
		public TerminalNode BAR() { return getToken(DijkstraParser.BAR, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DijkstraListener ) ((DijkstraListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DijkstraVisitor ) return ((DijkstraVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(311);
				_la = _input.LA(1);
				if ( !(_la==MINUS || _la==TILDE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(312);
				expr(11);
				}
				break;
			case 2:
				{
				setState(313);
				arrayAccessor();
				}
				break;
			case 3:
				{
				setState(314);
				functionCall();
				}
				break;
			case 4:
				{
				setState(315);
				match(LPAR);
				setState(316);
				expr(0);
				setState(317);
				match(RPAR);
				}
				break;
			case 5:
				{
				setState(319);
				match(ID);
				}
				break;
			case 6:
				{
				setState(320);
				_la = _input.LA(1);
				if ( !(_la==FALSE || _la==TRUE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 7:
				{
				setState(321);
				match(FLOAT_CONST);
				}
				break;
			case 8:
				{
				setState(322);
				match(INTEGER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(345);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(343);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(325);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(326);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SLASH) | (1L << STAR) | (1L << MOD) | (1L << DIV))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(327);
						expr(11);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(328);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(329);
						_la = _input.LA(1);
						if ( !(_la==MINUS || _la==PLUS) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(330);
						expr(10);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(331);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(332);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << GTEQ) | (1L << LTEQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(333);
						expr(9);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(334);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(335);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(336);
						expr(7);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(337);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(338);
						match(AMP);
						setState(339);
						expr(7);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(340);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(341);
						match(BAR);
						setState(342);
						expr(6);
						}
						break;
					}
					} 
				}
				setState(347);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return varList_sempred((VarListContext)_localctx, predIndex);
		case 10:
			return parameterList_sempred((ParameterListContext)_localctx, predIndex);
		case 11:
			return idList_sempred((IdListContext)_localctx, predIndex);
		case 12:
			return expressionList_sempred((ExpressionListContext)_localctx, predIndex);
		case 13:
			return argList_sempred((ArgListContext)_localctx, predIndex);
		case 14:
			return guardedStatementList_sempred((GuardedStatementListContext)_localctx, predIndex);
		case 32:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean varList_sempred(VarListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean parameterList_sempred(ParameterListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean idList_sempred(IdListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expressionList_sempred(ExpressionListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean argList_sempred(ArgListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean guardedStatementList_sempred(GuardedStatementListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 9);
		case 8:
			return precpred(_ctx, 8);
		case 9:
			return precpred(_ctx, 7);
		case 10:
			return precpred(_ctx, 6);
		case 11:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\60\u015f\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\6\3L\n\3\r\3\16\3M\3\4\3\4\3\4"+
		"\3\4\5\4T\n\4\3\5\3\5\3\6\3\6\5\6Z\n\6\3\7\3\7\3\7\3\7\5\7`\n\7\3\b\3"+
		"\b\3\t\5\te\n\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13q\n"+
		"\13\f\13\16\13t\13\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f|\n\f\f\f\16\f\177\13"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0087\n\r\f\r\16\r\u008a\13\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\7\16\u0092\n\16\f\16\16\16\u0095\13\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\7\17\u009d\n\17\f\17\16\17\u00a0\13\17\3\20\3\20"+
		"\3\20\3\20\3\20\7\20\u00a7\n\20\f\20\16\20\u00aa\13\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00b8\n\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\5\22\u00cb\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00e0\n\25\3\26\3\26"+
		"\3\26\3\26\5\26\u00e6\n\26\3\27\3\27\3\27\5\27\u00eb\n\27\3\30\3\30\3"+
		"\30\5\30\u00f0\n\30\3\31\3\31\6\31\u00f4\n\31\r\31\16\31\u00f5\3\31\3"+
		"\31\3\32\3\32\3\32\3\32\3\33\3\33\6\33\u0100\n\33\r\33\16\33\u0101\3\33"+
		"\3\33\3\34\3\34\3\34\5\34\u0109\n\34\3\35\3\35\3\35\3\35\5\35\u010f\n"+
		"\35\3\35\3\35\3\35\3\35\3\35\5\35\u0116\n\35\5\35\u0118\n\35\3\36\3\36"+
		"\3\36\3\36\5\36\u011e\n\36\3\36\3\36\3\36\3\36\3\36\5\36\u0125\n\36\5"+
		"\36\u0127\n\36\3\37\3\37\3\37\3\37\5\37\u012d\n\37\3 \3 \3 \5 \u0132\n"+
		" \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5"+
		"\"\u0146\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\7\"\u015a\n\"\f\"\16\"\u015d\13\"\3\"\2\t\24\26\30\32\34"+
		"\36B#\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>"+
		"@B\2\t\5\2\35\35$$**\4\2\n\n\22\22\4\2\36\36\'\'\4\2\20\21\33\34\4\2\n"+
		"\n\f\f\5\2\5\5\t\t\31\32\4\2\4\4\13\13\u0170\2D\3\2\2\2\4G\3\2\2\2\6S"+
		"\3\2\2\2\bU\3\2\2\2\nY\3\2\2\2\f_\3\2\2\2\16a\3\2\2\2\20d\3\2\2\2\22f"+
		"\3\2\2\2\24j\3\2\2\2\26u\3\2\2\2\30\u0080\3\2\2\2\32\u008b\3\2\2\2\34"+
		"\u0096\3\2\2\2\36\u00a1\3\2\2\2 \u00b7\3\2\2\2\"\u00ca\3\2\2\2$\u00cc"+
		"\3\2\2\2&\u00d3\3\2\2\2(\u00df\3\2\2\2*\u00e1\3\2\2\2,\u00e7\3\2\2\2."+
		"\u00ec\3\2\2\2\60\u00f1\3\2\2\2\62\u00f9\3\2\2\2\64\u00fd\3\2\2\2\66\u0105"+
		"\3\2\2\28\u0117\3\2\2\2:\u0126\3\2\2\2<\u012c\3\2\2\2>\u0131\3\2\2\2@"+
		"\u0133\3\2\2\2B\u0145\3\2\2\2DE\5\4\3\2EF\7\2\2\3F\3\3\2\2\2GH\7&\2\2"+
		"HK\7,\2\2IL\5\6\4\2JL\5(\25\2KI\3\2\2\2KJ\3\2\2\2LM\3\2\2\2MK\3\2\2\2"+
		"MN\3\2\2\2N\5\3\2\2\2OT\5&\24\2PT\5$\23\2QT\5 \21\2RT\5\"\22\2SO\3\2\2"+
		"\2SP\3\2\2\2SQ\3\2\2\2SR\3\2\2\2T\7\3\2\2\2UV\t\2\2\2V\t\3\2\2\2WZ\7,"+
		"\2\2XZ\5@!\2YW\3\2\2\2YX\3\2\2\2Z\13\3\2\2\2[`\7,\2\2\\]\5\b\5\2]^\7,"+
		"\2\2^`\3\2\2\2_[\3\2\2\2_\\\3\2\2\2`\r\3\2\2\2ab\5B\"\2b\17\3\2\2\2ce"+
		"\7\17\2\2dc\3\2\2\2de\3\2\2\2e\21\3\2\2\2fg\5B\"\2gh\7\6\2\2hi\5(\25\2"+
		"i\23\3\2\2\2jk\b\13\1\2kl\5\n\6\2lr\3\2\2\2mn\f\3\2\2no\7\26\2\2oq\5\n"+
		"\6\2pm\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2s\25\3\2\2\2tr\3\2\2\2uv\b"+
		"\f\1\2vw\5\f\7\2w}\3\2\2\2xy\f\3\2\2yz\7\26\2\2z|\5\f\7\2{x\3\2\2\2|\177"+
		"\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\27\3\2\2\2\177}\3\2\2\2\u0080\u0081\b\r"+
		"\1\2\u0081\u0082\7,\2\2\u0082\u0088\3\2\2\2\u0083\u0084\f\3\2\2\u0084"+
		"\u0085\7\26\2\2\u0085\u0087\7,\2\2\u0086\u0083\3\2\2\2\u0087\u008a\3\2"+
		"\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\31\3\2\2\2\u008a\u0088"+
		"\3\2\2\2\u008b\u008c\b\16\1\2\u008c\u008d\5B\"\2\u008d\u0093\3\2\2\2\u008e"+
		"\u008f\f\3\2\2\u008f\u0090\7\26\2\2\u0090\u0092\5B\"\2\u0091\u008e\3\2"+
		"\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\33\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\b\17\1\2\u0097\u0098\5\16"+
		"\b\2\u0098\u009e\3\2\2\2\u0099\u009a\f\3\2\2\u009a\u009b\7\26\2\2\u009b"+
		"\u009d\5\16\b\2\u009c\u0099\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3"+
		"\2\2\2\u009e\u009f\3\2\2\2\u009f\35\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1"+
		"\u00a2\b\20\1\2\u00a2\u00a3\5\22\n\2\u00a3\u00a8\3\2\2\2\u00a4\u00a5\f"+
		"\3\2\2\u00a5\u00a7\5\22\n\2\u00a6\u00a4\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\37\3\2\2\2\u00aa\u00a8\3\2\2"+
		"\2\u00ab\u00ac\7)\2\2\u00ac\u00ad\7,\2\2\u00ad\u00ae\7\b\2\2\u00ae\u00af"+
		"\7\16\2\2\u00af\u00b8\5\62\32\2\u00b0\u00b1\7)\2\2\u00b1\u00b2\7,\2\2"+
		"\u00b2\u00b3\7\b\2\2\u00b3\u00b4\5\26\f\2\u00b4\u00b5\7\16\2\2\u00b5\u00b6"+
		"\5\62\32\2\u00b6\u00b8\3\2\2\2\u00b7\u00ab\3\2\2\2\u00b7\u00b0\3\2\2\2"+
		"\u00b8!\3\2\2\2\u00b9\u00ba\7(\2\2\u00ba\u00bb\7,\2\2\u00bb\u00bc\7\b"+
		"\2\2\u00bc\u00bd\7\16\2\2\u00bd\u00be\7\25\2\2\u00be\u00bf\5\b\5\2\u00bf"+
		"\u00c0\5\62\32\2\u00c0\u00cb\3\2\2\2\u00c1\u00c2\7(\2\2\u00c2\u00c3\7"+
		",\2\2\u00c3\u00c4\7\b\2\2\u00c4\u00c5\5\26\f\2\u00c5\u00c6\7\16\2\2\u00c6"+
		"\u00c7\7\25\2\2\u00c7\u00c8\5\b\5\2\u00c8\u00c9\5\62\32\2\u00c9\u00cb"+
		"\3\2\2\2\u00ca\u00b9\3\2\2\2\u00ca\u00c1\3\2\2\2\u00cb#\3\2\2\2\u00cc"+
		"\u00cd\5\b\5\2\u00cd\u00ce\7\23\2\2\u00ce\u00cf\5B\"\2\u00cf\u00d0\7\24"+
		"\2\2\u00d0\u00d1\5\30\r\2\u00d1\u00d2\5\20\t\2\u00d2%\3\2\2\2\u00d3\u00d4"+
		"\5\b\5\2\u00d4\u00d5\5\30\r\2\u00d5\u00d6\5\20\t\2\u00d6\'\3\2\2\2\u00d7"+
		"\u00e0\5*\26\2\u00d8\u00e0\5,\27\2\u00d9\u00e0\5.\30\2\u00da\u00e0\5\60"+
		"\31\2\u00db\u00e0\5\62\32\2\u00dc\u00e0\5\64\33\2\u00dd\u00e0\5\66\34"+
		"\2\u00de\u00e0\58\35\2\u00df\u00d7\3\2\2\2\u00df\u00d8\3\2\2\2\u00df\u00d9"+
		"\3\2\2\2\u00df\u00da\3\2\2\2\u00df\u00db\3\2\2\2\u00df\u00dc\3\2\2\2\u00df"+
		"\u00dd\3\2\2\2\u00df\u00de\3\2\2\2\u00e0)\3\2\2\2\u00e1\u00e2\5\24\13"+
		"\2\u00e2\u00e3\7\3\2\2\u00e3\u00e5\5\32\16\2\u00e4\u00e6\7\17\2\2\u00e5"+
		"\u00e4\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6+\3\2\2\2\u00e7\u00e8\7#\2\2\u00e8"+
		"\u00ea\5\30\r\2\u00e9\u00eb\7\17\2\2\u00ea\u00e9\3\2\2\2\u00ea\u00eb\3"+
		"\2\2\2\u00eb-\3\2\2\2\u00ec\u00ed\7%\2\2\u00ed\u00ef\5B\"\2\u00ee\u00f0"+
		"\7\17\2\2\u00ef\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0/\3\2\2\2\u00f1"+
		"\u00f3\7!\2\2\u00f2\u00f4\5\22\n\2\u00f3\u00f2\3\2\2\2\u00f4\u00f5\3\2"+
		"\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7"+
		"\u00f8\7\"\2\2\u00f8\61\3\2\2\2\u00f9\u00fa\7\7\2\2\u00fa\u00fb\5<\37"+
		"\2\u00fb\u00fc\7\r\2\2\u00fc\63\3\2\2\2\u00fd\u00ff\7 \2\2\u00fe\u0100"+
		"\5\22\n\2\u00ff\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u00ff\3\2\2\2"+
		"\u0101\u0102\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\7\37\2\2\u0104\65"+
		"\3\2\2\2\u0105\u0106\7+\2\2\u0106\u0108\5B\"\2\u0107\u0109\7\17\2\2\u0108"+
		"\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109\67\3\2\2\2\u010a\u010b\7,\2\2"+
		"\u010b\u010c\7\b\2\2\u010c\u010e\7\16\2\2\u010d\u010f\7\17\2\2\u010e\u010d"+
		"\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0118\3\2\2\2\u0110\u0111\7,\2\2\u0111"+
		"\u0112\7\b\2\2\u0112\u0113\5\34\17\2\u0113\u0115\7\16\2\2\u0114\u0116"+
		"\7\17\2\2\u0115\u0114\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0118\3\2\2\2"+
		"\u0117\u010a\3\2\2\2\u0117\u0110\3\2\2\2\u01189\3\2\2\2\u0119\u011a\7"+
		",\2\2\u011a\u011b\7\b\2\2\u011b\u011d\7\16\2\2\u011c\u011e\7\17\2\2\u011d"+
		"\u011c\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0127\3\2\2\2\u011f\u0120\7,"+
		"\2\2\u0120\u0121\7\b\2\2\u0121\u0122\5\34\17\2\u0122\u0124\7\16\2\2\u0123"+
		"\u0125\7\17\2\2\u0124\u0123\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0127\3"+
		"\2\2\2\u0126\u0119\3\2\2\2\u0126\u011f\3\2\2\2\u0127;\3\2\2\2\u0128\u012d"+
		"\5> \2\u0129\u012a\5> \2\u012a\u012b\5<\37\2\u012b\u012d\3\2\2\2\u012c"+
		"\u0128\3\2\2\2\u012c\u0129\3\2\2\2\u012d=\3\2\2\2\u012e\u0132\5&\24\2"+
		"\u012f\u0132\5$\23\2\u0130\u0132\5(\25\2\u0131\u012e\3\2\2\2\u0131\u012f"+
		"\3\2\2\2\u0131\u0130\3\2\2\2\u0132?\3\2\2\2\u0133\u0134\7,\2\2\u0134\u0135"+
		"\7\23\2\2\u0135\u0136\5B\"\2\u0136\u0137\7\24\2\2\u0137A\3\2\2\2\u0138"+
		"\u0139\b\"\1\2\u0139\u013a\t\3\2\2\u013a\u0146\5B\"\r\u013b\u0146\5@!"+
		"\2\u013c\u0146\5:\36\2\u013d\u013e\7\b\2\2\u013e\u013f\5B\"\2\u013f\u0140"+
		"\7\16\2\2\u0140\u0146\3\2\2\2\u0141\u0146\7,\2\2\u0142\u0146\t\4\2\2\u0143"+
		"\u0146\7.\2\2\u0144\u0146\7-\2\2\u0145\u0138\3\2\2\2\u0145\u013b\3\2\2"+
		"\2\u0145\u013c\3\2\2\2\u0145\u013d\3\2\2\2\u0145\u0141\3\2\2\2\u0145\u0142"+
		"\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0144\3\2\2\2\u0146\u015b\3\2\2\2\u0147"+
		"\u0148\f\f\2\2\u0148\u0149\t\5\2\2\u0149\u015a\5B\"\r\u014a\u014b\f\13"+
		"\2\2\u014b\u014c\t\6\2\2\u014c\u015a\5B\"\f\u014d\u014e\f\n\2\2\u014e"+
		"\u014f\t\7\2\2\u014f\u015a\5B\"\13\u0150\u0151\f\t\2\2\u0151\u0152\t\b"+
		"\2\2\u0152\u015a\5B\"\t\u0153\u0154\f\b\2\2\u0154\u0155\7\27\2\2\u0155"+
		"\u015a\5B\"\t\u0156\u0157\f\7\2\2\u0157\u0158\7\30\2\2\u0158\u015a\5B"+
		"\"\b\u0159\u0147\3\2\2\2\u0159\u014a\3\2\2\2\u0159\u014d\3\2\2\2\u0159"+
		"\u0150\3\2\2\2\u0159\u0153\3\2\2\2\u0159\u0156\3\2\2\2\u015a\u015d\3\2"+
		"\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015cC\3\2\2\2\u015d\u015b"+
		"\3\2\2\2\"KMSY_dr}\u0088\u0093\u009e\u00a8\u00b7\u00ca\u00df\u00e5\u00ea"+
		"\u00ef\u00f5\u0101\u0108\u010e\u0115\u0117\u011d\u0124\u0126\u012c\u0131"+
		"\u0145\u0159\u015b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}