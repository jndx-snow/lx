package upa.jiangnan.care.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.jn.care.zxing.MipcaActivityCapture;

import java.util.ArrayList;
import java.util.List;

import upa.jiangnan.care.R;
import upa.jiangnan.care.adapter.SwipeAdapter_advice_right;
import upa.jiangnan.care.bean.Advice;
import upa.jiangnan.care.bean.Nurse;
import upa.jiangnan.care.bean.Patient;
import upa.jiangnan.care.dbservice.DB_Manager_Advice;
import upa.jiangnan.care.fragment.AdviceFragment;
import upa.jiangnan.care.fragment.AdviceLeftFragment;
import upa.jiangnan.care.fragment.AdviceRigtFragment;
import upa.jiangnan.care.fragment.MemoFragment;
import upa.jiangnan.care.fragment.MessageFragment;
import upa.jiangnan.care.fragment.NoteFragment;
import upa.jiangnan.care.fragment.SignFragment;
public class PatientDetailActivity extends FragmentActivity implements SwipeAdapter_advice_right.Callback{

	private final static int SCANNIN_GREQUEST_CODE = 1;

	List<Advice> advice_list = new ArrayList<Advice>();

	private ImageButton head_left, head_search, head_add;
	private TextView head_middle;

	private ImageButton sign_btn;
	private ImageButton advice_btn;
	private ImageButton note_btn;
	private ImageButton memo_btn, btn_message;
	private TextView p_doctor_tv;

	private TextView p_name_tv;
	private TextView p_bed_tv;
	private String note_flag = null;

	private Context mContext;
	private AlertDialog advice_execute_Dialog;
	private Intent myIntent;

	public WindowManager mWindowManager = null;
	private WindowManager.LayoutParams wmParams = null;
	// 用于显示右下角浮动图标
	public ImageView img_Float;

	private Boolean addFlag=false;
	private Boolean speak_flag=false;
	private Boolean isLast=false;

	private FragmentManager fragmentManager = getSupportFragmentManager();
	SignFragment signFragment = new SignFragment();
	AdviceFragment adviceFragment = new AdviceFragment();
	AdviceRigtFragment adviceRightFragment=new AdviceRigtFragment();
	AdviceLeftFragment adviceLeftFragment=new AdviceLeftFragment();
	NoteFragment noteFragment = new NoteFragment();
	MemoFragment memoFragment = new MemoFragment();
	MessageFragment messageFragment = new MessageFragment();
	private AlertDialog advice_ensure_Dialog, speack_dialog,add_memo_talking;
//	private Message msg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient_detail);

		mContext = this;
		myIntent=getIntent();
		btn_message = (ImageButton) findViewById(R.id.message);
		sign_btn = (ImageButton) findViewById(R.id.sign);
		advice_btn = (ImageButton) findViewById(R.id.advice);
		note_btn = (ImageButton) findViewById(R.id.note);
		memo_btn = (ImageButton) findViewById(R.id.memo);

		head_left = (ImageButton) findViewById(R.id.head_left);
		head_middle = (TextView) findViewById(R.id.head_middle);

		head_search = (ImageButton) findViewById(R.id.head_search);
		head_add = (ImageButton) findViewById(R.id.head_add);

		// ?????????????????
		p_name_tv = (TextView) findViewById(R.id.patient_info_name_tv);
		p_bed_tv = (TextView) findViewById(R.id.patient_room_bed_tv);
		p_doctor_tv = (TextView) findViewById(R.id.patient_doctor_tv);
//		Patient name1=((Patient) this.getIntent()
//				.getSerializableExtra("patient_detail"));
		if(this.getIntent()
				.getStringExtra("flag").equals("true")||this.getIntent()
				.getStringExtra("flag")=="true") {
			p_name_tv.setText(((Patient) this.getIntent()
					.getSerializableExtra("patient_detail")).getName()); // ????
			p_bed_tv.setText(((Patient) this.getIntent()
					.getSerializableExtra("patient_detail")).getRoom_bed_num());
			p_doctor_tv.setText("医师："
					+ ((Patient) this.getIntent().getSerializableExtra(
					"patient_detail")).getTo_doctor_name());
		}else if(this.getIntent()
				.getStringExtra("flag").equals("")||this.getIntent()
				.getStringExtra("flag")==""){
			p_name_tv.setText(((Nurse) this.getIntent()
					.getSerializableExtra("nurse_info")).getName()); // ????
			p_bed_tv.setText(((Nurse) this.getIntent()
					.getSerializableExtra("nurse_info")).getDomain());
			p_doctor_tv.setText(String.valueOf(((Nurse) this.getIntent().getSerializableExtra(
					"nurse_info")).getOnWork()));
		}
/*		Nurse name=((Nurse) this.getIntent()
				.getSerializableExtra("nurse_info"));
	if((!name.equals(""))||name!=null) {

}*/
		fragmentInit();

