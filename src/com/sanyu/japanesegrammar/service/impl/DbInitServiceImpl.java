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
		
		db.execSQL("INSERT INTO grammar VALUES(null, '~あげく/~あげくに', '俊壓強簡狛肇扮賜仝兆�~+の々議侘塀朔中', '燕幣匯嶽潤惚��根嗤＾恷朔嶮噐´´￣議吭房。念磯鞘宥械頁匯倖湖状熟海議狛殻��仝あげく々燕幣議潤惚嶄����自議秤趨熟謹。朔�醪三穩湛�肇扮潤鞘。', '', '', '', '恷朔嶮噐´´', '', '', '', '�Lい逗�今┐�ろう��のあげく、とうとう押�櫃砲覆辰討靴泙い泙靴拭�', '', '', '', '喇噐海豚議藤斥��潤惚誼阻押。', '', '', '');");
		db.execSQL("INSERT INTO grammar VALUES(null, '~あまり', '俊壓仝兆簡+の々議侘塀朔中賜試喘簡銭悶侘岻朔', '念�釀亞�需仝耙しい々、仝耙しさ々、仝丑しい々、仝丑しみ々吉揮嗤伉尖來議簡囂。念�郢醵担糞鎚洩�匯違聞喘�嶬敲隠�匆嗤富楚狛肇扮議秤趨竃�屐�', '', '', '', '狛業´´議潤惚、咀狛噐´´遇´´', '', '', '', '浪び�┐茲蹐海孱�のあまり、蕗�┐海┌�をあげた。', '', '', '', '咀葎狛噐互佶遇散柵', '', '', '');");
		db.execSQL("INSERT INTO grammar VALUES(null, '~參貧/~參貧は', '俊壓強簡、侘否簡銭悶侘朔中��侘否強簡、悶冱匯違聞喘仝である々議侘塀����狛肇扮���嶬敲云�辛聞喘。', '燕幣喇念戻哈竃議麼鉱僅協。念�醂�鳩協並糞��誼欺朔�遏圧曳燦叩�´￣、＾駅倬´´￣吉秤趨。', '', '', '', '屡隼´´祥´´', '', '', '', 'お署がない參貧、がまんするしかない。', '', '', '', '屡隼短熱��祥峪挫般匯般阻。', '', '', '');");
		db.execSQL("INSERT INTO grammar VALUES(null, '~匯圭�┐い辰櫃Γ�/~匯圭で/匯圭では', '念俊喘冱銭悶侘,兆簡、侘否強簡喘〆である〇議侘塀��匯違試喘簡喘�嶬敲院�', '燕幣揖扮贋壓議曾倖斤孚來並麗,〆匯圭〇匆辛參恬葎俊偬簡聞喘。', '', '', '', '匯圭中´´匯圭中', '', '', '', '剴徨�┐茲Δ械�は賠のチ�`ムを鮅��┐�うえん��する匯圭で、匯隻のチ�`ムも鮅�している。', '', '', '', '剴徨軸屶隔弌賠議白錦��匆屶隔匯隻議白錦。', '', '', '');");
		db.execSQL("INSERT INTO grammar VALUES(null, '~匯圭だ', '念俊強簡圻侏', '謹葎揮嗤延晒吭房議坪否��燕幣蝶嶽彜蓑、買�髻�秤趨音僅窟婢。', '', '', '', '埆栖埆´´', '', '', '', '〆混くなりましたね。〇〆ええ、これからは混くなる匯圭ですね。〇', '', '', '', '爺賑絶軟栖阻亜。頁亜��吏朔乎頁埆栖埆絶阻。', '', '', '');");
		db.execSQL("INSERT INTO grammar VALUES(null, '~うえ/~うえに', '〆うえ〇更撹侘塀悶冱��俊偬隈嚥兆簡�猴���試喘簡聞喘銭悶侘���嶬敲院�狛肇扮譲辛��兆簡朔偬〆の〇。', '燕幣拙紗、弓序。', '', '', '', '音叙´´遇拝´´', '', '', '', '垢並�┐海Δ牽�のうえ、並絞までおきて、祇揃は寄�筍┐燭い悗鵤��zん�┐海爍�でいる。', '', '', '', '祇揃貧壓仏垢��嗽窟伏阻並絞��延誼�犁詠擬掘�', '', '', '');");
		db.execSQL("INSERT INTO grammar VALUES(null, '~貧で/~貧の/~貧では/~貧でも/~貧での', '〆うえ〇議侘塀悶冱喘隈��俊偬隈嚥貧匯訳�猴�。〆~貧で〇、〆~貧では〇、〆貧でも〇壓鞘嶄恬彜囂聞喘��〆は、も〇膿距囂賑�察�~貧の〇、〆~貧での〇恫協囂俐蔑悶冱。', '念俊強簡狛肇扮��燕幣＾壓´´岻朔´´￣�犁詠據困討�ら〇議吭房��念�醪三穃�朔�鯔�俶議匯嶽児粥。喘〆揮嗤強恬吭吶議兆簡+の〇匆辛參軟欺揖劔恬喘。', '俊壓兆簡賜強簡�嶬敲疫�朔��燕幣蝶匯圭中、蝶嶽叔業���犁詠據姐慯據�´圭中￣。宸扮議〆貧〇辛喘〆�v�S〇、〆泣〇、〆中〇、〆��栽〇吉簡紋算。', '購噐´´圭中', '', '壓´´岻朔´´', '', '', '', '���烹┐靴鵑毅�の貧で、�Q協�┐韻辰討ぃ�します。', '碧並の貧では、とても泳に式ば�┐�よぶ��ない。', '', '', '蕪臥參朔壓恬畳協。', '壓垢恬圭中厘曳音貧麿。', '', '');");
		
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
