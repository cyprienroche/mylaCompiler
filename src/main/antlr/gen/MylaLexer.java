// Generated from /Users/cyprienroche/projects/mylaCompiler/src/main/antlr/MylaLexer.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MylaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEMICOLON=1, NAT=2, WHITESPACE=3, NEG=4, IDENT=5, MUL=6, DIV=7, MOD=8, 
		ADD=9, OPENPAR=10, CLOSEPAR=11, ASSIGN=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SEMICOLON", "NAT", "DIGIT", "WHITESPACE", "NEG", "IDENT", "MUL", "DIV", 
			"MOD", "ADD", "OPENPAR", "CLOSEPAR", "ASSIGN"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", null, null, "'-'", null, "'*'", "'/'", "'%'", "'+'", "'('", 
			"')'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SEMICOLON", "NAT", "WHITESPACE", "NEG", "IDENT", "MUL", "DIV", 
			"MOD", "ADD", "OPENPAR", "CLOSEPAR", "ASSIGN"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public MylaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MylaLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16A\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\6\3!\n\3\r\3\16\3\"\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\7\7/\n\7\f\7\16\7\62\13\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\2\2\17\3\3\5\4\7\2\t"+
		"\5\13\6\r\7\17\b\21\t\23\n\25\13\27\f\31\r\33\16\3\2\6\3\2\62;\5\2\13"+
		"\f\16\17\"\"\5\2C\\aac|\6\2\62;C\\aac|\2A\2\3\3\2\2\2\2\5\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5"+
		" \3\2\2\2\7$\3\2\2\2\t&\3\2\2\2\13*\3\2\2\2\r,\3\2\2\2\17\63\3\2\2\2\21"+
		"\65\3\2\2\2\23\67\3\2\2\2\259\3\2\2\2\27;\3\2\2\2\31=\3\2\2\2\33?\3\2"+
		"\2\2\35\36\7=\2\2\36\4\3\2\2\2\37!\5\7\4\2 \37\3\2\2\2!\"\3\2\2\2\" \3"+
		"\2\2\2\"#\3\2\2\2#\6\3\2\2\2$%\t\2\2\2%\b\3\2\2\2&\'\t\3\2\2\'(\3\2\2"+
		"\2()\b\5\2\2)\n\3\2\2\2*+\7/\2\2+\f\3\2\2\2,\60\t\4\2\2-/\t\5\2\2.-\3"+
		"\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\16\3\2\2\2\62\60\3\2\2"+
		"\2\63\64\7,\2\2\64\20\3\2\2\2\65\66\7\61\2\2\66\22\3\2\2\2\678\7\'\2\2"+
		"8\24\3\2\2\29:\7-\2\2:\26\3\2\2\2;<\7*\2\2<\30\3\2\2\2=>\7+\2\2>\32\3"+
		"\2\2\2?@\7?\2\2@\34\3\2\2\2\5\2\"\60\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}