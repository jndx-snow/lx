package upa.jiangnan.care.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import upa.jiangnan.care.adapter.SwipeAdapter_advice_right;
import upa.jiangnan.care.bean.Advice;
import upa.jiangnan.care.dbservice.DB_Manager_Advice;

public class AdviceRigtFragment extends Fragment implements SwipeAdapter_advice_right.Callback{
	

	private static SwipeListView mSwipeListView;
	private static SwipeAdapter_advice_right mAdapter;
	public static int deviceWidth;
	private static List<Advice> advice_list;
	private static DB_Manager_Advice db_manager;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_advice_right, container,
				false);
		mSwipeListView = (SwipeListView) linearLayout
				.findViewById(R.id.advice_right);
		
		db_manager = new DB_Manager_Advice(getActivity());
		advice_list = new ArrayList<Advice>();
		List<Advice> list = new ArrayList<Advice>();
		list = db_manager.query();
		for(int i = 0;i<list.size();i++)
		{
			if(list.get(i).getLong_short() == 1){
				advice_list.add(list.get(i));
			}
			
		}
		
		mAdapter = new SwipeAdapter_advice_right(getActivity(), advice_list,AdviceRigtFragment.this);
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

		if(advice_list.get((Integer)v.getTag()).getExecute_ok() != 1){
			Toast.makeText(getActivity(),"标记成功！",Toast.LENGTH_SHORT).show();

			advice_list.get((Integer)v.getTag()).setExecute_ok(1);

			mAdapter = new SwipeAdapter_advice_right(getActivity(), advice_list,this);
			deviceWidth = getDeviceWidth();
			mSwipeListView.setAdapter(mAdapter);
			mSwipeListView
					.setSwipeListViewListener(new TestBaseSwipeListViewListener());
		}
	}
	public  void notifyMyAdapter(Context context){

		List<Advice> list = new ArrayList<Advice>();
		list = db_manager.query();
		advice_list.clear();
		for(int i = 0;i<list.size();i++)
		{
			if(list.get(i).getLong_short() == 1){
				advice_list.add(list.get(i));
			}
			
		}

		mAdapter = new SwipeAdapter_advice_right(context, advice_list,AdviceRigtFragment.this);
		mSwipeListView.setAdapter(mAdapter);
		//mAdapter.notifyDataSetChanged();
	}
	
	private int getDeviceWidth() {
		return getResources().getDisplayMetrics().widthPixels;
	}

	private void reload() {
		mSwipeListView.setSwipeMode(SwipeListView.SWIPE_MODE_RIGHT);
		mSwipeListView.setSwipeActionRight(SwipeListView.SWIPE_ACTION_REVEAL);
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
			//Toast.makeText(getActivity(), testData.get(position),
			//Toast.LENGTH_SHORT).show();
		}
		@Override
		public void onClickBackView(int position) {
			super.onClickBackView(position);
//			Toast.makeText(getActivity(),"标记成功！",Toast.LENGTH_SHORT).show();
		}
		@Override
		public void onDismiss(int[] reverseSortedPositions) {
			for (int position : reverseSortedPositions) {
				//testData.remove(position);
			}
		}
	}
	

	
	
	


}
