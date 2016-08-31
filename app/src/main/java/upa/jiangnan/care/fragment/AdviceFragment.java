package upa.jiangnan.care.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import upa.jiangnan.care.R;

public class AdviceFragment extends Fragment {

	private RadioGroup advice_choose;
	private RadioButton advice_left;
	private RadioButton advice_right;


	private LinearLayout ll_left,ll_right;

	private FragmentManager fragmentManager;
	AdviceLeftFragment adviceLeftFragment = new AdviceLeftFragment();
	AdviceRigtFragment adviceRightFragment = new AdviceRigtFragment();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		LinearLayout linearLayout = (LinearLayout) inflater.inflate(
				R.layout.fragment_advice, container, false);

		// ????????????????????
		advice_choose = (RadioGroup) linearLayout
				.findViewById(R.id.advice_choose);
		advice_left = (RadioButton) linearLayout.findViewById(R.id.advice_choose_left);
		advice_right = (RadioButton) linearLayout
				.findViewById(R.id.advice_choose_right);

		ll_left=(LinearLayout)linearLayout.findViewById(R.id.ll_advice1__left);
		ll_right=(LinearLayout)linearLayout.findViewById(R.id.ll_advice__right);


		advice_group_init();

		// ????????????????radiogroup?????
		advice_choose.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (checkedId == advice_left.getId()) {
					advice_left_checked();
				} else {
					advice_right_checked();
				}
			}
		});

		return linearLayout;
	}
	// ??????????????????
	public void advice_group_init() {
		// fragmentManager??????????oncreat??????????getChildFragmentManager????§Õ?????
		fragmentManager = getChildFragmentManager();
		FragmentTransaction left_transaction = fragmentManager
				.beginTransaction();
		left_transaction.add(R.id.advice_container, adviceLeftFragment);
		left_transaction.commit();

		advice_left.setChecked(true);
		advice_left_checked();

	}

	public void advice_left_checked() {
		System.out.println("left checked");
		ll_right.setBackgroundResource(R.color.name_advice_left);
		ll_left.setBackgroundResource(R.color.ll_right);
/*		advice_left.setTextColor(Color.parseColor("#ffffff"));
		advice_right.setTextColor(Color.parseColor("#1ec6c4"));*/

		fragmentManager = getChildFragmentManager();
		FragmentTransaction left_transaction = fragmentManager
				.beginTransaction();
		left_transaction.replace(R.id.advice_container, adviceLeftFragment);
		left_transaction.commit();
	}

	public void advice_right_checked() {
		System.out.println("right checked");
		ll_left.setBackgroundResource(R.color.name_advice_left);
		ll_right.setBackgroundResource(R.color.ll_right);
/*		advice_left.setTextColor(Color.parseColor("#1ec6c4"));
		advice_right.setTextColor(Color.parseColor("#ffffff"));*/

		fragmentManager = getChildFragmentManager();
		FragmentTransaction right_transaction = fragmentManager
				.beginTransaction();
		right_transaction.replace(R.id.advice_container, adviceRightFragment);
		right_transaction.commit();
	}

}
