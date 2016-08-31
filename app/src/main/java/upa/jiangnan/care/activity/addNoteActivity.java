package upa.jiangnan.care.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import upa.jiangnan.care.R;

/**
 * @author axue
 * @date 2016/5/27 20:07
 */
public class addNoteActivity extends Activity {

    private TextView head_submit;
    private ImageButton head_back,add_note_time;
    private Context mContext;
    private AlertDialog add_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_sub_add_note);
        mContext=this;
        add_note_time=(ImageButton)findViewById(R.id.add_note_time);
        add_note_time.setOnClickListener(new View.OnClickListener() {
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
        head_submit=(TextView)findViewById(R.id.head_submit);
        head_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent();
//                intent.putExtra("note","1");
//                intent.setClass(mContext,PatientDetailActivity.class);
//                startActivity(intent);
                finish();
            }
        });
        head_back=(ImageButton)findViewById(R.id.head_left);
        head_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    Intent intent = new Intent(addNoteActivity.this,MainActivity.class);
//                    startActivity(intent);
                finish();
                }
        });
    }

}
