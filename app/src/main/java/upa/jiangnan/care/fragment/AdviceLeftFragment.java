package upa.jiangnan.care.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.fortysevendeg.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.swipelistview.SwipeListView;

import java.util.ArrayList;
import java.util.List;

import upa.jiangnan.care.R;
import upa.jiangnan.care.adapter.SwipeAdapter_advice_left;
import upa.jiangnan.care.bean.Advice;
import upa.jiangnan.care.dbservice.DB_Manager_Advice;

public class AdviceLeftFragment extends Fragment implements SwipeAdapter_advice_left.Callback {

	private static SwipeListView mSwipeListView;
	private static SwipeAdapter_advice_left mAdapter;
	public static int deviceWidth;
	private static List<Advice> advice_list;
	private static DB_Manager_Advice db_manager;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		LinearLayout linearLayout = (LinearLayout) inflater.inflate(
				R.layout.fragment_advice_right, container, false);
		mSwipeListView = (SwipeListView) linearLayout
				.findViewById(R.id.advice_right);
		
		db_manager = new DB_Manager_Advice(getActivity());
		advice_list = new ArrayList<Advice>();
		List<Advice> list = new ArrayList<Advice>();
		list = db_manager.query();
		for(int i = 0;i<list.size();i++)
		{
			if(list.get(i).getLong_short() == 0){
				advice_list.add(list.get(i));
			}
			
		}
		
		mAdapter = new SwipeAdapter_advice_left(getActivity(), advice_list,AdviceLeftFragment.this);
		deviceWidth = getDeviceWidth();
		mSwipeListView.setAdapter(mAdapter);
		mSwipeListView
				.setSwipeListViewListener(new TestBaseSwipeListViewListener());
		reload();

		return linearLayout;
	}

	/**
	 * 接口方法，响应ListView按钮点击事件
	 * */
	@Override
	public void click(View v) {

         Log.v("标记成功：",String.valueOf(
				 advice_list.get((Integer) v.getTag()).getTo_time().equals("未完成"))+";"+
				 ( advice_list.get((Integer) v.getTag()).getTo_time()=="未完成")
		 );
		if(advice_list.get((Integer) v.getTag()).getTo_time().equals("未完成")){
			Toast.makeText(getActivity(),"标记成功！",Toast.LENGTH_SHORT).show();
			advice_list.get((Integer) v.getTag()).setTo_time("已完成");
			mAdapter = new SwipeAdapter_advice_left(getActivity(), advice_list,this);
			deviceWidth = getDeviceWidth();
			mSwipeListView.setAdapter(mAdapter);
			mSwipeListView
					.setSwipeListViewListener(new TestBaseSwipeListViewListener());
//			isDonePicture.setBackgroundResource(R.color.gray);

		}else if(advice_list.get((Integer) v.getTag()).getTo_time().equals("亟需完成")){
			advice_list.get((Integer)v.getTag()).setTo_time("已完成");
			mAdapter = new SwipeAdapter_advice_left(getActivity(), advice_list,this);
			deviceWidth = getDeviceWidth();
			mSwipeListView.setAdapter(mAdapter);
			mSwipeListView
					.setSwipeListViewListener(new TestBaseSwipeListViewListener());
//			isDonePicture.setBackgroundResource(R.color.gray);
		}
	}
	public  void notifyAdapter(Context context){

		List<Advice> myList = new ArrayList<Advice>();
	/*	db_manager = new DB_Manager_Advice(context);
		advice_list = new ArrayList<Advice>();*/
		myList = db_manager.query();
		advice_list.clear();
		Log.v("list==",String.valueOf(myList.size()));
		for(int i = 0;i<myList.size();i++)
		{
			if(myList.get(i).getLong_short() == 1){
				advice_list.add(myList.get(i));
			}

		}
		/*mSwipeListView = (SwipeListView) linearLayout
				.findViewById(R.id.advice_right);*/
		mAdapter = new SwipeAdapter_advice_left(getActivity(), advice_list,this);
		mSwipeListView.setAdapter(mAdapter);
	}
	public void notifyDataChange(int position){
		if(advice_list.get(position).getTo_time().equals("未完成")){
			Toast.makeText(getActivity(),"标记成功！",Toast.LENGTH_SHORT).show();
			advice_list.get(position).setTo_time("已完成");
			mAdapter = new SwipeAdapter_advice_left(getActivity(), advice_list,this);
			deviceWidth = getDeviceWidth();
			mSwipeListView.setAdapter(mAdapter);
			mSwipeListView
					.setSwipeListViewListener(new TestBaseSwipeListViewListener());
//			isDonePicture.setBackgroundResource(R.color.gray);

		}else if(advice_list.get(position).getTo_time().equals("亟需完成")){
			advice_list.get(position).setTo_time("已完成");
			mAdapter = new SwipeAdapter_advice_left(getActivity(), advice_list,this);
			deviceWidth = getDeviceWidth();
			mSwipeListView.setAdapter(mAdapter);
			mSwipeListView
					.setSwipeListViewListener(new TestBaseSwipeListViewListener());
//			isDonePicture.setBackgroundResource(R.color.gray);
		}
	}

	private int getDeviceWidth() {
		return getResources().getDisplayMetrics().widthPixels;
	}

	private void reload() {
		mSwipeListView.setSwipeMode(SwipeListView.SWIPE_MODE_RIGHT);
		mSwipeListView.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_REVEAL);
		// mSwipeListView.setSwipeActionRight(settings.getSwipeActionRight());
		mSwipeListView.setOffsetRight(deviceWidth * 1 / 2);
		// mSwipeListView.setOffsetRight(convertDpToPixel(settings.getSwipeOffsetRight()));
		mSwipeListView.setAnimationTime(0);
		mSwipeListView.setSwipeOpenOnLongPress(false);
	}

	class TestBaseSwipeListViewListener extends BaseSwipeListViewListener {

		@Override
		public void onClickFrontView(int position) {
			super.onClickFrontView(position);
//			Toast.makeText(getActivity(), testData.get(position),
//					Toast.LENGTH_SHORT).show();
		}
		@Override
		public void onClickBackView(int position) {
			super.onClickBackView(position);
//			Toast.makeText(getActivity(),"标记成功！",Toast.LENGTH_SHORT).show();
		}
		@Override
		public void onDismiss(int[] reverseSortedPositions) {
			for (int position : reverseSortedPositions) {
				// testData.remove(position);
			}
			mAdapter.notifyDataSetChanged();
		}
	}
}
