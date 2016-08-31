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
		// ��һ������
		ContentValues values_1 = new ContentValues();
		values_1.put("advice_title", "�ڿƼ���������");
		values_1.put("detail", "");
		values_1.put("long_short", 1);
		values_1.put("frequence", "2106.3.13");
		values_1.put("from_time", "23");
		values_1.put("to_time", "�����");
		values_1.put("execute_ok", 1);
		db.insert("advice", null, values_1);

		// �ڶ�������
		ContentValues values_2 = new ContentValues();
		values_2.put("advice_title", "��������");
		values_2.put("detail", "");
		values_2.put("long_short", 1);
		values_2.put("frequence", "ÿ��");
		values_2.put("from_time", "11");
		values_2.put("to_time", "�����");
		values_2.put("execute_ok", 1);
		db.insert("advice", null, values_2);

		// ����������
		ContentValues values_3 = new ContentValues();
		values_3.put("advice_title", "���ε�֬��ʳ");
		values_3.put("detail", "");
		values_3.put("long_short", 1);
		values_3.put("frequence", "23.6.22");
		values_3.put("from_time", "11");
		values_3.put("to_time", "δ���");
		values_3.put("execute_ok", 0);
		db.insert("advice", null, values_3);

		// ����������
		ContentValues values_4 = new ContentValues();
		values_4.put("advice_title", "�������");
		values_4.put("detail", "1-2L/min");
		values_4.put("long_short", 1);
		values_4.put("frequence", "ÿ��");
		values_4.put("from_time", "22");
		values_4.put("to_time", "δ���");
		values_4.put("execute_ok", 0);
		db.insert("advice", null, values_4);

		// ����������
		ContentValues values_5 = new ContentValues();
		values_5.put("advice_title", "����Τ��");
		values_5.put("detail", "100ml");
		values_5.put("long_short", 1);
		values_5.put("frequence", "ÿ��");
		values_5.put("from_time", "2014");
		values_5.put("to_time", "���");
		values_5.put("execute_ok", 1);
		db.insert("advice", null, values_5);

		// ����������
		ContentValues values_6 = new ContentValues();
		values_6.put("advice_title", "������ù��");
		values_6.put("detail", "0.60g");
		values_6.put("long_short", 1);
		values_6.put("frequence", "ÿ��");
		values_6.put("from_time", "2014");
		values_6.put("to_time", "δ���");
		values_6.put("execute_ok", 0);
		db.insert("advice", null, values_6);

		// ����������
		ContentValues values_7 = new ContentValues();
		values_7.put("advice_title", "�԰���ˮ����������Ƭ");
		values_7.put("detail", "��");
		values_7.put("long_short", 1);
		values_7.put("frequence", "ÿ��");
		values_7.put("from_time", "2014");
		values_7.put("to_time", "δ���");
		values_7.put("execute_ok", 0);
		db.insert("advice", null, values_7);

		// �ڰ�������
		ContentValues values_8 = new ContentValues();
		values_8.put("advice_title", "�������");
		values_8.put("detail", " ����ע��Һ");
		values_8.put("long_short", 1);
		values_8.put("frequence", "2014");
		values_8.put("from_time", "10");
		values_8.put("to_time", "δ���");
		values_8.put("execute_ok", 0);
		db.insert("advice", null, values_8);

		// �ھ�������
		ContentValues values_9 = new ContentValues();
		values_9.put("advice_title", "���ᰱ����");
		values_9.put("detail", "����ע��");
		values_9.put("long_short", 1);
		values_9.put("frequence", "2016.2.12 12:12");
		values_9.put("from_time", "(��������)");
		values_9.put("to_time", "δ���");
		values_9.put("execute_ok", 0);
		db.insert("advice", null, values_9);

		//��������Ϊ��ʱҽ��������

		//��ʮ������
		ContentValues values_10 = new ContentValues();
		values_10.put("advice_title", "����������ɳ��");
		values_10.put("detail", "������");
		values_10.put("long_short", 0);
		values_10.put("frequence", "2016.2.12 12:12");
		values_10.put("from_time", "2014");
		values_10.put("to_time", "δ���");
		values_10.put("execute_ok", 0);
		db.insert("advice", null, values_10);

		//��ʮһ������
		ContentValues values_11 = new ContentValues();
		values_11.put("advice_title", "ѪҺ���");
		values_11.put("detail", "��ǰ");
		values_11.put("long_short", 0);
		values_11.put("frequence", "2015.12.12 12:10");
		values_11.put("from_time", "(��������)");
		values_11.put("to_time", "ؽ�����");
		values_11.put("execute_ok", 0);
		db.insert("advice", null, values_11);

		//��ʮ��������
		ContentValues values_12 = new ContentValues();
		values_12.put("advice_title", "������Һ���������ϣ�");
		values_12.put("detail", "��ǰ����");
		values_12.put("long_short", 0);
		values_12.put("frequence", "2015.12.12 12:10");
		values_12.put("from_time", "(��������)");
		values_12.put("to_time", "�����");
		values_12.put("execute_ok", 0);
		db.insert("advice", null, values_12);

		//��ʮ��������
		ContentValues values_13 = new ContentValues();
		values_13.put("advice_title", "����ƽ����");
		values_13.put("detail", "�ڷ�");
		values_13.put("long_short", 0);
		values_13.put("frequence", "2014��8-3");
		values_13.put("from_time", "(��������)");
		values_13.put("to_time", "δ���");
		values_13.put("execute_ok", 0);
		db.insert("advice", null, values_13);

		//��ʮ��������
		ContentValues values_14 = new ContentValues();
		values_14.put("advice_title", "�����Ұ�");
		values_14.put("detail", "�ڷ�");
		values_14.put("long_short", 0);
		values_14.put("frequence", "2014.2.12 12:11");
		values_14.put("from_time", "(��������)");
		values_14.put("to_time", "δ���");
		values_14.put("execute_ok", 0);
		db.insert("advice", null, values_14);
	}

}
