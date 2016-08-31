package upa.jiangnan.care.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.fortysevendeg.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.swipelistview.SwipeListView;

import java.util.ArrayList;
import java.util.List;

import upa.jiangnan.care.R;
import upa.jiangnan.care.activity.PatientDetailActivity;
import upa.jiangnan.care.adapter.SwipeAdapter_nurse;
import upa.jiangnan.care.bean.Nurse;
import upa.jiangnan.care.dbservice.DB_Manager_Nurse;

public class NursesFragment extends Fragment {
	
	private SwipeListView nurse_listview;
	private List<Nurse> nurse_list = new ArrayList<Nurse>();
	private DB_Manager_Nurse db_manager;
	private SwipeAdapter_nurse mAdapter;
	public static int deviceWidth;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_nurse_list,
				container, false);
		nurse_listview = (SwipeListView) linearLayout
				.findViewById(R.id.lv_list_nurse);
		
		//ȡ��nurses����ֵ��nurse_list
		db_manager = new DB_Manager_Nurse(getActivity());
		nurse_list = db_manager.query();

		mAdapter = new SwipeAdapter_nurse(getActivity(), nurse_list);
		deviceWidth = getDeviceWidth();
		nurse_listview.setAdapter(mAdapter);
		nurse_listview
				.setSwipeListViewListener(new TestBaseSwipeListViewListener());
		reload();

		return linearLayout;
	}

	private int getDeviceWidth() {
		return getResources().getDisplayMetrics().widthPixels;
	}

	private void reload() {
		nurse_listview.setSwipeMode(SwipeListView.SWIPE_MODE_RIGHT);
		nurse_listview.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_REVEAL);
		// mSwipeListView.setSwipeActionRight(settings.getSwipeActionRight());
		nurse_listview.setOffsetRight(deviceWidth * 3 / 7);
		// mSwipeListView.setOffsetRight(convertDpToPixel(settings.getSwipeOffsetRight()));
		nurse_listview.setAnimationTime(0);
		nurse_listview.setSwipeOpenOnLongPress(false);
	}

	class TestBaseSwipeListViewListener extends BaseSwipeListViewListener {

		@Override
		public void onClickFrontView(int position) {
			super.onClickFrontView(position);
			Intent intent = new Intent(getActivity(),PatientDetailActivity.class);
			Bundle bundle = new Bundle();
			bundle.putSerializable("nurse_info", nurse_list.get(position));
			bundle.putString("flag","");
			intent.putExtras(bundle);
			startActivity(intent);
		}

		@Override
		public void onDismiss(int[] reverseSortedPositions) {
			for (int position : reverseSortedPositions) {
				//testData.remove(position);
			}
			mAdapter.notifyDataSetChanged();
		}
	}


}
