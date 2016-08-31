package upa.jiangnan.care.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import upa.jiangnan.care.R;

public class NoteListAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<String[]> list;
	public NoteListAdapter(Context context, ArrayList<String[]>list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_note, parent, false);
		}

		/*
		 * ����ÿ��note�ı�����Ϣ
		 */
		TextView note_title_tv = (TextView) convertView
				.findViewById(R.id.note_title);
		note_title_tv.setText(list.get(0)[position]);

		TextView note_time=(TextView)convertView.findViewById(R.id.note_time);
		note_time.setText("("+list.get(1)[0]+")");

		TextView note_detail=(TextView) convertView.findViewById(R.id.note_detail);
		note_detail.setText(list.get(2)[0]);
		TextView note_state=(TextView) convertView.findViewById(R.id.note_state);
		note_state.setText(list.get(3)[position]);
		TextView note_tip=(TextView) convertView.findViewById(R.id.note_tip);
		note_tip.setText(list.get(4)[position]);

		TextView note_tag=(TextView) convertView.findViewById(R.id.note_tag);
		if(list.get(3)[position].equals("�ݸ�")){
			note_tag.setBackgroundResource(R.color.ll_right);
		}else {
			note_tag.setBackgroundResource(R.color.ll_left);
		}


		/*final ListView item_item_note_add_view = (ListView) convertView
				.findViewById(R.id.item_item_note);
		NoteSubListAdapter noteSubListAdapter = new NoteSubListAdapter(context,
				notes_str[position], 1);
		item_item_note_add_view.setAdapter(noteSubListAdapter);
		setListViewHeightBasedOnChildren(item_item_note_add_view);*/
	/*	// ��Ӱ�ť
		ImageButton note_add = (ImageButton) convertView
				.findViewById(R.id.note_add);
		note_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
//				if (item_item_note_add_view.getVisibility() == View.VISIBLE) {
//					item_item_note_add_view.setVisibility(View.GONE);
//				} else {
//					item_item_note_add_view.setVisibility(View.VISIBLE);
//				}
				final AlertDialog note_add_dialog = new AlertDialog.Builder(context).create();
				note_add_dialog.show();
				note_add_dialog.getWindow().setContentView(
						R.layout.dialog_note_add);
				
				note_add_dialog.getWindow().findViewById(R.id.note_add_ok).setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						note_add_dialog.dismiss();
					}
				});
				note_add_dialog.getWindow().findViewById(R.id.note_add_cancel).setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						note_add_dialog.dismiss();
					}
				});
			}
		});
		// ���鰴ť
		final ImageButton note_detail = (ImageButton) convertView
				.findViewById(R.id.note_detail);
		
		final ListView item_item_note_detail_view = (ListView) convertView
				.findViewById(R.id.item_item_note);
		NoteSubListDetailAdapter noteSubListAdapter_detail = new NoteSubListDetailAdapter(context,
				notes_str[position], 3);
		item_item_note_detail_view.setAdapter(noteSubListAdapter_detail);
		setListViewHeightBasedOnChildren(item_item_note_detail_view);
		
		note_detail.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (item_item_note_detail_view.getVisibility() == View.VISIBLE) {
					item_item_note_detail_view.setVisibility(View.GONE);
					note_detail.setBackgroundResource(R.drawable.note_right);
				} else {
					item_item_note_detail_view.setVisibility(View.VISIBLE);
					note_detail.setBackgroundResource(R.drawable.note_down);
				}

			}
		});*/

		return convertView;
	}

	// �����listview�߶�
	public static void setListViewHeightBasedOnChildren(ListView listView) {
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			return;
		}
		int totalHeight = 0;
		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0);
			totalHeight += listItem.getMeasuredHeight();
		}

		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		listView.setLayoutParams(params);
	}

}
