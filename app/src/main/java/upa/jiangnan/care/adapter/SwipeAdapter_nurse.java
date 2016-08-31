package upa.jiangnan.care.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import upa.jiangnan.care.R;
import upa.jiangnan.care.activity.CallPageActivity;
import upa.jiangnan.care.activity.CallRecordNurseActivity;
import upa.jiangnan.care.bean.Nurse;

/**
 * @author axue
 * @date 2016/5/29 17:49
 */
public class SwipeAdapter_nurse extends BaseAdapter {
    private Context context;
    private List<Nurse> nurse_list;

    public SwipeAdapter_nurse(Context context, List<Nurse> nurse_list) {
        super();
        this.context = context;
        this.nurse_list = nurse_list;
    }

    @Override
    public int getCount() {
        return nurse_list.size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_nurse, parent, false);
            TextView nurse_name = (TextView) convertView.findViewById(R.id.nurse_name);
            TextView nurse_domain = (TextView) convertView.findViewById(R.id.nurse_domain);
            TextView nurse_work_position = (TextView) convertView.findViewById(R.id.nurse_worposition);
//		TextView nurse_last_call = (TextView) convertView.findViewById(R.id.nurse_last_call);

            nurse_name.setText(nurse_list.get(position).getName());
            nurse_domain.setText(nurse_list.get(position).getDomain());
            nurse_work_position.setText(nurse_list.get(position).getWork_position());
//		nurse_last_call.setText(nurse_list.get(position).getLast_calltime());

            Button call_record_btn_nurse=(Button)convertView.
                    findViewById(R.id.call_record_btn_nurse);
            call_record_btn_nurse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent_call = new Intent(v.getContext(), CallRecordNurseActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("nurse_info", nurse_list.get(position));
                    intent_call.putExtras(bundle);
                    v.getContext().startActivity(intent_call);
                }
            });
            Button call_btn_nurse=(Button) convertView.findViewById(R.id.call_btn_nurse);
            call_btn_nurse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, CallPageActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("nurse", nurse_list.get(position));
                    bundle.putString("flag","");
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
            //护士列表拨打电话按钮
            ImageButton nurse_call = (ImageButton) convertView.findViewById(R.id.nurse_call);
            nurse_call.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, CallPageActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("nurse", nurse_list.get(position));
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        }
        return convertView;
    }
}
