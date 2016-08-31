package upa.jiangnan.care.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jn.care.zxing.MipcaActivityCapture;

import java.util.List;

import upa.jiangnan.care.R;
import upa.jiangnan.care.bean.Advice;

public class SwipeAdapter_advice_right extends BaseAdapter implements OnClickListener{
	
	private final static int SCANNIN_GREQUEST_CODE = 1;
	private Context context;
	private List<Advice> advice_right;
	private Callback callback;

	public interface Callback {
		public void click(View v);
	}

	public SwipeAdapter_advice_right(Context context, List<Advice> advice_right,Callback callback) {
		super();
		this.context = context;
		this.advice_right = advice_right;
		this.callback=callback;
	}

	@Override
	public int getCount() {
		return advice_right.size();
	}

	@Override
	public Object getItem(int position) {
		return advice_right.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.item_advice_right, parent,false);
			
			//����ҽ����ÿ��item�е�����
			TextView title_tv = (TextView) convertView
					.findViewById(R.id.advice_title);
			TextView detail_tv = (TextView) convertView
					.findViewById(R.id.advice_detail);
			TextView fre_tv = (TextView) convertView
					.findViewById(R.id.advice_freq);
			TextView from = (TextView) convertView
					.findViewById(R.id.advice_from);
			TextView to = (TextView) convertView.findViewById(R.id.advice_to);
			LinearLayout period = (LinearLayout) convertView
					.findViewById(R.id.advice_period);
			
			//�Գ���ҽ����ÿ��item��ֵ
			title_tv.setText(advice_right.get(position).getAdvice_title());
			detail_tv.setText(advice_right.get(position).getDetail());
			if ("".equals(advice_right.get(position).getFrom_time())) {
				fre_tv.setText(advice_right.get(position).getFrequence());
				period.setVisibility(View.GONE);
				fre_tv.setVisibility(View.VISIBLE);
			} else {
				from.setText(advice_right.get(position).getFrom_time());
				to.setText(advice_right.get(position).getTo_time());
				period.setVisibility(View.VISIBLE);
				fre_tv.setVisibility(View.GONE);
			}
			
			
			//ִ�а�ť���򿪶�ά��ɨ��
			TextView execute_right_tv = (TextView) convertView.findViewById(R.id.execute_right_tv);
			execute_right_tv.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(context, MipcaActivityCapture.class);
					//�ѵ�ǰλ�õ�ֵ����ȥ
					Bundle bundle = new Bundle();
					bundle.putSerializable("advice_right", advice_right.get(position));
					intent.putExtras(bundle);
					((Activity)context).startActivityForResult(intent, SCANNIN_GREQUEST_CODE);
				}
			});
			
			//ҽ��ִ��������
			TextView execute_tip = (TextView) convertView.findViewById(R.id.execute_tip_right);
//			DB_Manager_Advice db_manager_advice = new DB_Manager_Advice(context);
//			List<Advice> list_tip = new ArrayList<Advice>();
//			list_tip = db_manager_advice.query();
			if(advice_right.get(position).getExecute_ok() == 1){
				execute_tip.setText("�����");
			}else{
				execute_tip.setText("δ���");
			}
			System.out.println("tip");

			TextView lable_right_tv = (TextView) convertView.findViewById
					(R.id.lable_right_tv);
			lable_right_tv.setTag(position);
			lable_right_tv.setOnClickListener(this);
		}
		return convertView;
	}


	@Override
	public void onClick(View v) {
		callback.click(v);
	}
}
