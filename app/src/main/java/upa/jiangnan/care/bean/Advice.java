package upa.jiangnan.care.bean;

import java.io.Serializable;

/*
 * ҽ��
 */
public class Advice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4925229490087379512L;
	private int id;
	// ҽ����Ŀ
	private String advice_title;
	// ����ҽ������
	private String detail;
	// ����ҽ����1������ҽ����0
	private int long_short;
	// ҽ��Ƶ�ʣ�����ÿ��
	private String frequence;
	// ҽ����ʼʱ��
	private String from_time;
	// ҽ������ʱ��
	private String to_time;
	// �Ƿ�ִ����� 1:��� 0:δ���
	private int execute_ok;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdvice_title() {
		return advice_title;
	}

	public void setAdvice_title(String advice_title) {
		this.advice_title = advice_title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getLong_short() {
		return long_short;
	}

	public void setLong_short(int long_short) {
		this.long_short = long_short;
	}

	public String getFrequence() {
		return frequence;
	}

	public void setFrequence(String frequence) {
		this.frequence = frequence;
	}

	public String getFrom_time() {
		return from_time;
	}

	public void setFrom_time(String from_time) {
		this.from_time = from_time;
	}

	public String getTo_time() {
		return to_time;
	}

	public void setTo_time(String to_time) {
		this.to_time = to_time;
	}

	public int getExecute_ok() {
		return execute_ok;
	}

	public void setExecute_ok(int execute_ok) {
		this.execute_ok = execute_ok;
	}
	
	

	public Advice() {
		super();
	}

	public Advice(int id, int execute_ok) {
		super();
		this.id = id;
		this.execute_ok = execute_ok;
	}

	public Advice(int id, String to_time) {
		super();
		this.id = id;
		this.to_time = to_time;
	}
	

}