		btn_message.setOnClickListener(listener);
		sign_btn.setOnClickListener(listener);
		advice_btn.setOnClickListener(listener);
		note_btn.setOnClickListener(listener);
		memo_btn.setOnClickListener(listener);

		head_add.setOnClickListener(listener);
		head_left.setOnClickListener(listener);
	}

	private void initFloatImage() {
		// 获取WindowManager
		mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		// 设置LayoutParams(全局变量）相关参数
		wmParams = new WindowManager.LayoutParams();

		wmParams.type = WindowManager.LayoutParams.TYPE_PHONE; // 设置window type
		wmParams.format = PixelFormat.RGBA_8888; // 设置图片格式，效果为背景透明
		// 设置Window flag
		wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;

		// 以屏幕左上角为原点，设置x、y初始值
		wmParams.x = 820;
		wmParams.y = 425;
		System.out.println("*************" + wmParams.y);
		// 设置悬浮窗口长宽数据
		wmParams.width = 200;
		wmParams.height = 200;
	}

	private void createFloatView(Context context) {
		img_Float = new ImageView(context);
		img_Float.setImageResource(R.drawable.speak);
		img_Float.setAlpha(80);
		img_Float.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
					mWindowManager.removeView(img_Float);

				// 点击悬浮图片的事件
//				Toast.makeText(mContext, "成功!", Toast.LENGTH_SHORT).show();
				new Thread(new Runnable() {
					@Override
					public void run() {
						Message msg=new Message();
						msg.what=11;
						myHandler.sendMessage(msg);
					}
				}).start();
			}
		});
		// 调整悬浮窗口
		wmParams.gravity = Gravity.LEFT | Gravity.CENTER_VERTICAL;
		// 显示myFloatView图像
		mWindowManager.addView(img_Float, wmParams);
	}

	@Override
	public void click(View v) {

	}
	OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.sign:
				head_middle.setText("患者体征");
				head_search.setVisibility(View.GONE);
				head_add.setVisibility(View.GONE);
				FragmentTransaction sign_ft = fragmentManager
						.beginTransaction();
				sign_ft.replace(R.id.detail_container, signFragment);
				sign_ft.commit();

				/*//创建悬浮图片按钮
				initFloatImage();
				createFloatView(mContext);*/

				btn_message.setBackgroundResource(R.drawable.message_unselected);
				sign_btn.setBackgroundResource(R.drawable.sign_selected);
				advice_btn.setBackgroundResource(R.drawable.advice_unselected);
				note_btn.setBackgroundResource(R.drawable.note_unselected);
				memo_btn.setBackgroundResource(R.drawable.memo_unselected);
				break;
			case R.id.advice:

				head_middle.setText("患者医嘱");
				head_search.setVisibility(View.VISIBLE);
				head_add.setVisibility(View.GONE);
				/*//创建悬浮图片按钮
				initFloatImage();
				createFloatView(mContext);*/

				FragmentTransaction advice_ft = fragmentManager
						.beginTransaction();
				advice_ft.replace(R.id.detail_container, adviceFragment);
				advice_ft.commit();

				btn_message.setBackgroundResource(R.drawable.message_unselected);
				sign_btn.setBackgroundResource(R.drawable.sign_unselected);
				advice_btn.setBackgroundResource(R.drawable.advice_selected);
				note_btn.setBackgroundResource(R.drawable.note_unselected);
				memo_btn.setBackgroundResource(R.drawable.memo_unselected);
				break;
			case R.id.note:
				head_middle.setText("护理记录");
				head_search.setVisibility(View.VISIBLE);
				head_add.setVisibility(View.VISIBLE);
				addFlag=true;
				FragmentTransaction note_ft = fragmentManager
						.beginTransaction();
				note_ft.replace(R.id.detail_container, noteFragment);
				note_ft.commit();

				/*//创建悬浮图片按钮
				initFloatImage();
				createFloatView(mContext);*/

				btn_message.setBackgroundResource(R.drawable.message_unselected);
				sign_btn.setBackgroundResource(R.drawable.sign_unselected);
				advice_btn.setBackgroundResource(R.drawable.advice_unselected);
				note_btn.setBackgroundResource(R.drawable.note_selected);
				memo_btn.setBackgroundResource(R.drawable.memo_unselected);
				break;
			case R.id.memo:
				head_middle.setText("备忘录");
