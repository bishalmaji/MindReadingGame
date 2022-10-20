package com.bishal.mindreadinggame.network;



import static com.bishal.mindreadinggame.utils.Config.CLIENT_ID;

import com.bishal.mindreadinggame.models.Root;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface ImageApi {
    @Headers("Authorization: Client-ID "+CLIENT_ID)
    @GET("search/photos")
    Call<Root> getImages(
            @Query("query") String query,
            @Query("page") int page,
            @Query("per_page") int perPage);



}
