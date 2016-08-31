package upa.jiangnan.care.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import upa.jiangnan.care.R;
import upa.jiangnan.care.bean.Memo;
import upa.jiangnan.care.util.AudioRecorder;

public class MemoSwipeAdapter extends BaseAdapter {

	private AudioRecorder audioRecorder;

	private Context context;
	private List<Memo> memo_list;

	SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm");
	SimpleDateFormat dateFormat_date = new SimpleDateFormat("yy-MM-dd");

	public MemoSwipeAdapter(Context context, List<Memo> memo_list) {
		super();
		this.context = context;
		this.memo_list = memo_list;
	}

	@Override
	public int getCount() {
		return memo_list.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_memo, parent, false);
		}
		TextView tv_memo_title = (TextView) convertView.findViewById(R.id.memo_title);
		tv_memo_title.setText(memo_list.get(position).getMemo_title());

		TextView tv_memo_date_time = (TextView) convertView.findViewById(R.id.memo_date_time);

		//tv_memo_date_time.setText(memo_list.get(position).getMemo_date().toString());

		ImageButton btn_voice = (ImageButton) convertView.findViewById(R.id.btn_voice);
		TextView tv_voice_long = (TextView) convertView.findViewById(R.id.voice_long);

		if (position ==2 || position == 3 || position == 4) {
			btn_voice.setVisibility(View.VISIBLE);
			tv_voice_long.setVisibility(View.VISIBLE);

			tv_voice_long.setText(Integer.toString((int) (10*Math.random()))+"'");
		}
		return convertView;
	}
}
