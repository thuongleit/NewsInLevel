package com.thuongleit.collectandupdate.data.remote;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import com.thuongleit.collectandupdate.config.Constant;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.CallAdapter;
import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

@Module
public class ApiModule {

    public ApiModule() {
    }

    @Provides
    @Singleton
    public JacksonConverterFactory provideConverter() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return JacksonConverterFactory.create(mapper);
    }

    @Provides
    @Singleton
    public CallAdapter.Factory provideCallAdapter() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client, JacksonConverterFactory converter, CallAdapter.Factory callAdapter) {
        return new Retrofit.Builder()
                .baseUrl(Constant.PARSE_SERVICE_ENDPOINT)
                .client(client)
                .addCallAdapterFactory(callAdapter)
                .addConverterFactory(converter)
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient provideClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.interceptors().clear();
        // add logging as last interceptor
        okHttpClient.interceptors().add(logging);

        return okHttpClient;
    }

    @Provides
    @Singleton
    ParseService provideParseService(Retrofit retrofit) {
        return retrofit.create(ParseService.class);
    }

}
