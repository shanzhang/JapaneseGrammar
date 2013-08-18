package com.sanyu.japanesegrammar.util;

public final class SqlConstants {

	public static final int DATABASE_VERSION = 3;

	public static final String DATABASE_NAME = "Grammar.DB3";

	public static final String createGrammarTable = "CREATE TABLE IF NOT EXISTS grammar (GRAMMAR_SEQ INTEGER PRIMARY KEY AUTOINCREMENT, GRAMMAR_TITLE, CONJUNCTION, USAGE1, USAGE2, USAGE3, USAGE4, TRANSLATION1, TRANSLATION2, TRANSLATION3, TRANSLATION4, EXAMPLE1, EXAMPLE2, EXAMPLE3, EXAMPLE4, EX_TRANS1, EX_TRANS2, EX_TRANS3, EX_TRANS4);";

	public static final String createFavoriteTable = "CREATE TABLE IF NOT EXISTS favorite (FAVORITES_SEQ INTEGER PRIMARY KEY AUTOINCREMENT, GRAMMAR_SEQ INTEGER, GRAMMAR_TITLE);";

	public static final String insertGrammar = "INSERT INTO grammar VALUES(null, '~あまり', '接在「名词+の」的形式后面或活用词连体形之后', '前项中常见「嬉しい」、「嬉しさ」、「悲しい」、「悲しみ」等带有心理性的词语。前项活用词的时态一般使用现在时，也有少量过去时的情况出现。', '', '', '', '过度……的结果、因过于……而……', '', '', '', '喜び（よろこぶ）のあまり、声（こえ）をあげた。', '', '', '', '因为过于高兴而欢呼', '', '', '');";

	public static final String fetchGrammarTitle = "SELECT GRAMMAR_SEQ, GRAMMAR_TITLE FROM grammar;";
	
	public static final String fetchGrammarNo = "SELECT COUNT(*) as count FROM grammar;";

	public static final String fetchGrammarFavoritesNo = "SELECT COUNT(*) as count FROM favorite;";

	public static final String fetchGrammarDetail = "SELECT * FROM grammar WHERE GRAMMAR_SEQ = ?;";

	public static final String addFavorite = "";

	public static final String cancelFavorite = "";

	public static final String fetchFavorite = "";

}
