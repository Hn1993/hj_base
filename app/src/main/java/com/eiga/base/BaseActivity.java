package com.eiga.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.eiga.utils.AndroidWorkaround;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.SimpleResponseListener;
import com.zhy.autolayout.AutoLayoutActivity;

public class BaseActivity extends AutoLayoutActivity {

    private static BaseActivity mActivity;
    //在base activity 里定义请求队列
    private RequestQueue queue;

    public static Activity getBaseActivity(){
        if (mActivity == null){
            mActivity=new BaseActivity();
        }
        return mActivity;
    }


    // 提供给子类请求使用。
    public <T> void StringRequest(int what, Request<String> request, SimpleResponseListener<String> listener) {
        queue.add(what, request, listener);
    }

    /**
     * 跳转到登陆页
     * @param mContext
     * @param isFinishThis
     */
//    public void gotoLogin(Context mContext,boolean isFinishThis){
//        Intent intent=new Intent(mContext,LoginActivity.class);
//        startActivity(intent);
//        if (isFinishThis){
//            finish();
//        }
//    }

    public void autoVirtualKeys(){
        if (AndroidWorkaround.checkDeviceHasNavigationBar(this)) {
            AndroidWorkaround.assistActivity(findViewById(android.R.id.content));
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        queue = NoHttp.newRequestQueue();

    }
}
