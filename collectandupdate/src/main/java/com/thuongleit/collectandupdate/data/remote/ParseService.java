package com.thuongleit.collectandupdate.data.remote;

import com.thuongleit.collectandupdate.data.remote.model.CollectResponse;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by thuongle on 2/24/16.
 */
public interface ParseService {

    @GET("7u85cstg")
    Observable<CollectResponse> collectUrl(@Query("kimpath1") String level,
                                           @Query("kimpath2") String catalog,
                                           @Query("kimpath3") String catalogCode,
                                           @Query("kimpath4") String page);
}
