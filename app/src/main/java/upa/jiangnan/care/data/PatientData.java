package upa.jiangnan.care.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import upa.jiangnan.care.dbservice.DatabaseHelper;

public class PatientData {
	
	private DatabaseHelper databaseHelper;
	private SQLiteDatabase db;

	public PatientData(Context context) {
		databaseHelper = new DatabaseHelper(context);
		db = databaseHelper.getWritableDatabase();
	}

	public void insertPatientData() {
		// ��һ������
		ContentValues values_1 = new ContentValues();
		values_1.put("name", "��С��");
		values_1.put("age", 45);
		values_1.put("sex", 1);
		values_1.put("room_bed_num", "101-01��");
		values_1.put("hospital_num", "130374-5");
		values_1.put("in_hospital_time", "2014-7-10��Ժ");
		values_1.put("to_doctor_name", "����ҽʦ������");
		values_1.put("cure_detail", "��ϣ�ú������Ҽ��  ������");
		db.insert("patient", null, values_1);

		// �ڶ�������
		ContentValues values_2 = new ContentValues();
		values_2.put("name", "�����");
		values_2.put("age", 38);
		values_2.put("sex", 1);
		values_2.put("room_bed_num", "101-02��");
		values_2.put("hospital_num", "130632-2");
		values_2.put("in_hospital_time", "2014-7-12��Ժ");
		values_2.put("to_doctor_name", "����ҽʦ������");
		values_2.put("cure_detail", "��ϣ�ˮ�೾��Ҽ��  ������");
		db.insert("patient", null, values_2);

		// ����������
		ContentValues values_3 = new ContentValues();
		values_3.put("name", "�δ�");
		values_3.put("age", 64);
		values_3.put("sex", 0);
		values_3.put("room_bed_num", "101-03��");
		values_3.put("hospital_num", "130382-3");
		values_3.put("in_hospital_time", "2014-7-12��Ժ");
		values_3.put("to_doctor_name", "����ҽʦ������");
		values_3.put("cure_detail", "��ϣ�ˮ�೾��Ҽ��  ������");
		db.insert("patient", null, values_3);

		// ����������
		ContentValues values_4 = new ContentValues();
		values_4.put("name", "���ͷ");
		values_4.put("age", 84);
		values_4.put("sex", 1);
		values_4.put("room_bed_num", "101-04��");
		values_4.put("hospital_num", "H130632-1");
		values_4.put("in_hospital_time", "2014-7-15��Ժ");
		values_4.put("to_doctor_name", "����ҽʦ������");
		values_4.put("cure_detail", "��ϣ�ú������Ҽ��  ������");
		db.insert("patient", null, values_4);

		// ����������
		ContentValues values_5 = new ContentValues();
		values_5.put("name", "����");
		values_5.put("age", 73);
		values_5.put("sex", 1);
		values_5.put("room_bed_num", "102-01��");
		values_5.put("hospital_num", "130420-1");
		values_5.put("in_hospital_time", "2014-7-14��Ժ");
		values_5.put("to_doctor_name", "����ҽʦ������");
		values_5.put("cure_detail", "��ϣ�ú������Ҽ��  ������");
		db.insert("patient", null, values_5);

		// ����������
		ContentValues values_6 = new ContentValues();
		values_6.put("name", "���");
		values_6.put("age", 42);
		values_6.put("sex", 1);
		values_6.put("room_bed_num", "102-02��");
		values_6.put("hospital_num", "130683-5");
		values_6.put("in_hospital_time", "2014-7-18��Ժ");
		values_6.put("to_doctor_name", "����ҽʦ������");
		values_6.put("cure_detail", "��ϣ�ú������Ҽ��  ������");
		db.insert("patient", null, values_6);

		// ����������
		ContentValues values_7 = new ContentValues();
		values_7.put("name", "�Ŵ�è");
		values_7.put("age", 55);
		values_7.put("sex", 0);
		values_7.put("room_bed_num", "102-03��");
		values_7.put("hospital_num", "130420-5");
		values_7.put("in_hospital_time", "2014-7-16��Ժ");
		values_7.put("to_doctor_name", "����ҽʦ������");
		values_7.put("cure_detail", "��ϣ�ú������Ҽ��  ������");
		db.insert("patient", null, values_7);

		// �ڰ�������
		ContentValues values_8 = new ContentValues();
		values_8.put("name", "�����");
		values_8.put("age", 39);
		values_8.put("sex", 1);
		values_8.put("room_bed_num", "102-04��");
		values_8.put("hospital_num", "130420-5");
		values_8.put("in_hospital_time", "2014-7-16��Ժ");
		values_8.put("to_doctor_name", "����ҽʦ������");
		values_8.put("cure_detail", "��ϣ�ú������Ҽ��  ������");
		db.insert("patient", null, values_8);

		// �ھ�������
		ContentValues values_9 = new ContentValues();
		values_9.put("name", "������");
		values_9.put("age", 50);
		values_9.put("sex", 0);
		values_9.put("room_bed_num", "103-01��");
		values_9.put("hospital_num", "130420-5");
		values_9.put("in_hospital_time", "2014-7-16��Ժ");
		values_9.put("to_doctor_name", "����ҽʦ��������");
		values_9.put("cure_detail", "��ϣ�ú������Ҽ��  ������");
		db.insert("patient", null, values_9);
	}
}
