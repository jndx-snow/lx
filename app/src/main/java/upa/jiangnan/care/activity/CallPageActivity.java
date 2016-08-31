package upa.jiangnan.care.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import upa.jiangnan.care.R;
import upa.jiangnan.care.bean.Nurse;
import upa.jiangnan.care.bean.Patient;

public class CallPageActivity extends Activity {

	private TextView name_tv;
	private ImageButton cancel_btn,btn_ok,cancel_btn_in;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_callpage);

		name_tv = (TextView) findViewById(R.id.name);
		// call out
		cancel_btn = (ImageButton) findViewById(R.id.cancel_call_btn);

		//call in
		cancel_btn_in= (ImageButton) findViewById(R.id.cancel_call_in_btn);
		btn_ok=(ImageButton)findViewById(R.id.ok_call_in_btn);

		if (getIntent().getExtras().getSerializable("patient") == null) {
			name_tv.setText(((Nurse) getIntent().getExtras().getSerializable(
					"nurse")).getName());
		} else {
			name_tv.setText(((Patient) getIntent().getExtras().getSerializable(
					"patient")).getName());

		}

		cancel_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
//				Intent intent = new Intent(CallPageActivity.this,
//						MainActivity.class);
//				startActivity(intent);
				finish();

			}
		});
	}

}
