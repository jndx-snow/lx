package upa.jiangnan.care.dbservice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import upa.jiangnan.care.bean.Nurse;

public class DB_Manager_Nurse {

	private DatabaseHelper databaseHelper;
	private SQLiteDatabase db;

	public DB_Manager_Nurse(Context context) {
		databaseHelper = new DatabaseHelper(context);
		db = databaseHelper.getWritableDatabase();
	}

	// ????nurse????????????
	public List<Nurse> query() {
		List<Nurse> nurseList = new ArrayList<Nurse>();
		Cursor c = db.rawQuery("select * from nurse", null);
		while (c.moveToNext()) {
			Nurse nurse = new Nurse();
			nurse.setId(c.getInt(c.getColumnIndex("id")));
			nurse.setName(c.getString(c.getColumnIndex("name")));
			nurse.setOnWork(c.getInt(c.getColumnIndex("onwork")));
			nurse.setDomain(c.getString(c.getColumnIndex("domain")));
			nurse.setWork_position(c.getString(c
					.getColumnIndex("work_position")));
			nurse.setLast_calltime(c.getString(c
					.getColumnIndex("last_calltime")));
			nurseList.add(nurse);
		}

		return nurseList;
	}

	public void insertNurseData() {
		// ��һ������
		ContentValues values_1 = new ContentValues();
		values_1.put("name", "��ޱޱ ");
		values_1.put("onwork", 1);
		values_1.put("domain", "��ʿ");
		values_1.put("work_position", "�ڿ�B��");
		values_1.put("last_calltime", "12:40 am");
		db.insert("nurse", null, values_1);

		// �ڶ�������
		ContentValues values_2 = new ContentValues();
		values_2.put("name", "��С��");
		values_2.put("onwork", 1);
		values_2.put("domain", "��¥�ڿ�B��");
		values_2.put("work_position", "��ʿ");
		values_2.put("last_calltime", "10:15 am");
		db.insert("nurse", null, values_2);

		// ����������
		ContentValues values_3 = new ContentValues();
		values_3.put("name", "������");
		values_3.put("onwork", 1);
		values_3.put("domain", "��¥�ڿ�B��");
		values_3.put("work_position", "��ʿ");
		values_3.put("last_calltime", "����");
		db.insert("nurse", null, values_3);

		// ����������
		ContentValues values_4 = new ContentValues();
		values_4.put("name", "��Ƿ��");
		values_4.put("onwork", 1);
		values_4.put("domain", "��¥�ڿ�B��");
		values_4.put("work_position", "��ʿ");
		values_4.put("last_calltime", "8:25 am");
		db.insert("nurse", null, values_4);

		// ����������
		ContentValues values_5 = new ContentValues();
		values_5.put("name", "��ʯ");
		values_5.put("onwork", 1);
		values_5.put("domain", "��¥�ڿ�A��");
		values_5.put("work_position", "��ʿ��");
		values_5.put("last_calltime", "11:25 am");
		db.insert("nurse", null, values_5);
	}

}
