package com.example.liuguodong.testc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.lgd.conmoncore.net.OkHttpUtils;
import com.lgd.conmoncore.net.callback.Callback;
import com.lgd.conmoncore.net.callback.StringCallback;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    String as="http://test.ixiansheng.net/giftProduct!request.action";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkHttpUtils
                .post()
                .url(as)

                .addParams("method", "getProductDetail")
                .addParams("params", "12")
                .addParams("productCode", "01-099-12")
                .addParams("type", "1")

                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.i("qweqwe",""+e.toString());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.i("qweqwe",""+response.toString());
                    }
                });




        OkHttpUtils
                .postString()
                .url(as)

                .content(new Gson().toJson(new User("productCode", "01-099-12" ,"type","1")))
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.i("qweqwe",""+response.toString());
                    }
                });
    }


class User{
        String akey;String aval;String bkey;String bval;

    public User(String akey, String aval, String bkey, String bval) {
        this.akey = akey;
        this.aval = aval;
        this.bkey = bkey;
        this.bval = bval;
    }
}
}
