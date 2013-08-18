package com.sanyu.japanesegrammar.util;

public final class SqlConstants {

	public static final int DATABASE_VERSION = 3;

	public static final String DATABASE_NAME = "Grammar.DB3";

	public static final String createGrammarTable = "CREATE TABLE IF NOT EXISTS grammar (GRAMMAR_SEQ INTEGER PRIMARY KEY AUTOINCREMENT, GRAMMAR_TITLE, CONJUNCTION, USAGE1, USAGE2, USAGE3, USAGE4, TRANSLATION1, TRANSLATION2, TRANSLATION3, TRANSLATION4, EXAMPLE1, EXAMPLE2, EXAMPLE3, EXAMPLE4, EX_TRANS1, EX_TRANS2, EX_TRANS3, EX_TRANS4);";

	public static final String createFavoriteTable = "CREATE TABLE IF NOT EXISTS favorite (FAVORITES_SEQ INTEGER PRIMARY KEY AUTOINCREMENT, GRAMMAR_SEQ INTEGER, GRAMMAR_TITLE);";

	public static final String insertGrammar = "INSERT INTO grammar VALUES(null, '~あまり', '俊壓仝兆簡+の々議侘塀朔中賜試喘簡銭悶侘岻朔', '念�釀亞�需仝耙しい々、仝耙しさ々、仝丑しい々、仝丑しみ々吉揮嗤伉尖來議簡囂。念�郢醵担糞鎚洩�匯違聞喘�嶬敲隠�匆嗤富楚狛肇扮議秤趨竃�屐�', '', '', '', '狛業´´議潤惚、咀狛噐´´遇´´', '', '', '', '浪び�┐茲蹐海孱�のあまり、蕗�┐海┌�をあげた。', '', '', '', '咀葎狛噐互佶遇散柵', '', '', '');";

	public static final String fetchGrammarTitle = "SELECT GRAMMAR_SEQ, GRAMMAR_TITLE FROM grammar;";
	
	public static final String fetchGrammarNo = "SELECT COUNT(*) as count FROM grammar;";

	public static final String fetchGrammarFavoritesNo = "SELECT COUNT(*) as count FROM favorite;";

	public static final String fetchGrammarDetail = "SELECT * FROM grammar WHERE GRAMMAR_SEQ = ?;";

	public static final String addFavorite = "";

	public static final String cancelFavorite = "";

	public static final String fetchFavorite = "";

}