//				head_search.setBackgroundResource();
//				head_search.setBackgroundResource(R.drawable.more);
				head_search.setVisibility(View.VISIBLE);
				head_add.setVisibility(View.VISIBLE);
				addFlag=false;

				FragmentTransaction memo_ft = fragmentManager
						.beginTransaction();
				memo_ft.replace(R.id.detail_container, memoFragment);
				memo_ft.commit();

				/*//创建悬浮图片按钮
				initFloatImage();
				createFloatView(mContext);*/

				btn_message.setBackgroundResource(R.drawable.message_unselected);
				sign_btn.setBackgroundResource(R.drawable.sign_unselected);
				advice_btn.setBackgroundResource(R.drawable.advice_unselected);
				note_btn.setBackgroundResource(R.drawable.note_unselected);
				memo_btn.setBackgroundResource(R.drawable.memo_selected);
				break;
				case R.id.message:
					head_middle.setText("个人信息");
					head_search.setVisibility(View.GONE);
					head_add.setVisibility(View.GONE);

					FragmentTransaction message_ft = fragmentManager
							.beginTransaction();
					message_ft.replace(R.id.detail_container, messageFragment);
					message_ft.commit();

				/*	//创建悬浮图片按钮
					initFloatImage();
					createFloatView(mContext);*/

					btn_message.setBackgroundResource(R.drawable.message_selected);
					sign_btn.setBackgroundResource(R.drawable.sign_unselected);
					advice_btn.setBackgroundResource(R.drawable.advice_unselected);
					note_btn.setBackgroundResource(R.drawable.note_unselected);
					memo_btn.setBackgroundResource(R.drawable.memo_unselected);
					break;
			case R.id.head_left:
				finish();
				break;
			case R.id.head_add:
				if(addFlag) {
					Intent intent = new Intent();
						intent.setClass(mContext, addNoteActivity.class);
						startActivity(intent);
					}else{
						Intent intent = new Intent();
						intent.setClass(mContext, addMemoActivity.class);
						startActivity(intent);
					}
			}
		}
	};

	@Override
	protected void onResume() {
		super.onResume();
		Intent intent=getIntent();
		note_flag=intent.getStringExtra("note");
		if(note_flag==null||note_flag.equals("")) {
//			Log.e("note==",note_flag);
		}else {
			Log.e("note==",note_flag);
			if (note_flag.equals("1")) {
				head_middle.setText("护理记录");
				head_search.setVisibility(View.VISIBLE);
				head_add.setVisibility(View.VISIBLE);
				FragmentTransaction note_ft = fragmentManager
						.beginTransaction();
				note_ft.replace(R.id.detail_container, noteFragment);
				note_ft.commit();

				sign_btn.setBackgroundResource(R.drawable.sign_unselected);
				advice_btn.setBackgroundResource(R.drawable.advice_unselected);
				note_btn.setBackgroundResource(R.drawable.note_selected);
				memo_btn.setBackgroundResource(R.drawable.memo_unselected);
			}
		}
	}

	public void fragmentInit() {

		head_middle.setText("患者医嘱");
		head_search.setVisibility(View.VISIBLE);

		//创建悬浮图片按钮

			initFloatImage();
			createFloatView(mContext);

		FragmentTransaction advice_ft = fragmentManager.beginTransaction();
		advice_ft.add(R.id.detail_container, adviceFragment);
		advice_ft.commit();

	}
	
	@Override
	protected void onActivityResult(int arg0, int arg1, final Intent arg2) {
		System.out.println("advice right execute");

		mWindowManager.removeView(img_Float);

		myIntent=arg2;
		advice_execute_Dialog = new AlertDialog.Builder(this)
				.create();
		// checkDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		advice_execute_Dialog.show();
		advice_execute_Dialog.getWindow().setContentView(
				R.layout.dialog_advice_execute);

		advice_execute_Dialog.getWindow().findViewById(R.id.next)
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						advice_execute_Dialog.dismiss();

						new Thread(new Runnable() {
							@Override
							public void run() {

								Message msg=new Message();
								msg.what=1;
								myHandler.sendMessage(msg);
							}
						}).start();
					}
				});
		advice_execute_Dialog.getWindow().findViewById(R.id.cancel)
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(PatientDetailActivity.this,
								MipcaActivityCapture.class);
						startActivityForResult(intent, SCANNIN_GREQUEST_CODE);
						advice_execute_Dialog.dismiss();

					}
				});

	}
	Handler myHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case 1:
					advice_ensure_Dialog=new AlertDialog.Builder(mContext).create();
					advice_ensure_Dialog.show();
					advice_ensure_Dialog.getWindow().setContentView(R.layout.dialog_advice_ensure);
					advice_ensure_Dialog.getWindow().findViewById(R.id.cancel_do).setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							advice_ensure_Dialog.dismiss();
							advice_execute_Dialog.show();
						}
					});
					advice_ensure_Dialog.getWindow().findViewById(R.id.ensure)
							.setOnClickListener(new OnClickListener() {
								@Override
								public void onClick(View v) {
									Bundle bundle = myIntent.getExtras();
									Log.v("intent==",bundle.getString("ll"));
									if (bundle.getString("ll").equals("true")||bundle.getString("ll")=="true") {
									int id = ((Advice) bundle
											.getSerializable("advice_right")).getId();
									Advice advice = new Advice(id, 1);
									DB_Manager_Advice db_manager_advice = new DB_Manager_Advice(
											PatientDetailActivity.this);
									db_manager_advice.updateAdviceByID(advice);

									adviceRightFragment.notifyMyAdapter(PatientDetailActivity.this);
									for (int i = 0; i < db_manager_advice.query().size(); i++) {
										System.out.println(db_manager_advice.query().get(i)
												.getExecute_ok());
									}
									advice_ensure_Dialog.dismiss();
								}else if(bundle
											.getString("ll").equals("")||bundle
											.getString("ll")==""){
										int id = ((Advice) bundle
												.getSerializable("advice_left")).getId();
										Advice advice = new Advice(id, "已完成");
										DB_Manager_Advice db_manager_advice = new DB_Manager_Advice(
												PatientDetailActivity.this);
										db_manager_advice.updateAdviceByID1(advice);
										adviceLeftFragment.notifyAdapter(PatientDetailActivity.this);
										for (int i = 0; i < db_manager_advice.query().size(); i++) {
											System.out.println(db_manager_advice.query().get(i)
													.getTo_time());
										}
										advice_ensure_Dialog.dismiss();
									}
							}
							});
					initFloatImage();
					createFloatView(mContext);
					break;
				case 11:
					speack_dialog = new AlertDialog.Builder(mContext).create();
					speack_dialog.show();
					speack_dialog.getWindow().setContentView(R.layout.dialog_memo_speak);
					speack_dialog.getWindow().findViewById(R.id.tv_memo_speak).
							setOnClickListener(new View.OnClickListener() {
								@Override
								public void onClick(View v) {
//									if(speak_flag) {
										speack_dialog.getWindow().findViewById(R.id.tv_dialog_title)
												.setVisibility(View.GONE);
										speack_dialog.getWindow().findViewById(R.id.tv_memo_speak)
												.setVisibility(View.GONE);
										speack_dialog.getWindow().findViewById(R.id.ll_gray_line)
												.setVisibility(View.GONE);
										speack_dialog.getWindow().findViewById(R.id.tv_memo_talking_ok)
												.setVisibility(View.VISIBLE);
										speack_dialog.getWindow().findViewById(R.id.im_mic_image)
												.setBackgroundResource(R.drawable.add_ok);
//										speak_flag=false;
//
//									}else{
//										speack_dialog.getWindow().findViewById(R.id.tv_dialog_title)
//												.setVisibility(View.VISIBLE);
//										speack_dialog.getWindow().findViewById(R.id.im_mic_image)
//												.setBackgroundResource(R.drawable.speak_mic);
//										speak_flag=true;
//									}

									/*speack_dialog.dismiss();*/
								}

							});

					initFloatImage();
					createFloatView(mContext);
				break;
			}

			super.handleMessage(msg);
		}
	};
	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		switch(keyCode){
		case KeyEvent.KEYCODE_BACK:
			Intent intent = new Intent(PatientDetailActivity.this,LoginActivity.class);
			startActivity(intent);
			break;

		}
			
		return super.onKeyLongPress(keyCode, event);
	}

}
