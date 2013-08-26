package com.sanyu.japanesegrammar.util;

public final class SqlConstants {

	public static final int DATABASE_VERSION = 3;

	public static final String DATABASE_NAME = "Grammar.DB3";

	public static final String insertN2Gram = "INSERT INTO gram_dtl_n2 VALUES(null, ?, ?);";

	public static final String getN2GramTitle = "SELECT GRAM_SEQ, TITLE FROM gram_dtl_n2;";

	public static final String getN2GramNo = "SELECT COUNT(*) as count FROM gram_dtl_n2;";

	public static final String getFavGramNo = "SELECT COUNT(*) as count FROM fav_gram;";

	public static final String getGramDetail = "SELECT * FROM gram_dtl_n2 WHERE GRAM_SEQ = ?;";

	public static final String addFavorite = "";

	public static final String cancelFavorite = "";

	public static final String fetchFavorite = "";

}
