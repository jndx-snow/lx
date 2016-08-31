package upa.jiangnan.care.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import upa.jiangnan.care.R;

/**
 * Created by qiuaikun on 16/5/28.
 */
public class NotificationActivity extends Activity{

    private RadioGroup rp_down;
    private RadioButton rb_left;
    private RadioButton rb_mid;
    private RadioButton rb_right;
    private LinearLayout down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        rp_down = (RadioGroup) findViewById(R.id.rg_down);
        rb_left = (RadioButton) findViewById(R.id.rb_left);
        rb_mid = (RadioButton) findViewById(R.id.rb_mid);
        rb_right = (RadioButton) findViewById(R.id.rb_right);
        down = (LinearLayout) findViewById(R.id.down);

        rp_down.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_left:
                        if (rb_left.isChecked()) {
                            rb_left.setTextColor(Color.rgb(83,198,201));
                            rb_mid.setTextColor(Color.rgb(255,255,255));
                            rb_right.setTextColor(Color.rgb(255,255,255));
                        }
                        down.setBackgroundResource(R.drawable.downyz);
                        break;
                    case R.id.rb_mid:
                        if (rb_mid.isChecked()) {
                            rb_left.setTextColor(Color.rgb(255,255,255));
                            rb_mid.setTextColor(Color.rgb(83,198,201));
                            rb_right.setTextColor(Color.rgb(255,255,255));
                        }
                        down.setBackgroundResource(R.drawable.downhr);
                        break;
                    case R.id.rb_right:
                        if (rb_right.isChecked()) {
                            rb_left.setTextColor(Color.rgb(255,255,255));
                            rb_mid.setTextColor(Color.rgb(255,255,255));
                            rb_right.setTextColor(Color.rgb(83,198,201));
                        }
                        down.setBackgroundResource(R.drawable.downbw);
                        break;
                }


            }
        });
    }
}
