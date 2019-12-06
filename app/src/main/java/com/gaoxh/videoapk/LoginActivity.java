package com.gaoxh.videoapk;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gaoxh.videoapk.bean.ApiResult;
import com.gaoxh.videoapk.bean.UserInfo;
import com.gaoxh.videoapk.http.ApiException;
import com.gaoxh.videoapk.http.HttpUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends AbsActivity {

    private EditText mUserNameEt;
    private EditText mPwdEt;
    private Button mLoginBtn;
    private Disposable loginDisposable;


    @Override
    public int layoutId() {
        return R.layout.activity_login;
    }

    @Override
    public String titleText() {
        return "登录/注册";
    }

    @Override
    public boolean isTop() {
        return false;
    }

    @Override
    public void initView() {
        mUserNameEt = findViewById(R.id.et_user_name);
        mPwdEt = findViewById(R.id.et_pwd);
        mLoginBtn = findViewById(R.id.btn_login);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String userName = mUserNameEt.getEditableText().toString();
        String pwd = mPwdEt.getEditableText().toString();
        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(getApplicationContext(), "用户名错误!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(getApplicationContext(), "密码错误!", Toast.LENGTH_SHORT).show();
            return;
        }
        HttpUtils.get().api.login(userName, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<ApiResult<UserInfo>, ObservableSource<ApiResult<UserInfo>>>() {
                    @Override
                    public ObservableSource<ApiResult<UserInfo>> apply(ApiResult<UserInfo> userInfoApiResult) throws Exception {
                        if (userInfoApiResult == null) {
                            return Observable.error(new ApiException(0, getResources().getString(R.string.http_error)));
                        }
                        if (userInfoApiResult.getCode() != 200) {
                            return Observable.error(new ApiException(userInfoApiResult.getCode(), userInfoApiResult.getMsg()));
                        }
                        return Observable.just(userInfoApiResult);
                    }
                })
                .subscribe(new Observer<ApiResult<UserInfo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        loginDisposable = d;
                        showLoading();
                    }

                    @Override
                    public void onNext(ApiResult<UserInfo> userInfoApiResult) {
                        mApp.setUserInfo(userInfoApiResult.getData());
                        finish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        if (e instanceof ApiException) {
                            ApiException apiException = (ApiException) e;
                            Toast.makeText(getApplicationContext(), apiException.getMsg(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), getResources().getString(R.string.http_error), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onComplete() {
                        loginDisposable = null;
                        dismissLoading();
                    }
                });
    }

    @Override
    protected void onDestroy() {
        if (loginDisposable != null && !loginDisposable.isDisposed()) {
            loginDisposable.dispose();
        }
        super.onDestroy();
    }
}
