package upa.jiangnan.care.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import upa.jiangnan.care.R;

/**
 * @author axue
 * @date 2016/5/26 21:19
 */
public class MessageFragment extends Fragment {

    private ImageButton ib_message,ib_hospital;
    private LinearLayout ll_message,ll_hospital;
    private TextView tv_message_detail,tv_hospital_detail;


    private boolean flag_message=false,flag_hospital=false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.message_detail,
                container, false);

        ib_message=(ImageButton)linearLayout.findViewById(R.id.im_message);
        ib_hospital=(ImageButton)linearLayout.findViewById(R.id.im_hospital_message);

        ll_message=(LinearLayout)linearLayout.findViewById(R.id.ll_message);
        ll_hospital=(LinearLayout)linearLayout.findViewById(R.id.ll_hospital_message);

        tv_message_detail=(TextView)linearLayout.findViewById(R.id.tv_message_detail);
        tv_hospital_detail=(TextView)linearLayout.findViewById(R.id.tv_hospital_detail);

        ib_message.setOnClickListener(listener);
        ib_hospital.setOnClickListener(listener);
        return linearLayout;
    }
    View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.im_message:
                    if(flag_message){
                        ib_message.setBackgroundResource(R.drawable.down_tip);
                        tv_message_detail.setVisibility(View.VISIBLE);
                        ll_message.setVisibility(View.GONE);
                        flag_message=false;
                    }else{
                        tv_message_detail.setVisibility(View.GONE);
                        ib_message.setBackgroundResource(R.drawable.delete);
                        ll_message.setVisibility(View.VISIBLE);
                        flag_message=true;
                    }
                    break;
                case R.id.im_hospital_message:
                    if(flag_hospital){
                        ib_hospital.setBackgroundResource(R.drawable.down_tip);
                        tv_hospital_detail.setVisibility(View.VISIBLE);
                        ll_hospital.setVisibility(View.GONE);
                        flag_hospital=false;
                    }else {
                        tv_hospital_detail.setVisibility(View.GONE);
                        ib_hospital.setBackgroundResource(R.drawable.delete);
                        ll_hospital.setVisibility(View.VISIBLE);
                        flag_hospital=true;
                    }
                    break;
            }
        }
    };
}
