// Generated from Isilang.g4 by ANTLR 4.7.1
package com.gabriel.parser;

    import com.gabriel.datastructure.Symbol;
    import com.gabriel.datastructure.Variable;
    import com.gabriel.datastructure.SymbolTable;
    import com.gabriel.exceptions.SemanticException;
    import com.gabriel.ast.Program;
    import com.gabriel.ast.Command;
    import com.gabriel.ast.LeituraCommand;
    import com.gabriel.ast.EscritaCommand;
    import com.gabriel.ast.AtribuicaoCommand;
    import com.gabriel.ast.DecisaoCommand;
    import com.gabriel.ast.RepeticaoCommand;
    import java.util.ArrayList;
    import java.util.Stack;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsilangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		AP=10, FP=11, SC=12, OP=13, ATTR=14, VIR=15, ACH=16, FCH=17, OPREL=18, 
		ID=19, NUMBER=20, STRING=21, WS=22;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdattrib = 8, 
		RULE_cmdrepeticao = 9, RULE_cmdselecao = 10, RULE_expr = 11, RULE_termo = 12;
	public static final String[] ruleNames = {
		"prog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", 
		"cmdattrib", "cmdrepeticao", "cmdselecao", "expr", "termo"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog;'", "'numero'", "'texto'", "'leia'", "'escreva'", 
		"'enquanto'", "'se'", "'senao'", "'('", "')'", "';'", null, "'='", "','", 
		"'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "AP", "FP", 
		"SC", "OP", "ATTR", "VIR", "ACH", "FCH", "OPREL", "ID", "NUMBER", "STRING", 
		"WS"
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
	public String getGrammarFileName() { return "Isilang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private int _tipo;
	    private String _varName;
	    private String _varValue;
	    private SymbolTable table = new SymbolTable();
	    private Symbol symbol;
	    private Program program = new Program();
	    private ArrayList<Command> curThread;
	    private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();
	    private String _readID;
	    private String _writeID;
	    private String _exprID;
	    private String _exprContent;
	    private String _exprDecision;
	    private String _whileDecision;

	    private ArrayList<Command> listaTrue;
	    private ArrayList<Command> listaFalse;
	    private ArrayList<Command> listaWhile;

	    private ArrayList<Variable> listaSymbolAttr = new ArrayList<Variable>();
	    private String leftID;
	    private String rigthID;

	    public void verificaID(String id) {
	    if (!table.exists(id))
	        throw new SemanticException("Symbol "+ id + " not declared");
	    }
	    public void exibeComandos() {
	        for (Command c : program.getComandos()) {
	            System.out.println(c);
	        }
	    }
	    public void generateCode() {
	        program.generateTarget();
	    }
	 
	public IsilangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(T__0);
			setState(27);
			decl();
			setState(28);
			bloco();
			setState(29);
			match(T__1);

			                program.setVartable(table);
			                program.setComandos(stack.pop());
			              
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

	public static class DeclContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				declaravar();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 || _la==T__3 );
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

	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(IsilangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsilangParser.ID, i);
		}
		public TerminalNode SC() { return getToken(IsilangParser.SC, 0); }
		public List<TerminalNode> VIR() { return getTokens(IsilangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(IsilangParser.VIR, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			tipo();
			setState(38);
			match(ID);

			                    _varName = _input.LT(-1).getText();
			                    _varValue = null;
			                    symbol = new Variable(_varName, _tipo, _varValue);
			                    if(!table.exists(_varName)) {
			                         table.add(symbol);
			                    } else {
			                        throw new SemanticException("Symbol "+_varName+" already declared");
			                    }
			                    
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(40);
				match(VIR);
				setState(41);
				match(ID);

				                                                  _varName = _input.LT(-1).getText();
				                                                  _varValue = null;
				                                                  symbol = new Variable(_varName, _tipo, _varValue);
				                                                  if(!table.exists(_varName)) {
				                                                       table.add(symbol);
				                                                  } else {
				                                                      throw new SemanticException("Symbol "+_varName+" already declared");
				                                                  }
				                                                
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
			match(SC);
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

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(T__2);
				 _tipo = Variable.NUMBER; 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				match(T__3);
				 _tipo = Variable.TEXT; 
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

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 curThread = new ArrayList<Command>();
			               stack.push(curThread);

			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
				cmd();
				}
				}
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << ID))) != 0) );
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

	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmdselecaoContext cmdselecao() {
			return getRuleContext(CmdselecaoContext.class,0);
		}
		public CmdrepeticaoContext cmdrepeticao() {
			return getRuleContext(CmdrepeticaoContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				cmdleitura();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				cmdattrib();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				cmdselecao();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 5);
				{
				setState(66);
				cmdrepeticao();
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

	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsilangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsilangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsilangParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsilangParser.SC, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__4);
			setState(70);
			match(AP);
			setState(71);
			match(ID);

			                            verificaID(_input.LT(-1).getText());
			                            _readID = _input.LT(-1).getText();
			                            
			setState(73);
			match(FP);
			setState(74);
			match(SC);

			                            Variable var = (Variable) table.get(_readID);
			                            LeituraCommand cmd = new LeituraCommand(_readID, var);
			                            stack.peek().add(cmd);
			                            
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

	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsilangParser.AP, 0); }
		public TerminalNode FP() { return getToken(IsilangParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsilangParser.SC, 0); }
		public TerminalNode ID() { return getToken(IsilangParser.ID, 0); }
		public TerminalNode STRING() { return getToken(IsilangParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(IsilangParser.NUMBER, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__5);
			setState(78);
			match(AP);
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(79);
				match(ID);

				                                verificaID(_input.LT(-1).getText());
				                                _writeID = _input.LT(-1).getText();
				                                
				}
				break;
			case STRING:
				{
				setState(81);
				match(STRING);
				  _writeID = _input.LT(-1).getText(); 
				}
				break;
			case NUMBER:
				{
				setState(83);
				match(NUMBER);
				  _writeID = _input.LT(-1).getText(); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(87);
			match(FP);
			setState(88);
			match(SC);

			                                EscritaCommand cmd = new EscritaCommand(_writeID);
			                                stack.peek().add(cmd);
			                                                        
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

	public static class CmdattribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsilangParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(IsilangParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(IsilangParser.SC, 0); }
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).enterCmdattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).exitCmdattrib(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(ID);

			                verificaID(_input.LT(-1).getText());
			                _exprID = _input.LT(-1).getText();
			                leftID = _input.LT(-1).getText();
			                
			setState(93);
			match(ATTR);
			 _exprContent = ""; 
			setState(95);
			expr();
			setState(96);
			match(SC);

			                    AtribuicaoCommand cmd = new AtribuicaoCommand(_exprID, _exprContent, (Variable) table.get(leftID), listaSymbolAttr);
			                    stack.peek().add(cmd);
			                
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

	public static class CmdrepeticaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsilangParser.AP, 0); }
		public TerminalNode OPREL() { return getToken(IsilangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsilangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsilangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsilangParser.FCH, 0); }
		public List<TerminalNode> ID() { return getTokens(IsilangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsilangParser.ID, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(IsilangParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(IsilangParser.NUMBER, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdrepeticaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdrepeticao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).enterCmdrepeticao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).exitCmdrepeticao(this);
		}
	}

	public final CmdrepeticaoContext cmdrepeticao() throws RecognitionException {
		CmdrepeticaoContext _localctx = new CmdrepeticaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdrepeticao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__6);
			setState(100);
			match(AP);
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(101);
				match(ID);

				                                verificaID(_input.LT(-1).getText());
				                                leftID = _input.LT(-1).getText();

				}
				break;
			case NUMBER:
				{
				setState(103);
				match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 _whileDecision = _input.LT(-1).getText(); 
			setState(107);
			match(OPREL);
			 _whileDecision += _input.LT(-1).getText(); 
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(109);
				match(ID);

				                                  verificaID(_input.LT(-1).getText());
				                                  rigthID = _input.LT(-1).getText();
				                             
				}
				break;
			case NUMBER:
				{
				setState(111);
				match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 _whileDecision += _input.LT(-1).getText();
			                                            
			setState(115);
			match(FP);
			setState(116);
			match(ACH);

			                                curThread = new ArrayList<Command>();
			                                stack.push(curThread);
			                                
			setState(119); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(118);
				cmd();
				}
				}
				setState(121); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << ID))) != 0) );
			setState(123);
			match(FCH);

			                                  listaWhile = stack.pop();
			                                  RepeticaoCommand cmd = new RepeticaoCommand(_whileDecision, listaWhile,(Variable) table.get(leftID), (Variable) table.get(rigthID));
			                                  stack.peek().add(cmd);
			                                
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

	public static class CmdselecaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsilangParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(IsilangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsilangParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(IsilangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsilangParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(IsilangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(IsilangParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(IsilangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(IsilangParser.FCH, i);
		}
		public TerminalNode NUMBER() { return getToken(IsilangParser.NUMBER, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdselecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdselecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).enterCmdselecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).exitCmdselecao(this);
		}
	}

	public final CmdselecaoContext cmdselecao() throws RecognitionException {
		CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__7);
			setState(127);
			match(AP);
			setState(128);
			match(ID);

			                            verificaID(_input.LT(-1).getText());
			                            _exprDecision = _input.LT(-1).getText();
			                            leftID = _exprDecision;
			                    
			setState(130);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText();
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(132);
				match(ID);

				                         verificaID(_input.LT(-1).getText());
				                         rigthID = _input.LT(-1).getText();
				                     
				}
				break;
			case NUMBER:
				{
				setState(134);
				match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 _exprDecision += _input.LT(-1).getText();
			                                    
			setState(138);
			match(FP);
			setState(139);
			match(ACH);
			 curThread = new ArrayList<Command>();
			                          stack.push(curThread);  
			setState(142); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(141);
				cmd();
				}
				}
				setState(144); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << ID))) != 0) );
			setState(146);
			match(FCH);

			                        listaTrue = stack.pop();
			                    
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(148);
				match(T__8);
				setState(149);
				match(ACH);
				 curThread = new ArrayList<Command>();
				                                  stack.push(curThread);  
				{
				setState(152); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(151);
					cmd();
					}
					}
					setState(154); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << ID))) != 0) );
				}
				setState(156);
				match(FCH);

				                                       listaFalse = stack.pop();

				                                
				}
			}


			                                    DecisaoCommand cmd = new DecisaoCommand(_exprDecision, listaTrue, listaFalse, (Variable) table.get(leftID), (Variable) table.get(rigthID));
			                                    stack.peek().add(cmd);
			                                
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
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(IsilangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(IsilangParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			termo();
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(164);
				match(OP);
				 _exprContent += _input.LT(-1).getText(); 
				setState(166);
				termo();
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsilangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(IsilangParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(IsilangParser.STRING, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilangListener ) ((IsilangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_termo);
		try {
			setState(177);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				match(ID);
				 verificaID(_input.LT(-1).getText());
				                    _exprContent += _input.LT(-1).getText();
				                    listaSymbolAttr.add((Variable) table.get(_input.LT(-1).getText()));
				                
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(NUMBER);

				                    _exprContent += _input.LT(-1).getText();
				                
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(176);
				match(STRING);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u00b6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\3\6\3$\n\3\r"+
		"\3\16\3%\3\4\3\4\3\4\3\4\3\4\3\4\7\4.\n\4\f\4\16\4\61\13\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\5\59\n\5\3\6\3\6\6\6=\n\6\r\6\16\6>\3\7\3\7\3\7\3\7\3\7\5"+
		"\7F\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\5\tX\n\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\5\13k\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13s\n\13\3"+
		"\13\3\13\3\13\3\13\3\13\6\13z\n\13\r\13\16\13{\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u008a\n\f\3\f\3\f\3\f\3\f\3\f\6\f\u0091"+
		"\n\f\r\f\16\f\u0092\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u009b\n\f\r\f\16\f\u009c"+
		"\3\f\3\f\3\f\5\f\u00a2\n\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u00aa\n\r\f\r\16"+
		"\r\u00ad\13\r\3\16\3\16\3\16\3\16\3\16\5\16\u00b4\n\16\3\16\2\2\17\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\2\2\2\u00bc\2\34\3\2\2\2\4#\3\2\2\2\6\'"+
		"\3\2\2\2\b8\3\2\2\2\n:\3\2\2\2\fE\3\2\2\2\16G\3\2\2\2\20O\3\2\2\2\22]"+
		"\3\2\2\2\24e\3\2\2\2\26\u0080\3\2\2\2\30\u00a5\3\2\2\2\32\u00b3\3\2\2"+
		"\2\34\35\7\3\2\2\35\36\5\4\3\2\36\37\5\n\6\2\37 \7\4\2\2 !\b\2\1\2!\3"+
		"\3\2\2\2\"$\5\6\4\2#\"\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\5\3\2\2"+
		"\2\'(\5\b\5\2()\7\25\2\2)/\b\4\1\2*+\7\21\2\2+,\7\25\2\2,.\b\4\1\2-*\3"+
		"\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2\62"+
		"\63\7\16\2\2\63\7\3\2\2\2\64\65\7\5\2\2\659\b\5\1\2\66\67\7\6\2\2\679"+
		"\b\5\1\28\64\3\2\2\28\66\3\2\2\29\t\3\2\2\2:<\b\6\1\2;=\5\f\7\2<;\3\2"+
		"\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?\13\3\2\2\2@F\5\16\b\2AF\5\20\t\2B"+
		"F\5\22\n\2CF\5\26\f\2DF\5\24\13\2E@\3\2\2\2EA\3\2\2\2EB\3\2\2\2EC\3\2"+
		"\2\2ED\3\2\2\2F\r\3\2\2\2GH\7\7\2\2HI\7\f\2\2IJ\7\25\2\2JK\b\b\1\2KL\7"+
		"\r\2\2LM\7\16\2\2MN\b\b\1\2N\17\3\2\2\2OP\7\b\2\2PW\7\f\2\2QR\7\25\2\2"+
		"RX\b\t\1\2ST\7\27\2\2TX\b\t\1\2UV\7\26\2\2VX\b\t\1\2WQ\3\2\2\2WS\3\2\2"+
		"\2WU\3\2\2\2XY\3\2\2\2YZ\7\r\2\2Z[\7\16\2\2[\\\b\t\1\2\\\21\3\2\2\2]^"+
		"\7\25\2\2^_\b\n\1\2_`\7\20\2\2`a\b\n\1\2ab\5\30\r\2bc\7\16\2\2cd\b\n\1"+
		"\2d\23\3\2\2\2ef\7\t\2\2fj\7\f\2\2gh\7\25\2\2hk\b\13\1\2ik\7\26\2\2jg"+
		"\3\2\2\2ji\3\2\2\2kl\3\2\2\2lm\b\13\1\2mn\7\24\2\2nr\b\13\1\2op\7\25\2"+
		"\2ps\b\13\1\2qs\7\26\2\2ro\3\2\2\2rq\3\2\2\2st\3\2\2\2tu\b\13\1\2uv\7"+
		"\r\2\2vw\7\22\2\2wy\b\13\1\2xz\5\f\7\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2\2{"+
		"|\3\2\2\2|}\3\2\2\2}~\7\23\2\2~\177\b\13\1\2\177\25\3\2\2\2\u0080\u0081"+
		"\7\n\2\2\u0081\u0082\7\f\2\2\u0082\u0083\7\25\2\2\u0083\u0084\b\f\1\2"+
		"\u0084\u0085\7\24\2\2\u0085\u0089\b\f\1\2\u0086\u0087\7\25\2\2\u0087\u008a"+
		"\b\f\1\2\u0088\u008a\7\26\2\2\u0089\u0086\3\2\2\2\u0089\u0088\3\2\2\2"+
		"\u008a\u008b\3\2\2\2\u008b\u008c\b\f\1\2\u008c\u008d\7\r\2\2\u008d\u008e"+
		"\7\22\2\2\u008e\u0090\b\f\1\2\u008f\u0091\5\f\7\2\u0090\u008f\3\2\2\2"+
		"\u0091\u0092\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094"+
		"\3\2\2\2\u0094\u0095\7\23\2\2\u0095\u00a1\b\f\1\2\u0096\u0097\7\13\2\2"+
		"\u0097\u0098\7\22\2\2\u0098\u009a\b\f\1\2\u0099\u009b\5\f\7\2\u009a\u0099"+
		"\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u009f\7\23\2\2\u009f\u00a0\b\f\1\2\u00a0\u00a2\3"+
		"\2\2\2\u00a1\u0096\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00a4\b\f\1\2\u00a4\27\3\2\2\2\u00a5\u00ab\5\32\16\2\u00a6\u00a7\7\17"+
		"\2\2\u00a7\u00a8\b\r\1\2\u00a8\u00aa\5\32\16\2\u00a9\u00a6\3\2\2\2\u00aa"+
		"\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\31\3\2\2"+
		"\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\7\25\2\2\u00af\u00b4\b\16\1\2\u00b0"+
		"\u00b1\7\26\2\2\u00b1\u00b4\b\16\1\2\u00b2\u00b4\7\27\2\2\u00b3\u00ae"+
		"\3\2\2\2\u00b3\u00b0\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\33\3\2\2\2\21%"+
		"/8>EWjr{\u0089\u0092\u009c\u00a1\u00ab\u00b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}