package com.example.yy.xutiltest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.ScrollView;
import android.widget.TextView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.textview)
    TextView textview;
    @InjectView(R.id.scrollview)
    ScrollView scrollview;
    @InjectView(R.id.webview)
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.Ext.init(getApplication());
        x.Ext.setDebug(BuildConfig.DEBUG);

        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        RequestParams params = new RequestParams("http://www.baidu.com");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public void onSuccess(String result) {
                textview.setText(result);

            }
        });


    }
}
