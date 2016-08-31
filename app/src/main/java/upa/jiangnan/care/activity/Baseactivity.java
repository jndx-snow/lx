package upa.jiangnan.care.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import upa.jiangnan.care.R;

/**
 * @author axue
 * @date 2016/5/28 17:08
 */
public class Baseactivity extends Activity {

    //�����������
    WindowManager mWindowManager;
    WindowManager.LayoutParams wmParams;
    LinearLayout mFloatLayout;
    //����ͼ��
    public ImageView mFloatView;

    /**
     * ��Ļ�Ŀ�Ⱥ͸߶�
     */
    protected int mScreenWidth;
    protected int mScreenHeight;

    public static Baseactivity baseactivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        Baseactivity.baseactivity=this;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //��ȡ��Ļ���
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        mScreenWidth = metric.widthPixels;
        mScreenHeight = metric.heightPixels;
        //getWindow().setFlags(FLAG_HOMEKEY_DISPATCHED, FLAG_HOMEKEY_DISPATCHED);
    }

    /**
     * �÷�ֱ������Ҫʹ�õĽ��������øú���,Ȼ����ú�����Ӽ����¼�
     * createFloatView(Rcjc.this);
     * mFloatView.setOnClickListener;
     */
    //���������ť
    @SuppressWarnings("unused")
    public void createFloatView(Context cx) {
        //��ȡLayoutParams����
        wmParams = new WindowManager.LayoutParams();

        //��ȡ����LocalWindowManager����
        mWindowManager = this.getWindowManager();
        //mWindowManager = getWindow().getWindowManager();

        //��ȡ����CompatModeWrapper����
        //mWindowManager = (WindowManager) getApplication().getSystemService(Context.WINDOW_SERVICE);
        wmParams.type = WindowManager.LayoutParams.TYPE_PHONE;
        wmParams.format = PixelFormat.RGBA_8888;
        ;
        wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        wmParams.gravity = Gravity.LEFT | Gravity.TOP;
        wmParams.x = mScreenWidth - 50;
        wmParams.y = 70;
        wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        LayoutInflater inflater = this.getLayoutInflater();//LayoutInflater.from(getApplication());

//        mFloatLayout = (LinearLayout) inflater.inflate(R.layout.base_activity, null);
        mWindowManager.addView(mFloatLayout, wmParams);
        //setContentView(R.layout.main);
        mFloatView = (ImageView) mFloatLayout.findViewById(R.id.img_float);

        //�󶨴����ƶ�����

    }
}