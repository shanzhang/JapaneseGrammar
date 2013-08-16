package com.sanyu.japanesegrammar.util;

public final class SqlConstants {

	public static final int DATABASE_VERSION = 3;

	public static final String DATABASE_NAME = "Grammar.DB3";

	public static final String createGrammarTable = "CREATE TABLE IF NOT EXISTS grammar (GRAMMAR_SEQ INTEGER PRIMARY KEY AUTOINCREMENT, GRAMMAR_TITLE, CONJUNCTION, USAGE1, USAGE2, USAGE3, USAGE4, TRANSLATION1, TRANSLATION2, TRANSLATION3, TRANSLATION4, EXAMPLE1, EXAMPLE2, EXAMPLE3, EXAMPLE4, EX_TRANS1, EX_TRANS2, EX_TRANS3, EX_TRANS4);";

	public static final String createFavoriteTable = "CREATE TABLE IF NOT EXISTS favorite (FAVORITES_SEQ INTEGER PRIMARY KEY AUTOINCREMENT, GRAMMAR_SEQ INTEGER, GRAMMAR_TITLE);";

	public static final String insertGrammar = "INSERT INTO grammar VALUES(null, '���Ф����', '������������ + �Ф���ˡ� ������ + �Ǥ��� + �Ф���ˡ�', '��ʾ��Ϊ��ԭ���²��ý�����ź�����', '', '', '', '����Ϊ', '', '', '', '���', '�Ěs��', '', '', '����Ϊ����������Ԥ��������ù', '����Ϊû��ѧ����û���Ǽҹ�˾¼��', '', '');INSERT INTO grammar VALUES(null, '���Ф����', '������������ + �Ф���ˡ� ������ + �Ǥ��� + �Ф���ˡ�', '��ʾ��Ϊ��ԭ���²��ý�����ź�����', '', '', '', '����Ϊ', '', '', '', '���', '�Ěs��', '', '', '����Ϊ����������Ԥ��������ù', '����Ϊû��ѧ����û���Ǽҹ�˾¼��', '', '');INSERT INTO grammar VALUES(null, '���Ф����', '������������ + �Ф���ˡ� ������ + �Ǥ��� + �Ф���ˡ�', '��ʾ��Ϊ��ԭ���²��ý�����ź�����', '', '', '', '����Ϊ', '', '', '', '���', '�Ěs��', '', '', '����Ϊ����������Ԥ��������ù', '����Ϊû��ѧ����û���Ǽҹ�˾¼��', '', '');";

	public static final String fetchGrammarTitle = "SELECT GRAMMAR_SEQ, GRAMMAR_TITLE FROM grammar;";
	
	public static final String fetchGrammarNo = "SELECT COUNT(*) as count FROM grammar;";

	public static final String fetchGrammarFavoritesNo = "SELECT COUNT(*) as count FROM favorite;";

	public static final String fetchGrammarDetail = "SELECT * FROM grammar WHERE GRAMMAR_SEQ = ?;";

	public static final String addFavorite = "";

	public static final String cancelFavorite = "";

	public static final String fetchFavorite = "";

}
