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

public class CallRecordActivity extends Activity {

	private TextView head_info_tv, patient_name_tv, patient_room_bed_tv;
	private ImageButton head_left;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_callrecord);

		// ????????????????????????
		head_info_tv = (TextView) findViewById(R.id.head_middle);
		head_left = (ImageButton) findViewById(R.id.head_left);

		head_info_tv.setText("通话记录");
		head_left.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CallRecordActivity.this,
						MainActivity.class);
				startActivity(intent);
			}
		});

		// ???????·????????????????????
		patient_name_tv = (TextView) findViewById(R.id.patient_info_name_tv);
		patient_room_bed_tv = (TextView) findViewById(R.id.patient_room_bed_tv);
//		Patient name1=((Patient) this.getIntent()
//				.getSerializableExtra("patient_detail"));
//		Log.v("接收到的值：：",name1.toString());
		if((!((Patient) this.getIntent()
				.getSerializableExtra("patient_detail")).equals(""))||(((Patient) this.getIntent()
				.getSerializableExtra("patient_detail"))!=null)) {
			patient_name_tv.setText(((Patient) getIntent().getSerializableExtra(
					"patient_detail")).getName());
			patient_room_bed_tv.setText(((Patient) getIntent()
					.getSerializableExtra("patient_detail")).getRoom_bed_num());
		}
	}
	
	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		switch(keyCode){
		case KeyEvent.KEYCODE_BACK:
			Intent intent = new Intent(CallRecordActivity.this,LoginActivity.class);
			startActivity(intent);
			break;

		}
			
		return super.onKeyLongPress(keyCode, event);
	}

}
