package com.narumasolutions.petapp.Dagger;

import com.narumasolutions.petapp.Services.Interfaces.IPetAppServices;
import com.narumasolutions.petapp.Utils.Util;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rudielavilaperaza on 3/5/18.
 */
@Module
public class NetworkModule {

    private static final String URL = "URL";

    @Provides
    @Named(URL)
    String provideBaseUrlString() {
        return Util.GLOBAL_URL;
    }

    @Provides
    @Singleton
    Converter.Factory provideGsonConverter() {

        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Converter.Factory converter, @Named(URL) String baseUrl) {

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converter)
                .build();
    }

    @Provides
    @Singleton
    IPetAppServices provideServices(Retrofit retrofit) {
        return retrofit.create(IPetAppServices.class);
    }


}
