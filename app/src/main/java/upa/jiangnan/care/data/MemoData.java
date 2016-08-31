package upa.jiangnan.care.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import upa.jiangnan.care.R;
import upa.jiangnan.care.dbservice.DatabaseHelper;

public class MemoData {

	private DatabaseHelper databaseHelper;
	private SQLiteDatabase db;

	public MemoData(Context context) {
		databaseHelper = new DatabaseHelper(context);
		db = databaseHelper.getWritableDatabase();
	}

	public void insertMemoData() {
		// ��һ������
		ContentValues values_1 = new ContentValues();
		values_1.put("memo_title", "��ǰ׼��");
		values_1.put("memo_detail", R.string.memo_data);
		values_1.put("memo_date_time", "2014-09-10 13:20");
		db.insert("memo", null, values_1);

		// �ڶ�������
		ContentValues values_2 = new ContentValues();
		values_2.put("memo_title", "�ɼ�Ѫ����Ѫ�����");
		values_2.put("memo_detail",R.string.memo_data);
		values_2.put("memo_date_time", "2014-08-03 12:20");
		db.insert("memo", null, values_2);

		// ����������
		ContentValues values_3 = new ContentValues();
		values_3.put("memo_title", "������");
		values_3.put("memo_detail",R.string.memo_data);
		values_3.put("memo_date_time", "2014-09-10 10:20");
		db.insert("memo", null, values_3);

		// ����������
		ContentValues values_4 = new ContentValues();
		values_4.put("memo_title", "��ǰע����������");
		values_4.put("memo_detail",R.string.memo_data);
		values_4.put("memo_date_time", "2014-08-03 15:30");
		db.insert("memo", null, values_4);

		// ����������
		ContentValues values_5 = new ContentValues();
		values_5.put("memo_title", "��ǰ����");
		values_5.put("memo_detail",R.string.memo_data);
		values_5.put("memo_date_time", "2014-09-10 13:20");
		db.insert("memo", null, values_5);

		// ����������
		ContentValues values_6 = new ContentValues();
		values_6.put("memo_title", "��������");
		values_6.put("memo_detail",R.string.memo_data);
		values_6.put("memo_date_time", "2014-09-10 07:20");
		db.insert("memo", null, values_6);

	}
}
