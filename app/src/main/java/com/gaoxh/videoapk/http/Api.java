package com.gaoxh.videoapk.http;

import com.gaoxh.videoapk.bean.ApiResult;
import com.gaoxh.videoapk.bean.UserInfo;
import com.gaoxh.videoapk.bean.VideoListResp;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    String BASE_URL = "http://driver.amize.cn/f/";

    @POST("pro_user/login")
    @FormUrlEncoded
    Observable<ApiResult<UserInfo>> login(@Field("userName") String userName,@Field("pwd") String pwd);

    @POST("pro_vedio/list")
    @FormUrlEncoded
    Observable<ApiResult<VideoListResp>> listVideo(@Field("level") int level,@Field("p") int p);
}
