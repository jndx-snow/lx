package upa.jiangnan.care.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import upa.jiangnan.care.R;


/**
 * @author axue
 * @date 2016/5/29 10:43
 */
public class addMemoActivity extends Activity {

    private Context mContext;

    private ImageButton head_back_memo;
    private ImageButton ib_add_data,ib_add_time;

    private AlertDialog add_date,add_time;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_sub_add_memo);
        mContext = this;

        ib_add_data=(ImageButton)findViewById(R.id.ib_add_data);
        ib_add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_date= new AlertDialog.Builder(mContext).create();
                add_date.show();
                add_date.getWindow().setContentView(
                        R.layout.dialog_add_data);
                add_date.getWindow().findViewById(R.id.tv_add_date_cancel)
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                add_date.dismiss();
                            }
                        });
                add_date.getWindow().findViewById(R.id.tv_add_date_ok)
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                add_date.dismiss();
                            }
                        });
            }
        });
        ib_add_time=(ImageButton)findViewById(R.id.ib_add_time);
        ib_add_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_time= new AlertDialog.Builder(mContext).create();
                add_time.show();
                add_time.getWindow().setContentView(
                        R.layout.dialog_add_time);
                add_time.getWindow().findViewById(R.id.tv_add_time_cancel)
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                add_time.dismiss();
                            }
                        });
                add_time.getWindow().findViewById(R.id.tv_add_time_ok)
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                add_time.dismiss();
                            }
                        });
            }
        });

        head_back_memo=(ImageButton)findViewById(R.id.head_left_memo);
        head_back_memo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
