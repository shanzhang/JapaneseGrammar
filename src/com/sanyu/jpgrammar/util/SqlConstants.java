package com.sanyu.jpgrammar.util;

public final class SqlConstants {

	public static final int DATABASE_VERSION = 3;

	public static final String DATABASE_NAME = "Grammar.DB3";

	public static final String getN1GramTitlePrepend = "SELECT GRAM_SEQ, TITLE FROM gram_dtl_n1 limit ";

	public static final String getN1GramTitleTail = ", 50;";

	public static final String getN2GramTitlePrepend = "SELECT GRAM_SEQ, TITLE FROM gram_dtl_n2 limit ";

	public static final String getN2GramTitleTail = ", 50;";

	public static final String getN1FavGramTitlePrepend = "SELECT GRAM_SEQ, TITLE FROM fav_gram WHERE N_LVL=1 limit ";

	public static final String getN1FavGramTitleTail = ", 50;";

	public static final String getN2FavGramTitlePrepend = "SELECT GRAM_SEQ, TITLE FROM fav_gram WHERE N_LVL=2 limit ";

	public static final String getN2FavGramTitleTail = ", 50;";

	public static final String getN1GramNo = "SELECT COUNT(*) as count FROM gram_dtl_n1;";

	public static final String getN2GramNo = "SELECT COUNT(*) as count FROM gram_dtl_n2;";

	public static final String getN1FavGramNo = "SELECT COUNT(*) as count FROM fav_gram WHERE N_LVL=1;";

	public static final String getN2FavGramNo = "SELECT COUNT(*) as count FROM fav_gram WHERE N_LVL=2;";

	public static final String getN1GramDetail = "SELECT * FROM gram_dtl_n1 WHERE GRAM_SEQ = ?;";

	public static final String getN2GramDetail = "SELECT * FROM gram_dtl_n2 WHERE GRAM_SEQ = ?;";

	public static final String addFavorite = "INSERT INTO fav_gram VALUES(null, ?, ?, ?);";

	public static final String cancelFavorite = "DELETE FROM fav_gram WHERE GRAM_SEQ=? AND N_LVL=?;";

	public static final String fetchFavorite = "";

}
