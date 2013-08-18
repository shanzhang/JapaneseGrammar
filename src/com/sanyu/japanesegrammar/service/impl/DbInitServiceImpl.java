package com.sanyu.japanesegrammar.service.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sanyu.japanesegrammar.service.DbInitService;
import com.sanyu.japanesegrammar.util.SqlConstants;

public class DbInitServiceImpl implements DbInitService {

	@Override
	public void initDatabase(SQLiteDatabase db) {
		
		db.execSQL("drop table grammar;");
		
		db.execSQL(SqlConstants.createGrammarTable);
		db.execSQL(SqlConstants.createFavoriteTable);
		
		db.execSQL("INSERT INTO grammar VALUES(null, '~あげく/~あげくに', '接在动词过去时或「名詞+の」的形式后面', '表示一种结果，含有“最后终于……”的意思。前半句通常是一个感觉较长的过程，「あげく」表示的结果中，消极的情况较多。后项一般用过去时结句。', '', '', '', '最后终于……', '', '', '', '長い苦労（くろう）のあげく、とうとう病気になってしまいました。', '', '', '', '由于长期的疲劳，结果得了病。', '', '', '');");
		db.execSQL("INSERT INTO grammar VALUES(null, '~あまり', '接在「名词+の」的形式后面或活用词连体形之后', '前项中常见「嬉しい」、「嬉しさ」、「悲しい」、「悲しみ」等带有心理性的词语。前项活用词的时态一般使用现在时，也有少量过去时的情况出现。', '', '', '', '过度……的结果、因过于……而……', '', '', '', '喜び（よろこぶ）のあまり、声（こえ）をあげた。', '', '', '', '因为过于高兴而欢呼', '', '', '');");
		db.execSQL("INSERT INTO grammar VALUES(null, '~以上/~以上は', '接在动词、形容词连体形后面（形容动词、体言一般使用「である」的形式），过去时，现在时均可使用。', '表示由前提引出的主观断定。前项为确定事实，得到后项“当然该……”、“必须……”等情况。', '', '', '', '既然……就……', '', '', '', 'お金がない以上、がまんするしかない。', '', '', '', '既然没钱，就只好忍一忍了。', '', '', '');");
		db.execSQL("INSERT INTO grammar VALUES(null, '~一方（いっぽう）/~一方で/一方では', '前接用言连体形,名词、形容动词用『である』的形式，一般活用词用现在时。', '表示同时存在的两个对照性事物,『一方』也可以作为接续词使用。', '', '', '', '一方面……一方面', '', '', '', '洋子（ようこ）は清のチームを応援（おうえん）する一方で、一郎のチームも応援している。', '', '', '', '洋子即支持小清的球队，也支持一郎的球队。', '', '', '');");
		db.execSQL("INSERT INTO grammar VALUES(null, '~一方だ', '前接动词原型', '多为带有变化意思的内容，表示某种状态、倾向、情况不断发展。', '', '', '', '越来越……', '', '', '', '『寒くなりましたね。』『ええ、これからは寒くなる一方ですね。』', '', '', '', '天气冷起来了啊。是啊，往后该是越来越冷了。', '', '', '');");
		db.execSQL("INSERT INTO grammar VALUES(null, '~うえ/~うえに', '『うえ』构成形式体言，接续法与名词相同，活用词使用连体形，现在时、过去时均可，名词后续『の』。', '表示累加、递进。', '', '', '', '不仅……而且……', '', '', '', '工事（こうじ）のうえ、事故までおきて、道路は大変（たいへん）込ん（こむ）でいる。', '', '', '', '道路上在施工，又发生了事故，变得相当拥挤。', '', '', '');");
		db.execSQL("INSERT INTO grammar VALUES(null, '~上で/~上の/~上では/~上でも/~上での', '『うえ』的形式体言用法，接续法与上一条相同。『~上で』、『~上では』、『上でも』在句中作状语使用，『は、も』强调语气；『~上の』、『~上での』坐定语修饰体言。', '前接动词过去时，表示“在……之后……”相当于『てから』的意思，前项一般为后向所需的一种基础。用『带有动作意义的名词+の』也可以起到同样作用。', '接在名词或动词现在时之后，表示某一方面、某种角度，相当于“关于……方面”。这时的『上』可用『関係』、『点』、『面』、『場合』等词替换。', '关于……方面', '', '在……之后……', '', '', '', '審査（しんさ）の上で、決定（けってい）します。', '仕事の上では、とても彼に及ば（およぶ）ない。', '', '', '审查以后在作决定。', '在工作方面我比不上他。', '', '');");
		
		if (checkHasData(db)) {
			db.execSQL(SqlConstants.insertGrammar);
		}
	}

	private boolean checkHasData(SQLiteDatabase db) {
		Cursor cursor = db.rawQuery(SqlConstants.fetchGrammarNo, null);
		cursor.moveToNext();
		int no = cursor.getInt(cursor.getColumnIndex("count"));
		return no > 0 ? false : true;
	}

}
