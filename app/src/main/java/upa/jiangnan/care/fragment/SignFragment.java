package upa.jiangnan.care.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import upa.jiangnan.care.R;

public class SignFragment extends Fragment {
	
	private ImageButton heart_rate_view,temperature_view,pulse_view;
	private ImageView body_image,image_axis;
	private CheckBox select_rate;
	private Spinner select_data;
	private TextView tv_rate,tv_temperature,tv_rate_color;
	//是否显示脉搏坐标
	private LinearLayout ll_plus,ll_rate;
	private boolean flag=false;
	//标记当前处于心率或脉搏
	private String tag=null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		RelativeLayout linearLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_sign,
				container, false);

		body_image=(ImageView)linearLayout.findViewById(R.id.body_image);
		image_axis=(ImageView)linearLayout.findViewById(R.id.image_axis);

		select_rate=(CheckBox)linearLayout.findViewById(R.id.select_rate);
		select_rate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(flag){
					flag=false;
					if(!(tag==null||tag.equals(""))) {
						if (tag == "0" || tag.equals("0")) {
							//坐标栏
							ll_plus.setVisibility(View.GONE); //脉搏
							select_rate.setVisibility(View.VISIBLE);//复选框
							//心率和温度
							tv_rate.setVisibility(View.VISIBLE);
							ll_rate.setVisibility(View.VISIBLE);
							tv_rate_color.setVisibility(View.VISIBLE);
							tv_temperature.setVisibility(View.GONE);
							//坐标和图片
							body_image.setBackgroundResource(R.drawable.rate_data);
							image_axis.setBackgroundResource(R.drawable.rate_axis);
						} else if (tag == "1" || tag.equals("1")) {
							//坐标栏
							ll_plus.setVisibility(View.VISIBLE); //脉搏
							select_rate.setVisibility(View.VISIBLE);//复选框
							ll_rate.setVisibility(View.GONE);//心率和温度
							tv_temperature.setVisibility(View.GONE);
							tv_rate.setVisibility(View.GONE);
							tv_rate_color.setVisibility(View.GONE);
							//坐标和图片
							body_image.setBackgroundResource(R.drawable.rate_data);
							image_axis.setBackgroundResource(R.drawable.rate_axis);
						}
					}
				}else{
					flag=true;
					//坐标栏
					ll_plus.setVisibility(View.VISIBLE); //脉搏
					//心率和温度
					tv_rate.setVisibility(View.VISIBLE);
					ll_rate.setVisibility(View.VISIBLE);
					tv_rate_color.setVisibility(View.VISIBLE);
					tv_temperature.setVisibility(View.GONE);
					//坐标和图片
					body_image.setBackgroundResource(R.drawable.rate_plus);
				}

			}
		});
		ll_plus=(LinearLayout)linearLayout.findViewById(R.id.ll_plus);
		ll_rate=(LinearLayout)linearLayout.findViewById(R.id.ll_rate);

		tv_rate_color=(TextView)linearLayout.findViewById(R.id.tv_rate_color);
		tv_temperature=(TextView)linearLayout.findViewById(R.id.tv_temperature);
		tv_rate=(TextView)linearLayout.findViewById(R.id.tv_rate);

		temperature_view=(ImageButton)linearLayout.findViewById(R.id.temperature);
		heart_rate_view=(ImageButton)linearLayout.findViewById(R.id.heart_rate);
		pulse_view=(ImageButton)linearLayout.findViewById(R.id.pulse);
		select_data=(Spinner)linearLayout.findViewById(R.id.select_data);

		temperature_view.setOnClickListener(listener);
		heart_rate_view.setOnClickListener(listener);
		pulse_view.setOnClickListener(listener);
		select_data.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
									   int position, long id) {
				parent.setVisibility(View.VISIBLE);
				if(position>0) {
					body_image.setVisibility(View.GONE);
				}else {
					body_image.setVisibility(View.VISIBLE);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});
		return linearLayout;
	}
	
	OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch(v.getId()){
				case R.id.heart_rate:

					select_rate.setChecked(false);
					flag=false;
					tag="0";
					//标题栏
					temperature_view.setBackgroundResource(R.drawable.temeputrue_unselected);
					heart_rate_view.setBackgroundResource(R.drawable.heart_rate_selected);
					pulse_view.setBackgroundResource(R.drawable.pulse_rate_unselected);
					//坐标栏
					ll_plus.setVisibility(View.GONE); //脉搏
					select_rate.setVisibility(View.VISIBLE);//复选框
					//心率和温度
					tv_rate.setVisibility(View.VISIBLE);
					ll_rate.setVisibility(View.VISIBLE);
					tv_rate_color.setVisibility(View.VISIBLE);
					tv_temperature.setVisibility(View.GONE);
					//坐标和图片
					body_image.setBackgroundResource(R.drawable.rate_data);
					image_axis.setBackgroundResource(R.drawable.rate_axis);

				break;
				case R.id.temperature:

					select_rate.setChecked(false);
					flag=false;
					//标题栏
					temperature_view.setBackgroundResource(R.drawable.temeputrue_selected);
					heart_rate_view.setBackgroundResource(R.drawable.heart_rate_unselected);
					pulse_view.setBackgroundResource(R.drawable.pulse_rate_unselected);
					//坐标栏
					ll_plus.setVisibility(View.GONE); //脉搏
					select_rate.setVisibility(View.GONE);//复选框
					ll_rate.setVisibility(View.VISIBLE);//心率和温度
					tv_temperature.setVisibility(View.VISIBLE);
					tv_rate.setVisibility(View.GONE);
					tv_rate_color.setVisibility(View.GONE);
					//坐标和图片
					body_image.setBackgroundResource(R.drawable.temperature_data);
					image_axis.setBackgroundResource(R.drawable.tempeture_axis);

				break;
			case R.id.pulse:

				select_rate.setChecked(false);
				flag=false;
				tag="1";
				//标题栏
				temperature_view.setBackgroundResource(R.drawable.temeputrue_unselected);
				heart_rate_view.setBackgroundResource(R.drawable.heart_rate_unselected);
				pulse_view.setBackgroundResource(R.drawable.pulse_rate_selected);

				//坐标栏
				ll_plus.setVisibility(View.VISIBLE); //脉搏
				select_rate.setVisibility(View.VISIBLE);//复选框
				ll_rate.setVisibility(View.GONE);//心率和温度
				tv_temperature.setVisibility(View.GONE);
				tv_rate.setVisibility(View.GONE);
				tv_rate_color.setVisibility(View.GONE);
				//坐标和图片
				body_image.setBackgroundResource(R.drawable.rate_data);
				image_axis.setBackgroundResource(R.drawable.rate_axis);
				break;
				case R.id.select_data:
			}
		}
	};
	
	

}
