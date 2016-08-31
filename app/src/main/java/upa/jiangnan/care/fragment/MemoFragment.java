package upa.jiangnan.care.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.fortysevendeg.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.swipelistview.SwipeListView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import upa.jiangnan.care.R;
import upa.jiangnan.care.adapter.MemoSwipeAdapter;
import upa.jiangnan.care.bean.Memo;
import upa.jiangnan.care.dbservice.DB_Manager_Memo;

public class MemoFragment extends Fragment {
	
	private ListView memo_list_view;
	private List<Memo> memo_list;
	private DB_Manager_Memo db_manager;
	
	private TextView date1_tv;
	private TextView date2_tv;

	public static int deviceWidth;
	private SwipeListView mSwipeListView;
	MemoSwipeAdapter memoSwipeAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_memo, container, false);

		db_manager = new DB_Manager_Memo(getActivity());
		memo_list = db_manager.query();

		mSwipeListView = (SwipeListView) linearLayout.findViewById(R.id.memo_list);
		memoSwipeAdapter = new MemoSwipeAdapter(getActivity(), memo_list);
		deviceWidth = getDeviceWidth();
		mSwipeListView.setAdapter(memoSwipeAdapter);
		mSwipeListView
				.setSwipeListViewListener(new TestBaseSwipeListViewListener());

		reload();


		return linearLayout;
	}

	private void reload() {
		mSwipeListView.setSwipeMode(SwipeListView.SWIPE_MODE_RIGHT);
		mSwipeListView.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_REVEAL);
		// mSwipeListView.setSwipeActionRight(settings.getSwipeActionRight());
		mSwipeListView.setOffsetRight(deviceWidth*2/3);
		// mSwipeListView.setOffsetRight(convertDpToPixel(settings.getSwipeOffsetRight()));
		mSwipeListView.setAnimationTime(0);
		mSwipeListView.setSwipeOpenOnLongPress(false);
	}
	/*
	 * ???????????? 
	 */
	public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
	private int getDeviceWidth() {
		return getResources().getDisplayMetrics().widthPixels;
	}

	class TestBaseSwipeListViewListener extends BaseSwipeListViewListener {

		@Override
		public void onClickFrontView(int position) {
			super.onClickFrontView(position);

		}

		@Override
		public void onDismiss(int[] reverseSortedPositions) {
			for (int position : reverseSortedPositions) {
				//testData.remove(position);
			}
			memoSwipeAdapter.notifyDataSetChanged();
		}
	}
}
