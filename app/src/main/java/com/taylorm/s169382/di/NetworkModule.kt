package com.taylorm.s169382.di

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.taylorm.s169382.data.api.CqcService
import com.taylorm.s169382.data.local.NoConnectionInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/*
Dagger Hilt module providing network dependencies.
 */

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    /*
    Provides an instance of OkHttpClient using the OkHttpClient builder.
    Adds a logging interceptor to log the body of the response.
     */
    @Singleton
    @Provides
    fun providesOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder().addInterceptor(logging)
            .addInterceptor(NoConnectionInterceptor(context)).connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS).build()

    }

    /*
    Provides an instance of Retrofit using the Retrofit builder to make API requests.
     */
    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        return Retrofit.Builder().baseUrl("https://api.cqc.org.uk/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    }

    /*
    Provides an instance of the CqcService interface by creating it from Retrofit.
     */
    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit) : CqcService {
        return retrofit.create(CqcService::class.java)
    }

    /*
    These dependencies will be available for injection throughout the app.
     */
}