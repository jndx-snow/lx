package upa.jiangnan.care.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import upa.jiangnan.care.R;
import upa.jiangnan.care.bean.Patient;

public class BaseInfoActivity extends Activity {
	
	private TextView  head_info_tv,patient_name_tv,patient_room_bed_tv;
	private ImageButton head_left;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_baseinfo);

		//页面头部的返回和病人名字，床号
		head_info_tv = (TextView) findViewById(R.id.head_middle);
		head_left = (ImageButton) findViewById(R.id.head_left);

		head_info_tv.setText("");
//		head_info_tv.setText(((Patient)getIntent().getSerializableExtra("nurse_info")).getName()
//				+ "(" + ((Patient)getIntent().getSerializableExtra("nurse_info")).getRoom_bed_num()
//				+ ")");
		head_left.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(BaseInfoActivity.this,MainActivity.class);
				startActivity(intent);
			}
		});
		
		//???????·????????????????????
		patient_name_tv = (TextView) findViewById(R.id.base_name_sign);
		patient_room_bed_tv = (TextView) findViewById(R.id.base_bed);
		patient_name_tv.setText(((Patient)getIntent().getSerializableExtra("nurse_info")).getName());
		patient_room_bed_tv.setText(((Patient)getIntent().getSerializableExtra("nurse_info"))
				.getRoom_bed_num());
	}
	
	
	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		switch(keyCode){
		case KeyEvent.KEYCODE_BACK:
			Intent intent = new Intent(BaseInfoActivity.this,LoginActivity.class);
			startActivity(intent);
			break;

		}
			
		return super.onKeyLongPress(keyCode, event);
	}
	
	

}
