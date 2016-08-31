package upa.jiangnan.care.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;

import com.jn.care.zxing.MipcaActivityCapture;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import upa.jiangnan.care.R;
import upa.jiangnan.care.bean.Patient;
import upa.jiangnan.care.dbservice.DB_Manager_Patient;
import upa.jiangnan.care.fragment.NursesFragment;
import upa.jiangnan.care.fragment.PatientsFragment;

public class MainActivity extends FragmentActivity {

	private final static int SCANNIN_GREQUEST_CODE = 1;

	private int mWidth;
	private int mHeight;
	private  float mDensity;

	private RadioGroup radioGroup_main;
	private RadioButton radioButton_left;
	private RadioButton radioButton_right;
	private ImageButton search,btn_title;
	private ImageView title_three_line;
	private LinearLayout ll_left,ll_right;
	private PopupWindow mPopupWindow;

	private FrameLayout frameLayout;
	private LinearLayout ll_title_line;
	private RelativeLayout rl_title,rl_list,rl_letter;

	private FragmentManager fragmentManager = getSupportFragmentManager();
	private ImageView letter;
	NursesFragment nurseFragment = new NursesFragment();
	PatientsFragment patientFragment = new PatientsFragment();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ll_title_line=(LinearLayout)findViewById(R.id.ll_red_line);
		rl_title=(RelativeLayout)findViewById(R.id.rl_title);
		rl_list=(RelativeLayout)findViewById(R.id.rl_list);
		frameLayout=(FrameLayout)findViewById(R.id.main_container);
		title_three_line=(ImageView)findViewById(R.id.title_three_line);
		radioGroup_main = (RadioGroup) findViewById(R.id.radioGroup_main);
		radioButton_left = (RadioButton) findViewById(R.id.radiobutton_left);
		radioButton_right = (RadioButton) findViewById(R.id.radiobutton_right);

		rl_letter=(RelativeLayout)findViewById(R.id.rl_letter);
		rl_letter.setVisibility(View.VISIBLE);
		letter=(ImageView)findViewById(R.id.letter);
		letter.setMaxWidth(0);

		btn_title=(ImageButton)findViewById(R.id.btn_title);
		btn_title.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				rl_letter.setVisibility(View.VISIBLE);
				rl_title.setVisibility(View.VISIBLE);
				ll_title_line.setVisibility(View.VISIBLE);
				frameLayout.setVisibility(View.VISIBLE);
				btn_title.setVisibility(View.GONE);
//				title_three_line.setBackgroundResource(R.drawable.left_three);
				rl_list.setVisibility(View.GONE);
			}
		});

		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		mWidth = metric.widthPixels;     // 屏幕宽度（像素）
		mHeight = metric.heightPixels;   // 屏幕高度（像素）
		mDensity = metric.density;
		View contentView = LayoutInflater.from(this).inflate(
				R.layout.popupwindowleft, null);
		mPopupWindow = new PopupWindow(contentView,
				LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);

		search=(ImageButton)findViewById(R.id.head_middle);
		search.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				rl_letter.setVisibility(View.GONE);
				rl_title.setVisibility(View.GONE);
				ll_title_line.setVisibility(View.GONE);
				frameLayout.setVisibility(View.GONE);
				btn_title.setVisibility(View.VISIBLE);
				rl_list.setVisibility(View.VISIBLE);

			}
		});
		title_three_line.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				showPopupWindow(v);
			}
		});
		ll_left=(LinearLayout)findViewById(R.id.ll_left);
		ll_right=(LinearLayout)findViewById(R.id.ll_right);

		radioGroup_init();

		radioGroup_main.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == radioButton_left.getId()) {
							left_radiobutton_checked();
							letter.setVisibility(View.GONE);
							letter.setMaxWidth(0);
							FragmentTransaction left_transaction = fragmentManager
									.beginTransaction();
							left_transaction.replace(R.id.main_container,
									patientFragment);
							left_transaction.commit();

						} else if (checkedId == radioButton_right.getId()) {
							right_radiobutton_checked();
							letter.setMaxWidth(15);
							letter.setVisibility(View.VISIBLE);
							FragmentTransaction left_transaction = fragmentManager
									.beginTransaction();
							left_transaction.replace(R.id.main_container,
									nurseFragment);
							left_transaction.commit();
						}
					}
				});
	}

	public void showPopupWindow(View view) {

		if (mPopupWindow.isShowing()) {

			mPopupWindow.dismiss();
		} else {
			mPopupWindow.setOutsideTouchable(true);
			mPopupWindow.setFocusable(false);
			mPopupWindow.setHeight((int) (mHeight - (45 * mDensity + getStatusBarHeight(this))));
			mPopupWindow.setWidth(600);
			mPopupWindow.showAtLocation(title_three_line, Gravity.LEFT | Gravity.BOTTOM, 0, 0);

		}
	}
	public int getStatusBarHeight(Context context){
		Class<?> c = null;
		Object obj = null;
		Field field = null;
		int x = 0, statusBarHeight = 0;
		try {
			c = Class.forName("com.android.internal.R$dimen");
			obj = c.newInstance();
			field = c.getField("status_bar_height");
			x = Integer.parseInt(field.get(obj).toString());
			statusBarHeight = context.getResources().getDimensionPixelSize(x);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return statusBarHeight;
	}


	public void radioGroup_init() {
		radioButton_left.setChecked(true);
		radioButton_right.setChecked(false);
//		radioButton_left.setTextColor(Color.parseColor("#1ec6c4"));
//		radioButton_right.setTextColor(Color.parseColor("#ffffff"));
		ll_right.setBackgroundResource(R.color.ll_left);
		FragmentTransaction left_transaction = fragmentManager
				.beginTransaction();
		left_transaction.add(R.id.main_container, patientFragment);
		left_transaction.commit();
	}

	public void left_radiobutton_checked() {
		System.out.println("left");
//		radioButton_left.setTextColor(Color.parseColor("#1ec6c4"));
//		radioButton_right.setTextColor(Color.parseColor("#ffffff"));
		ll_right.setBackgroundResource(R.color.ll_left);
		ll_left.setBackgroundResource(R.color.ll_right);
	}

	public void right_radiobutton_checked() {
		System.out.println("right");
//		radioButton_right.setTextColor(Color.parseColor("#1ec6c4"));
//		radioButton_left.setTextColor(Color.parseColor("#ffffff"));
		ll_left.setBackgroundResource(R.color.ll_left);
		ll_right.setBackgroundResource(R.color.ll_right);
	}
	
	/*
	 * 音量上键  启动二维码扫描
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_VOLUME_UP:
			Intent intent = new Intent(this, MipcaActivityCapture.class);
			startActivityForResult(intent, SCANNIN_GREQUEST_CODE);
			break;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	
	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		switch(keyCode){
		case KeyEvent.KEYCODE_BACK:
			Intent intent = new Intent(MainActivity.this,LoginActivity.class);
			startActivity(intent);
			break;

		}
			
		return super.onKeyLongPress(keyCode, event);
	}

	/*
	 * onActivityResult处理二维码扫描后的结果
	 */
	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		//取出数据库中的一个数据，作为演示方式，否则会报空指针
		DB_Manager_Patient db_manager = new DB_Manager_Patient(this);
		List<Patient> patient_list = new ArrayList<Patient>();
		patient_list = db_manager.query();
		
		Intent intent = new Intent(MainActivity.this,PatientDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putSerializable("patient_detail", patient_list.get(0));
		intent.putExtras(bundle);
		startActivity(intent);
	}
	
	

}
