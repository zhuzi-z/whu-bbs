package com.wuda.bbs.utils.network;

import com.wuda.bbs.R;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface MobileService {
    // app => poster recomm hot boards
    @GET("mobile.php")
    public Call<ResponseBody> request(@Query("app") String app, @QueryMap Map<String, String> formData);

    @FormUrlEncoded
    @POST("mobile.php")
    public Call<ResponseBody> post(@FieldMap Map<String, String> formData);
}
