package upa.jiangnan.care.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import upa.jiangnan.care.dbservice.DatabaseHelper;

public class AdviceData {

	private DatabaseHelper databaseHelper;
	private SQLiteDatabase db;

	public AdviceData(Context context) {
		databaseHelper = new DatabaseHelper(context);
		db = databaseHelper.getWritableDatabase();
	}


	public void insertAdviceData() {
		// 第一条数据
		ContentValues values_1 = new ContentValues();
		values_1.put("advice_title", "内科疾病护理常规");
		values_1.put("detail", "");
		values_1.put("long_short", 1);
		values_1.put("frequence", "2106.3.13");
		values_1.put("from_time", "23");
		values_1.put("to_time", "已完成");
		values_1.put("execute_ok", 1);
		db.insert("advice", null, values_1);

		// 第二条数据
		ContentValues values_2 = new ContentValues();
		values_2.put("advice_title", "二级护理");
		values_2.put("detail", "");
		values_2.put("long_short", 1);
		values_2.put("frequence", "每日");
		values_2.put("from_time", "11");
		values_2.put("to_time", "已完成");
		values_2.put("execute_ok", 1);
		db.insert("advice", null, values_2);

		// 第三条数据
		ContentValues values_3 = new ContentValues();
		values_3.put("advice_title", "低盐低脂饮食");
		values_3.put("detail", "");
		values_3.put("long_short", 1);
		values_3.put("frequence", "23.6.22");
		values_3.put("from_time", "11");
		values_3.put("to_time", "未完成");
		values_3.put("execute_ok", 0);
		db.insert("advice", null, values_3);

		// 第四条数据
		ContentValues values_4 = new ContentValues();
		values_4.put("advice_title", "间断吸氧");
		values_4.put("detail", "1-2L/min");
		values_4.put("long_short", 1);
		values_4.put("frequence", "每日");
		values_4.put("from_time", "22");
		values_4.put("to_time", "未完成");
		values_4.put("execute_ok", 0);
		db.insert("advice", null, values_4);

		// 第五条数据
		ContentValues values_5 = new ContentValues();
		values_5.put("advice_title", "利巴韦林");
		values_5.put("detail", "100ml");
		values_5.put("long_short", 1);
		values_5.put("frequence", "每日");
		values_5.put("from_time", "2014");
		values_5.put("to_time", "完成");
		values_5.put("execute_ok", 1);
		db.insert("advice", null, values_5);

		// 第六条数据
		ContentValues values_6 = new ContentValues();
		values_6.put("advice_title", "苄星青霉素");
		values_6.put("detail", "0.60g");
		values_6.put("long_short", 1);
		values_6.put("frequence", "每日");
		values_6.put("from_time", "2014");
		values_6.put("to_time", "未完成");
		values_6.put("execute_ok", 0);
		db.insert("advice", null, values_6);

		// 第七条数据
		ContentValues values_7 = new ContentValues();
		values_7.put("advice_title", "对氨基水杨酸异烟腾片");
		values_7.put("detail", "口");
		values_7.put("long_short", 1);
		values_7.put("frequence", "每日");
		values_7.put("from_time", "2014");
		values_7.put("to_time", "未完成");
		values_7.put("execute_ok", 0);
		db.insert("advice", null, values_7);

		// 第八条数据
		ContentValues values_8 = new ContentValues();
		values_8.put("advice_title", "多索茶碱");
		values_8.put("detail", " 静脉注射液");
		values_8.put("long_short", 1);
		values_8.put("frequence", "2014");
		values_8.put("from_time", "10");
		values_8.put("to_time", "未完成");
		values_8.put("execute_ok", 0);
		db.insert("advice", null, values_8);

		// 第九条数据
		ContentValues values_9 = new ContentValues();
		values_9.put("advice_title", "盐酸氨溴索");
		values_9.put("detail", "静脉注射");
		values_9.put("long_short", 1);
		values_9.put("frequence", "2016.2.12 12:12");
		values_9.put("from_time", "(二级护理)");
		values_9.put("to_time", "未完成");
		values_9.put("execute_ok", 0);
		db.insert("advice", null, values_9);

		//以下数据为临时医嘱的数据

		//第十条数据
		ContentValues values_10 = new ContentValues();
		values_10.put("advice_title", "盐酸左氧氟沙星");
		values_10.put("detail", "续静滴");
		values_10.put("long_short", 0);
		values_10.put("frequence", "2016.2.12 12:12");
		values_10.put("from_time", "2014");
		values_10.put("to_time", "未完成");
		values_10.put("execute_ok", 0);
		db.insert("advice", null, values_10);

		//第十一条数据
		ContentValues values_11 = new ContentValues();
		values_11.put("advice_title", "血液检测");
		values_11.put("detail", "术前");
		values_11.put("long_short", 0);
		values_11.put("frequence", "2015.12.12 12:10");
		values_11.put("from_time", "(二级护理)");
		values_11.put("to_time", "亟需完成");
		values_11.put("execute_ok", 0);
		db.insert("advice", null, values_11);

		//第十二条数据
		ContentValues values_12 = new ContentValues();
		values_12.put("advice_title", "康复新液（湖南中南）");
		values_12.put("detail", "术前化验");
		values_12.put("long_short", 0);
		values_12.put("frequence", "2015.12.12 12:10");
		values_12.put("from_time", "(二级护理)");
		values_12.put("to_time", "已完成");
		values_12.put("execute_ok", 0);
		db.insert("advice", null, values_12);

		//第十三条数据
		ContentValues values_13 = new ContentValues();
		values_13.put("advice_title", "利福平胶囊");
		values_13.put("detail", "口服");
		values_13.put("long_short", 0);
		values_13.put("frequence", "2014－8-3");
		values_13.put("from_time", "(二级护理)");
		values_13.put("to_time", "未完成");
		values_13.put("execute_ok", 0);
		db.insert("advice", null, values_13);

		//第十四条数据
		ContentValues values_14 = new ContentValues();
		values_14.put("advice_title", "盐酸乙胺");
		values_14.put("detail", "口服");
		values_14.put("long_short", 0);
		values_14.put("frequence", "2014.2.12 12:11");
		values_14.put("from_time", "(二级护理)");
		values_14.put("to_time", "未完成");
		values_14.put("execute_ok", 0);
		db.insert("advice", null, values_14);
	}

}
