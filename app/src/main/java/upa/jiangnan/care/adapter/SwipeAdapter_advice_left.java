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
public class SwipeAdapter_advice_left extends BaseAdapter implements OnClickListener{

	private final static int SCANNIN_GREQUEST_CODE = 1;
	private Context context;
	private List<Advice> advice_left;
	private TextView isDonePicture;
	private Callback callback;

	public interface Callback {
		public void click(View v);
	}
	public SwipeAdapter_advice_left(Context context,
									List<Advice> advice_left,  Callback callback) {
		super();
		this.context = context;
		this.advice_left = advice_left;
		this.callback=callback;
	}

	@Override
	public int getCount() {
		return advice_left.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			convertView = LayoutInflater.from(context).inflate(R.layout.item_advice_left, parent, false);
			
			//����ҽ����ÿ��item�е�����
			//һ����
			TextView first_title = (TextView) convertView.findViewById(R.id.advice_left_title);
			//������
			TextView second_title=(TextView)convertView.findViewById(R.id.advice_left_item);
			//������
			TextView three_title = (TextView) convertView.findViewById(R.id.advice_left_detail);
			//ͼƬ����Ƿ�ִ��
			isDonePicture=(TextView)convertView.findViewById(R.id.advice_left_from);
			//���ֱ���Ƿ����
			TextView isDone = (TextView) convertView.findViewById(R.id.advice_left_to);
			//ʱ��
			TextView time = (TextView) convertView.findViewById(R.id.advice_left_freq);

			LinearLayout period = (LinearLayout) convertView.findViewById(R.id.advice_left_period);
			
			//�Զ���ҽ����ÿ��item��ֵ
			first_title.setText(advice_left.get(position).getAdvice_title());
			three_title.setText(advice_left.get(position).getDetail());

//			if ("".equals(advice_left.get(position).getFrom_time())) {
				second_title.setText(advice_left.get(position).getFrom_time());
				time.setText(advice_left.get(position).getFrequence());
//				period.setVisibility(View.GONE);
//				time.setVisibility(View.VISIBLE);
//			} else {
//				from.setText("ʼ��" + advice_left.get(position).getFrom_time());
				isDone.setText(advice_left.get(position).getTo_time());
//				period.setVisibility(View.VISIBLE);
//				time.setVisibility(View.GONE);
			}
		if(advice_left.get(position).getTo_time().equals("�����")){
			isDonePicture.setBackgroundResource(R.color.gray);
		}else if(advice_left.get(position).getTo_time().equals("δ���")){
			isDonePicture.setBackgroundResource(R.color.ll_left);
		}else {
			isDonePicture.setBackgroundResource(R.color.ll_right);
		}
			
			//ִ�а�ť���򿪶�ά��ɨ��
			TextView execute_left_tv = (TextView) convertView.findViewById(R.id.execute_left_tv);
			execute_left_tv.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
//					patientDetailActivity.mWindowManager.removeView(patientDetailActivity.img_Float);
					Intent intent = new Intent(context, MipcaActivityCapture.class);
					//context.startActivity(intent);
					//�ѵ�ǰλ�õ�ֵ����ȥ
					Bundle bundle = new Bundle();
					bundle.putSerializable("advice_left", advice_left.get(position));
					intent.putExtras(bundle);
					((Activity)context).startActivityForResult(intent, SCANNIN_GREQUEST_CODE);
				}
			});
		TextView lable_left_tv=(TextView)convertView.findViewById(R.id.lable_left_tv);
		lable_left_tv.setTag(position);
		lable_left_tv.setOnClickListener(this);

		return convertView;
	}

	@Override
	   public void onClick(View v) {
		callback.click(v);
	  }
	public  void onActivityResult(int requestCode, int resultCode, Intent data) {
		System.out.println("advice right execute");
	}
	
}
